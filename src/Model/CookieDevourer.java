package Model;

import View.Input;

import java.util.Random;

public class CookieDevourer extends Character{
    Input i = new Input();
    int specialAttackCount = 0;
    ////////////////////////////////////////////////////////////////
    public CookieDevourer(String name, int hp, int attack){
        super.setName(name);
        super.setHp(hp);
        super.setAttack(attack);
    }
    ///////////////////////////////////////////////////
    //this will stack the attack multiple times and hit the player
    public int barrage(){
        Random ran = new Random();
        int loop = ran.nextInt(4) + 1;
        int lastAttack = 0;
        if(specialAttackCount < 3) {
            while (loop > 0) {
                lastAttack = lastAttack + getAttack();
                loop--;
            }
            i.print("The " + getName() + " went on a rampage and threw nasty insults at you! You took: " + lastAttack + " damage!");
            return lastAttack;
        }
        else{
            i.print(getName() + " tried to throw an insult at you but it has no more good lines");
            return lastAttack;
        }
    }
    /////////////////////////////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
}
