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

public class Storytime1 implements Initializable{
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
    private Label tom8;
    @FXML
    private Label tom9;
    @FXML
    private Label tom10;
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
    @FXML
    private Button response1;
    @FXML
    private Button response2;
    @FXML
    private Button response3;
    @FXML
    private Button sayYes;
    @FXML
    private Button sayNo;
    @FXML
    private Button lookAtVolunteer;
    @FXML
    private Button giggle;
    @FXML
    private Button endStorytime;
    @FXML
    private Label storytimeEnded;

    private Method testMethod = new Method();
    Timer timer = new Timer();
    private int dialogueCount = 0;

    public Storytime1 () throws Exception
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
        System.out.println("Playing Storytime Dialogue 1");
        String s = "!vcc1=0!rst15#";
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
        }, 1*4000);

    }

    public void PressNextDialogue(javafx.event.ActionEvent event) throws IOException
    {
        dialogueCount++;
        nextDialogue.setVisible(false);
        playAddYes.setVisible(false);
        switch (dialogueCount)
        {
            case 2:
                System.out.println("Playing Storytime Dialogue 2");
                String s = "!vcc1=0!rst16#";
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
                }, 1*4000);
                break;

            case 3:
                System.out.println("Playing Storytime Dialogue 3");
                s = "!vcc1=0!rst17#";
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
                }, 1*4000);
                break;

            case 4:
                System.out.println("Playing Storytime Dialogue 4");
                s = "!vcc1=0!rst18#";
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
                                playAddYes.setVisible(true);
                            }
                        }, 1*1000);
                    }
                }, 1*4000);
                break;

            case 5:
                System.out.println("Playing Storytime Dialogue 5");
                s = "!vcc1=0!rst19#";
                testMethod.SendInstructionToWeigl(s);
                tom4.setVisible(false);
                tom5.setVisible(true);
                volunteer4.setVisible(false);
                volunteer5.setVisible(true);
                volunteer5.setDisable(true);
                StorytimeDialogue5();
                break;

            case 6:
                System.out.println("Playing Storytime Dialogue 6");
                s = "!vcc1=0!rst20#";
                testMethod.SendInstructionToWeigl(s);
                tom5.setVisible(false);
                tom6.setVisible(true);
                volunteer5.setVisible(false);
                volunteer.setVisible(false);
                StorytimeDialogue6();
                break;

            case 7:
                System.out.println("Playing Storytime Dialogue 7");
                s = "!vcc1=0!rst24#";
                testMethod.SendInstructionToWeigl(s);
                tom6.setVisible(false);
                tom7.setVisible(true);
                volunteer.setVisible(true);
                volunteer6.setVisible(true);
                response1.setVisible(false);
                response2.setVisible(false);
                response3.setVisible(false);
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

            case 8:
                System.out.println("Playing Storytime Dialogue 8");
                s = "!vcc1=0!rst25#";
                testMethod.SendInstructionToWeigl(s);
                tom7.setVisible(false);
                tom8.setVisible(true);
                volunteer6.setVisible(false);
                volunteer.setVisible(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        tom.setVisible(false);
                        tom8.setVisible(false);
                        sayYes.setVisible(true);
                        sayNo.setVisible(true);
                        lookAtVolunteer.setVisible(true);
                        giggle.setVisible(true);
                        endStorytime.setVisible(true);
                    }
                }, 1*4000);
                break;

            case 9:
                storytimeEnded.setVisible(false);
                if (Method.showQueue.element() == "seeyalater") {
                    System.out.println("Playing Storytime Dialogue 9");
                    s = "!vcc1=0!rst30#";
                    testMethod.SendInstructionToWeigl(s);
                    tom.setVisible(true);
                    tom9.setVisible(true);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            next.setVisible(true);
                        }
                    }, 1 * 4000);
                }
                else  if (Method.showQueue.element() == "goodnight") {
                    System.out.println("Playing Storytime Dialogue 10");
                    s = "!vcc1=0!rst31#";
                    testMethod.SendInstructionToWeigl(s);
                    tom.setVisible(false);
                    tom10.setVisible(true);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            next.setVisible(true);
                        }
                    }, 1 * 4000);
                }
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
            case 5:
                System.out.println("Playing Storytime Dialogue 5 with Yes");
                String s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst19#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1*1000);
                tom4.setVisible(false);
                tom5.setVisible(true);
                volunteer4.setVisible(false);
                volunteer5.setVisible(true);
                volunteer5.setDisable(true);
                StorytimeDialogue5();
                break;

            case 6:
                System.out.println("Playing Storytime Dialogue 6 with Yes");
                s = "!vcc1=0!rst26#";
                testMethod.SendInstructionToWeigl(s);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String s = "!vcc1=0!rst20#";
                        testMethod.SendInstructionToWeigl(s);
                    }
                }, 1*1000);
                tom5.setVisible(false);
                tom6.setVisible(true);
                volunteer5.setVisible(false);
                volunteer.setVisible(false);
                StorytimeDialogue6();
                break;

        }

    }

    public void PressEndStorytime(javafx.event.ActionEvent event) throws IOException
    {
        nextDialogue.setVisible(true);
        endStorytime.setVisible(false);
        sayYes.setVisible(false);
        sayNo.setVisible(false);
        lookAtVolunteer.setVisible(false);
        giggle.setVisible(false);
        storytimeEnded.setVisible(true);
    }

    private void StorytimeDialogue5() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                volunteer5.setDisable(false);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                        playAddYes.setVisible(true);
                    }
                }, 1*2000);
            }
        }, 1*000);
    }

    private void StorytimeDialogue6() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                response1.setVisible(true);
                response2.setVisible(true);
                response3.setVisible(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        nextDialogue.setVisible(true);
                    }
                }, 1*2000);
            }
        }, 1*8000);
    }

    public void PressResponse1(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing Response Dialogue 1");
        String s = "!vcc1=0!rst21#";
        testMethod.SendInstructionToWeigl(s);
        ToggleResponses();
    }
    public void PressResponse2(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing Response Dialogue 2");
        String s = "!vcc1=0!rst22#";
        testMethod.SendInstructionToWeigl(s);
        ToggleResponses();
    }
    public void PressResponse3(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing Response Dialogue 3");
        String s = "!vcc1=0!rst23#";
        testMethod.SendInstructionToWeigl(s);
        ToggleResponses();
    }
    public void SayYes(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing Yes Dialogue");
        String s = "!vcc1=0!rst26#";
        testMethod.SendInstructionToWeigl(s);
        ToggleReadingButtons();
    }

    public void SayNo(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing No Dialogue");
        String s = "!vcc1=0!rst27#";
        testMethod.SendInstructionToWeigl(s);
        ToggleReadingButtons();
    }

    public void LookAtVolunteer(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing Look at Volunteer");
        String s = "!vcc1=0!rst28#";
        testMethod.SendInstructionToWeigl(s);
        ToggleReadingButtons();
    }

    public void Giggle(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Playing Giggle Dialogue");
        String s = "!vcc1=0!rst29#";
        testMethod.SendInstructionToWeigl(s);
        ToggleReadingButtons();
    }

    private void ToggleReadingButtons() {
        sayYes.setDisable(true);
        sayNo.setDisable(true);
        lookAtVolunteer.setDisable(true);
        giggle.setDisable(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sayYes.setDisable(false);
                sayNo.setDisable(false);
                lookAtVolunteer.setDisable(false);
                giggle.setDisable(false);
            }
        }, 1*1000);
    }

    private void ToggleResponses() {
        response1.setDisable(true);
        response2.setDisable(true);
        response3.setDisable(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                response1.setDisable(false);
                response2.setDisable(false);
                response3.setDisable(false);
            }
        }, 1*1000);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialogueCount = 0;
    }
}
