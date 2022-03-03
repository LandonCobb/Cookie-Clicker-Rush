package Model;

public class Player extends Character{
    int score;
    public Player(String name, int hp, int attack){
        super.setName(name);
        super.setHp(hp);
        super.setAttack(attack);
    }

    public Player(){

    }
    ///////////////////////////////////////
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0){
            this.score = 0;
        }
        else{
            this.score = score;
        }
    }
    ///////////////////////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
}
