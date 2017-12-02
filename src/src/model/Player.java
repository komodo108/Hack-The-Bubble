package model;

import shared.Block;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Player extends Observable implements IPlayer {
    private int x = 1;
    private int y = 22;
    private IMap map;
    private int jumps = 0;
    private int maxJumps = 6;


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
        if (map.getMap()[x][y].getChar(map.getTileAt(x,y)) == Block.wall || map.getMap()[x][y].getChar(map.getTileAt(x,y)) == Block.floor) {
            thatsAWall = true;
        }
        else {
            thatsAWall = false;
        }
        return thatsAWall;
    }

    @Override
    public Dimension getPos() {
        return new Dimension(x,y);
    }

    @Override
    public int getJumps() {
        return jumps;
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
        boolean arrowToTheKnee = false;
        try {
            if (map.getMap()[x][y+1].getChar(map.getTileAt(x,(y+1))) == Block.lava || map.getMap()[x][y+1].getChar(map.getTileAt(x,(y+1))) == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getMap()[x][y-1].getChar(map.getTileAt(x,(y-1))) == Block.lava || map.getMap()[x][y-1].getChar(map.getTileAt(x,(y-1))) == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getMap()[x+1][y].getChar(map.getTileAt((x+1),y)) == Block.lava || map.getMap()[x+1][y].getChar(map.getTileAt((x+1),y)) == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getMap()[x-1][y].getChar(map.getTileAt((x-1),y)) == Block.lava || map.getMap()[x-1][y].getChar(map.getTileAt((x-1),y)) == Block.spike) {
                arrowToTheKnee = true;

            } else {
                arrowToTheKnee = false;
            }
        } catch(ArrayIndexOutOfBoundsException e){ }

        return arrowToTheKnee;
    }

    public void addAnObserver(Observer o) {
        addObserver(o);
    }

}
