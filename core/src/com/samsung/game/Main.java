package com.samsung.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.game.Screens.DeadScreen;
import com.samsung.game.Screens.GameScreen;
import com.samsung.game.Screens.StartScreen;
import com.samsung.game.Tools.SaveLoad;

public class Main extends Game {
	public SpriteBatch batch;
	public static int  WIDTH, HEIGHT;
	public static Texture circle,actor,bullet,player;
	public static Texture background;
	public StartScreen startScreen;
	public GameScreen gameScreen;
	public DeadScreen deadScreen;
	public SaveLoad saveLoad;

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
		saveLoad = new SaveLoad();
		startScreen = new StartScreen(this);
		gameScreen = new GameScreen(this);
		deadScreen = new DeadScreen(this);
		setScreen(startScreen);
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
