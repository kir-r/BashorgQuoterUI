package com.epam.bashquoter;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String inputNumber;
        URLCompiler compilerURL = new URLCompiler();
        UIManager.put("OptionPane.cancelButtonText", "достоточно");
        UIManager.put("OptionPane.okButtonText", "тык!");

        UIManager.put("OptionPane.messageFont", new Font("Verdana", Font.BOLD, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Verdana23", Font.BOLD, 14));

        while (true) {
            inputNumber = JOptionPane.showInputDialog("Введи число от 1 до ~464766");
            if (inputNumber == null || inputNumber.equals("")) {
                System.exit(0);
                break;
            }
            try {
                Integer.parseInt(inputNumber);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, WrongInputMessage.getInputMessage());
                continue;
            }
            String compiledNumber = compilerURL.numberCompile(inputNumber);
            String compiledRightURL = compilerURL.compileRightURLAddress(compiledNumber);
            String readURL = compilerURL.readURL(compiledRightURL);
            String result = new QuoteGetter().getQuote(readURL);
            JOptionPane.showMessageDialog(null, result);
        }
    }

}