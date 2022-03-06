package Controller;
import Model.Click;
import Model.Player;

import java.util.Timer;
import java.util.TimerTask;

public class BleedClick extends Multiplier{
    Player player = new Player();
    @Override
    void multiplier(Click c) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                player.setScore(player.getScore() + 5);
            }
        }, 0, 500);
    }
}
