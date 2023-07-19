//Brain Boost game logic

// Brain Boost is a memory game where the user is presented with a sequence of numbers. 
// The user has to remember the sequence, and then input it correctly before the time runs out. 

//1. Create canvas and set width and height

    var canvas = document.createElement('canvas');
    canvas.width = 800;
    canvas.height = 600;
    document.body.appendChild(canvas);
    
//2. Declare variables

    //Context to draw on canvas
    var ctx = canvas.getContext("2d");
    //Sequence of numbers to be remembered
    var sequence = [];
    //User's input sequence
    var userInput = [];
    //Create a new game
    var game = {};

//3. Generate Random Number

    function generateRandomNum() {
        return Math.floor(Math.random() * 10);
    }

//4. Create game object

    game.create = function() {
        // Generate random sequence
        for ( var i = 0; i < 5; i++ ) {
            sequence.push(generateRandomNum());
        }
        //Start game time
        game.time = 20;
        game.startTime = Date.now();
        game.gameOver = false;
    }

//5. Update game object

    game.update = function() {
        // Decrement game time
        if (game.time > 0) {
            game.time -= (Date.now() - game.startTime)/1000;
            game.startTime = Date.now();
        }
        //End game if time runs out
        else {
            game.gameOver = true;
        }
    }

//6. Render game

    game.render = function() {
        //Clear canvas
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        //Draw sequence
        for (var i = 0; i < sequence.length; i++) {
            ctx.fillStyle = "blue";
            ctx.font = "24px Arial";
            ctx.fillText(sequence[i], i*50+50, canvas.height/2);
        }
        //Draw user input
        for (var j = 0; j < userInput.length; j++) {
            ctx.fillStyle = "red";
            ctx.font = "24px Arial";
            ctx.fillText(userInput[j], j*50+50, canvas.height/2 + 50);
        }
        //Draw game time
        ctx.fillStyle = "green";
        ctx.font = "24px Arial";
        ctx.fillText(Math.floor(game.time), canvas.width - 50, canvas.height/2);
    }

//7. Check user input

    function checkInput(key) {
        if (key >= 0 && key <= 9) {
            userInput.push(key);
            if (userInput.length > sequence.length) {
                if (compareInput()) {
                    game.gameOver = true;
                }
                else {
                    userInput = [];
                }
            }
        }
    }

//8. Compare user input and random sequence
 
    function compareInput() {
        for (var i = 0; i < userInput.length; i++) {
            if (userInput[i] !== sequence[i]) {
                return false;
            }
        }
        return true;
    }

//9. Listen for user keypress

    window.addEventListener('keydown', function (event) {
        checkInput(event.key);
    });

//10. Game loop

    function loop() {
        if (game.gameOver) {
            console.log("Game over!");
            //Game restart logic
            sequence = [];
            userInput = [];
            game.create();
        }
        else {
            game.update();
            game.render();
            //Call loop again
            requestAnimationFrame(loop);
        }
    }

//11. Run the game logic

    game.create();
    loop();