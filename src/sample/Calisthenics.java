package sample;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
    public void PressHeadTurn(javafx.event.ActionEvent event) throws Exception {

        headturn.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("Test Head Turn");
        String s="!vcc1=0!rst801#";
        testMethod.SendInstructionToWeigl(s);

    }
    public void PressHeadTilt(javafx.event.ActionEvent event) throws Exception {
        headtilt.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("Test Head tilt");
        String s="!vcc1=0!rst804#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressTorsoBend(javafx.event.ActionEvent event) throws Exception {
        torso.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("Test Torso Bend");
        String s="!vcc1=0!rst803#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressMouth(javafx.event.ActionEvent event) throws Exception {
        mouth.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("TestMouthOpen");
        String s="!vcc1=0!rst802#";
        testMethod.SendInstructionToWeigl(s);
    }
    public void PressScepter(javafx.event.ActionEvent event) throws Exception {
        scepter.setStyle("-fx-background-color: #66BB6A; ");
        System.out.println("TestScepter");
        String s="!vcc1=0!rst805#";
        testMethod.SendInstructionToWeigl(s);
    }
    public void PressStop(javafx.event.ActionEvent event) throws Exception {
        testMethod.ResetAllPositions();
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
        testMethod.ResetAllPositions();
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
