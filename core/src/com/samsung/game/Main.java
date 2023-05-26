package com.samsung.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Screens.GameScreen;

public class Main extends Game {
	public SpriteBatch batch;
	public static int  WIDTH, HEIGHT;
	public static Texture circle,actor,bullet,player;
	public static Texture background;

	@Override
	public void create () {
		batch = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		circle = new Texture("entity/img.png");
		actor = new Texture("entity/Actor.png");
		bullet = new Texture("entity/player/bullet.png");
		player = new Texture("entity/player/player.png");
		background = new Texture("backgrounds/bg.png");
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
		circle.dispose();
		actor.dispose();
		bullet.dispose();
		player.dispose();
		background.dispose();
	}
}
