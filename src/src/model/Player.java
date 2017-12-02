package model;

import shared.Block;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Player extends Observable implements IPlayer {
    private int x = 1;
    private int y = 22;
    private IMap map;

    public Player(IMap map){
        this.map = map;
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
        /*if (map[x][y] == wall || map[x][y] == floor) {
            thatsAWall = true;
        }
        else {
            thatsAWall = false;
        }*/
        return thatsAWall;
    }

    @Override
    public Dimension getPos() {
        return new Dimension(x,y);
    }

    @Override
    public int getJumps() {
        return 0;
    }

    @Override
    public boolean hasWon() {
        boolean canIHazWin;
        if(map.getMap()[getPos().width][getPos().height].type == Block.finish) {
            canIHazWin = true;
        }
        else {
            canIHazWin = false;
        }
        return canIHazWin;
    }

    @Override
    public boolean hasLost() {
        boolean arrowToTheKnee;
        if (map[x][y+1].getChar() == Block.lava || map[x][y+1].getChar() == Block.spike){
            arrowToTheKnee = true;

        }else if(map[x][y-1].getChar() == Block.lava || map[x][y-1].getChar() == Block.spike){
            arrowToTheKnee = true;

        }else if(map[x+1][y].getChar() == Block.lava || map[x+1][y].getChar() == Block.spike){
            arrowToTheKnee = true;

        }else if (map[x-1][y].getChar() == Block.lava || map[x-1][y].getChar() == Block.spike){
            arrowToTheKnee = true;

        } else {
            arrowToTheKnee = false;
        }

        return arrowToTheKnee;
    }

    public void addAnObserver(Observer o) {
        addObserver(o);
    }

}
