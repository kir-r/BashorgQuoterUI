package com.epam.bashquoter;

public class WrongInputMessage {
    public static String getInputMessage() {
        int randomNumber = 1 + (int) (Math.random() * 5);
        switch (randomNumber) {
            case (1):
                return "Ты что вводишь?";
            case (2):
                return "WTF dude?";
            case (3):
                return "Нормально же все было";
            case (4):
                return "Ты дьявола вызвать хочешь?";
            case (5):
                return "Что это?";
        }
        return "";
    }
}