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
    private Button mainmenu;

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
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        thankyou.setDisable(true);
        calisthenics.setDisable(true);
        control.setDisable(true);
        mainmenu.setDisable(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                thankyou.setDisable(false);
                calisthenics.setDisable(false);
                control.setDisable(false);
                mainmenu.setDisable(false);
            }
        }, 1*2000);
    }
}
