package com.samsung.game.Tools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Joystick {

    Texture circleImg, stickImg;
    Circle circleBounds, stickBounds;
    float rCircle, rStick;
    private int pointer = -1;
    Vector2 direction;

    public Joystick(Texture circleImg, Texture stickImg, Vector2 point, float size) {
        this.circleImg = circleImg;
        this.stickImg = stickImg;
        rCircle = size / 2;
        rStick = rCircle / 4;
        circleBounds = new Circle(point, rCircle);
        stickBounds = new Circle(point, rStick);
        direction = new Vector2(0, 0);
    }

    public void draw(SpriteBatch batch) {
        batch.setColor(1,1,1,0.5f);
        batch.draw(circleImg, circleBounds.x - rCircle, circleBounds.y - rCircle, rCircle * 2, rCircle * 2);
        batch.draw(stickImg, stickBounds.x - rStick, stickBounds.y - rStick, rStick * 2, rStick * 2);
        batch.setColor(Color.WHITE);
    }

    public void update(float x, float y,boolean isDownTouch,int pointer) {
        Vector2 touch = new Vector2(x,y);
        if (circleBounds.contains(touch) && isDownTouch && this.pointer == -1) this.pointer = pointer;
        if (circleBounds.overlaps(stickBounds) && isDownTouch && pointer == this.pointer) atControl(new Vector2(x,y));
        if ((!isDownTouch && pointer == this.pointer) || (isDownTouch && pointer == this.pointer && !circleBounds.contains(touch))) returnStick();

    }

    public void atControl(Vector2 point) {
        stickBounds.set(point, rStick);
        float dx = circleBounds.x - stickBounds.x;
        float dy = circleBounds.y - stickBounds.y;
        float dist = (float) Math.sqrt(dx * dx + dy * dy);
        direction.set(-(dx / dist), -(dy / dist));
    }
    public void returnStick(){
        stickBounds.set(circleBounds);
        direction.set(0,0);
        pointer = -1;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
