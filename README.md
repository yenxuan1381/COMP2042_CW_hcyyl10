# COMP2042_CW_hcyyl10
Brick Breaker

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

To run the game, select Run -> Run Configurations -> Arguments -> 


Add the following line to the VM Arguments:
```
--module-path "**/path/to/JavaFX/lib**" --add-modules=javafx.controls
```
In my case, the path to my JavaFx library is as follow:
```
--module-path "C:\javafx\javafx-sdk-17.0.1\lib" --add-modules=javafx.controls
```


After that, run
- Maven Build
- Maven Clean
- Maven Install


Everything is working fine if the "BUILD SUCCESS" is printed in the console


Now, run the project as a Java Application. **Game Starts**


## Refactoring
- Organized classes into packages
- Removed code smells
	- removed duplicated code
	- improved encapsulation
	- broke down large classes to adhere the SOLID principle
	- added interfaces (playable interface)
	- removed primitive obsession, used enum instead
- Arranged Code into MVC pattern
- Applied some design patterns
	- Level Factory
	- Brick Factory
	- Added Singleton to Player Class
- Added meaningful JUnit tests
	- BrickTest
	- BallTest
	- WallTest
	- PlayerTest
- Converted the project to Maven project


## Additions
- Added Highscore

[insert image]

- Added Username input

![image](https://user-images.githubusercontent.com/76611914/144702175-58a6d401-e26f-4fb7-bb40-0b8be890a4ce.png)


- Added additional levels
	- The presence of special brick when creating a single brick type level
	- From 4 levels -> 8 levels
	- New brick type: Vibranium Brick, stronger than steel brick (able to crack)
- Additional Features
	- Cheatmode enabled when special brick is destroyed
	- 2 types of cheatmode
		- 30% increases the speed of the ball
		- 70% the ball bounces oddly after impact
	- Additional Info Page created using Java Swing
	
  ![image](https://user-images.githubusercontent.com/76611914/144702228-d33f5818-4cac-441f-971c-78743269cdfd.png)
  
  
	- Created a main menu using JavaFx

  [insert image]
	
  
	


## Documentation
- Javadocs : [insert link here]
- High-level class diagram:
- Readme

## Git Use
- commit history from the start of the project
- meaningful commit messages
- use of branch and merge function
