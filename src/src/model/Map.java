package model;
import model.IMap;
import shared.Block;
import sun.invoke.empty.Empty;

import java.io.*;
import java.util.Observable;

public class Map extends Observable implements IMap {
    private int size = 15;
    private Block[][] map = new Block[size][size];

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
                        map[j][i] = new Block(Block.empty);
                        break;

                    case Block.floor:
                        map[j][i] = new Block(Block.floor);
                        break;

                    case Block.lava:
                        map[j][i] = new Block(Block.lava);
                        break;

                    case Block.wall:
                        map[j][i] = new Block(Block.wall);
                        break;

                    case Block.spike:
                        map[j][i] = new Block(Block.spike);
                        break;

                    case Block.door:
                        map[j][i] = new Block(Block.door);
                        break;

                    case Block.finish:
                        map[j][i] = new Block(Block.finish);
                        break;

                    case Block.key:
                        map[j][i] = new Block(Block.key);
                        break;

                    case Block.lever:
                        map[j][i] = new Block(Block.lever);
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

    // this should turn char array to block array




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