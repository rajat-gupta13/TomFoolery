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

    private static boolean MOUTH_PRESSED = false;
    private static boolean HEAD_TILT_PRESSED = false;
    private static boolean HEAD_TURN_PRESSED = false;
    private static boolean TORSO_PRESSED = false;
    private static boolean SCEPTER_PRESSED = false;

    public ControlFunctions()throws Exception
    {

    }
    public void PressHeadTurn(javafx.event.ActionEvent event) throws Exception {
        if (!HEAD_TURN_PRESSED) {
            headturn.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Head Turn");
            String s = "!vcc1=0!dmo1:xx0xx#";
            testMethod.SendInstructionToWeigl(s);
            HEAD_TURN_PRESSED = true;
            testMethod.SavePreferences("HEAD_TURN", true);
        }
        else if (HEAD_TURN_PRESSED) {
            headturn.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Head Turn");
            String s = "!vcc1=0!dmo1:xx1xx#";
            testMethod.SendInstructionToWeigl(s);
            HEAD_TURN_PRESSED = false;
            testMethod.SavePreferences("HEAD_TURN", false);
        }

    }
    public void PressHeadTilt(javafx.event.ActionEvent event) throws Exception {
       if (!HEAD_TILT_PRESSED) {
           headtilt.setStyle("-fx-background-color: #B71C1C; ");
           System.out.println("Stop Head tilt");
           String s = "!vcc1=0!dmo1:x0xxx#";
           testMethod.SendInstructionToWeigl(s);
           HEAD_TILT_PRESSED = true;
           testMethod.SavePreferences("HEAD_TILT", true);
       }
       else if (HEAD_TILT_PRESSED) {
           headtilt.setStyle("-fx-background-color: #FFFFFF; ");
           System.out.println("Start Head tilt");
           String s = "!vcc1=0!dmo1:x1xxx#";
           testMethod.SendInstructionToWeigl(s);
           HEAD_TILT_PRESSED = false;
           testMethod.SavePreferences("HEAD_TILT", false);
       }
    }

    public void PressTorsoBend(javafx.event.ActionEvent event) throws Exception {
        if (!TORSO_PRESSED) {
            torso.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Torso Bend");
            String s = "!vcc1=0!dmo1:xxxx0#";
            testMethod.SendInstructionToWeigl(s);
            TORSO_PRESSED = true;
            testMethod.SavePreferences("TORSO", true);
        }
        else if (TORSO_PRESSED) {
            torso.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Torso Bend");
            String s = "!vcc1=0!dmo1:xxxx1#";
            testMethod.SendInstructionToWeigl(s);
            TORSO_PRESSED = false;
            testMethod.SavePreferences("TORSO", false);
        }
    }

    public void PressMouth(javafx.event.ActionEvent event) throws Exception {
        if (!MOUTH_PRESSED) {
            mouth.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Mouth");
            String s = "!vcc1=0!dmo1:0xxxx#";
            testMethod.SendInstructionToWeigl(s);
            MOUTH_PRESSED = true;
            testMethod.SavePreferences("MOUTH", true);
        }
        else if (MOUTH_PRESSED) {
            mouth.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Mouth");
            String s = "!vcc1=0!dmo1:1xxxx#";
            testMethod.SendInstructionToWeigl(s);
            MOUTH_PRESSED = false;
            testMethod.SavePreferences("MOUTH", false);
        }
    }
    public void PressScepter(javafx.event.ActionEvent event) throws Exception {
        if (!SCEPTER_PRESSED) {
            scepter.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Scepter");
            String s = "!vcc1=0!dmo1:xxx0x#";
            testMethod.SendInstructionToWeigl(s);
            SCEPTER_PRESSED = true;
            testMethod.SavePreferences("SCEPTER", true);
        }
        else if (SCEPTER_PRESSED) {
            scepter.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Scepter");
            String s = "!vcc1=0!dmo1:xxx1x#";
            testMethod.SendInstructionToWeigl(s);
            SCEPTER_PRESSED = false;
            testMethod.SavePreferences("SCEPTER", false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MOUTH_PRESSED = testMethod.ReadPreferences("MOUTH");
        HEAD_TILT_PRESSED = testMethod.ReadPreferences("HEAD_TILT");
        HEAD_TURN_PRESSED = testMethod.ReadPreferences("HEAD_TURN");
        TORSO_PRESSED = testMethod.ReadPreferences("TORSO");
        SCEPTER_PRESSED = testMethod.ReadPreferences("SCEPTER");

        if (MOUTH_PRESSED)
        {
            mouth.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (HEAD_TILT_PRESSED)
        {
            headtilt.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (HEAD_TURN_PRESSED)
        {
            headturn.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (SCEPTER_PRESSED)
        {
            scepter.setStyle("-fx-background-color: #B71C1C; ");
        }
        if (TORSO_PRESSED)
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
