package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
