package Controller;
import Model.Click;
import Model.CookieDemon;
import Model.Player;

import java.util.Timer;
import java.util.TimerTask;

public class BleedClick extends Multiplier {
    Player player = new Player();
    CookieDemon cd = new CookieDemon();
    @Override
    void multiplier(Click c) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(player.getHp() <= 0 || cd.getHp() <= 0) timer.cancel();
                player.setScore(player.getScore() + 5);
            }
        }, 0, 500);
    }
}
