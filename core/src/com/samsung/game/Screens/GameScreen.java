package com.samsung.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.samsung.game.Actors.Bullet;
import com.samsung.game.Actors.Enemy;
import com.samsung.game.Actors.Player;
import com.samsung.game.Main;
import com.samsung.game.Tools.*;

public class GameScreen implements Screen {

    Joystick joy, joy2;
    public static Player player;
    public static Array<Bullet> bullets;
    public static Array<Enemy> enemies;
    public static Wave wave;
    public static GameHud hud;
    public static BulletGenerator bulletGenerator;
    DataSaveLoad saveLoad;
    Main main;

    public GameScreen(Main main) {
        this.main = main;
        saveLoad = new DataSaveLoad();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            //------------------------------------------------------------------------------
            //Android
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Main.HEIGHT - screenY;
                multiTouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY = Main.HEIGHT - screenY;
                multiTouch((int)screenX,(int)screenY,false,pointer);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY = Main.HEIGHT - screenY;
                multiTouch(screenX,screenY,true,pointer);
                return false;
            }

            //------------------------------------------------------------------------------
            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });
        loadActors();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0.0f,0.0f,1);
        gameUpdate();
        main.batch.begin();
        gameRender(main.batch);
        main.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public void gameUpdate(){
        player.setDirection(joy.getDirection());
        player.update();
        bulletGenerator.update(joy2);
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).update();
            if (bullets.get(i).isOut) bullets.removeIndex(i--);
        }
        for (int i = 0; i < enemies.size; i++){
            enemies.get(i).update();
            if (enemies.get(i).getHealth() < 1) enemies.removeIndex(i--);
            collision();
        }
        wave.update();
        if (player.getHealth() < 1){
//            if (player.getScore() )
            main.setScreen(new DeadScreen(main,player.getScore() + " "));
        }
    }
    public void gameRender(SpriteBatch batch){
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).draw(batch);
        }
        for (int i = 0; i < enemies.size; i++) {
            enemies.get(i).draw(batch);
        }
        player.draw(batch);
        joy.draw(batch);
        joy2.draw(batch);
        if (wave.isDraw()) wave.draw(batch);
        hud.draw(batch);
    }
    public void loadActors(){
        joy2 = new Joystick(main.circle,main.actor,new Vector2(Main.WIDTH - ((Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4),(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4),Main.HEIGHT/3);
        joy = new Joystick(main.circle,main.actor,new Vector2(((Main.HEIGHT/3)/4 + Main.HEIGHT/5),(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4),Main.HEIGHT/3);
        bullets = new Array<>();
        enemies = new Array<>();
        bulletGenerator = new BulletGenerator();
        player = new Player(main.actor,new Vector2(Main.WIDTH/2,Main.HEIGHT/2),10,Main.HEIGHT/20,3);
        wave = new Wave(1,1,5);
        hud = new GameHud();
    }

    public void multiTouch(float x, float y,boolean isDownTouch,int pointer) {
        for (int i = 0; i < 5; i++) {
            joy.update(x, y, isDownTouch, pointer);
            joy2.update(x, y, isDownTouch, pointer);
        }
    }
    public void collision(){
        for (int i = 0; i < bullets.size; i++) for (int j = 0; j < enemies.size; j++) {
            if (bullets.get(i).bounds.overlaps(enemies.get(j).bounds)){
                bullets.removeIndex(i--);
                player.addScore();
                enemies.get(j).hit();
                break;
            }
        }
        for (int i = 0; i < enemies.size; i++) {
            if (player.bounds.overlaps(enemies.get(i).bounds)){
                player.hit();
                if (!player.isGhost()) enemies.get(i).hit();
            }
        }
    }
}
