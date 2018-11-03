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
    @FXML
    private Label show5;


    private Method testMethod = new Method();
    Object showArray[]= Method.showQueue.toArray();
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

        int queueLength = showArray.length;

        for (int i = 0; i < queueLength; i++)
        {
            switch (i)
            {
                case 0:
                    show1.setText("1. "+ ShowLabel(i));
                    break;
                case 1:
                    show2.setText("2. "+ ShowLabel(i));
                    break;
                case 2:
                    show3.setText("3. "+ ShowLabel(i));
                    break;
                case 3:
                    show4.setText("4. "+ ShowLabel(i));
                    break;
                case 4:
                    show5.setText("5. "+ ShowLabel(i));
                    break;
            }
        }
        if (queueLength != 14)
        {
            for (int i = queueLength; i < 14; i++)
            {
               switch (i)
               {
                   case 2:
                       show3.setVisible(false);
                       show4.setVisible(false);
                       show5.setVisible(false);
                       break;
                   case 3:
                       show4.setVisible(false);
                       show5.setVisible(false);
                       break;
                   case 4:
                       show5.setVisible(false);
                       break;

               }
            }
        }
    }

    private String ShowLabel(int index)
    {
        switch (showArray[index].toString()){
            case "welcome":
                return "WELCOME CASTLE";

            case "magic":
                return "MAGIC TRICK";

            case "dance":
                return "DANCE PARTY";

            case "story":
                return "STORYTIME";

            case "goodnight":
                return "GOODNIGHT CASTLE";

            case "seeyalater":
                return "SEE YA LATER!";

            case "halloween":
                return "HALLOWEEN";

            case "christmas":
                return "CHRISTMAS";

            case "thanksgiving":
                return "THANKSGIVING";

            case "easter":
                return "HAPPY EASTER";

            case "hanukkah":
                return "HANUKKAH";

            case "independence":
                return "HAPPY 4th OF JULY";

            case "birthday":
                return "HAPPY BIRTHDAY";

            case "clayton":
                return "HAPPY BIRTHDAY MAYOR CLAYTON";

            case "veteran":
                return "HAPPY VETERANS DAY";

            case "labor":
                return "HAPPY LABOR DAY";
        }
        return null;
    }
}
