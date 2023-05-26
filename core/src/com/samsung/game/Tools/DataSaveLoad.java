package com.samsung.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaveLoad{

    FileHandle fileHandle;
    FileReader reader;
    FileWriter writer;

    public DataSaveLoad(){
        fileHandle = Gdx.files.internal("assets/Save.txt");
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
        try {
            writer = new FileWriter(fileHandle.file());
            System.out.println("Write");
            writer.write(score);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String load(){
        return fileHandle.readString();
    }

}
