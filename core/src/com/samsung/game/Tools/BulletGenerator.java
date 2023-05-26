package com.samsung.game.Tools;

import com.samsung.game.Actors.Bullet;
import com.samsung.game.Main;
import com.samsung.game.Screens.GameScreen;

public class BulletGenerator {

    boolean isFire = false;
    int fireRate = 3;
    int timer = 0;

    public void update(Joystick joy) {
        isFire = joy.getDirection().x != 0 || joy.getDirection().y != 0;
        if (isFire) {
            timer++;
            if (timer >= 60 / fireRate && !GameScreen.player.isGhost()) {
                GameScreen.bullets.add(new Bullet(Main.bullet, GameScreen.player.position, 25, GameScreen.player.r / 2, joy.getDirection()));
                timer = 0;
            }
        }

    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }
}
