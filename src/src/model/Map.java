package model;
import model.IMap;
import shared.Block;
import sun.invoke.empty.Empty;

import java.io.*;
import java.util.Observable;

public class Map extends Observable implements IMap {
    private int size = 25;
    private Block[][] map = new Block[size][size];
    private char[][] importedMap = new char [size][size];






    //return size
    int getSize(){
        return size;
    }

    @Override
    public Block[][] getMap() {
        return map;
    }

    @Override
    public void updateTile(int x, int y, Block block) {
        map[x][y] = block;
    }

    @Override
    public Block getTileAt(int x, int y) {
        return map[x][y];
    }

    @Override
    public void readMapFromFile(String pathname) {
        try {
            BufferedReader mapReader = new BufferedReader(new FileReader(pathname));


            //i = y; j = x
        String line = "";
        for(int i = 0; (line = mapReader.readLine()) != null; i++) {

            char[] chars = line.toCharArray();

            for (int j = 0; j < size; i++) {

                switch(chars[j]) {
                    case Block.empty:
                        map[j][i] = Block.empty;
                        break;

                    case Block.floor:
                        map[j][i] = Block.floor;
                        break;

                    case Block.lava:
                        map[j][i] = Block.lava;
                        break;

                    case Block.wall:
                        map[j][i] = Block.wall;
                        break;

                    case Block.spike:
                        map[j][i] = Block.spike;
                        break;

                    case Block.door:
                        map[j][i] = Block.door;
                        break;

                    case Block.finish:
                        map[j][i] = Block.finish;
                        break;

                    case Block.key:
                        map[j][i] = Block.key;
                        break;



                }
            }
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

        /*
        * floor tile
        * empty
        * player tile
        *
        *
        *
        *
        *
        * */