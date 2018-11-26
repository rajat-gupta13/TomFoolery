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

public class Halloween {
    @FXML
    private Label tom;
    @FXML
    private Label volunteer;
    @FXML
    private Label tom1;
    @FXML
    private Label volunteer1;
    @FXML
    private Label tom2;

    @FXML
    private Button next;
    @FXML
    private Button nextDialogue;
    @FXML
    private Button startShow;
    @FXML
    private Button playAddYes;

    private Method testMethod = new Method();
    Timer timer = new Timer();

    public Halloween () throws Exception
    {

    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception
    {
        testMethod.ResetAllPositions(1.5f);
        Parent pageone = FXMLLoader.load(getClass().getResource(testMethod.ShowSelector() +".fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

    public void PressStartShow(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(1.5f);
        startShow.setVisible(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
        System.out.println("Playing Halloween Dialogue 1");
        String s = "!vcc1=0!rst171#";
        testMethod.SendInstructionToWeigl(s);
        tom.setVisible(true);
        tom1.setVisible(true);
        volunteer.setVisible(true);
        volunteer1.setVisible(true);
        volunteer1.setDisable(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                volunteer1.setDisable(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                        playAddYes.setVisible(true);
                    }
                }, 1*1700);
            }
        }, 1*12500);
            }
        }, 1*1500);
    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        testMethod.ResetAllPositions(1.5f);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Playing Halloween Dialogue 2");
                String s = "!vcc1=0!rst172#";
                testMethod.SendInstructionToWeigl(s);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer.setVisible(false);
                volunteer1.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        next.setVisible(true);
                    }
                }, 1 * 8000);
            }
        }, 1 * 1500);
    }

    public void PressAddYes(javafx.event.ActionEvent event) throws IOException
    {
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        testMethod.ResetAllPositions(1.5f);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Playing Halloween Dialogue 2 with Yes");
                String s = "!vcc1=0!rst38#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst172#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1 * 1000);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer.setVisible(false);
                volunteer1.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        next.setVisible(true);
                    }
                }, 1 * 8000);
            }
        }, 1 * 1500);
    }

}
