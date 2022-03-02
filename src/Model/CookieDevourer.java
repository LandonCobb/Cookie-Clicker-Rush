package Model;

import java.util.Random;

public class CookieDevourer extends Character{
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
        int loop = ran.nextInt(4);
        int lastAttack = 0;
        while(loop > 0){
            lastAttack = lastAttack + getAttack();
            loop--;
        }
        System.out.println("The " + getName() + " went on a rampage and threw nasty insults at you! You took: " + lastAttack + " damage!");
        return lastAttack;
    }
    /////////////////////////////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
}
