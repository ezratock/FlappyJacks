# Flappy Jacks

| Name            | Email                    |
|-----------------|--------------------------|
| Dylan Mckellips | dmckelli@u.rochester.edu |
| Andres Montoya  | amontoy6@u.rochester.edu |
| Ezra Tock       | etock@u.rochester.edu    |
| Leo Sciortino   | lsciort2@u.rochester.edu |

##Running Instructions
Compatible to run from both the terminal and an IDE with Game.java as the main class.
###Using the Terminal
Compile all files in the Project3/src directory (from the parent directory of Project3, run `javac Project3/src/*` in the terminal) <br>
Run Project3/src/Game.java (from the parent directory of Project3, run `java Project3/src/Game` in the terminal)
###Using an IDE
Import the Project3 folder into the IDE with an SDK of Java version 17 or later. <br>
Set up a running configuration with working directory Project3 and main class src.Game and run it

##How To Play
The purpose of the game is to guide the flapjacks through the pillars without touching the floor, the ceiling, or any of the forks in the way. Pressing space (or any key, for that matter) will cause actions to be performed. Two actions happen—flap or restart. A key-press instigated flap will cause the flapjack’s position to rise, otherwise “gravity” will cause it to fall. Upon dying (hitting one of the pillars, the floor, or the ceiling), a key press will restart the game.


##Project Requirements
The animation is evident by the moving flapjack and pillars. <br>
The interaction comes from the flapjack’s response to a keypress. <br>
The scoring mechanism counts how many pillars are passed, and is displayed in the top left corner of the screen. <br>
The definitive ending mechanism occurs when a pillar is hit. <br>
The physical mechanisms are velocity and acceleration (gravity). <br>
Collision detection occurs when the flapjack hits the pillars, ceiling, or floor. <br>
Creativity is subjective, yes? <br>
Our flourishes are the graphics, high scores.


##Project Structure
The classes in this project
###Game.java
The game class contains our main game loop. A GameFrame is initialized and then run every 13 milliseconds with the _update_ method until boolean variables _GamePanel.gameOver_ or _GamePanel.reset_ signify the reset mechanism, _resetGame_, should be called. The _resetGame_ method resets the score stored in the UI class after a short delay and then resets many of the other classes in the line `gameFrame.update(stopUpdate);`.

###GameFrame.java
The GameFrame class, derived from the javax.swing.JFrame package, controls the frame our GamePanel is painted on and initializes important variables like the frames height and width.  It contains _update_ and _reset_ methods, which when called then, in turn, call `panel.update(birdDead);` and `panel.reset();`.

###GamePanel.java
The GamePanel class, derived from the javax.swing.JPanel package, controls the game panel and collision detection. Our GamePanel class initializes a new Bird (the playable character), Pillars, and UI instance from their respective classes, as well as initializing variables relating to gamestate (gameOver, reset) and graphics (background, ground, and the associated ground dimension variables). Everytime the GamePanel is updated, there is a check for the player's collision with the forks, ground, or ceiling. If they occur, the player "dies" and the reset mechanism is called. Otherwise, the player's position is updated according to the phsyics and repainted to the frame.

###GameComponenet.java
The abstract class GameComponent, derived from the javax.swing.JComponent package, is a parent class all JComponents used in our game. It contains empty update and getProperties methods.

###UI.java
The UI class handles displaying the score. Every time the GamePanel is updated, the _updateScoreDisplay_ and _updateHighScore_ methods update the new current score and high score being displayed if they have changed. When the UI is reset, the score is set to 0.

###Pillars.java
The Pillars class controls all the pairs of forks on the screen, which are stored in an array of type Pillar called _pills_. There are always only 2 "pillars" on the screen, each containing one fork on the lower half of the screen and one on the upper half. Each time the GamePanel is updated, the pillar class checks if the player has passed it, in which case it incraeses the score by one, and also if the pillar has made it past the left side of the screen, in which case the _resetPillars()_ method cycles them back to the right side of the screen. Then, all the pillars are moved to the left

###Pillar.java
The Pillar class controls each individual fork.  The _initializePillar_ method creates a random “gap” variable that determines where the gap in the forks will be and sets the forks' location rightwards half of the frame's width if it is the second pillar to ensure equal spacing. The _isAtEnd_ method checks if the pillar has reached the end of the screen, and then the _reset_ method moves the forks back to the right of the screen.

###RectangleComponent.java
The RectangleComponent class stores values for the RectangleComponents comprising the pillars. It has set and get methods for each value (x, y, width, height), and each of these variables are initialized, as well as color and rectangle. The RectangleComponent method is a constructor that takes x, y, width, height, and color methods then creates a Rectangle.
The paintComponent methods sets color and paints the rectangle.
The update method is empty.
The getProperties method returns an array of the values comprising the rectangle.

###Bird.java
The Bird class controls the flying flapjack that the user controls.  Every time a key is pressed, the flapjacks' upwards velocity will be set to a positive value, and then the flapjacks will fall towards the ground due to gravity.  If it hits the ceiling, floor, or any of the forks on the screen, the _isDead_ boolean is used to store the player's death.  After the flapjacks die, the gravity still affects it until they touches the floor.  Every time the flapjacks "flap", a different image is used to visually show the flapjacks thrusting upwards.

###MovningGroup.java
The MovingGroup class stores a group of MovingObjects so that code storing multiple MovingObjects is more readable.

###MovingObject.java
The MovingObject class handles all objects that move along with the scrolling backdrop, which is currently only the ground sprites.  Were we to continue with this project, we were thinking of adding power-ups and potentially a start screen which would also utilize the MovingObject class.

