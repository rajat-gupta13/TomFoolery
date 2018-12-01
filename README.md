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

