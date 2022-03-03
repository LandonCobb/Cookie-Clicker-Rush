package Controller;

import Model.Click;

import java.util.Random;

public class MultClick extends Multiplier{
    @Override
    void multiplier(Click c) {
        Random ran = new Random();
        c.setClickValue(c.getClickValue() * (ran.nextInt(3) + 2));
    }

}
