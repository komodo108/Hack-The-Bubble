package model;

import shared.Block;

import java.awt.*;
import java.util.Observable;

public class Player extends Observable implements IPlayer {
    private int x = 1;
    private int y = 13;
    private Block[][] map;

    Player(Block[][] theMap,){
        map = theMap;
    }


    @Override
    public void move(char direction){
        switch(direction){
            case 'u':
                if(!((map[x][y+1].getChar(map[x][y+1]) == Block.floor || checkWall)))
                break;
            case 'd': break;
            case 'l': break;
            case 'r': break;
        }
    }

    @Override
    public boolean checkWall(int x, int y) {
        boolean thatsAWall;
        if (map[x][y] == wall || map[x][y] == floor) {
            thatsAWall == true;
        }
        else {
            thatsAWall == false;
        }
        return thatsAWall;
    }

    @Override
    public Dimension getPos() {
        return null;
    }


}
