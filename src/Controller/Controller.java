package Controller;

import Model.Click;
import Model.Player;
import View.Input;

import java.util.ArrayList;

public class Controller {
    private Input i = new Input();
    private Player p = new Player();
    private Click c = new Click();
    private ArrayList<Multiplier> multipliers = new ArrayList<>();
    private int counter = 0;

    public void start(){
        Player p = new Player(i.getUserString("Enter your name"), 50, c.getClickValue());
        boolean done = false;
        do {
            switch (mainMenu()) {
                case 1 -> click(p.getHp());
                case 2 -> done = true;
            }
        } while(!done);

    }

    public int mainMenu(){
        return i.getUserInt("[1]Start Game\n" + "[2]Exit");
    }

    public void shopMenu(){
        boolean done = false;

        do {
            int choice = i.getUserInt("""
                    [1]25\uD83C\uDF6A for random click
                    [2]100\uD83C\uDF6A for random multiplier
                    [3]500\uD83C\uDF6A for cookie bleed
                    [4]Back to game""");
            switch (choice){
                case 1:
                    if (p.getScore() >= 25 && counter == 0) {
                        multipliers.add(new RandomClick());
                        i.print("Random Click has been added");
                        p.setScore(p.getScore() - 25);
                        counter++;
                    } else {
                        i.print("You do not have enough cookies for this, or you have already bought this multiplier.");
                    }
                    break;
                case 2:
                    if (p.getScore() >= 100 && counter == 1) {
                        multipliers.add(new MultClick());
                        i.print("Multiply Click has been added");
                        p.setScore(p.getScore() - 100);
                        counter++;
                    } else {
                        i.print("You do not have enough cookies for this, or you have already bought this multiplier.");
                    }
                    break;
                case 3:
                    if (p.getScore() >= 500 && counter == 2) {
                        multipliers.add(new BleedClick());
                        i.print("Bleed Click has been added");
                        p.setScore(p.getScore() -500);
                        counter++;
                    } else {
                        i.print("You do not have enough cookies for this, or you have already bought this multiplier.");
                    }
                    break;
                case 4:
                    done = true;
                    break;
            }
        }while (!done);

    }

    public void click(int hp){
        boolean done = false;
        do {
            i.clearScreen();
            String check = i.getUserString("");
            if (check.isEmpty()){
                if (multipliers == null){
                    p.setScore(p.getScore() + c.getClickValue());
                } else {
                    for (Multiplier m : multipliers) {
                        m.multiplier(c);
                    }
                    p.setScore(p.getScore() + c.getClickValue());
                }
            } else if (check.equalsIgnoreCase("s")){
                shopMenu();
            } else if (check.equalsIgnoreCase("e")){
                done = true;
            }
            i.print("\uD83C\uDF6A: " + p.getScore() + " HP: " + hp);
        } while (!done);

    }

}
