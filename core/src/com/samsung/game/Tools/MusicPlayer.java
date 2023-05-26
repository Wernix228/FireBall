package com.samsung.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer {

    static Music music = Gdx.audio.newMusic(Gdx.files.internal("music/musicBackg.mp3"));
    public MusicPlayer(){
        music = Gdx.audio.newMusic(Gdx.files.internal("music/musicBackg.mp3"));
    }
    public static void play(){
        music.setVolume(0.3f);
        music.play();
    }

}
