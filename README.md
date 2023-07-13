# Brick Breaker

Brick Breaker is a classic arcade game implemented in Java using JavaFX for the graphical user interface. The game is designed to entertain and challenge players by allowing them to control a paddle and a ball to break bricks on the screen. It provides a fun and nostalgic gaming experience, reminiscent of the popular brick-breaking games of the past. The project utilizes Java 11.0.2, Eclipse IDE, JavaFX for the GUI components, and Maven for dependency management. It incorporates refactoring, code maintenance, design patterns, and documentation practices to improve code quality and maintainability.

### Table of Contents  
- **[Project Setup](#project-setup)**<br> 
- **[Refactoring](#refactoring)**<br>
- **[Additions](#additions)**<br>
- **[Documentation](#documentation)**<br>
- **[Git Use](#git-use)**<br>


## Project Setup

I'm using Java 11.0.2 on eclipse.
```
$user > java --version
openjdk 11.0.2 2019-01-15
OpenJDK Runtime Environment 18.9 (build 11.0.2+9)
OpenJDK 64-Bit Server VM 18.9 (build 11.0.2+9, mixed mode)
```

I have tested my program on 2 different Windows devices using Eclipse

To run the game, select Run -> Run Configurations -> Arguments -> 


Add the following line to the VM Arguments:
```
--module-path "/path/to/JavaFX/lib" --add-modules=javafx.controls
```
In my case, the path to my JavaFx library is as follow:
```
--module-path "C:\javafx\javafx-sdk-17.0.1\lib" --add-modules=javafx.controls
```


After that, run
- Maven Build (goal: "verify")
- Maven Clean
- Maven Install


Once the Maven Dependencies folder appeared, the program is now ready to be run.


Now, right click the main project and run it as a Java Application. 

If any error occured, try right click the project -> maven -> reload project.

**Game Starts**


## Refactoring
- Organized classes into packages
- Basic Code Maintenance
	- Renamed Variable & Class name to improve readability
	- Improved encapsulation
	- Added Interfaces (Playable interface)
	- broke down large classes (wall & gameboard class is too large)
	- Error Handling (Throws exception, print error message)
- Removed code smells
	- removed duplicated code
	- removed primitive obsession, used enum instead (enum CrackDirection, enum Impact Direction, enum BrickType)
	- Separated Crack Class into its own individual class to adhere the Single Responsibility principle
	- Did not allow crack class to inherit from brick class due to Liskov's Substitution Principle
- Arranged Code into MVC pattern
	- brick
	- ball
	- player
	- wall
	- crack
- Applied some design patterns
	- Level Factory
	- Brick Factory
	- Ball Factory
	- Added Singleton to Player Class
- Added meaningful JUnit tests, testing for the void methods for each class
	- BrickTest
	- BallTest
	- WallTest
	- PlayerTest
	- CrackTest
	- LevelTest
- Converted the project to Maven project to handle dependencies (JUnit & JavaFx)


## Additions
- Added Highscore 
	- Able to save and load the highscore from a txt file
	- When the current score of the player is greater than the highscore, it overwrites the highscore

![image](https://user-images.githubusercontent.com/76611914/145346830-816b5bf4-68cd-490f-9e8b-99b94041104e.png)


- Added additional levels
	- The presence of special brick when creating a single brick type level
	- From 4 levels -> 8 levels
	- New brick type: Vibranium Brick, stronger than steel brick (able to crack)
	- When creating single type brick level, there's chance to spawn health brick and special brick, when creating chessboard type level, there's 10% chance to spawn health brick


- Additional Features
	- Cheatmode enabled when special brick is destroyed
	- 2 types of cheatmode
		- 30% chance it increases the speed of the ball
		- 70% chance the ball bounces oddly after impact 
	- Added Username input

  ![image](https://user-images.githubusercontent.com/76611914/144702175-58a6d401-e26f-4fb7-bb40-0b8be890a4ce.png)


	- Added health bricks
		- Add health when health brick is destroyed
	- Additional Info Page created using Java Swing
	
  ![image](https://user-images.githubusercontent.com/76611914/144702228-d33f5818-4cac-441f-971c-78743269cdfd.png)


	- Added choice to choose level in Debug Panel

  ![image](https://user-images.githubusercontent.com/76611914/144796566-8b8204d9-0c57-462a-9caf-fe097579543c.png)

  
  
	- Created a main menu using JavaFx

  ![image](https://user-images.githubusercontent.com/76611914/144796471-cdd32bcf-0913-49a6-a7d9-cdf3c162fe1e.png)

	
  
	


## Documentation
- Javadocs 
- High-level class diagram:

![image](https://user-images.githubusercontent.com/76611914/145712652-b76f55de-dde4-408a-9105-e9ba5efd7225.png)



- Readme

## Git Use
- commit history from the start of the project
- meaningful commit messages
- use of branch and merge function
