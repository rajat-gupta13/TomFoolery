package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AdminPanel {

    @FXML
    private Button thankyou;
    @FXML
    private Button calisthenics;
    @FXML
    private Button control;
    @FXML
    private Button opening;

    Method testMethod = new Method();
    Timer timer = new Timer();

    public AdminPanel () throws Exception
    {

    }

    public void PressCalisthenics(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Open Calisthenics Panel");
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        Parent pageone = FXMLLoader.load(getClass().getResource("Calisthenics.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
    }

    public void PressControlFunctions(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Open Control Functions Panel");
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        Parent pageone = FXMLLoader.load(getClass().getResource("ControlFunctions.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

    public void PressThankYou(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Play Thank You Sponsors!");
        Parent pageone = FXMLLoader.load(getClass().getResource("ThankYouSponsors.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

    public void PressOpeningCeremony(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Play Opening Ceremony");
        String s="!vcc1=0!rst201#";
        testMethod.SendInstructionToWeigl(s);
        ToggleDisable(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ToggleDisable(false);
            }
        }, 1*15000);
    }

    private void ToggleDisable(boolean bool){
        opening.setDisable(bool);
        control.setDisable(bool);
        calisthenics.setDisable(bool);
        thankyou.setDisable(bool);
    }
}
