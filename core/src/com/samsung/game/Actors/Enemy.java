package com.samsung.game.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.samsung.game.Main;

public class Enemy extends Actor {

    private int health, score, rank;

    public Enemy(Texture img, Vector2 position, int rank) {
        super(img, position);

        switch (rank) {
            case 1:
                r = Main.WIDTH / 30;
                speed = 10;
                score = health = 10;
                break;
            case 2:
                r = Main.WIDTH / 20;
                speed = 7;
                score = health = 20;
                break;
            case 3:
                r = Main.WIDTH / 15;
                speed = 5;
                score = health = 30;
                break;
        }
        bounds = new Circle(position, r);
        direction.x = (MathUtils.sin((float) Math.toRadians(Math.random() * 360)));
        direction.y = (MathUtils.cos((float) Math.toRadians(Math.random() * 360)));
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.setColor(Color.BLUE);
        batch.draw(img,position.x-r,position.y-r,r*2,r*2);
        batch.setColor(Color.WHITE);
    }

    @Override
    public void update() {

        if (position.x + r/5 > Main.WIDTH) direction.x = -direction.x;
        if (position.x - r < 0) direction.x = -direction.x;

        if (position.y + r/5 > Main.HEIGHT) direction.y = -direction.y;
        if (position.y - r < 0) direction.y = -direction.y;

        position.add(direction.x*speed,direction.y*speed);
        bounds.set(position,r);
    }
    public void hit(){
        health--;
    }

    public int getHealth() {
        return health;
    }
}
