package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Controller {
    DatagramSocket socket;
    InetAddress address;
    Method testMethod = new Method();

    public Controller()throws Exception
    {
        socket=new DatagramSocket();
        address=InetAddress.getByName("10.0.0.102");
        testMethod.ResetAllPositions();

    }
    public void PressSelect(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Selecting Shows");
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        Parent pageone = FXMLLoader.load(getClass().getResource("StartShows.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }
    public void PressAdmin(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Log-in to Admin Panel");
        String s="!vcc1=0!rst901#";
        testMethod.SendInstructionToWeigl(s);
        Parent pageone = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        testMethod.ShowSceneFunction(pageone, event);
    }

}
