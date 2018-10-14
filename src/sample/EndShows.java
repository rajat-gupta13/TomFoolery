package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class EndShows {
    @FXML
    private Button goodnight;
    @FXML
    private Button seeyalater;
    @FXML
    private Button next;

    Method testMethod = new Method();
    private boolean choiceMade = false;

    public EndShows() throws Exception
    {

    }

    public void PressGoodnightCastle(javafx.event.ActionEvent event) throws Exception {

        goodnight.setStyle("-fx-background-color: #66BB6A; ");
        seeyalater.setStyle("-fx-background-color: #FFFFFF; ");
        System.out.println("Press Goodnight");
        Method.showQueue.add("goodnight");
        choiceMade = true;
        if (choiceMade) {
            Method.showQueue.remove("seeyalater");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        next.setDisable(false);
    }

    public void PressSeeYaLater(javafx.event.ActionEvent event) throws Exception {

        seeyalater.setStyle("-fx-background-color: #66BB6A; ");
        goodnight.setStyle("-fx-background-color: #FFFFFF; ");
        System.out.println("Press See Ya Later!");
        Method.showQueue.add("seeyalater");
        choiceMade = true;
        if (choiceMade) {
            Method.showQueue.remove("goodnight");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        next.setDisable(false);
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception {

        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("Welcome1.fxml"));
        testMethod.ShowSceneFunction(pageone,event);

    }

    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("MiddleShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }
}

