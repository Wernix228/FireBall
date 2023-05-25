package com.samsung.game.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.samsung.game.Main;

public class Bullet extends Actor{

    public boolean isOut;
    public Bullet(Texture img, Vector2 position, float speed, float r,Vector2 direction) {
        super(img, position, speed, r);
        this.direction = new Vector2(direction);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.setColor(0.7f,0.5f,0,1);
        batch.draw(img,position.x-r,position.y-r,r*2,r*2);
    }

    @Override
    public void update() {

        isOut = (position.x - r > Main.WIDTH) || (position.x - r < 0) || (position.y - r > Main.HEIGHT) || (position.y - r < 0);


        position.add(direction.x*speed,direction.y*speed);
        bounds.set(position,r);
    }
}
