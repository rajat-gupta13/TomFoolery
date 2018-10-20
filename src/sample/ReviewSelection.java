package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviewSelection implements Initializable {
    @FXML
    private Label show1;
    @FXML
    private Label show2;
    @FXML
    private Label show3;
    @FXML
    private Label show4;

    private Method testMethod = new Method();

    public ReviewSelection () throws Exception
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

    public void PressStartOver(javafx.event.ActionEvent event) throws Exception {

        testMethod.ResetAllPositions();
        Method.showQueue.clear();
        Parent pageone = FXMLLoader.load(getClass().getResource("StartShows.fxml"));
        testMethod.ShowSceneFunction(pageone,event);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Method.showQueue.element() == "welcome")
        {
            show1.setText("1. WELCOME CASTLE");
        } else if (Method.showQueue.element() == "magic"){
            show1.setText("1. MAGIC TRICK");
        }

        Object showArray[]= Method.showQueue.toArray();
        if (showArray[1] == "dance")
        {
            show2.setText("2. DANCE PARTY");
            if (showArray[2] == "story")
            {
                show3.setText("3. STORYTIME");
                if (showArray[3] == "goodnight")
                {
                    show4.setText("4. GOODNIGHT CASTLE");
                }
                else if (showArray[3] == "seeyalater")
                {
                    show4.setText("4. SEE YA LATER!");
                }
            }
            else {
                ShowSelection(showArray);
            }
        }
        else if (showArray[1] == "story")
        {
            show2.setText("2. STORYTIME");
            if (showArray[2] == "dance")
            {
                show3.setText("3. DANCE PARTY");
                if (showArray[3] == "goodnight")
                {
                    show4.setText("4. GOODNIGHT CASTLE");
                }
                else if (showArray[3] == "seeyalater")
                {
                    show4.setText("4. SEE YA LATER!");
                }
            }
            else ShowSelection(showArray);
        }
        else if (showArray[1] == "goodnight")
        {
            show2.setText("2. GOODNIGHT CASTLE");
            show3.setVisible(false);
            show4.setVisible(false);
        }
        else if (showArray[1] == "seeyalater")
        {
            show2.setText("2. SEE YA LATER!");
            show3.setVisible(false);
            show4.setVisible(false);
        }
    }

    private void ShowSelection(Object[] showArray) {
        if (showArray[2] == "goodnight")
        {
            show3.setText("3. GOODNIGHT CASTLE");
            show4.setVisible(false);
        }
        else if (showArray[2] == "seeyalater")
        {
            show3.setText("3. SEE YA LATER!");
            show4.setVisible(false);
        }
    }
}
