package View;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.KeyEvent;

public class Input {
    BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
    public String getUserString(String prompt) {
        print(prompt);
        return read();
    }
    public int getUserInt(String prompt){
        boolean validInt = false;
        int res = -1;
        do {
            try{
                res = Integer.parseInt(getUserString(prompt));
                validInt = true;
            } catch (Exception e) {
                print("Invalid input, please input another number");
            }
        } while (!validInt);
        return res;
    }

    public void print(String string){
        System.out.println(string);
    }

    public String read(){
        try {
            return bread.readLine();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

//    public void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
public void clearConsole() {
    try {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_1);
    } catch (AWTException ex) {
        ex.printStackTrace(System.err);
    }
}
}
