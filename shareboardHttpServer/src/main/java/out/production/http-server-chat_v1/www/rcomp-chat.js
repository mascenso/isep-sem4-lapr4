
// global variables
var nextMsg;
var mArea,nicknameBox, messageBox, hints; // defined only after the document is loaded

var cardId = 0; // global variable to keep track of the card IDs

function loadAndStart() {
    mArea=document.getElementById("messages");
    nicknameBox=document.getElementById("nickname");
    messageBox=document.getElementById("message");
    hints=document.getElementById("hints");
    nextMsg=0;
    setTimeout(getNextMessage, 1000);

    var board = document.querySelector('.board');

    for (var i = 0; i < 10; i++) {
        var column = addColumn();

        for (var j = 0; j < 20; j++) {
            var card = addCard(column, i*20 + j + 1);
            column.appendChild(card);
        }

        board.appendChild(column);
    }
    }

function getNextMessage() {
    var request = new XMLHttpRequest();

    request.onload = function() {
        if(nextMsg===0) {
		mArea.value = "";
        	mArea.style.color="blue";
	}
        mArea.value = mArea.value + this.responseText + "\r\n";
        mArea.scrollTop = mArea.scrollHeight; // scroll the textarea to make last lines visible
        nextMsg=nextMsg+1;
        setTimeout(getNextMessage, 100);
        };

    request.onerror = function() {
        nextMsg=0;
        mArea.value = "Server not responding.";
        mArea.style.color="red";
        setTimeout(getNextMessage, 1000);
    };

    request.ontimeout = function() {
        nextMsg=0;
        mArea.value = "Server not responding.";
        mArea.style.color="red";
        setTimeout(getNextMessage, 100);
    };


    request.open("GET", "/messages/" + nextMsg, true);
    if(nextMsg===0) request.timeout = 1000;
    // Message 0 is a server's greeting, it should always exist
    // no timeout, for following messages, the server responds only when the requested
    // message number exists
    request.send();
}

function postMessage() {
    hints.innerHTML="";
    if(nicknameBox.value === "") {
        hints.innerHTML="Settle a nickname before sending.";
        return;
        }
    if(messageBox.value === "") {
        hints.innerHTML="Not sending empty message.";
        return;
        }
    var POSTrequest = new XMLHttpRequest();
    nicknameBox.disabled=true;
    POSTrequest.open("POST", "/messages", true);
    POSTrequest.timeout = 5000;
    POSTrequest.send("(" + nicknameBox.value + ") " + messageBox.value);
    }

// Function to add a new card
function addCard(column, cardId) {
    var newCardContainer = column.querySelector('.newCardContainer');


    // Create a span element to display the card ID
    var cardIdSpan = document.createElement('span');
    cardIdSpan.textContent = 'Card ID: ' + cardId;


    // Create a new card element
    var card = document.createElement('div');
    card.classList.add('card');

    // Create a non-editable textarea element
    var textarea = document.createElement('textarea');
    textarea.setAttribute('readonly', true);

    // Create an input field for text input
    var inputField = document.createElement('input');
    inputField.type = 'text';
    inputField.placeholder = 'Enter text';

    // Create the delete button for the card
    var deleteButton = createDeleteButton(card);

    // Add an event listener to the input field
    inputField.addEventListener('change', function() {
        var text = this.value;
        if (text.trim() !== '') {
            postContent(card, text); // Send the text content to the server
            textarea.value = text; // Update the textarea with the posted content
            inputField.value = ''; // Clear the input field
        }
    });

    // Append the input field, textarea, and delete button to the card
    card.appendChild(cardIdSpan);
    card.appendChild(inputField);
    card.appendChild(textarea);
    card.appendChild(deleteButton);

    // Append the new card to the column
    column.insertBefore(card, newCardContainer);

    return card;
}

// Function to post the content to the server
function postContent(card, text) {
    // Here, you can make a POST request to the server
    // and send the card reference and text content as data
    // using your preferred method (e.g., XMLHttpRequest, Fetch API, Axios)

    // Example using XMLHttpRequest
    var request = new XMLHttpRequest();
    request.open("POST", "/messages", true);
    request.timeout = 5000;
    request.setRequestHeader('Content-Type', 'application/json');
    request.onload = function() {
        // Handle the response from the server if needed
    };
    var data = {
        card: card,
        content: text
    };
    request.send(JSON.stringify(data));
}


// Function to delete a card
function deleteCard(card) {
    card.parentNode.removeChild(card);
}

// Function to create the delete button for a card
function createDeleteButton(card) {
    var deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.addEventListener('click', function() {
        deleteCard(card);
    });
    return deleteButton;
}

// Function to create the add card button for a column
function createAddCardButton(column) {
    var addCardButton = document.createElement('button');
    addCardButton.textContent = 'Add a card...';
    addCardButton.addEventListener('click', function() {
        addCard(column);
    });
    return addCardButton;
}

// Function to add a new column
function addColumn() {
    var board = document.querySelector('.board');
    var newColumnContainer = document.getElementById('newColumnContainer');

    // Create a new column element
    var column = document.createElement('div');
    column.classList.add('column');

    // Create the delete button for the column
    var deleteButton = createDeleteButton(column);

    // Create the add card button for the column
    var addCardButton = createAddCardButton(column);

    // Create the column title
    var columnTitle = document.createElement('h3');
    columnTitle.textContent = 'New Column';

    // Create the container for new cards
    var newCardContainer = document.createElement('div');
    newCardContainer.classList.add('newCardContainer');

    // Append the delete button, column title, add card button, and new card container to the column

    column.appendChild(columnTitle);
    column.appendChild(deleteButton);
    column.appendChild(addCardButton);
    column.appendChild(newCardContainer);


    // Append the new column to the board
    board.insertBefore(column, newColumnContainer);

    return column;
}

// Function to delete a column
function deleteColumn(column) {
    column.parentNode.removeChild(column);
}






