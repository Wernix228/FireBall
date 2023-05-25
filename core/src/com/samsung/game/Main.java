package com.samsung.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.samsung.game.Screens.GameScreen;

public class Main extends Game {
	public SpriteBatch batch;
	public Texture img;
	public static int  WIDTH, HEIGHT;
	public static Texture circle,actor;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		circle = new Texture("img.png");
		actor = new Texture("Actor.png");
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
