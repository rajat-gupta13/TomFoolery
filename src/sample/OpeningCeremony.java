package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class OpeningCeremony {
    @FXML
    private Label tom;
    @FXML
    private Label tom1;
    @FXML
    private Button endShow;
    @FXML
    private Button startShow;

    private Method testMethod = new Method();
    Timer timer = new Timer();

    public OpeningCeremony() throws Exception
    {

    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    } 

    public void PressStartShow(javafx.event.ActionEvent event) throws IOException
    {
        //testMethod.ResetAllPositions();
        System.out.println("Playing Opening Ceremony Dialogue");
        String s = "!vcc1=0!rst201#";
        testMethod.SendInstructionToWeigl(s);
        startShow.setVisible(false);
        tom.setVisible(true);
        tom1.setVisible(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endShow.setVisible(true);
            }
        }, 1*112600);

    }
}
