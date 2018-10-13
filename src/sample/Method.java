package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Method {
    DatagramSocket socket;
    InetAddress address;
    public Method()throws Exception
    {
        socket=new DatagramSocket();
        address=InetAddress.getByName("10.0.0.102");
        //ResetAllPositions();
    }

    public void SendInstructionToWeigl(String s) {

        try {
            byte[] buf = s.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5555);
            socket.send(packet);
        } catch (Exception e) {
            System.out.println("Handle exception here......");
        }
    }

    public void ResetAllPositions()
    {
        System.out.println("Resetting all to Middle in 3.5 seconds");
        String s="!rse0#";
        SendInstructionToWeigl(s);
        s="!dfl1:1%50<3.5#";
        SendInstructionToWeigl(s);
        s="!dfl1:2%55<3.5#";
        SendInstructionToWeigl(s);
        s="!dfl1:3%50<3.5#";
        SendInstructionToWeigl(s);
        s="!dfl1:4%60<3.5#";
        SendInstructionToWeigl(s);
        s="!dfl1:5%60<3.5#";
        SendInstructionToWeigl(s);

    }

    public void ShowSceneFunction(Parent pageone, javafx.event.ActionEvent event)
    {
        Scene pageone_scene = new Scene(pageone);
        Stage app_Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Stage.setScene(pageone_scene);
        app_Stage.setFullScreen(true);
        app_Stage.setFullScreenExitHint("");
        app_Stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        app_Stage.show();
    }

    public void PressMainMenuFunction(javafx.event.ActionEvent event) throws IOException
    {
        System.out.println("Returning to Main Menu");
        ResetAllPositions();
        Parent pageone = FXMLLoader.load(getClass().getResource("sample.fxml"));
        ShowSceneFunction(pageone, event);
    }
}
