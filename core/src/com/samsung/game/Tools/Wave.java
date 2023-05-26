package com.samsung.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.samsung.game.Actors.Enemy;
import com.samsung.game.Main;
import com.samsung.game.Screens.GameScreen;

public class Wave {

    private int delay;
    private long startTimer;
    private String str = "WAVE - ";
    private int waveNumber;
    private int minEnemy;
    BitmapFont font;

    public Wave(int delay, int waveNumber,int minEnemy) {
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter p = new FreeTypeFontGenerator.FreeTypeFontParameter();
        p.size = Main.WIDTH/10;
        p.color = new Color(0.5f,0.2f,0f,1f);

        font = gen.generateFont(p);

        this.delay = delay;
        this.waveNumber = waveNumber;
        this.minEnemy = minEnemy;
    }

    public void update(){
        if (GameScreen.enemies.size == 0 && startTimer == 0) startTimer = System.currentTimeMillis();
        int seconds = 0;
        if (startTimer > 0) seconds = (int) ((System.currentTimeMillis() - startTimer) / 1000);
        if (seconds >= delay){
            setWave();
            waveNumber++;
            startTimer = 0;
            seconds = 0;
        }
    }

    public void setWave(){
        int enimies = minEnemy + waveNumber * 2;
        int maxRank = 1;
        if (waveNumber > 5) maxRank = 2;
        if (waveNumber > 10) maxRank = 3;

        for (int i = 0; i < enimies; i++) {
            GameScreen.enemies.add(new Enemy(Main.actor,new Vector2(Main.WIDTH/2,Main.HEIGHT/4), MathUtils.random(1,maxRank)));
        }


    }
    public void draw(SpriteBatch batch){

        GlyphLayout gl = new GlyphLayout();
        gl.setText(font,str + waveNumber);
        font.draw(batch,gl,Main.WIDTH/2 - gl.width/2,Main.HEIGHT/1.5f);
    }
    public boolean isDraw(){
        return startTimer > 0;
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
