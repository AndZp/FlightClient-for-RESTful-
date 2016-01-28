package ua.com.ukrelektro.flight.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageManager {

    public static void showInformMessage(Component comp, String title, String message) {
        JOptionPane.showMessageDialog(comp, message, title, JOptionPane.PLAIN_MESSAGE);
    }
    
     public static void showErrorMessage(Component comp, String title, String message) {
        JOptionPane.showMessageDialog(comp, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
}

