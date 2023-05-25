package com.samsung.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.samsung.game.Main;
import com.samsung.game.Screens.GameScreen;

public class GameHud {

    BitmapFont font;

    public GameHud(){

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter p = new FreeTypeFontGenerator.FreeTypeFontParameter();
        p.size = Main.WIDTH/20;
        p.color = new Color(Color.ORANGE);

        font = gen.generateFont(p);
    }
    public void draw(SpriteBatch batch){
        GlyphLayout gl = new GlyphLayout();
        gl.setText(font, GameScreen.player.getHealth() + " ");
        font.draw(batch,gl,0,Main.HEIGHT-gl.height);
        gl.setText(font, GameScreen.player.getScore() + " ");
        font.draw(batch,gl,Main.WIDTH/2 - gl.width/2,Main.HEIGHT-gl.height);
    }

}
