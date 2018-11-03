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

public class Christmas implements Initializable{

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
    private Label tom5;
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
    int dialogueCount = 0;

    public Christmas () throws Exception
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialogueCount = 0;
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
        System.out.println("Playing Christmas Dialogue 1");
        String s = "!vcc1=0!rst173#";
        dialogueCount++;
        testMethod.SendInstructionToWeigl(s);
        startShow.setVisible(false);
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
                }, 1*1000);
            }
        }, 1*10000);

    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Christmas Dialogue 2");
                String s = "!vcc1=0!rst174#";
                testMethod.SendInstructionToWeigl(s);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer1.setVisible(false);
                volunteer2.setVisible(true);
                volunteer2.setDisable(true);
                ChristmasDialogue2();
                break;

            case 3:
                System.out.println("Playing Christmas Dialogue 3");
                s = "!vcc1=0!rst175#";
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
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                nextDialogue.setVisible(true);
                            }
                        }, 1 * 1000);
                    }
                }, 1 * 11000);
                break;

            case 4:
                System.out.println("Playing Christmas Dialogue 4");
                s = "!vcc1=0!rst176#";
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
                                nextDialogue.setVisible(true);
                            }
                        }, 1 * 1000);
                    }
                }, 1 * 750);
                break;
            case 5:
                System.out.println("Playing Christmas Dialogue 5");
                s = "!vcc1=0!rst177#";
                testMethod.SendInstructionToWeigl(s);
                tom4.setVisible(false);
                tom5.setVisible(true);
                volunteer.setVisible(false);
                volunteer4.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        next.setVisible(true);
                    }
                }, 1*6000);
                break;
        }
    }

    private void ChristmasDialogue2() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                volunteer2.setDisable(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                        playAddYes.setVisible(true);
                    }
                }, 1 * 1500);
            }
        }, 1 * 6000);
    }

    public void PressAddYes(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Christmas Dialogue 2");
                String s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst174#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1 * 1000);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer1.setVisible(false);
                volunteer2.setVisible(true);
                volunteer2.setDisable(true);
                ChristmasDialogue2();
                break;

            case 3:
                System.out.println("Playing Christmas Dialogue 3");
                s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst175#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1 * 1000);
                tom2.setVisible(false);
                tom3.setVisible(true);
                volunteer2.setVisible(false);
                volunteer3.setVisible(true);
                volunteer3.setDisable(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        volunteer3.setDisable(false);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                nextDialogue.setVisible(true);
                            }
                        }, 1 * 1000);
                    }
                }, 1 * 11000);
                break;
        }
    }
}
