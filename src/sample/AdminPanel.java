package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

//Class for Admin Panel
//Calisthenics and Thank You Sponsors are currently operational
//Test if the Control Functions command is active
public class AdminPanel {

//    @FXML
//    private Button thankyou;
//    @FXML
//    private Button calisthenics;
//    @FXML
//    private Button control;

    Method testMethod = new Method();
    Timer timer = new Timer();

    public AdminPanel () throws Exception
    {

    }

    //Opens the Calisthenics page
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

//    public void PressControlFunctions(javafx.event.ActionEvent event) throws IOException
//    {
//        System.out.println("Open Control Functions Panel");
//        String s="!vcc1=0!rst901#";
//        testMethod.SendInstructionToWeigl(s);
//        Parent pageone = FXMLLoader.load(getClass().getResource("ControlFunctions.fxml"));
//        testMethod.ShowSceneFunction(pageone, event);
//    }

    //Starts the Thank You Sponsors show
    public void PressThankYou(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Play Thank You Sponsors!");
        Parent pageone = FXMLLoader.load(getClass().getResource("ThankYouSponsors.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

//    private void ToggleDisable(boolean bool){
//        control.setDisable(bool);
//        calisthenics.setDisable(bool);
//        thankyou.setDisable(bool);
//    }
}
