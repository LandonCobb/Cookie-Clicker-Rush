package Controller;

import Model.*;
import View.Input;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

interface Callback {
    void call();
}

public class Controller {
    private final Input i = new Input();
    private Player p = new Player();
    private final Click c = new Click();
    private final ArrayList<Multiplier> multipliers = new ArrayList<>();
    private int counter = 0;
    int bossCounter = 0;

    public Controller(){
        start();
    }

    public void start() {
        p = new Player(i.getUserString("Enter your name"), 100, c.getClickValue());
        AtomicBoolean done = new AtomicBoolean(false);
        do {
            switch (mainMenu()) {
                case 1 -> click(p.getHp(), () -> done.set(true));
                case 2 -> done.set(true);
            }
        } while (!done.get());

    }

    public int mainMenu() {
        return i.getUserInt("[1]Start Game\n" + "[2]Exit");
    }

    public void shopMenu() {
        boolean done = false;
        do {
            int choice = i.getUserInt("""
                    [1]25\uD83C\uDF6A for random click
                    [2]100\uD83C\uDF6A for random multiplier
                    [3]500\uD83C\uDF6A for cookie bleed
                    [4]Back to game""");
            switch (choice) {
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
                        p.setScore(p.getScore() - 500);
                        counter++;
                    } else {
                        i.print("You do not have enough cookies for this, or you have already bought this multiplier.");
                    }
                    break;
                case 4:
                    done = true;
                    break;
            }
        } while (!done);

    }

    public void click(int hp, Callback cb){
        AtomicBoolean done = new AtomicBoolean(false);
        do {
            i.clearConsole();
            String check = i.getUserString("");
            if (check.isEmpty()) {
                if (multipliers.isEmpty()) {
                    p.setScore(p.getScore() + c.getClickValue());
                } else {
                    for (Multiplier m : multipliers) {
                        m.multiplier(c);
                    }
                    p.setScore(p.getScore() + c.getClickValue());
                }
            } else if (check.equalsIgnoreCase("s")) {
                shopMenu();
            } else if (check.equalsIgnoreCase("e")) {
                done.set(true);
            } else if (check.equalsIgnoreCase("b")) {
                bossCounter++;
                selectBossFight(() -> {done.set(true); cb.call();});
            }
            i.print("\uD83C\uDF6A: " + p.getScore() + " HP: " + hp);
        } while (!done.get());
    }

    public void selectBossFight(Callback cb) {
        if (bossCounter == 1) {
            bossFight1(cb);
        }
        if (bossCounter == 2) {
            bossFight2(cb);
        }
        if (bossCounter == 3) {
            bossFight3(cb);
        }
    }

    //////////////////////////////////////////////////////////////
    public Object bossFight1(Callback cb) {
        CookieGobbler boss1 = new CookieGobbler("Cookie Gobbler", 50, 2);
        i.print("You stumble upon one of the Demon Lords minions the Cookie Gobbler, you get ready for the fight of your life");
        while (boss1.getHp() > 0) {
            if (p.getHp() <= 0) {
                i.print("Game Over.");
                cb.call();
                return null;
            }
            Random ran = new Random();
            int num = ran.nextInt(10) + 1;
            if (num < 8) {
                i.print("attack!");
                if (i.getUserString("").isEmpty()) {
                    for (Multiplier m : multipliers) {
                        m.multiplier(c);
                    }
                    boss1.setHp(boss1.getHp() - c.getClickValue());
                    i.print("You dealt " + c.getClickValue() + " Damage!");
                    i.print(boss1.getName() + " has " + boss1.getHp() + " hp");
                    i.print("The Cookie Gobbler hit you for:" + boss1.getAttack());
                    p.setHp(p.getHp() - boss1.getAttack());
                    i.print(p.getName() + " has HP: " + p.getHp());
                }
            }
            if (num > 8) {
                boss1.heal(num * 4);
                i.print("Attack!");
                if (i.getUserString("").isEmpty()) {
                    for (Multiplier m : multipliers) {
                        m.multiplier(c);
                    }
                    boss1.setHp(boss1.getHp() - c.getClickValue());
                    i.print("You dealt: " + c.getClickValue() + " Damage");
                }
            }
        }
        i.print("You defeated the terrible cookie gobbler!");
        p.setHp(100);
        return null;
    }

    /////////////////////////////////////////////////////////////
    public Object bossFight2(Callback cb) {
        CookieDevourer boss2 = new CookieDevourer("Cookie Devourer", 80, 4);
        i.print("You see a little bug crawling about and decided to follow it... " + "/n" + "it leads you into a cave where you see another minion The Cookie Devourer he leaps out at you and blocks the entrance theres no escape you get ready to fight");
        while (boss2.getHp() > 0) {
            if (p.getHp() <= 0) {
                i.print("Game Over.");
                cb.call();
                return null;
            }
                Random ran = new Random();
                int num = ran.nextInt(10) + 1;
                if (num < 9) {
                    i.print("Attack!");
                    if (i.getUserString("").isEmpty()) {
                        for (Multiplier m : multipliers) {
                            m.multiplier(c);
                        }
                        boss2.setHp(boss2.getHp() - c.getClickValue());
                        i.print("you dealt: " + c.getClickValue() + " damage!");
                        i.print(boss2.getName() + " has " + boss2.getHp() + " hp");
                        i.print(boss2.getName() + " hit you for: " + boss2.getAttack() + " Damage!");
                        p.setHp(p.getHp() - boss2.getAttack());
                        i.print(p.getName() + " has HP: " + p.getHp());
                    }
                }
                if (num > 9) {
                    p.setHp(p.getHp() - boss2.barrage());
                    i.print(p.getName() + " has HP: " + p.getHp());
                    i.print("You get up from the powerful attack, you strike at the " + boss2.getName());
                    if (i.getUserString("").isEmpty()) {
                        for (Multiplier m : multipliers) {
                            m.multiplier(c);
                        }
                        i.print("you dealt: " + c.getClickValue() + "Damage!");
                        boss2.setHp(boss2.getHp() - c.getClickValue());
                        i.print(boss2.getName() + " has " + boss2.getHp() + " hp");
                    }
                }
        }
        i.print("you defeated the " + boss2.getName() + "!");
        p.setHp(200);
        return null;
    }
        /////////////////////////////////////////////////////////////////////
        public Object bossFight3 (Callback cb) {
            i.print("You decide to head to the Cookie Demon in cookie capital the one who started this mess. " + "/n" + " You see him in the grand hall of the castle. You point your sword at him and say I Will slay you foul demon for corrupting this land. The fight begins");
            CookieDemon boss3 = new CookieDemon("Cookie Demon", 120, 5);
            while (boss3.getHp() > 0) {
                if (p.getHp() <= 0) {
                    i.print("Game Over.");
                    cb.call();
                    return null;
                }
                    Random ran = new Random();
                    int num = ran.nextInt(20) + 1;
                    if (num < 15) {
                        i.print("Attack!");
                        if (i.getUserString("").isEmpty()) {
                            for (Multiplier m : multipliers) {
                                m.multiplier(c);
                            }
                            boss3.setHp(boss3.getHp() - c.getClickValue());
                            i.print("you dealt: " + c.getClickValue() + " damage!");
                            i.print(boss3.getName() + " has " + boss3.getHp() + " hp");
                            i.print(boss3.getName() + " hit you for: " + boss3.getAttack() + " Damage!");
                            p.setHp(p.getHp() - boss3.getAttack());
                            i.print(p.getName() + " has HP:" + p.getHp());

                        }
                    }
                    if (num == 19) {
                        p.setScore(p.getScore() - (num));
                        boss3.cookieDrainHealth(num);
                    }
                    if (num == 20) {
                        p.setScore(p.getScore() - (num));
                        p.setHp(p.getHp() - boss3.cookieDrainAttack(num));
                        i.print(p.getName() + " has HP:" + p.getHp());
                    }
            }
            if (boss3.getHp() <= 0) {
                i.print("You defeated the Cookie Demon. You win!");
                cb.call();
                return null;
            }
            return null;
        }
    }

