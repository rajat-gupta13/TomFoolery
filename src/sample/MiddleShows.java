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
    @FXML
    private Button danceShort;
    @FXML
    private Button danceLong;

    private boolean danceOpen = false;

    Method testMethod = new Method();

    public MiddleShows() throws Exception
    {

    }

    private void CheckStatus() {
        if (Method.showQueue.contains("dance")) {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            if (Method.isDancePartyShort && !Method.isDancePartyLong)
            {
                danceShort.setStyle("-fx-background-color: #66BB6A; ");
            }else if (!Method.isDancePartyShort && Method.isDancePartyLong)
            {
                danceLong.setStyle("-fx-background-color: #66BB6A; ");
            }
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
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartLoop = false;
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

        if (!danceOpen) {
            danceShort.setVisible(true);
            danceLong.setVisible(true);
            danceOpen = true;
        }
        else if (danceOpen) {
            danceShort.setVisible(false);
            danceLong.setVisible(false);
            danceOpen = false;
        }
    }

    public void PressDancePartyShort(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartLoop)
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            danceShort.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance Short");
            Method.showQueue.add("dance");
            Method.isDancePartyShort = true;
            Method.isDancePartyLong = false;
            Method.isDancePartLoop = false;
        }else if (Method.showQueue.contains("dance") && Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartLoop) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            danceShort.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance Short");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartLoop = false;
        } else if (Method.showQueue.contains("dance") && Method.isDancePartyLong && !Method.isDancePartyShort && !Method.isDancePartLoop) {
            danceShort.setStyle("-fx-background-color: #66BB6A; ");
            danceLong.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Short");
            Method.isDancePartyShort = true;
            Method.isDancePartyLong = false;
            Method.isDancePartLoop = false;
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }


    public void PressDancePartyLong(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartLoop)
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            danceLong.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance Long");
            Method.showQueue.add("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = true;
            Method.isDancePartLoop = false;
        }else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && Method.isDancePartyLong && !Method.isDancePartLoop) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            danceLong.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance Long");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartLoop = false;
        } else if (Method.showQueue.contains("dance") && Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartLoop) {
            danceLong.setStyle("-fx-background-color: #66BB6A; ");
            danceShort.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Long");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = true;
            Method.isDancePartLoop = false;
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

    public void PressSeasonalContent(javafx.event.ActionEvent event) throws Exception {

        Parent pageone = FXMLLoader.load(getClass().getResource("SeasonalContent.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
        Method.isDancePartyShort = false;
        Method.isDancePartyLong = false;
        Method.isDancePartLoop = false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CheckStatus();
    }
}
