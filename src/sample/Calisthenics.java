package sample;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

//Class for Calisthenics
//Each function can be run either individually or together.
public class Calisthenics {

    Timer timer = new Timer();

    @FXML
    private Button headturn;
    @FXML
    private Button headtilt;
    @FXML
    private Button torso;
    @FXML
    private Button scepter;
    @FXML
    private Button mouth;

    Method testMethod = new Method();

    public Calisthenics()throws Exception
    {

    }
    //Starts running Head Turn looped
    public void PressHeadTurn(javafx.event.ActionEvent event) throws Exception {

        headturn.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("Test Head Turn");
        String s="!vcc1=0!rsal801#";
        testMethod.SendInstructionToWeigl(s);

    }
    //Starts running Head Tilt looped
    public void PressHeadTilt(javafx.event.ActionEvent event) throws Exception {
        headtilt.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("Test Head tilt");
        String s="!vcc1=0!rsal804#";
        testMethod.SendInstructionToWeigl(s);
    }
    //Starts running Torso Forebend looped
    public void PressTorsoBend(javafx.event.ActionEvent event) throws Exception {
        torso.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("Test Torso Bend");
        String s="!vcc1=0!rsal805#";
        testMethod.SendInstructionToWeigl(s);
    }
    //Starts running Mouth looped
    public void PressMouth(javafx.event.ActionEvent event) throws Exception {
        mouth.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("TestMouthOpen");
        String s="!vcc1=0!rsal802#";
        testMethod.SendInstructionToWeigl(s);
    }
    //Starts running Scepter looped
    public void PressScepter(javafx.event.ActionEvent event) throws Exception {
        scepter.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("TestScepter");
        String s="!vcc1=0!rsal803#";
        testMethod.SendInstructionToWeigl(s);
    }
    //Stops all playing calisthenics and returns Tom to idle position
    public void PressStop(javafx.event.ActionEvent event) throws Exception {
        testMethod.ResetAllPositions(3);
        ToggleDisable(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               ToggleDisable(false);
            }
        }, 1*2500);
        headturn.setStyle("-fx-background-color: #FFFFFF; ");
        headtilt.setStyle("-fx-background-color: #FFFFFF; ");
        torso.setStyle("-fx-background-color: #FFFFFF; ");
        mouth.setStyle("-fx-background-color: #FFFFFF; ");
        scepter.setStyle("-fx-background-color: #FFFFFF; ");
        System.out.println("STOP ALL TESTS");
        String s="!rse0#";
        testMethod.SendInstructionToWeigl(s);
    }


    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(3);
        Parent pageone = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    private void ToggleDisable(boolean bool){
        headturn.setDisable(bool);
        headtilt.setDisable(bool);
        torso.setDisable(bool);
        mouth.setDisable(bool);
        scepter.setDisable(bool);
    }
}
