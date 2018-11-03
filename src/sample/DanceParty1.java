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

public class DanceParty1 implements Initializable{
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
    private Label tom7;
    @FXML
    private Label volunteerFirst;
    @FXML
    private Label volunteerFirstDialogue;
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
    private int dialogueCount = 0;

    public DanceParty1 () throws Exception
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
        System.out.println("Playing Dance Party Dialogue 1");
        String s = "!vcc1=0!rst08#";
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
                }, 1*1000);
            }
        }, 1*2000);

    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Dance Party Dialogue 2");
                String s = "!vcc1=0!rst09#";
                testMethod.SendInstructionToWeigl(s);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer1.setVisible(false);
                volunteer2.setVisible(true);
                volunteer2.setDisable(true);
                DancePartDialogue2();
                break;

            case 3:
                System.out.println("Playing Dance Party Dialogue 3");
                s = "!vcc1=0!rst10#";
                testMethod.SendInstructionToWeigl(s);
                tom2.setVisible(false);
                tom3.setVisible(true);
                volunteer2.setVisible(false);
                volunteer3.setVisible(true);
                volunteer3.setDisable(true);
                DancePartyDialogue3();
                break;

            case 4:
                System.out.println("Playing Dance Party Dialogue 4");
                s = "!vcc1=0!rst11#";
                testMethod.SendInstructionToWeigl(s);
                tom3.setVisible(false);
                tom4.setVisible(true);
                volunteer3.setVisible(false);
                volunteer4.setVisible(true);
                volunteer4.setDisable(true);
                DancePartyDialogue4();
                break;

            case 5:
                System.out.println("Playing Dance Party Dialogue 5");
                s = "!vcc1=0!rst12#";
                testMethod.SendInstructionToWeigl(s);
                tom4.setVisible(false);
                tom5.setVisible(true);
                volunteer4.setVisible(false);
                volunteer5.setVisible(true);
                volunteer5.setDisable(true);
                DancePartyDialogue5();
                break;

            case 6:
                System.out.println("Playing Dance Party Dialogue 6");
                s = "!vcc1=0!rst13#";
                testMethod.SendInstructionToWeigl(s);
                if (Method.isDancePartyShort && !Method.isDancePartyLong) {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            String s1 = "!vcc1=0!rst51#";
                            testMethod.SendInstructionToWeigl(s1);
                        }
                    }, 1 * 2496);
                    tom5.setVisible(false);
                    tom6.setVisible(true);
                    volunteer5.setVisible(false);
                    volunteer.setVisible(false);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            nextDialogue.setVisible(true);
                        }
                    }, 1 * 150000);
                } else if (Method.isDancePartyLong && !Method.isDancePartyShort) {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            String s1 = "!vcc1=0!rst52#";
                            testMethod.SendInstructionToWeigl(s1);
                        }
                    }, 1 * 2496);
                    tom5.setVisible(false);
                    tom6.setVisible(true);
                    volunteer5.setVisible(false);
                    volunteer.setVisible(false);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            nextDialogue.setVisible(true);
                        }
                    }, 1 * 300000);
                }
                break;

            case 7:
                System.out.println("Playing Dance Party Dialogue 7");
                s = "!vcc1=0!rst14#";
                testMethod.SendInstructionToWeigl(s);
                tom6.setVisible(false);
                tom7.setVisible(true);
                volunteer.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        next.setVisible(true);
                    }
                }, 1*5000);
                break;

        }


    }

    public void PressAddYes(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Dance Party Dialogue 2 with Yes");
                String s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst09#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1*500);
                tom1.setVisible(false);
                tom2.setVisible(true);
                volunteer1.setVisible(false);
                volunteer2.setVisible(true);
                volunteer2.setDisable(true);
                DancePartDialogue2();
                break;

            case 3:
                System.out.println("Playing Dance Party Dialogue 3 with Yes");
                s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst10#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1*500);
                tom2.setVisible(false);
                tom3.setVisible(true);
                volunteer2.setVisible(false);
                volunteer3.setVisible(true);
                volunteer3.setDisable(true);
                DancePartyDialogue3();
                break;

            case 4:
                System.out.println("Playing Dance Party Dialogue 4 with Yes");
                s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst11#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1*500);
                tom3.setVisible(false);
                tom4.setVisible(true);
                volunteer3.setVisible(false);
                volunteer4.setVisible(true);
                volunteer4.setDisable(true);
                DancePartyDialogue4();
                break;

            case 5:
                System.out.println("Playing Dance Party Dialogue 5 with Yes");
                s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst12#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1*500);
                tom4.setVisible(false);
                tom5.setVisible(true);
                volunteer4.setVisible(false);
                volunteer5.setVisible(true);
                volunteer5.setDisable(true);
                DancePartyDialogue5();
                break;
        }


    }

    private void DancePartyDialogue4() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                volunteer4.setDisable(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                        playAddYes.setVisible(true);
                    }
                }, 1*1000);
            }
        }, 1*12000);
    }

    private void DancePartyDialogue5() {
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
    }

    private void DancePartyDialogue3() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                volunteer3.setDisable(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                        playAddYes.setVisible(true);
                    }
                }, 1*1001);
            }
        }, 1*6000);
    }

    private void DancePartDialogue2() {
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
                }, 1*2000);
            }
        }, 1*4000);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialogueCount = 0;
    }
}
