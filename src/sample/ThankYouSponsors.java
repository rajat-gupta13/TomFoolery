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

public class ThankYouSponsors implements Initializable{
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
    private Label volunteer2;
    @FXML
    private Label tom3;
    @FXML
    private Label volunteer3;
    @FXML
    private Label tom4;
    @FXML
    private Label volunteer4;
    @FXML
    private Label volunteerFirst;
    @FXML
    private Label volunteerFirstDialogue;
    @FXML
    private Button nextDialogue;
    @FXML
    private Button startShow;
    @FXML
    private Button endShow;

    private Method testMethod = new Method();
    Timer timer = new Timer();
    private int dialogueCount = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialogueCount = 0;
    }

    public ThankYouSponsors () throws Exception
    {

    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressStartShow(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Playing Thank You Sponsors Dialogue 1");
        String s = "!vcc1=0!rst151#";
        testMethod.SendInstructionToWeigl(s);
        dialogueCount++;
        startShow.setVisible(false);
        volunteerFirst.setVisible(false);
        volunteerFirstDialogue.setVisible(false);
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
                    }
                }, 1*2000);
            }
        }, 1*5000);

    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        switch (dialogueCount) {
            case 2:
                System.out.println("Playing Thank You Sponsors Dialogue 2");
                String s = "!vcc1=0!rst152#";
                testMethod.SendInstructionToWeigl(s);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer1.setVisible(false);
                volunteer2.setVisible(true);
                volunteer2.setDisable(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        volunteer2.setDisable(false);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                nextDialogue.setVisible(true);
                            }
                        }, 1 * 1000);
                    }
                }, 1 * 1000);
                break;

            case 3:
                System.out.println("Playing Thank You Sponsors Dialogue 3");
                s = "!vcc1=0!rst153#";
                testMethod.SendInstructionToWeigl(s);
                tom2.setVisible(false);
                tom3.setVisible(true);
                volunteer2.setVisible(false);
                volunteer3.setVisible(true);
                volunteer3.setDisable(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        volunteer3.setDisable(false);
                        nextDialogue.setVisible(true);
                    }
                }, 1 * 1000);
                break;

            case 4:
                System.out.println("Playing Thank You Sponsors Dialogue 4");
                s = "!vcc1=0!rst154#";
                testMethod.SendInstructionToWeigl(s);
                tom3.setVisible(false);
                tom4.setVisible(true);
                volunteer3.setVisible(false);
                volunteer4.setVisible(true);
                volunteer4.setDisable(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        volunteer4.setDisable(false);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                endShow.setVisible(true);
                            }
                        }, 1 * 2000);
                    }
                }, 1 * 14000);
                break;

        }
    }
}
