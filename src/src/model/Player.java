package model;

import shared.Block;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Player extends Observable implements IPlayer {
    private int x = 1;
    private int y = 22;
    private int mapID = 1;
    private IMap map;

    private boolean hasKey = false;
    private int maxJumps = 6;
    private int jumps = maxJumps;

    public Player(IMap map){
        this.map = map;
    }

    @Override
    public void move(char direction) {
        try {
            switch (direction) {
                case 'u':
                    if(jumps != 0) {
                        jumps--;
                        if (!(checkWall(x, (y - 1)))) y--;
                    } else {
                        if(!(checkWall(x, (y + 1)))) y++;
                    }
                    break;
                case 'd':
                    if (!(checkWall(x, (y + 1)))) {
                        y++;
                    }
                    break;
                case 'l':
                    if(jumps != 0) {
                        jumps--;
                        if (!(checkWall((x - 1), y))) x--;
                    } else  {
                        if (!(checkWall((x - 1), y))) x--;
                        if(!(checkWall(x, (y + 1)))) y++;
                    }
                    break;
                case 'r':
                    if(jumps != 0) {
                        jumps--;
                        if (!(checkWall((x + 1), y))) x++;
                    } else {
                        if (!(checkWall((x + 1), y))) x++;
                        if(!(checkWall(x, (y + 1)))) y++;
                    }
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) { }

        setChanged();
        notifyObservers();
    }

    @Override
    public boolean checkWall(int x, int y) {
        if(map.getTileAt(x, y).type == Block.upgrade) {
            maxJumps += 2;
            map.updateTile(x, y, new Block(Block.empty));
        } else if(map.getTileAt(x, y).type == Block.key) {
            hasKey = true;
            map.updateTile(x, y, new Block(Block.empty));
        } else if(map.getTileAt(x, y).type == Block.lever1) {
            for(int i = 0; i < map.getMap().length; i++) {
                for(int j = 0; j < map.getMap()[i].length; j++) {
                    if(map.getTileAt(i, j).type == Block.blockage1) map.updateTile(i, j, new Block(Block.empty));
                }
            }
        } else if (map.getTileAt(x, y).type == Block.lever2) {
            for(int i = 0; i < map.getMap().length; i++) {
                for(int j = 0; j < map.getMap()[i].length; j++) {
                    if(map.getTileAt(i, j).type == Block.blockage2) map.updateTile(i, j, new Block(Block.empty));
                }
            }
        } else if(map.getTileAt(x,y).type == Block.door) {
            if (hasKey) {
                map.updateTile(x, y, new Block(Block.empty));
                return false;
            } else return true;
        } else if (map.getTileAt(x, y).type == Block.spike) {
            jumps = 0;
            maxJumps = 0;
            return true;
        } else if(map.getTileAt(x, y + 1).type == Block.floor) {
            jumps = maxJumps;
            //return true;
        } else if(map.getTileAt(x, y).type == Block.empty) {
            return false;
        }

        return (map.getTileAt(x, y).isSolid());
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
        try {
            boolean canIHazWin;
            if (map.getMap()[getPos().width][getPos().height].type == Block.finish) {
                canIHazWin = true;
                mapID++;
            } else {
                canIHazWin = false;
            }
            return canIHazWin;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public boolean hasLost() {
        boolean arrowToTheKnee = false;
        try {
            if (map.getTileAt(x, y+1).type == Block.lava || map.getTileAt(x, y+1).type == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getTileAt(x, y-1).type == Block.lava || map.getTileAt(x, y-1).type == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getTileAt(x+1, y).type == Block.lava || map.getTileAt(x+1, y).type == Block.spike) {
                arrowToTheKnee = true;

            } else return (map.getTileAt(x-1, y).type == Block.lava || map.getTileAt(x-1, y).type == Block.spike);
        } catch(ArrayIndexOutOfBoundsException e){
            return true;
        }

        return arrowToTheKnee;
    }

    public void addAnObserver(Observer o) {
        addObserver(o);
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
        jumps = maxJumps;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;

        setChanged();
        notifyObservers();
    }

}
