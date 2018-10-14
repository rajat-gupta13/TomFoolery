package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class MiddleShows implements Initializable {

    @FXML
    private Button dance;
    @FXML
    private Button story;

    Method testMethod = new Method();

    public MiddleShows() throws Exception
    {

    }

    private void CheckStatus() {
        if (Method.showQueue.contains("dance")) {
            dance.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("story")) {
            story.setStyle("-fx-background-color: #66BB6A; ");
        }
    }
    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("StartShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
        if (Method.showQueue.contains("dance")){
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance");
            Method.showQueue.remove("dance");
        }
        if (Method.showQueue.contains("story")){
            story.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Story");
            Method.showQueue.remove("story");
        }
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception {

        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("EndShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressDanceParty(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance"))
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance");
            Method.showQueue.add("dance");
        }else if (Method.showQueue.contains("dance")) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance");
            Method.showQueue.remove("dance");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressStoryTime(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("story"))
        {
            story.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Story");
            Method.showQueue.add("story");
        }else if (Method.showQueue.contains("story")) {
            story.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Story");
            Method.showQueue.remove("story");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CheckStatus();
    }
}
