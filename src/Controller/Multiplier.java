package Controller;

import Model.Click;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Multiplier {
    private int multValue;
    Click click = new Click();

    public int getMultValue() {
        return multValue;
    }

    public void setMultValue(int multValue) {
        this.multValue = multValue;
    }

    //basic multiplier
    public void multClick(int multValue){
        click.setClickValue(click.getClickValue() * multValue);
    }

    //timer multiplier/adder
    public void bleedClick(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //TODO cancel timer at certain point
            }
        }, 0, 2000);
    }

    public void randomClick(){
        Random rnd = new Random();
        click.setClickValue(rnd.nextInt(3) + 1);
    }
}
