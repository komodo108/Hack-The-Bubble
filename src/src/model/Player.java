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
    public void checkWall(int x, int y) {

    }

    @Override
    public Dimension getPos() {
        return null;
    }


}
