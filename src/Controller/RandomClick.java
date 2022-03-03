package Controller;

import Model.Click;

import java.util.Random;

public class RandomClick extends Multiplier{


    @Override
    void multiplier(Click c) {
        c.setClickValue(new Random().nextInt(3) + 1);
    }
}
