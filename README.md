# COMP2042_CW_hcyyl10
Brick Breaker

#### Table of Contents
[Project Setup] (#setup)


<a name="setup"/>
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


Now, run the project as a Java Application. 

**Game Starts**


