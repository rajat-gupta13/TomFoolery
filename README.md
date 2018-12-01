# TomFoolery
Tom Foolery is a five function audio animatronic puppet created by the Miracle Workshop team at Carnegie Mellon University’s Entertainment Technology Center. The puppet was installed at Give Kids the World Village in Kissimmee, Florida. This is the code for the touch screen interface that the staff at the village can use to control Tom Foolery. 

## Before you begin: 
1. You will need an IDE that supports JavaFX. We used JetBrains IntelliJ, but anything else would also work like Eclipse.
2. You will also need the JDK 8u191 and JRE installed. You can find them here: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html 
3. The interface is designed to have a show queue system at the start where, players can choose what shows they want to play, review their selection and then play through the entire show. 
4. There will always be one Start show and one End show but the staff can decide whether to choose any of the Middle shows including the Seasonal Content.
5. Once the players are done selecting shows, they can start playing shows. The first screen on a show is always the title screen with the Start show button that plays the first and sometimes only dialogue of the show.
6. After the specified amount of delay, the Play Next Dialogue button appears which triggers the next dialogue. In some shows, there are additional dialogue options. 
7. At the end of each show, there will be a Next button leading to the next show in the queue or an End Show button leading to the Main Menu.
8. On each button press of the Play Next Dialogue or the Main Menu, the Animatronic is faded from its current position to its central idle position in the specified amount of time to avoid snapping in the animatronic. This means there is a delay of the specified time before which the next dialogue is played.
9. The Default resolution of the Touch Screen Interface is 1920x1080. Whenever you create a new page, make sure to make the changes to .fxml file so that the aspect ratio of the pane is maintained.

## Classes:
Open /src/sample/
 
