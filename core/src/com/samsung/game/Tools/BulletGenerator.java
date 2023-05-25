package com.samsung.game.Tools;

import com.samsung.game.Actors.Bullet;
import com.samsung.game.Main;
import com.samsung.game.Screens.GameScreen;

public class BulletGenerator {

    boolean isFire = false;
    public void update(Joystick joy){
        isFire = joy.getDirection().x != 0 || joy.getDirection().y != 0;

        if (isFire) GameScreen.bullets.add(new Bullet(Main.circle,GameScreen.player.position,25,GameScreen.player.r/2,joy.getDirection()));
    }

}
