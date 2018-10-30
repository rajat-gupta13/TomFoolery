package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SeasonalContent implements Initializable{
    @FXML
    private Button halloween;
    @FXML
    private Button christmas;
    @FXML
    private Button hanukkah;
    @FXML
    private Button easter;
    @FXML
    private Button thanksgiving;
    @FXML
    private Button independence;
    @FXML
    private Button clayton;
    @FXML
    private Button birthday;
    @FXML
    private Button labor;
    @FXML
    private Button veteran;

    Method testMethod = new Method();

    public SeasonalContent() throws Exception
    {

    }

    private void CheckStatus() {
        if (Method.showQueue.contains("halloween")) {
            halloween.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("christmas")) {
            christmas.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("hanukkah")) {
            hanukkah.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("easter")) {
            easter.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("thanksgiving")) {
            thanksgiving.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("independence")) {
            independence.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("clayton")) {
            clayton.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("birthday")) {
            birthday.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("labor")) {
            labor.setStyle("-fx-background-color: #66BB6A; ");
        }
        if (Method.showQueue.contains("veteran")) {
            veteran.setStyle("-fx-background-color: #66BB6A; ");
        }
    }
    public void PressBack(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("MiddleShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
        if (Method.showQueue.contains("halloween")) {
            halloween.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("halloween");
        }
        if (Method.showQueue.contains("christmas")) {
            christmas.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("christmas");
        }
        if (Method.showQueue.contains("hanukkah")) {
            hanukkah.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("hanukkah");
        }
        if (Method.showQueue.contains("easter")) {
            easter.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("easter");
        }
        if (Method.showQueue.contains("thanksgiving")) {
            thanksgiving.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("thanksgiving");
        }
        if (Method.showQueue.contains("independence")) {
            independence.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("independence");
        }
        if (Method.showQueue.contains("clayton")) {
            clayton.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("clayton");
        }
        if (Method.showQueue.contains("birthday")) {
            birthday.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("birthday");
        }
        if (Method.showQueue.contains("labor")) {
            labor.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("labor");
        }
        if (Method.showQueue.contains("veteran")) {
            veteran.setStyle("-fx-background-color: #FFFFFF; ");
            Method.showQueue.remove("veteran");
        }
    }

    public void PressNext(javafx.event.ActionEvent event) throws Exception {

        testMethod.ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("MiddleShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);
    }

    public void PressHalloween(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("halloween"))
        {
            halloween.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Halloween");
            Method.showQueue.add("halloween");
        }else if (Method.showQueue.contains("halloween")) {
            halloween.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Halloween");
            Method.showQueue.remove("halloween");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressChristmas(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("christmas"))
        {
            christmas.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Christmas ");
            Method.showQueue.add("christmas");
        }else if (Method.showQueue.contains("christmas")) {
            christmas.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Christmas");
            Method.showQueue.remove("christmas");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressHanukkah(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("hanukkah"))
        {
            hanukkah.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Hanukkah");
            Method.showQueue.add("hanukkah");
        }else if (Method.showQueue.contains("hanukkah")) {
            hanukkah.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Hanukkah");
            Method.showQueue.remove("hanukkah");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressEaster(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("easter"))
        {
            easter.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Easter");
            Method.showQueue.add("easter");
        }else if (Method.showQueue.contains("easter")) {
            easter.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Easter");
            Method.showQueue.remove("easter");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressIndependence(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("independence"))
        {
            independence.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select 4th of July");
            Method.showQueue.add("independence");
        }else if (Method.showQueue.contains("independence")) {
            independence.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select 4th of July");
            Method.showQueue.remove("independence");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressThanksgiving(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("thanksgiving"))
        {
            thanksgiving.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Thanksgiving");
            Method.showQueue.add("thanksgiving");
        }else if (Method.showQueue.contains("thanksgiving")) {
            thanksgiving.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Thanksgiving");
            Method.showQueue.remove("thanksgiving");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressBirthday(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("birthday"))
        {
            birthday.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Happy Birthday");
            Method.showQueue.add("birthday");
        }else if (Method.showQueue.contains("birthday")) {
            birthday.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Happy Birthday");
            Method.showQueue.remove("birthday");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressClaytonBirthday(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("clayton"))
        {
            clayton.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Happy Birthday Mayor Clayton");
            Method.showQueue.add("clayton");
        }else if (Method.showQueue.contains("clayton")) {
            clayton.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Happy Birthday Mayor Clayton");
            Method.showQueue.remove("clayton");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressLaborDay(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("labor"))
        {
            labor.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Labor Day");
            Method.showQueue.add("labor");
        }else if (Method.showQueue.contains("labor")) {
            labor.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Labor Day");
            Method.showQueue.remove("labor");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressVeteransDay(javafx.event.ActionEvent event) throws Exception {

        if (!Method.showQueue.contains("veteran"))
        {
            veteran.setStyle("-fx-background-color: #66BB6A; ");
            System.out.println("Select Veterans Day");
            Method.showQueue.add("veteran");
        }else if (Method.showQueue.contains("veteran")) {
            veteran.setStyle("-fx-background-color: #FFFFFF; ");
            System.out.println("De-Select Veterans Day");
            Method.showQueue.remove("veteran");
        }
        System.out.println(Method.showQueue);
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
        Method.showQueue.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CheckStatus();
    }
}
