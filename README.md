This is an implementation of Tennis Kata, in which the mains goal remains in creating a 
score system for a tennis game. 

### Rules details:

- A tennis match begins with the umpire doing a coin toss. The player who wins the toss can choose to serve, receive or pick the side from which they want to start the match.
- The match commences with both players having a score of 0 points (it's also called love).
- Whenever a player secures a point, the game score transitions in the sequence: 0 -> 15 -> 30 -> 40 -> Victory in the game.
- Upon both players reaching a score of 40, the DEUCE regulation is initiated.
- In the event of a DEUCE, the player who secures the point gains the ADVANTAGE.
- If holding the ADVANTAGE, the player who wins the point clinches the game.
- Should the player holding the ADVANTAGE lose the point, the score reverts to DEUCE.

This was implemented by using TDD with JUnit and Hamcrest, and java 21.

---

This Kata goal is to implement a simple tennis score computer.

The scoring system consist in one game, divided by points:
- Each player starts a game with 0 point.
- If the player wins the 1st ball, he will have 15 points.
- 2nd balls won: 30 points.
- 3rd ball won: 40 points.
- If a player has 40 points and wins the ball, he wins the game; however, there are special rules.

If both players have 40 points, the players are “deuce”.

If the game is in deuce, the winner of the ball will have advantage.

If the player with advantage wins the ball, he wins the game.

If the player without advantage wins the ball, they are back at “deuce”.

You can find more details about the rules [here](http://en.wikipedia.org/wiki/Tennis#Scoring).

Here we want you to develop a Java method that will take a String as input containing the character ‘A’ or ‘B’. 
The character ‘A’ corresponds to “player A won the ball”, and ‘B’ corresponds to “player B won the ball”. 
The Java method should print the score after each won ball (for example: “Player A: 15 / Player B: 30”) 
and print the winner of the game.

For example, the following input “ABABAA” should print:

“Player A: 15 / Player B: 0"
“Player A: 15 / Player B: 15"
“Player A: 30 / Player B: 15”
“Player A: 30 / Player B: 30”
“Player A: 40 / Player B: 30”
“Player A wins the game"
