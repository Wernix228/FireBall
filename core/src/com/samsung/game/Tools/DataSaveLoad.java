package com.samsung.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.IOException;

public class DataSaveLoad{

    FileHandle fileHandle;

    public DataSaveLoad(){
        fileHandle = Gdx.files.internal("Assets/Save.txt");
        if (!fileHandle.exists()) {
            System.out.println("create");
            try {
                fileHandle.file().createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void save(String score){
        fileHandle.writeString(score,false);
    }
    public String load(){
        return fileHandle.readString();
    }

}
