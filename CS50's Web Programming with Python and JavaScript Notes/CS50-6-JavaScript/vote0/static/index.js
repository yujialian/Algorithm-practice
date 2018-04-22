document.addEventListener('DOMContentLoaded', () => {

    // Connect to websocket:allow real time communication between client and server
    var socket = io.connect(location.protocol + '//' + document.domain + ':' + location.port);
                            //http or https               domain name        Port that currently working on
// When connected, configure buttons
    socket.on('connect', () => {
        //Once the websocket is connected, make sure all the buttons are configure to do sth with websocket,
        //in particular, when the button is clicked, I want to emit a new event, telling the world, telling
        //the webserver the vote has been submitted.

        // Each button should emit a "submit vote" event
        document.querySelectorAll('button').forEach(button => {
            button.onclick = () => {
                const selection = button.dataset.vote;
                socket.emit('submit vote', {'selection': selection});
                //emit the event to the webserver, name: submit vote
                //pass in the data that associate with this event.
                
            };
        });
    });

    // When a new vote is announced, add to the unordered list
    socket.on('announce vote', data => {
        const li = document.createElement('li');
        li.innerHTML = `Vote recorded: ${data.selection}`;
        document.querySelector('#votes').append(li);
    });
});
