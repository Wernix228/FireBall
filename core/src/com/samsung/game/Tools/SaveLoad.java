package com.samsung.game.Tools;

import java.io.*;

public class SaveLoad {

    private static File file;
    private static BufferedReader reader;
    private static Writer writer;

    public SaveLoad(){
        create();
    }
    private void create(){
        file = new File("assets/Save.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("created");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void save(String score){
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(score);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String load(){
        String str;
        try {
            reader = new BufferedReader(new FileReader(file));
            str = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }


}
