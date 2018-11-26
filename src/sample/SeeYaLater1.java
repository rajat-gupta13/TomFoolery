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

public class SeeYaLater1 implements Initializable{
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
    private Label volunteer5;
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

    public SeeYaLater1 () throws Exception
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
                System.out.println("Playing See Ya Later Dialogue 1");
                String s = "!vcc1=0!rst111#";
                testMethod.SendInstructionToWeigl(s);
                dialogueCount++;

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
                        }, 1 * 1000);
                    }
                }, 1 * 5000);
            }
            }, 1 * 1500);
    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
                switch (dialogueCount) {
                    case 2:
                        testMethod.ResetAllPositions(1.5f);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("Playing See Ya Later Dialogue 2");
                                String s = "!vcc1=0!rst112#";
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
                                        nextDialogue.setVisible(true);
                                    }
                                }, 1 * 1000);

                            }
                            }, 1 * 1000);
                        break;

                    case 3:
                        testMethod.ResetAllPositions(1.5f);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("Playing See Ya Later Dialogue 3");
                                String s = "!vcc1=0!rst113#";
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
                                }, 1 * 1500);
                            }
                        }, 1 * 1500);
                        break;

                    case 4:
                        System.out.println("Playing See Ya Later Dialogue 4");
                        String s = "!vcc1=0!rst114#";
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
                                }, 1 * 2000);
                            }
                        }, 1 * 14000);
                        break;

                    case 5:
                        testMethod.ResetAllPositions(1.5f);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("Playing See Ya Later Dialogue 5");
                                String s = "!vcc1=0!rst115#";
                                testMethod.SendInstructionToWeigl(s);
                                tom4.setVisible(false);
                                tom5.setVisible(true);
                                volunteer4.setVisible(false);
                                volunteer5.setVisible(true);
                                volunteer5.setDisable(true);
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        volunteer5.setDisable(false);
                                        timer.schedule(new TimerTask() {
                                            @Override
                                            public void run() {
                                                endShow.setVisible(true);
                                            }
                                        }, 1 * 1000);
                                    }
                                }, 1 * 24000);
                            }
                        }, 1 * 1500);
                        break;
                }
    }


}


