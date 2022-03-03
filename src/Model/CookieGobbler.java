package Model;

import View.Input;

import java.util.Random;

public class CookieGobbler extends Character{
    ///////////////////////////////////////////////////////////////////////
    int healCounter = 0;
    Input i = new Input();
    ///////////////////////////////////////////////////////////////////////
    public CookieGobbler(String name, int hp, int attack){
        super.setName(name);
        super.setHp(hp);
        super.setAttack(attack);
    }
    ///////////////////////////////////////////////////////////
    public void heal(int cookie){
        //heals the boss but can only be used a certain amount of times
        if(healCounter <= 3){
            int hp = getHp() + cookie;
            setHp(hp);
            healCounter++;
            i.print("the Horrible monster found " + cookie + " cookies running about and ate them! " + getName() + "healed for:" + cookie);
        }
        if(cookie == 0){
            i.print("the monster tried to grab a lone cookie to eat but it was to fast for him");
        }
        else{
            i.print("The monster tried to stuff cookies into his mouth but its too full to eat another");
        }
    }
    ////////////////////////////////////////////////////////////
    @Override
    public void setHp(int hp) {
        if(hp > 100){
            this.hp = 100;
        }
        else{
            this.hp = hp;
        }
    }
    //////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
}