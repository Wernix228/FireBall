package com.samsung.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;
import com.samsung.game.Main;
import com.samsung.game.Tools.MusicPlayer;
import com.samsung.game.Tools.SaveLoad;

public class StartScreen implements Screen {

    private Main main;
    private BitmapFont font;
    private GlyphLayout gl;

    public StartScreen(Main main) {
        this.main = main;
        MusicPlayer.play();

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter p = new FreeTypeFontGenerator.FreeTypeFontParameter();
        p.size = Main.WIDTH/20;
        p.color = new Color(Color.ORANGE);

        font = gen.generateFont(p);

        gl = new GlyphLayout();
        gl.setText(font,"Fire Ball Defender \n  tap to start");
        System.out.println(SaveLoad.load());
    }

    @Override
    public void show() {

    }
    int time = 0;
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        main.batch.begin();
        main.batch.draw(Main.background,0,0,Main.WIDTH,Main.HEIGHT);
        font.draw(main.batch, gl,Main.WIDTH/2-Main.WIDTH/9,Main.HEIGHT/1.5f-Main.WIDTH/20);
        main.batch.end();
        time++;
        if(Gdx.input.isTouched() && time > 60){
            main.setScreen(main.gameScreen);
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
