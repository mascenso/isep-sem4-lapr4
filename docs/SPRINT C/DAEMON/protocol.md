## 4. Communication protocol

* Tcp connection must be established
* Uses the client-server model. The client application (Shared Board App) is the one that takes
  the initiative of requesting a TCP connection establishment with the counterpart server
  application, which should accept incoming connection requests.
* Once established, the TCP connection between the client and the server is kept alive and is used
  for all required data exchanges while the client application is running
* Every request (sent by the client or the server) has a mandatory response (correspondingly sent
  by the server or the client).

### Message Format
| Field      | Offset (bytes) | Length (bytes) | Description                                                                                                                                                                                                                                                                                               |
|------------|----------------|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Version    | 0              | 1              | SBP message format version. This field is a single byte and should be interpreted as an unsigned integer (0 to 255). The present message format version number is one                                                                                                                                     |
| Code       | 1              | 1              | This field identifies the type of request or response, it should be interpreted as an unsigned integer (0 to 255)                                                                                                                                                                                         |
| D_LENGTH_1 | 2              | 1              | These field is used to specify the length in bytes of the DATA field. Both these fields are to be interpreted as unsigned integer numbers (0 to 555). he length of the DATA field is to be calculated as: _LENGTH_1 + 256 x D_LENGTH_2 he length of the DATA field may be zero, meaning it does not exist |
| D_LENGTH_2 | 3              | 1              | Same as D_LENGTH_1                                                                                                                                                                                                                                                                                        |
| Data       | 4              | -              | Contains data to meet the specific needs of the participating applications, the content depends on the message code.                                                                                                                                                                                      |


### Message code
| Code | Meaning  | Description                                                                                                                                                                                                                                                                                            |
|------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0    | COMMTEST | Communications test request with no other effect on the counterpart application than the response with a code two message (ACK). This request has no data                                                                                                                                              |
| 1    | DISCONN  | End of session request. The counterpart application is supposed to respond with a code two message, afterwards both applications are expected to close the session (TCP connection). This request has no data.                                                                                         |
| 2    | ACK      | Generic acknowledgment and success response message. Used in response to successful requests. This response contains no data.                                                                                                                                                                          |
| 3    | ERR      | Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase explaining is carried in the DATA field as string of ASICII codes, it’s not required  to be null terminated. |
| 4    | AUTH     | User authentication request. Described ahead.                                                                                                                                                                                                                                                          |

