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

public class GoodnightCastle1 implements Initializable{
    @FXML
    private Label volunteerFirst;
    @FXML
    private Label volunteerFirstDialogue;
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
    private Label tom4;
    @FXML
    private Label tom5;
    @FXML
    private Label tom6;
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

    public GoodnightCastle1 () throws Exception
    {

    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    public void PressStartShow(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(1.5f);
        startShow.setVisible(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
        System.out.println("Playing Goodnight Castle Dialogue 1");
        String s = "!vcc1=0!rst31#";
        testMethod.SendInstructionToWeigl(s);
        dialogueCount++;

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
                }, 1*1000);
            }
        }, 1*4500);
            }
        }, 1*1500);
    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions(1.5f);
        dialogueCount++;
        nextDialogue.setVisible(false);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                switch (dialogueCount) {
                    case 2:
                        System.out.println("Playing Goodnight Castle Dialogue 2");
                        String s = "!vcc1=0!rst32#";
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
                                }, 1 * 1400);
                            }
                        }, 1 * 3700);
                        break;

                    case 3:
                        System.out.println("Playing Goodnight Castle Dialogue 3");
                        s = "!vcc1=0!rst33#";
                        testMethod.SendInstructionToWeigl(s);
                        tom2.setVisible(false);
                        tom3.setVisible(true);
                        volunteer2.setVisible(false);
                        volunteer.setVisible(false);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                nextDialogue.setVisible(true);
                            }
                        }, 1 * 7500);
                        break;

                    case 4:
                        System.out.println("Playing Goodnight Castle Dialogue 4");
                        s = "!vcc1=0!rst34#";
                        testMethod.SendInstructionToWeigl(s);
                        tom3.setVisible(false);
                        tom4.setVisible(true);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                nextDialogue.setVisible(true);
                            }
                        }, 1 * 9400);
                        break;

                    case 5:
                        System.out.println("Playing Goodnight Castle Dialogue 5");
                        s = "!vcc1=0!rst35#";
                        testMethod.SendInstructionToWeigl(s);
                        tom4.setVisible(false);
                        tom5.setVisible(true);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("Playing Goodnight Castle Dialogue 6");
                                String s2 = "!vcc1=0!rst36#";
                                testMethod.SendInstructionToWeigl(s2);
                                tom5.setVisible(false);
                                tom6.setVisible(true);
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        System.out.println("Playing Goodnight Castle Dialogue 7");
                                        String s1 = "!vcc1=0!rst37#";
                                        testMethod.SendInstructionToWeigl(s1);
                                        timer.schedule(new TimerTask() {
                                            @Override
                                            public void run() {
                                                endShow.setVisible(true);
                                            }
                                        }, 1 * 150000);
                                    }
                                }, 1 * 3000);
                            }
                        }, 1 * 5200);
                        break;
                }
            }
        }, 1 * 1500);
    }
}
