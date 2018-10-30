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

public class IndependenceDay {
    @FXML
    private Label tom;
    @FXML
    private Label tom1;
    @FXML
    private Button next;
    @FXML
    private Button startShow;

    private Method testMethod = new Method();
    Timer timer = new Timer();

    public IndependenceDay() throws Exception
    {

    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception
    {
        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource(testMethod.ShowSelector() +".fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressStartShow(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Playing Independence Dialogue");
        String s = "!vcc1=0!rst181#";
        testMethod.SendInstructionToWeigl(s);
        startShow.setVisible(false);
        tom.setVisible(true);
        tom1.setVisible(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                next.setVisible(true);
            }
        }, 1*6000);

    }
}
