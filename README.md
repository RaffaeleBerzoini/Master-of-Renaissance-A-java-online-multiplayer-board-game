<p align="center">
  <img alt="🧝_♂️Master_of_Renaissance" src="https://user-images.githubusercontent.com/62103572/182853946-59f2b6f0-6023-4cf4-a3fc-8db3c3218912.png">
  <img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/y/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game">
  <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game">
  <img alt="GitHub code size" src="https://img.shields.io/github/languages/code-size/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game">
  <img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game">
  <img alt="GitHub follow" src="https://img.shields.io/github/followers/EliaFantini?label=Follow">
  <img alt="GitHub fork" src="https://img.shields.io/github/forks/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game?label=Fork">
  <img alt="GitHub watchers" src="https://img.shields.io/github/watchers/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game?abel=Watch">
  <img alt="GitHub star" src="https://img.shields.io/github/stars/EliaFantini/Master-of-Renaissance-A-java-online-multiplayer-board-game?style=social">
</p>

Master of Renaissance is an online multiplayer board game coded in java, playable both on a javaFX GUI or on CLI. 

The game was made as final project of the course *Software Engineering* (2020/2021) and presented as *Engineering of Computing Systems* Bachelor’s graduation's final project. 

The game is entirely coded with java, plus javaFX and CSS for the GUI. Client side and Server side were both coded from the very backbone using a complex structure of java classes. Once the server has been set up and is running, all players can connect to it from all over the world (multiplayer function), chosing to play either on a command line user interface or on a more practical GUI. The server will wait for the players to join while players wait in a lobby screen, then the match will start. 

Main functionalities:
- Multiple games: the server can handle multiple matches between different players simultaneously.
- Disconnections: if a player disconnects the server will save it's state and let the other players continue the match. When the player will join the match again, it will restart from where he had left.
- Persistence: the server constantly saves all matches' states, so that if the server disconnects for some connection problems or it crashes, it is not a problem. In fact, whenever the connection problem is solved and the server is set up again and running, all the players will be able to rejoin the match, without having to start all over again.

| Functionality | State |
|:-----------------------|:------------------------------------:|
| Basic rules | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png)|
| Complete rules | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) |
| Socket | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) |
| GUI | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) |
| CLI | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png)|
| Multiple games | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) |
| Persistence | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) |
| Disconnections | ![#c5f015](https://via.placeholder.com/15/c5f015/c5f015.png) |


## Authors
- [Elia Fantini](https://www.github.com/EliaFantini)
- [Raffaele Berzoini](https://github.com/RaffaeleBerzoini)
- [Elisabetta Fedele](https://github.com/elisabettafedele)
## Gameplay
The following video shows a quick match between two players, one using the GUI and one using the CLI, while the server is running on the same machine (which is not necessary, it might have also been on another pc connected to internet). If you hare using Windows like me, you should run the CLI on the PowerShell or another shell substitute, it won't work on the command prompt. 
The GUI  is optimized for a Full HD screen. Since my monitor is 2K, I could go to *screen settings*->*resizing*  (on Windows) and set it to 125% to have a bigger window of the game and read the cards more easily, but in the video it was set to 100% to give a broader view of the two players.

https://user-images.githubusercontent.com/62103572/182883994-5d008b6a-d6a9-4bee-8062-276d7a60f058.mp4


## Contents
* **Deliverables**: folder containing the two jar files (in the *jar* folder) to execute the server and the client, and another *UML* folder containing all sequence and class diagrams.
* **src**: folder containing all code files, including code's tests.
* **Presentation.pdf**: pdf with the project presentation.

## How to install and play
- Download the repository as a zip file and extract its content into a folder
- In the [Deliverables](Deliverables) folder there are two multi-platform jar files, one to set the Server up, and the other one to start the Client.
- If you don't have java installed in your machine, [download Java 11 or higher](https://www.oracle.com/java/technologies/downloads/archive/) first and install it.
- The Server can be run with the following command on a shell prompt, as default it runs on port 1234:
    ```shell
    > java -jar MasterOfReinassanceServer.jar
    ```
  This command can be followed by these arguments:
  - **-port**: followed by the desired port number between MIN_PORT (1024) and MAX_PORT (65535) as argument;
  - **-log**: to save the log in a file;
  - **-help**: to get help.

- The Client can be run with the following command on a shell prompt:
    ```shell
    > java -jar MasterOfReinassanceClient.jar
    ```
    - This command sets the Client on Graphical User Interface (GUI) mode, but it can be followed by **-cli** if the Command Line Interface (CLI) is preferred.
    - The Server's IP and port to connect to can be specified during the execution.
    



## CLI View
![Immagine1](https://user-images.githubusercontent.com/62103572/131249493-2e6940a1-c5e1-4ad9-b803-a3c2131cd2c2.png)

## GUI View
![Immagine3](https://user-images.githubusercontent.com/62103572/131249497-571b9ab9-b9ee-4295-8fef-343e32dc52f5.png)

### Server's simplified class diagram
![Initial-Model-Controller_UML](https://user-images.githubusercontent.com/62103572/182864378-08be4ee4-04d1-4e41-a8f6-d6f71503557c.png)
### Server-Client Network simplified class diagram
![Initial-Network_UML](https://user-images.githubusercontent.com/62103572/182864401-a7a269e0-76fc-4369-b254-fdccb1022ae5.png)

## Tools used
* [draw.io](http://draw.io) - UML Diagram
* [Maven](https://maven.apache.org/) - Dependency Management
* [IntelliJ](https://www.jetbrains.com/idea/) - IDE
* [JavaFX](https://openjfx.io) - Graphical Framework
## 🛠 Skills
Java, CSS, JavaFX, UML, JSON. Complex class structure with UML, advanced Java implentation of internet communication Client-to-Server and Server-to-Client. Game design for a practival and visually pleasing experience of the board game. Handling of server problems and features such as discconections, multiple games and match persistency.
## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/EliaFantini/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/-elia-fantini/)

## License

This project is developed in collaboration with [Politecnico di Milano](https://www.polimi.it) and [Cranio Creations](http://www.craniocreations.it)
