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

public class MagicTrick1 implements Initializable{
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
    private Label tom3;
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
    private Label volunteer7;
    @FXML
    private Button next;
    @FXML
    private Button nextDialogue;
    @FXML
    private Button startShow;

    private Method testMethod = new Method();
    Timer timer = new Timer();
    private int dialogueCount = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialogueCount = 0;
    }

    public MagicTrick1 () throws Exception
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
        System.out.println("Playing Magic Trick Dialogue 1");
        String s = "!vcc1=0!rst121#";
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
                }, 1*5000);
            }
        }, 1*16000);

    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Magic Trick Dialogue 2");
                String s = "!vcc1=0!rst122#";
                testMethod.SendInstructionToWeigl(s);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer.setVisible(false);
                volunteer1.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                    }
                }, 1*6000);
                break;

            case 3:
                System.out.println("Playing Magic Trick Dialogue 3");
                s = "!vcc1=0!rst123#";
                testMethod.SendInstructionToWeigl(s);
                tom2.setVisible(false);
                tom3.setVisible(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);

                    }
                }, 1*14000);
                break;

            case 4:
                System.out.println("Playing Magic Trick Dialogue 4");
                s = "!vcc1=0!rst124#";
                testMethod.SendInstructionToWeigl(s);
                tom3.setVisible(false);
                tom4.setVisible(true);
                volunteer.setVisible(true);
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
                        }, 1*4000);
                    }
                }, 1*6000);
                break;

            case 5:
                System.out.println("Playing Magic Trick Dialogue 5");
                s = "!vcc1=0!rst125#";
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
                        }, 1*3000);
                    }
                }, 1*8000);
                break;

            case 6:
                System.out.println("Playing Magic Trick Dialogue 6");
                s = "!vcc1=0!rst126#";
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
                        }, 1*3000);
                    }
                }, 1*5000);
                break;

            case 7:
                System.out.println("Playing Magic Trick Dialogue 7");
                s = "!vcc1=0!rst127#";
                testMethod.SendInstructionToWeigl(s);
                tom6.setVisible(false);
                tom7.setVisible(true);
                volunteer6.setVisible(false);
                volunteer7.setVisible(true);
                volunteer7.setDisable(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        volunteer7.setDisable(false);
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                next.setVisible(true);
                            }
                        }, 1*3000);
                    }
                }, 1*5000);
                break;
        }


    }
}
