package Model;

public class CookieDemon extends Character{

    public CookieDemon(String name, int hp, int attack){
        super.setName(name);
        super.setHp(hp);
        super.setAttack(attack);
    }
    //////////////////////////////////////////////////
    public void cookieDrainHealth(int cookie){
        int hp;
        if(cookie > 0){
            hp = getHp() + cookie;
            setHp(hp);
            System.out.println("The Cookie Demon stole " + cookie + " cookies from you and ate them...how rude! Cookie Demon restored: " + cookie + " hp!");
        }
        else{
            System.out.println("The Cookie Demon tries to snatch cookies from your bag but upon seeing your bag empty he laughs at how poor you are...you cry in sadness");
        }
    }
/////////////////////////////////////////////////////////////////////////////
    public int cookieDrainAttack(int cookie){
        int cookieAttack;
        if(cookie > 0){
            cookieAttack = getAttack() + cookie;
            System.out.println("The Demon magically took cookies out of your bag and tossed them at your face!!! you took: " + cookieAttack + " damage!");
            return cookieAttack;
        }
        System.out.println("The Cookie Demon tries to snatch cookies from your bag but its empty. He sighs in disappointment, you felt mentally hurt by this, you took: " + getAttack() + " damage!");
        return getAttack();
    }
    ////////////////////////////////////////////////
    //need to change variables
    @Override
    public void setHp(int hp){
        if(hp > 100){
            this.hp = 100;
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
