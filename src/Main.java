import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
                null,
                "Welcome to Douban Movie Management System",
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE
        );

        String username = JOptionPane.showInputDialog(
                null,
                "Please enter your username:",
                "Login",
                JOptionPane.QUESTION_MESSAGE
        );

        String password = JOptionPane.showInputDialog(
                null,
                "Please enter your password:",
                "Login",
                JOptionPane.QUESTION_MESSAGE
        );

        String correctUsername = "Qijie,Wang";
        String correctPassword = "123456";

        if (username != null && username.equals(correctUsername)) {
            if (password != null && password.equals(correctPassword)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Login successful! Welcome to use the system ~",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );


            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Wrong password, please try again",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Wrong account, try please again",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }





                javax.swing.SwingUtilities.invokeLater(() -> {

                    MovieManager movieManager = new MovieManager();

                    movieManager.showMainMenu();
                });
            }
        }








