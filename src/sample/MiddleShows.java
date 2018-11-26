package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    @FXML
    private Button danceChristmas;
    @FXML
    private Button danceLoop;
    @FXML
    private Label seasonalContentSelection;
    @FXML
    private Button seasonalContent;

    private boolean danceOpen = false;

    Method testMethod = new Method();

    public MiddleShows() throws Exception
    {

    }

    private void CheckStatus() {
        if (Method.showQueue.contains("dance")) {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            if (Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop)
            {
                danceShort.setStyle("-fx-background-color: #66BB6A; ");
            }else if (!Method.isDancePartyShort && Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop)
            {
                danceLong.setStyle("-fx-background-color: #66BB6A; ");
            }
            else if (!Method.isDancePartyShort && !Method.isDancePartyLong && Method.isDancePartyChristmas && !Method.isDancePartyLoop)
            {
                danceChristmas.setStyle("-fx-background-color: #66BB6A; ");
            }
            else if (!Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && Method.isDancePartyLoop)
            {
                danceLoop.setStyle("-fx-background-color: #66BB6A; ");
            }
        }

        if (Method.showQueue.contains("story")) {
            story.setStyle("-fx-background-color: #66BB6A; ");
        }

        if (Method.showQueue.contains("halloween")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Halloween selected");
        }else if (Method.showQueue.contains("christmas")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Christmas selected");
        }else if (Method.showQueue.contains("hanukkah")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Hanukkah selected");
        }else if (Method.showQueue.contains("easter")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Easter selected");
        }else if (Method.showQueue.contains("thanksgiving")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Thanksgiving selected");
        }else if (Method.showQueue.contains("independence")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("4th of July selected");
        }else if (Method.showQueue.contains("clayton")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Happy Birthday Mayor Clayton selected");
        }else if (Method.showQueue.contains("birthday")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Happy Birthday selected");
        }else if (Method.showQueue.contains("labor")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Happy Labor Day selected");
        }else if (Method.showQueue.contains("veteran")) {
            seasonalContent.setStyle("-fx-background-color: #66BB6A; ");
            seasonalContentSelection.setVisible(true);
            seasonalContentSelection.setText("Happy Veterans Day selected");
        }else {
            seasonalContent.setStyle("-fx-background-color: #FFFFFF; ");
            seasonalContentSelection.setVisible(false);
        }
    }
    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(3);
        Parent pageone = FXMLLoader.load(getClass().getResource("StartShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
        if (Method.showQueue.contains("dance")){
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        }
        if (Method.showQueue.contains("story")){
            story.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Story");
            Method.showQueue.remove("story");
        }
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception {

        testMethod.ResetAllPositions(3);
        Parent pageone = FXMLLoader.load(getClass().getResource("EndShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressDanceParty(javafx.event.ActionEvent event) throws Exception {

        if (!danceOpen) {
            danceShort.setVisible(true);
            danceLong.setVisible(true);
            danceChristmas.setVisible(true);
            danceLoop.setVisible(true);
            danceOpen = true;
        }
        else if (danceOpen) {
            danceShort.setVisible(false);
            danceLong.setVisible(false);
            danceChristmas.setVisible(false);
            danceLoop.setVisible(false);
            danceOpen = false;
        }
    }

    public void PressDancePartyShort(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop)
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            danceShort.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance Short");
            Method.showQueue.add("dance");
            Method.isDancePartyShort = true;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        }else if (Method.showQueue.contains("dance") && Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            danceShort.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance Short");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && Method.isDancePartyLong && !Method.isDancePartyShort && !Method.isDancePartyChristmas && !Method.isDancePartyLoop) {
            danceShort.setStyle("-fx-background-color: #66BB6A; ");
            danceLong.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Short DS Long");
            Method.isDancePartyShort = true;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyLong && !Method.isDancePartyShort && Method.isDancePartyChristmas && !Method.isDancePartyLoop) {
            danceShort.setStyle("-fx-background-color: #66BB6A; ");
            danceChristmas.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Short DS Christmas");
            Method.isDancePartyShort = true;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        }
        else if (Method.showQueue.contains("dance") && !Method.isDancePartyLong && !Method.isDancePartyShort && !Method.isDancePartyChristmas && Method.isDancePartyLoop) {
            danceShort.setStyle("-fx-background-color: #66BB6A; ");
            danceLoop.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Short DS Loop");
            Method.isDancePartyShort = true;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }


    public void PressDancePartyLong(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop)
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            danceLong.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance Long");
            Method.showQueue.add("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = true;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        }else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            danceLong.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance Long");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && !Method.isDancePartyLoop) {
            danceLong.setStyle("-fx-background-color: #66BB6A; ");
            danceShort.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Long DS Short");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = true;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && Method.isDancePartyChristmas && !Method.isDancePartyLoop) {
            danceLong.setStyle("-fx-background-color: #66BB6A; ");
            danceChristmas.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Long DS Christmas");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = true;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas && Method.isDancePartyLoop) {
            danceLong.setStyle("-fx-background-color: #66BB6A; ");
            danceLoop.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Long DS Loop");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = true;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        }

        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressDancePartyChristmas(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas  && !Method.isDancePartyLoop)
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            danceChristmas.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance Christmas");
            Method.showQueue.add("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = true;
            Method.isDancePartyLoop = false;
        }else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && Method.isDancePartyChristmas  && !Method.isDancePartyLoop) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            danceChristmas.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance Christmas");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas  && !Method.isDancePartyLoop) {
            danceChristmas.setStyle("-fx-background-color: #66BB6A; ");
            danceShort.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Christmas DS Short");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = true;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && Method.isDancePartyLong && !Method.isDancePartyChristmas  && !Method.isDancePartyLoop) {
            danceChristmas.setStyle("-fx-background-color: #66BB6A; ");
            danceLong.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Christmas DS Long");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = true;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas  && Method.isDancePartyLoop) {
            danceChristmas.setStyle("-fx-background-color: #66BB6A; ");
            danceLoop.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Christmas DS Loop");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = true;
            Method.isDancePartyLoop = false;
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressDancePartyLoop(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas  && !Method.isDancePartyLoop)
        {
            dance.setStyle("-fx-background-color: #66BB6A; ");
            danceLoop.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Dance Loop");
            Method.showQueue.add("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = true;
        }else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas  && Method.isDancePartyLoop) {
            dance.setStyle("-fx-background-color: #FFFFFF; ");
            danceLoop.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Dance Loop");
            Method.showQueue.remove("dance");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = false;
        } else if (Method.showQueue.contains("dance") && Method.isDancePartyShort && !Method.isDancePartyLong && !Method.isDancePartyChristmas  && !Method.isDancePartyLoop) {
            danceLoop.setStyle("-fx-background-color: #66BB6A; ");
            danceShort.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Loop DS Short");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = true;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && Method.isDancePartyLong && !Method.isDancePartyChristmas  && !Method.isDancePartyLoop) {
            danceLoop.setStyle("-fx-background-color: #66BB6A; ");
            danceLong.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Loop DS Long");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = true;
        } else if (Method.showQueue.contains("dance") && !Method.isDancePartyShort && !Method.isDancePartyLong && Method.isDancePartyChristmas  && !Method.isDancePartyLoop) {
            danceLoop.setStyle("-fx-background-color: #66BB6A; ");
            danceChristmas.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Select Dance Loop DS Christmas");
            Method.isDancePartyShort = false;
            Method.isDancePartyLong = false;
            Method.isDancePartyChristmas = false;
            Method.isDancePartyLoop = true;
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
        Method.isDancePartyChristmas = false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CheckStatus();
    }
}
