package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//EXPERIMENTAL
//Class for Controlling Tom's Functions remotely
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
    //Turn Head Turn On/Off
    public void PressHeadTurn(javafx.event.ActionEvent event) throws Exception {
        if (!HEAD_TURN_PRESSED) {
            headturn.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Head Turn");
            String s = "!eamxx0xxxxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            HEAD_TURN_PRESSED = true;
            testMethod.SavePreferences("HEAD_TURN", true);
        }
        else if (HEAD_TURN_PRESSED) {
            headturn.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Head Turn");
            String s = "!eamxx1xxxxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            HEAD_TURN_PRESSED = false;
            testMethod.SavePreferences("HEAD_TURN", false);
        }

    }

    //Turn Head Tilt On/Off
    public void PressHeadTilt(javafx.event.ActionEvent event) throws Exception {
       if (!HEAD_TILT_PRESSED) {
           headtilt.setStyle("-fx-background-color: #B71C1C; ");
           System.out.println("Stop Head tilt");
           String s = "!eamx0xxxxxxxxxxxxxx#";
           testMethod.SendInstructionToWeigl(s);
           HEAD_TILT_PRESSED = true;
           testMethod.SavePreferences("HEAD_TILT", true);
       }
       else if (HEAD_TILT_PRESSED) {
           headtilt.setStyle("-fx-background-color: #FFFFFF; ");
           System.out.println("Start Head tilt");
           String s = "!eamx1xxxxxxxxxxxxxx#";
           testMethod.SendInstructionToWeigl(s);
           HEAD_TILT_PRESSED = false;
           testMethod.SavePreferences("HEAD_TILT", false);
       }
    }

    //Turn Torso Forebend On/Off
    public void PressTorsoBend(javafx.event.ActionEvent event) throws Exception {
        if (!TORSO_PRESSED) {
            torso.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Torso Bend");
            String s = "!eamxxxx0xxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            TORSO_PRESSED = true;
            testMethod.SavePreferences("TORSO", true);
        }
        else if (TORSO_PRESSED) {
            torso.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Torso Bend");
            String s = "!eamxxxx1xxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            TORSO_PRESSED = false;
            testMethod.SavePreferences("TORSO", false);
        }
    }

    //Turn Mouth On/Off
    public void PressMouth(javafx.event.ActionEvent event) throws Exception {
        if (!MOUTH_PRESSED) {
            mouth.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Mouth");
            String s = "!eam0xxxxxxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            MOUTH_PRESSED = true;
            testMethod.SavePreferences("MOUTH", true);
        }
        else if (MOUTH_PRESSED) {
            mouth.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Mouth");
            String s = "!eam1xxxxxxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            MOUTH_PRESSED = false;
            testMethod.SavePreferences("MOUTH", false);
        }
    }

    //Turn Scepter On/Off
    public void PressScepter(javafx.event.ActionEvent event) throws Exception {
        if (!SCEPTER_PRESSED) {
            scepter.setStyle("-fx-background-color: #B71C1C; ");
            System.out.println("Stop Scepter");
            String s = "!eamxxx0xxxxxxxxxxxx#";
            testMethod.SendInstructionToWeigl(s);
            SCEPTER_PRESSED = true;
            testMethod.SavePreferences("SCEPTER", true);
        }
        else if (SCEPTER_PRESSED) {
            scepter.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("Start Scepter");
            String s = "!eamxxx1xxxxxxxxxxxx#";
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
        testMethod.ResetAllPositions(3);
        Parent pageone = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }
}
