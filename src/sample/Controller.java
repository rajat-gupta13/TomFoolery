package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    DatagramSocket socket;
    InetAddress address;
    Method testMethod = new Method();
    Timer timer = new Timer();

    @FXML
    private Button powerButton;

    private static boolean POWER_ON = false;

    public Controller()throws Exception
    {
        socket=new DatagramSocket();
        address=InetAddress.getByName("10.0.0.102");
        testMethod.ResetAllPositions(3);

    }
    public void PressSelect(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(3);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
        System.out.println("Selecting Shows");
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
            }
        }, 1 * 3000);
        Parent pageone = FXMLLoader.load(getClass().getResource("StartShows.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }
    public void PressAdmin(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(3);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Log-in to Admin Panel");
                String s = "!vcc1=0!rst901#";
                testMethod.SendInstructionToWeigl(s);
            }
            }, 1 * 3000);
        Parent pageone = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

    public void PressPower(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Pressing Power");
        if (!POWER_ON)
        {
            String s = "!dss1:1#";
            testMethod.SendInstructionToWeigl(s);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String s= "!dss1:1000000010000000#";
                    testMethod.SendInstructionToWeigl(s);
                    powerButton.setStyle("-fx-background-color: #66BB6A; ");
                    testMethod.ResetAllPositions(3);
                }
            }, 1 * 2000);
            POWER_ON = true;
            testMethod.SavePreferences("POWER", true);
        }
        else if (POWER_ON)
        {
            String s = "!dss1:0000000000000000#";
            testMethod.SendInstructionToWeigl(s);
            powerButton.setStyle("-fx-background-color: #B71C1C; ");
            POWER_ON = false;
            testMethod.SavePreferences("POWER", false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        POWER_ON = testMethod.ReadPreferences("POWER");
        if (POWER_ON) {
            powerButton.setStyle("-fx-background-color: #66BB6A; ");
        }
        else if (!POWER_ON)
        {
            powerButton.setStyle("-fx-background-color: #B71C1C; ");
        }
    }
}
