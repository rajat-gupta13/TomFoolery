package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminLogin {
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Label incorrectText;

    Method testMethod = new Method();

    public AdminLogin() throws Exception {
    }

    public void PressSubmit(javafx.event.ActionEvent event) throws Exception
    {
        System.out.println("Logging in");
        if (usernameText.getText().equals("EXIT"))
        {
            System.exit(0);
        }
        if ((usernameText.getText().equals("admin")) )
        {
            if ((passwordText.getText().equals("gktwtomadmin123")))
            {
                Parent pageone = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                testMethod.ShowSceneFunction(pageone, event);
            } else {
                incorrectText.setVisible(true);
                usernameText.clear();
                passwordText.clear();
            }
        } else {
            incorrectText.setVisible(true);
            usernameText.clear();
            passwordText.clear();
        }
    }

    public void PressMainMenu(javafx.event.ActionEvent event) throws IOException
    {
        testMethod.PressMainMenuFunction(event);
    }
}
