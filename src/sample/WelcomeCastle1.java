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

public class WelcomeCastle1 implements Initializable {
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
    private Label tom6;
    @FXML
    private Label volunteer6;
    @FXML
    private Label tom7;
    @FXML
    private Button next;
    @FXML
    private Button nextDialogue;
    @FXML
    private Button startShow;

    private Method testMethod = new Method();
    Timer timer = new Timer();
    private int dialogueCount = 0;

    public WelcomeCastle1 () throws Exception
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
        System.out.println("Playing Welcome Dialogue 1");
        String s = "!vcc1=0!rst01#";
        testMethod.SendInstructionToWeigl(s);
        dialogueCount++;
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
                    }
                }, 1*2000);
            }
        }, 1*21000);

    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Welcome Dialogue 2");
                String s = "!vcc1=0!rst02#";
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
                        }, 1*1000);
                    }
                }, 1*7000);
                break;

            case 3:
                System.out.println("Playing Welcome Dialogue 3");
                s = "!vcc1=0!rst03#";
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
                        }, 1*1000);
                    }
                }, 1*15000);
                break;

            case 4:
                System.out.println("Playing Welcome Dialogue 4");
                s = "!vcc1=0!rst04#";
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
                        }, 1*2000);
                    }
                }, 1*6000);
                break;

            case 5:
                System.out.println("Playing Welcome Dialogue 5");
                s = "!vcc1=0!rst05#";
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
                                nextDialogue.setVisible(true);
                            }
                        }, 1*1000);
                    }
                }, 1*9000);
                break;

            case 6:
                System.out.println("Playing Welcome Dialogue 6");
                s = "!vcc1=0!rst06#";
                testMethod.SendInstructionToWeigl(s);
                tom5.setVisible(false);
                tom6.setVisible(true);
                volunteer5.setVisible(false);
                volunteer6.setVisible(true);
                volunteer6.setDisable(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        volunteer6.setDisable(false);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                nextDialogue.setVisible(true);
                            }
                        }, 1*1000);
                    }
                }, 1*4000);
                break;

            case 7:
                System.out.println("Playing Welcome Dialogue 7");
                s = "!vcc1=0!rst07#";
                testMethod.SendInstructionToWeigl(s);
                tom6.setVisible(false);
                tom7.setVisible(true);
                volunteer6.setVisible(false);
                volunteer.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        next.setVisible(true);
                    }
                }, 1*7000);
                break;
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialogueCount = 0;
    }
}
