package Model;

public class Player extends Character{
    public Player(String name, int hp, int attack){
        super.setName(name);
        super.setHp(hp);
        super.setAttack(attack);
    }
///////////////////////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
}
