package Model;

import View.Input;

public class CookieDemon extends Character{
    Input i = new Input();
    int specialAttackCount = 0;
    int specialHeal = 0;
    public CookieDemon(String name, int hp, int attack){
        super.setName(name);
        super.setHp(hp);
        super.setAttack(attack);
    }

    public CookieDemon(){}
    //////////////////////////////////////////////////
    public void cookieDrainHealth(int cookie){
        int hp;
        if(specialHeal < 2){
            hp = getHp() + cookie;
            setHp(hp);
            i.print("The Cookie Demon stole " + cookie + " cookies from you and ate them...how rude! Cookie Demon restored: " + cookie + " hp!");
            specialHeal++;
        }
        else{
            i.print("The Cookie Demon tries to snatch cookies from your bag but upon seeing your bag empty he laughs at how poor you are...you cry in sadness");
        }
    }
/////////////////////////////////////////////////////////////////////////////
    public int cookieDrainAttack(int cookie){
        int cookieAttack;
        if(specialAttackCount < 2){
            cookieAttack = getAttack() + cookie;
            i.print("The Demon magically took cookies out of your bag and tossed them at your face!!! you took: " + cookieAttack + " damage!");
            specialAttackCount++;
            return cookieAttack;
        }
        i.print("The Cookie Demon tries to snatch cookies from your bag but its empty. He sighs in disappointment, you felt mentally hurt by this, you took: " + getAttack() + " damage!");
        return getAttack();
    }
    ////////////////////////////////////////////////
    //need to change variables
    @Override
    public void setHp(int hp){
        if(hp > 120){
            this.hp = 120;
        }
        else{
            this.hp = hp;
        }
    }
    ////////////////////////////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
}
