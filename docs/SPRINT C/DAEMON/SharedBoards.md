# Create a Post-it

## Requirements

The system should have a way to enable remote client applications 
to obtain the shared boards info and to place a post-it. 

## Analisis

This use case is necessary to interface with shared boards.

The shared board app is able to communicate using sockets.

Functionaly, this is quite similar to the functionality currently provided in the `CreateAPostItController`. 
No new domain concepts are at play.

## Design

The main questions about this use case are:

- How to provide the remote capability? 
- How does each party know each other, namely, how does the kiosk know about this service?
- Which kind of communication protocol to use?

This functionality will be provided as a deamon with a server socket on a well-known address using TCP as transport mecanism. The kiosks will need to know this IP and port (as part of its setup, e.g., property file).

Since the kiosk provider does not tell us its protocol we will design the communication protocol and the kiosk provider will implement it, otherwise we would be using the kiosk communication protocol. 

### Communication protocol

We will be using native sockets based on text messages encoded as UTF-8 and delimited by a new line character `\n`. 
The data content will be CSV (the SB provider asked us to use CSV in order to simplify the parsing on their side). 
All non-numeric values must be inside double quotes, e.g., `"A text message"` not `A text message`.

The protocol will support two message types:
- GET_SHARED_BOARDS_LIST
- GET_SHARED_BOARD_INFO
- CREATE_POST_IT
- ...

To be a good client the connection must not be abruptly closed and 
the client should send a `GOODBYE` message with no extra content.

If the server does not understand the message it will reply 
with an `UNKNOWN_REQUEST` message which has the following format:

    UNKNOWN_REQUEST, «request»

Where `request` is the content the server has received. 
For instance, if the server receives a message `GET_JRJOFJLSKDJFL user1`, it will reply with 

    UNKNOWN_REQUEST, "GET_JRJOFJLSKDJFL user1"

If there is a sintax error on the request, that is, 
the request is known but not conformat to the specification, the server will reply with:

    ERROR_IN_REQUEST, «request», «error-description» 
    
For example:

    ERROR_IN_REQUEST, "GET_AVAILABLE_MEALS, user1", "Wrong number of parameters"

If there is a semantic error on the request (e.g., unknown user id), the server will reply with

    BAD_REQUEST, «request», «error-description»

If there is a problem executing the request (e.g., the server cannot execute the action), the server will reply with

    SERVER_ERROR, «request», «error-description»


#### GET_SHARED_BOARDS_LIST

The GET_AVAILABLE_MEALS message has the following format

    GET_SHARED_BOARDS_LIST, «username»

In response, the service will reply with a **multi-line** response in the format:

    «header»
    «content-line»

Where `header` is `"ID", "NAME", "TYPE", "CALORIES", "SALT", "PRICE"` 
and each `content-line` will correspond to one available shared board 
for that user with the fiels according to the header.

For example:

```
"TITLE", "N ROWS", "N COL", "OWNER", "ARCHIVE"\n
"uma board",2,2,"joe power","false"\n
"outra board",2,2,"joe power","false"\n
    \n
```

Multi-line responses end with a blank line.

#### CREATE_POST_IT

The BOOK_A_MEAL message has the following format:

    CREATE_POST_IT, «board-title», «row» , «col», «content» «username»

The response is in the format:

    CREATED, «cell-id»

### Use case realization

This responsability will be assigned to a new application (`Deamon`) since all the 
existing applications are for user interaction, while this one does not require user interaction.

There are multiple responsibilities at play that need to be distributed among the different objects, namely:
- server socket
- client connection handling (in a separate thread)
- inbound message parsing
- request execution
- outbound message construction

Regarding the execution itself, we will reuse as much as possible the existing `CreateAPostIt` controller.

We won't use any framework (e.g., Spring Boot) for this and will leverage regular socket support in java (_mainly because we want to learn java sockets and multi-threading_).

The server must be resilient to badly formed input as well as abrupt connection closing from the client.

![use case](use-case-realization2/use-case-realization2.svg.svg)

Having the request create the representation makes it harder to unit test the response protocol, so in order to separate the execution from the response we need to use dependecy injection in the `ProtocolRequest` in order to inject a mock controller.

The server socket (and client) will be part of the `presentation` layer as it handles interaction with the outside world (similar to the UI).

The protocol parsing and command execution will be in the `daemon` application project reusing the existing controller from the `core` project.


### Unit testing

For `SBProtocolMessageParser`:
- ensure rightly formatted message (for each message type) is parsed correctly
- ensure wrongly formatted message (for each message type) is parsed to `ERROR_IN_REQUEST`
- ensure unknown message type is parsed to `UnknownRequest`

Genraly for all `SBProtocolRequest`:
- ensure a "SERVER_ERROR" is returned if the operation (of the controller) throws 
- ensure a "BAD_REQUEST" is returned if some of the arguments is unknown or semantically incorrect (e.g., invalid date)

For `GetSharedBoardsListRequest`:
- ensure an empty list (just the header) is returned if there are no meals for the desired date and meal type
- ensure the meals are returned in a properly formatted multi-line response if there are meals for the desired date and meal type all 

For `CreateAPostItRequest`:
- ensure the cell id is returned upon success

### Manual testing

Since we use a text-based CSV-like protocol we can test the server using a telnet client. 