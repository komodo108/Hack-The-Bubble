package model;
import model.IMap;
import shared.Block;
import sun.invoke.empty.Empty;

import java.util.Observable;

public class Map extends Observable implements IMap {
    private int size = 25;
    private Block[][] map = new Block[size][size];
    private char[][] importedMap = new char [size][size];



    private void makeBoard(){
        // this will set the initial empty board
        //defines valid and invalid

        for (int x = 0; x < size; x++){
            for (int y = 0; y < size; y++){



            }
        }
    }

    public void setBoard(){


    }





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