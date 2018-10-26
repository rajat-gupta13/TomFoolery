package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlFunctions implements Initializable {
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

    private static boolean mouthPressed, headTiltPressed, headTurnPressed, torsoPressed, scepterPressed = false;

    public ControlFunctions()throws Exception
    {

    }
    public void PressHeadTurn(javafx.event.ActionEvent event) throws Exception {
        if (!headTurnPressed) {
            headturn.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Head Turn");
            String s = "!vcc1=0!dmo1:xx0xx#";
            testMethod.SendInstructionToWeigl(s);
            headTurnPressed = true;
        }
        else if (headTurnPressed) {
            headturn.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Head Turn");
            String s = "!vcc1=0!dmo1:xx1xx#";
            testMethod.SendInstructionToWeigl(s);
            headTurnPressed = false;
        }

    }
    public void PressHeadTilt(javafx.event.ActionEvent event) throws Exception {
       if (!headTiltPressed) {
           headtilt.setStyle("-fx-background-color: #B71C1C; ");
           System.out.println("Stop Head tilt");
           String s = "!vcc1=0!dmo1:x0xxx#";
           testMethod.SendInstructionToWeigl(s);
           headTiltPressed = true;
       }
       else if (headTiltPressed) {
           headtilt.setStyle("-fx-background-color: #FFFFFF; ");
           System.out.println("Start Head tilt");
           String s = "!vcc1=0!dmo1:x1xxx#";
           testMethod.SendInstructionToWeigl(s);
           headTiltPressed = false;
       }
    }

    public void PressTorsoBend(javafx.event.ActionEvent event) throws Exception {
        if (!torsoPressed) {
            torso.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Torso Bend");
            String s = "!vcc1=0!dmo1:xxxx0#";
            testMethod.SendInstructionToWeigl(s);
            torsoPressed = true;
        }
        else if (torsoPressed) {
            torso.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Torso Bend");
            String s = "!vcc1=0!dmo1:xxxx1#";
            testMethod.SendInstructionToWeigl(s);
            torsoPressed = false;
        }
    }

    public void PressMouth(javafx.event.ActionEvent event) throws Exception {
        if (!mouthPressed) {
            mouth.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Mouth");
            String s = "!vcc1=0!dmo1:0xxxx#";
            testMethod.SendInstructionToWeigl(s);
            mouthPressed = true;
        }
        else if (mouthPressed) {
            mouth.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Mouth");
            String s = "!vcc1=0!dmo1:1xxxx#";
            testMethod.SendInstructionToWeigl(s);
            mouthPressed = false;
        }
    }
    public void PressScepter(javafx.event.ActionEvent event) throws Exception {
        if (!scepterPressed) {
            scepter.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Scepter");
            String s = "!vcc1=0!dmo1:xxx0x#";
            testMethod.SendInstructionToWeigl(s);
            scepterPressed = true;
        }
        else if (scepterPressed) {
            scepter.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Scepter");
            String s = "!vcc1=0!dmo1:xxx1x#";
            testMethod.SendInstructionToWeigl(s);
            scepterPressed = false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (mouthPressed)
        {
            mouth.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (headTiltPressed)
        {
            headtilt.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (headTurnPressed)
        {
            headturn.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (scepterPressed)
        {
            scepter.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (torsoPressed)
        {
            torso.setStyle("-fx-background-color: #B71C1C; ");
        }
    }

    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }
}
