package Controller;

import Model.*;
import View.Input;

import java.util.ArrayList;
import java.util.Random;

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
            selectBossFight();
        } while (!done);

    }
    public void selectBossFight(){
        if(p.getScore() == 150){
            bossFight1();
        }
        if(p.getScore() == 300){
            bossFight2();
        }
        if(p.getScore() == 750){
            bossFight3();
        }
    }
//////////////////////////////////////////////////////////////
    public void bossFight1() {
        CookieGobbler boss1 = new CookieGobbler("Cookie Gobbler", 100, 5);
            i.print("You stumble upon one of the Demon Lords minions the Cookie Gobbler, you get ready for the fight of your life");
            while (boss1.getHp() > 0) {
                Random ran = new Random();
                int num = ran.nextInt(10) + 1;
                if (num < 8) {
                    i.print("attack!");
                    click(p.getHp());
                    boss1.setHp(boss1.getHp() - c.getClickValue());
                    i.print("You dealt" + c.getClickValue());
                    i.print(boss1.getName() + " has " + boss1.getHp() + " hp");
                    i.print("The Cookie Gobbler hit you for:" + boss1.getAttack());
                    p.setHp(p.getHp() - boss1.getAttack());
                }
                if (num > 8) {
                    boss1.heal(num * 4);
                    i.print("Attack!");
                    click(p.getHp());
                    boss1.setHp(boss1.getHp() - c.getClickValue());
                    i.print("You dealt: " + c.getClickValue() + " Damage");
                }
                i.print("You defeated the terrible cookie gobbler!");
            }
        }
        /////////////////////////////////////////////////////////////
        public void bossFight2(){
        CookieDevourer boss2 = new CookieDevourer("Cookie Devourer", 200, 8);
            i.print("You see a little bug crawling about and decided to follow it... " + "/n" + "it leads you into a cave where you see another minion The Cookie Devourer he leaps out at you and blocks the entrance theres no escape you get ready to fight");
            while (boss2.getHp() > 0) {
                Random ran = new Random();
                int num = ran.nextInt(10) + 1;
                if (num < 9) {
                    i.print("Attack!");
                    click(p.getHp());
                    boss2.setHp(boss2.getHp() - c.getClickValue());
                    i.print("you dealt: " + c.getClickValue() + " damage!");
                    i.print(boss2.getName() + " has " + boss2.getHp() + " hp");
                    i.print(boss2.getName() + " hit you for: " + boss2.getAttack() + " Damage!");
                    p.setHp(p.getHp() - boss2.getAttack());
                }
                if (num > 9) {
                    p.setHp(p.getHp() - boss2.barrage());
                    i.print("You get up from the powerful attack, you strike at the " + boss2.getName());
                    click(p.getHp());
                    i.print("you dealt: " + c.getClickValue() + "Damage!");
                    boss2.setHp(boss2.getHp() - c.getClickValue());
                    i.print(boss2.getName() + " has " + boss2.getHp() + " hp");
            }
        }
            i.print("you defeated the " + boss2.getName() + "!");
            }
            /////////////////////////////////////////////////////////////////////
            public void bossFight3(){
                i.print("You decide to head to the Cookie Demon in cookie capital the one who started this mess. " + "/n" + " You see him in the grand hall of the castle. You point your sword at him and say I Will slay you foul demon for corrupting this land. The fight begins");
                        CookieDemon boss3 = new CookieDemon("Cookie Demon", 300, 10);
                        while(boss3.getHp() > 0) {
                            Random ran = new Random();
                            int num = ran.nextInt(20) + 1;
                            if (num < 15) {
                                i.print("Attack!");
                                click(p.getHp());
                                boss3.setHp(boss3.getHp() - c.getClickValue());
                                i.print("you dealt: " + c.getClickValue() + " damage!");
                                i.print(boss3.getName() + " has " + boss3.getHp() + " hp");
                                i.print(boss3.getName() + " hit you for: " + boss3.getAttack() + " Damage!");
                                p.setHp(p.getHp() - boss3.getAttack());

                            }
                            if(num >= 15 && num < 18){
                                p.setScore(p.getScore() - (num * 2));
                                boss3.cookieDrainHealth(num * 2);
                            }
                            if(num >= 18){
                                p.setScore(p.getScore() - (num * 2));
                                p.setHp(p.getHp() - boss3.cookieDrainAttack(num * 2));
                            }
                        }
                        i.print("You defeated the Cookie Demon. You win!");
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
