package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartShows implements Initializable {
    @FXML
    private Button welcome;
    @FXML
    private Button magic;
    @FXML
    private Button next;

    Method testMethod = new Method();

    public StartShows() throws Exception
    {

    }

    private void CheckStatus() {
        if (Method.showQueue.contains("magic")){
            magic.setStyle("-fx-background-color: #66BB6A; ");
            next.setDisable(false);
        }else if (Method.showQueue.contains("welcome")){
            welcome.setStyle("-fx-background-color: #66BB6A; ");
            next.setDisable(false);
        }
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    public void PressMagicTrick(javafx.event.ActionEvent event) throws Exception {

        magic.setStyle("-fx-background-color: #66BB6A; ");
        welcome.setStyle("-fx-background-color: #FFFFFF; ");
        System.out.println("Press Magic");
        Method.showQueue.add("magic");
        if (Method.showQueue.element() == "welcome") {
            Method.showQueue.remove("welcome");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        next.setDisable(false);
    }

    public void PressWelcomeCastle(javafx.event.ActionEvent event) throws Exception {

        welcome.setStyle("-fx-background-color: #66BB6A; ");
        magic.setStyle("-fx-background-color: #FFFFFF; ");
        System.out.println("Press Welcome");
        Method.showQueue.add("welcome");
        if (Method.showQueue.element() == "magic") {
            Method.showQueue.remove("magic");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        next.setDisable(false);
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception {
        Method.isDancePartyShort = false;
        Method.isDancePartyLong = false;
        Method.isDancePartyChristmas = false;
        testMethod.ResetAllPositions(3);
        Parent pageone = FXMLLoader.load(getClass().getResource("MiddleShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CheckStatus();
    }
}
