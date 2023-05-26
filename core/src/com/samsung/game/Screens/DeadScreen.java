package com.samsung.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;
import com.samsung.game.Main;
import com.samsung.game.Tools.DataSaveLoad;

public class DeadScreen implements Screen {

    Main main;
    BitmapFont font;
    GlyphLayout gl;
    Texture bg;
    public DeadScreen(Main main, String score) {
        this.main = main;

        bg = new Texture("backgrounds/gameOver.png");

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter p = new FreeTypeFontGenerator.FreeTypeFontParameter();
        p.size = Main.WIDTH/20;
        p.color = new Color(Color.YELLOW);

        font = gen.generateFont(p);

        gl = new GlyphLayout();
        gl.setText(font,"Score: " + score);
    }

    @Override
    public void show() {

    }
    int time;
    @Override
    public void render(float delta) {
        time++;
        ScreenUtils.clear(Color.BLACK);
        main.batch.begin();
        main.batch.draw(bg,0,0,Main.WIDTH,Main.HEIGHT);
        font.draw(main.batch, gl,Main.WIDTH/2 - gl.width/2,Main.HEIGHT/2 - gl.height/2);
        main.batch.end();

        if(Gdx.input.isTouched() && time > 60){
            main.setScreen(new GameScreen(main));
        }
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
}