| Class           | Description   |
| -------------   | ------------- |
| Main.java       | This is the most important default class that is used to build and run the entire application. It opens the page sample.fxml that contains the Main Menu.  |
| Controller.java | This is the default class linked to sample.fxml. It controls the Power on Tom being toggled On/Off. It also leads to the Admin Panel or the Show Selection screens.  |
| Method.java     | This is the class that all the show classes creates objects of to access all the methods. This is the most important class in the application. Some of the methods in the class are:<br>1. SendInstructionToWeigl(String s): It sends the ASCII command stored in the String “s” as a Datagram packet to the Weigle show controller.<br>2. ResetAllPositions(float fadeTime): It sends ASCII commands to the show controller to fade the functions of Tom to their central idle position in fadeTime seconds.<br>3. ShowSceneFunction(Parent pageone, javafx.event.ActionEvent event): When called displays the .fxml Page that was assigned to pageone.<br>4. ShowSelector(): Called on the Next button presses at the end of a show to check which is the next show in the queue. |
| AdminLogin.java | Class for the login screen to the Admin Panel. Connected to AdminLogin.fxml.  |
| AdminPanel.java | Class for the Admin Panel. Calisthenics and Thank You Sponsors show is currently active. Optionally add the Control Functions screen. Connected to AdminPanel.fxml. |
| Calisthenics.java | Class for the Calisthenics of Tom’s functions. The functions can be operated individually or together. Once started, the calisthenics will keep on playing until the user manually presses the Stop button. Connected to Calisthenics.fxml. |
| ThankYouSponsors.java | Class for the Thank You Sponsors show. The show has 4 dialogues. Connected to ThankYouSponsors.fxml |
| StartShows.java | Class for selecting a Start show to add to show queue. The staff can select either the Welcome Castle show or the Magic Trick show. A selection needs to be made to proceed. Connected to StartShows.fxml |
| MiddleShows.java  | Class for selecting Middle shows to add to show queue. No selections is required to be made to proceed to the next page. The staff can select one of four Dance Parties, a Storytime show or a selection of Seasonal Content that are displayed on a separate page. More than one item can be selected. Connected to MiddleShows.fxml |
| SeasonalContent.java  | Class for selecting Seasonal Content to add to show queue. Only one show can be selected. The options are Christmas; Easter; Halloween; Hanukkah; Happy Birthday; Happy Birthday Mayor Clayton; 4th of July; Labor Day; Thanksgiving and Veterans Day. Connected to SeasonalContent.fxml. Pressing the Next button returns to the Middle Shows page.  |
| EndShows.java | Class for selecting an Endshow to add to show queue. The staff can select either the Goodnight Castle show or the See Ya Later show. A selection needs to be made to proceed. Connected to EndShows.fxml  |
| ReviewSelection.java  | Class for Reviewing the Selections made. The shows in the queue will be displayed. There is a minimum of 2 shows that will always be played and a maximum of 5 shows. Connected to ReviewSelections.fxml  |
| WelcomeCastle1.java | Class for the Welcome Castle show. The show has 7 dialogues. Connected to WelcomeCastle1.fxml |
| MagicTrick1.java  | Class for the Magic Trick show. The show has 7 dialogues. Connected to MagicTrick1.fxml |
| DanceParty1.java  | Class for the Dance Party show. The show has 7 dialogues. Connected to DanceParty1.fxml. A few dialogues have additional capability of adding “Yes” before the next dialogue if the guests know the answer to a particular joke. There are 4 types of Dance Parties, a Long 5 minute one, a short 2 minute 30 seconds one, a Christmas Dance Party mix and an empty Dance animation where the staff can play their own music selection. |
| Storytime1.java | Class for the Storytime show. The show has 8 dialogues. Connected to Storytime1.fxml. The last dialogue in the show is chosen depending on what end show is selected. A few dialogues have additional capability of adding “Yes” before the next dialogue if the guests know the answer to a particular joke. There are extra responses when Tom is asking the guests about their favorite books. There are responses when the book is being read to the guests.  |
| GoodnightCastle1.java | Class for the Goodnight Castle show. The show has 7 dialogues. Connected to GoodnightCastle1.fxml. The last 3 dialogues of the show are played one after the other and are automatically triggered. The last dialogue triggers the interaction with the Father Time animatronic in the castle.  |
| SeeYaLater1.java  | Class for the See Ya Later show. The show has 5 dialogues. Connected to SeeYalater1.fxml  |
| Christmas.java | Class for the Seasonal Content Christmas show. The show has 5 dialogues. Connected to Christmas.fxml  |
| Easter.java | Class for the Seasonal Content Easter show. The show has 1 dialogue. Connected to Easter.fxml |
| Halloween.java | Class for the Seasonal Content Halloween show. The show has 2 dialogues. Connected to Halloween.fxml |
| Hanukkah.java | Class for the Seasonal Content Hanukkah show. The show has 1 dialogues. Connected to Hanukkah.fxml
| HappyBirthday.java | Class for the Seasonal Content Happy Birthday show. The show has 1 dialogues. Connected to HappyBirthday.fxml
| HappyBirthdayClayton.java | Class for the Seasonal Content Happy Birthday Mayor Clayton show. The show has 1 dialogues. Connected to HappyBirthdayClayton.fxml  |
| IndependenceDay.java |  Class for the Seasonal Content 4th of July show. The show has 1 dialogues. Connected to IndependenceDay.fxml  |
| LaborDay.java | Class for the Seasonal Content Labor Day show. The show has 1 dialogues. Connected to LaborDay.fxml |
| Thanksgiving.java | Class for the Seasonal Content Thanksgiving show. The show has 1 dialogues. Connected to Thanksgiving.fxml  |
| VeteransDay.java  | Class for the Seasonal Content Veterans Day show. The show has 1 dialogues. Connected to VeteransDay.fxml |
| ControlFunctions.java | [EXPERIMENTAL] Class to toggle the functions on Tom On/Off. The functions last tested were still in Beta on the version 3.25 of the Show Controller. Connected to the ControlFunctions.fxml |
| OpeningCeremony.java  | [EXTRA] Class for Special Opening Ceremony show that was played on 11/09/2018 at the Give Kids the World Village. Not part of final build.  |
