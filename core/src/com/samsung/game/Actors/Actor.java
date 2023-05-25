package com.samsung.game.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.samsung.game.GraphicsObj.GraphicsObj;

public class Actor extends GraphicsObj {

    public Vector2 position;
    public float speed, r;
    public Circle bounds;
    public Vector2 direction;

    public Actor(Texture img, Vector2 position, float speed, float r) {
        super(img);
        this.position = new Vector2(position);
        this.speed = speed;
        this.r = r;
        bounds = new Circle(position, r);
        direction = new Vector2(0,0);
    }
    public Actor(Texture img, Vector2 position) {
        super(img);
        this.position = new Vector2(position);
        direction = new Vector2(0,0);
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void update() {

    }
}
