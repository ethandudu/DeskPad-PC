import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Utils {
    public static String getSHA256(String word) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(word.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void runCommand(String command) throws Exception {
        Runtime.getRuntime().exec(command);
    }

    public static void pressKey(String key) throws AWTException {
        Robot robot = new Robot();
        //switch case for each key on the keyboard
        switch (key) {
            //letters
            case "A":
                robot.keyPress(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_A);
                break;
            case "B":
                robot.keyPress(KeyEvent.VK_B);
                robot.keyRelease(KeyEvent.VK_B);
                break;
            case "C":
                robot.keyPress(KeyEvent.VK_C);
                robot.keyRelease(KeyEvent.VK_C);
                break;
            case "D":
                robot.keyPress(KeyEvent.VK_D);
                robot.keyRelease(KeyEvent.VK_D);
                break;
            case "E":
                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);
                break;
            case "F":
                robot.keyPress(KeyEvent.VK_F);
                robot.keyRelease(KeyEvent.VK_F);
                break;
            case "G":
                robot.keyPress(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_G);
                break;
            case "H":
                robot.keyPress(KeyEvent.VK_H);
                robot.keyRelease(KeyEvent.VK_H);
                break;
            case "I":
                robot.keyPress(KeyEvent.VK_I);
                robot.keyRelease(KeyEvent.VK_I);
                break;
            case "J":
                robot.keyPress(KeyEvent.VK_J);
                robot.keyRelease(KeyEvent.VK_J);
                break;
            case "K":
                robot.keyPress(KeyEvent.VK_K);
                robot.keyRelease(KeyEvent.VK_K);
                break;
            case "L":
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                break;
            case "M":
                robot.keyPress(KeyEvent.VK_M);
                robot.keyRelease(KeyEvent.VK_M);
                break;
            case "N":
                robot.keyPress(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_N);
                break;
            case "O":
                robot.keyPress(KeyEvent.VK_O);
                robot.keyRelease(KeyEvent.VK_O);
                break;
            case "P":
                robot.keyPress(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_P);
                break;
            case "Q":
                robot.keyPress(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_Q);
                break;
            case "R":
                robot.keyPress(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_R);
                break;
            case "S":
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_S);
                break;
            case "T":
                robot.keyPress(KeyEvent.VK_T);
                robot.keyRelease(KeyEvent.VK_T);
                break;
            case "U":
                robot.keyPress(KeyEvent.VK_U);
                robot.keyRelease(KeyEvent.VK_U);
                break;
            case "V":
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                break;
            case "W":
                robot.keyPress(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_W);
                break;
            case "X":
                robot.keyPress(KeyEvent.VK_X);
                robot.keyRelease(KeyEvent.VK_X);
                break;
            case "Y":
                robot.keyPress(KeyEvent.VK_Y);
                robot.keyRelease(KeyEvent.VK_Y);
                break;
            case "Z":
                robot.keyPress(KeyEvent.VK_Z);
                robot.keyRelease(KeyEvent.VK_Z);
                break;
            //numbers
            case "0":
                robot.keyPress(KeyEvent.VK_0);
                robot.keyRelease(KeyEvent.VK_0);
                break;
            case "1":
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                break;
            case "2":
                robot.keyPress(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_2);
                break;
            case "3":
                robot.keyPress(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_3);
                break;
            case "4":
                robot.keyPress(KeyEvent.VK_4);
                robot.keyRelease(KeyEvent.VK_4);
                break;
            case "5":
                robot.keyPress(KeyEvent.VK_5);
                robot.keyRelease(KeyEvent.VK_5);
                break;
            case "6":
                robot.keyPress(KeyEvent.VK_6);
                robot.keyRelease(KeyEvent.VK_6);
                break;
            case "7":
                robot.keyPress(KeyEvent.VK_7);
                robot.keyRelease(KeyEvent.VK_7);
                break;
            case "8":
                robot.keyPress(KeyEvent.VK_8);
                robot.keyRelease(KeyEvent.VK_8);
                break;
            case "9":
                robot.keyPress(KeyEvent.VK_9);
                robot.keyRelease(KeyEvent.VK_9);
                break;
            //num pad
            case "NUMPAD0":
                robot.keyPress(KeyEvent.VK_NUMPAD0);
                robot.keyRelease(KeyEvent.VK_NUMPAD0);
                break;
            case "NUMPAD1":
                robot.keyPress(KeyEvent.VK_NUMPAD1);
                robot.keyRelease(KeyEvent.VK_NUMPAD1);
                break;
            case "NUMPAD2":
                robot.keyPress(KeyEvent.VK_NUMPAD2);
                robot.keyRelease(KeyEvent.VK_NUMPAD2);
                break;
            case "NUMPAD3":
                robot.keyPress(KeyEvent.VK_NUMPAD3);
                robot.keyRelease(KeyEvent.VK_NUMPAD3);
                break;
            case "NUMPAD4":
                robot.keyPress(KeyEvent.VK_NUMPAD4);
                robot.keyRelease(KeyEvent.VK_NUMPAD4);
                break;
            case "NUMPAD5":
                robot.keyPress(KeyEvent.VK_NUMPAD5);
                robot.keyRelease(KeyEvent.VK_NUMPAD5);
                break;
            case "NUMPAD6":
                robot.keyPress(KeyEvent.VK_NUMPAD6);
                robot.keyRelease(KeyEvent.VK_NUMPAD6);
                break;
            case "NUMPAD7":
                robot.keyPress(KeyEvent.VK_NUMPAD7);
                robot.keyRelease(KeyEvent.VK_NUMPAD7);
                break;
            case "NUMPAD8":
                robot.keyPress(KeyEvent.VK_NUMPAD8);
                robot.keyRelease(KeyEvent.VK_NUMPAD8);
                break;
            case "NUMPAD9":
                robot.keyPress(KeyEvent.VK_NUMPAD9);
                robot.keyRelease(KeyEvent.VK_NUMPAD9);
                break;

            //function keys
            case "F1":
                robot.keyPress(KeyEvent.VK_F1);
                robot.keyRelease(KeyEvent.VK_F1);
                break;
            case "F2":
                robot.keyPress(KeyEvent.VK_F2);
                robot.keyRelease(KeyEvent.VK_F2);
                break;
            case "F3":
                robot.keyPress(KeyEvent.VK_F3);
                robot.keyRelease(KeyEvent.VK_F3);
                break;
            case "F4":
                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                break;
            case "F5":
                robot.keyPress(KeyEvent.VK_F5);
                robot.keyRelease(KeyEvent.VK_F5);
                break;
            case "F6":
                robot.keyPress(KeyEvent.VK_F6);
                robot.keyRelease(KeyEvent.VK_F6);
                break;
            case "F7":
                robot.keyPress(KeyEvent.VK_F7);
                robot.keyRelease(KeyEvent.VK_F7);
                break;
            case "F8":
                robot.keyPress(KeyEvent.VK_F8);
                robot.keyRelease(KeyEvent.VK_F8);
                break;
            case "F9":
                robot.keyPress(KeyEvent.VK_F9);
                robot.keyRelease(KeyEvent.VK_F9);
                break;
            case "F10":
                robot.keyPress(KeyEvent.VK_F10);
                robot.keyRelease(KeyEvent.VK_F10);
                break;
            case "F11":
                robot.keyPress(KeyEvent.VK_F11);
                robot.keyRelease(KeyEvent.VK_F11);
                break;
            case "F12":
                robot.keyPress(KeyEvent.VK_F12);
                robot.keyRelease(KeyEvent.VK_F12);
                break;
            case "F13":
                robot.keyPress(KeyEvent.VK_F13);
                robot.keyRelease(KeyEvent.VK_F13);
                break;
            case "F14":
                robot.keyPress(KeyEvent.VK_F14);
                robot.keyRelease(KeyEvent.VK_F14);
                break;
            case "F15":
                robot.keyPress(KeyEvent.VK_F15);
                robot.keyRelease(KeyEvent.VK_F15);
                break;
            case "F16":
                robot.keyPress(KeyEvent.VK_F16);
                robot.keyRelease(KeyEvent.VK_F16);
                break;
            case "F17":
                robot.keyPress(KeyEvent.VK_F17);
                robot.keyRelease(KeyEvent.VK_F17);
                break;
            case "F18":
                robot.keyPress(KeyEvent.VK_F18);
                robot.keyRelease(KeyEvent.VK_F18);
                break;
            case "F19":
                robot.keyPress(KeyEvent.VK_F19);
                robot.keyRelease(KeyEvent.VK_F19);
                break;
            case "F20":
                robot.keyPress(KeyEvent.VK_F20);
                robot.keyRelease(KeyEvent.VK_F20);
                break;
            case "F21":
                robot.keyPress(KeyEvent.VK_F21);
                robot.keyRelease(KeyEvent.VK_F21);
                break;
            case "F22":
                robot.keyPress(KeyEvent.VK_F22);
                robot.keyRelease(KeyEvent.VK_F22);
                break;
            case "F23":
                robot.keyPress(KeyEvent.VK_F23);
                robot.keyRelease(KeyEvent.VK_F23);
                break;
            case "F24":
                robot.keyPress(KeyEvent.VK_F24);
                robot.keyRelease(KeyEvent.VK_F24);
                break;

            //ctrl keys
            case "CTRL":
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                break;
            case "ALT":
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyRelease(KeyEvent.VK_ALT);
                break;
            case "SHIFT":
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;

        }
    }
}
