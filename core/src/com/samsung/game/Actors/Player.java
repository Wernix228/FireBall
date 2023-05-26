package com.samsung.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.samsung.game.Main;

public class Player extends Actor {

    private int score;
    private float health;
    private boolean ghost;
    private long startTimer = 0;
    private float regeneration = 0.0002f;

    public Player(Texture img, Vector2 position, float speed, float r, float health) {
        super(img, position, speed, r);
        this.health = health;
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (ghost) batch .setColor(10,0,10,1);
        else batch.setColor(Color.ORANGE);
        batch.draw(img, position.x - r, position.y - r, r * 2, r * 2);
        batch.setColor(Color.WHITE);

    }

    @Override
    public void update() {
        health += regeneration;
        if (position.x + r / 5 > Main.WIDTH) position.x = Main.WIDTH - r / 5;
        if (position.x - r < 0) position.x = r;

        if (position.y + r / 5 > Main.HEIGHT) position.y = Main.HEIGHT - r / 5;
        if (position.y - r < 0) position.y = r;

        if (startTimer == 0 && ghost) startTimer = System.currentTimeMillis();
        int seconds = 0;
        if (startTimer > 0) seconds = (int) (System.currentTimeMillis() - startTimer) / 1000;
        if (seconds > 0.5f) {
            ghost = false;
            startTimer = 0;
            seconds = 0;
        }

        position.add(direction.x * speed, direction.y * speed);
        bounds.set(position, r);
    }

    public void setDirection(Vector2 dir) {
        direction = dir;
    }

    public void hit() {
        if (!ghost) {
            ghost = true;
            health--;
        }
    }

    public boolean isGhost() {
        return ghost;
    }

    public float getHealth() {
        return health;
    }
    public void addScore(){
        score++;
    }

    public int getScore() {
        return score;
    }

    public float getRegeneration() {
        return regeneration;
    }

    public void setRegeneration(float regeneration) {
        this.regeneration = regeneration;
    }

}
