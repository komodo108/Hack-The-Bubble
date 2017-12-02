package model;
import model.IMap;
import shared.Block;
import sun.invoke.empty.Empty;

import java.io.*;
import java.util.Observable;

public class Map extends Observable implements IMap {
    private int mapID = 1;
    private int size = 25;
    private Block[][] map = new Block[size][size];

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

            for (int j = 0; j < size; j++) {

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

                    case Block.lever1:
                        map[j][i] = new Block(Block.lever1);
                        break;


                    case Block.lever2:
                        map[j][i] = new Block(Block.lever2);
                        break;

                    case Block.upgrade:
                        map[j][i] = new Block(Block.upgrade);
                        break;

                    case Block.blockage1:
                        map[j][i] = new Block(Block.blockage1);
                        break;

                    case Block.blockage2:
                        map[j][i] = new Block(Block.blockage2);
                        break;
                    case Block.enemy1:
                        map[j][i] = new Block(Block.enemy1);
                        break;
                    case Block.enemy2:
                        map[j][i] = new Block(Block.enemy2);
                        break;
                    case Block.cute1:
                        map[j][i] = new Block(Block.cute1);
                        break;
                    case Block.cute2:
                        map[j][i] = new Block(Block.cute2);
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