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
                if(!(checkWall(x, (y+1)))){
                    y = y+1;
                }
                break;
            case 'd':
                if(!(checkWall(x, (y-1)))){
                    y = y-1;
                }
                break;
            case 'l':
                if(!(checkWall((x+1), y))){
                    x = x+1;
                }
                break;
            case 'r':
                if(!(checkWall((x-1), y))){
                    x = x-1;
                }
                break;
        }
    }

    @Override
    public boolean checkWall(int x, int y) {
        boolean thatsAWall = false;
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
