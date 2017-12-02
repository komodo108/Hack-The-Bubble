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
    private int enemy = 0;

    private boolean hasKey = false;
    private boolean interact = false;
    private String text = "";

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

            boolean isDone = false;
            for(int i = 0; i < map.getMap().length; i++) {
                for(int j = 0; j < map.getMap()[i].length; j++) {
                    if(map.getTileAt(i, j).type == Block.enemy) {
                        if(!isDone) {
                            if (enemy == 0) {
                                map.updateTile(i, j, new Block(Block.empty));
                                map.updateTile(i, (j - 1), new Block(Block.enemy));
                                enemy++;
                            } else if (enemy == 1) {
                                map.updateTile(i, j, new Block(Block.empty));
                                map.updateTile(i, (j + 1), new Block(Block.enemy));
                                enemy--;
                            }
                            isDone = true;
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) { }

        setChanged();
        notifyObservers();
    }

    @Override
    public boolean checkWall(int x, int y) {
        if(map.getTileAt(x, y).type == Block.cute1) {
            text = "What are you looking at you mangled lizard?";
            interact = true;

            for(int i = 0; i < map.getMap().length; i++) {
                for(int j = 0; j < map.getMap()[i].length; j++) {
                    if(map.getTileAt(i, j).type == Block.cute1) {
                        map.updateTile(i, j, new Block(Block.empty));
                        map.updateTile(i, j, new Block(Block.enemy));
                    }
                }
            }
        } else if(map.getTileAt(x, y).type == Block.cute2) {
            text = "Fellow infernal, you're looking grim. Here, empower thyself.";
            interact = true;
            maxJumps +=2;
        } else if(map.getTileAt(x, y).type == Block.upgrade) {
            text = "You feel yourself grow stronger.";
            interact = true;
            maxJumps += 2;
            map.updateTile(x, y, new Block(Block.empty));
        } else if(map.getTileAt(x, y).type == Block.key) {
            text = "Something glints on the floor in the dim light. A key.";
            interact = true;
            hasKey = true;
            map.updateTile(x, y, new Block(Block.empty));
        } else if(map.getTileAt(x, y).type == Block.lever1) {
            text = "You press the button and hear a terrible crumbling sound.";
            interact = true;
            for(int i = 0; i < map.getMap().length; i++) {
                for(int j = 0; j < map.getMap()[i].length; j++) {
                    if(map.getTileAt(i, j).type == Block.blockage1) map.updateTile(i, j, new Block(Block.empty));
                }
            }
        } else if (map.getTileAt(x, y).type == Block.lever2) {
            text = "You press the button and hear a terrible crumbling sound.";
            interact = true;
            for(int i = 0; i < map.getMap().length; i++) {
                for(int j = 0; j < map.getMap()[i].length; j++) {
                    if(map.getTileAt(i, j).type == Block.blockage2) map.updateTile(i, j, new Block(Block.empty));
                }
            }
        } else if(map.getTileAt(x,y).type == Block.door) {
            if (hasKey) {
                text = "Silently, the door swings open.";
                interact = true;
                map.updateTile(x, y, new Block(Block.empty));
                return false;
            } else {
                text = "An imposing door looms in front of you.";
                interact = true;
                return true;
            }
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
            if(map.getTileAt(x, y).type == Block.enemy) {
                arrowToTheKnee = true;
            }

            if (map.getTileAt(x, y+1).type == Block.lava || map.getTileAt(x, y+1).type == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getTileAt(x, y-1).type == Block.lava || map.getTileAt(x, y-1).type == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getTileAt(x+1, y).type == Block.lava || map.getTileAt(x+1, y).type == Block.spike) {
                arrowToTheKnee = true;

            } else if (map.getTileAt(x-1, y).type == Block.lava || map.getTileAt(x-1, y).type == Block.spike) {
                return true;
            }
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
        hasKey = false;

        setChanged();
        notifyObservers();
    }

    public String getToSay() {
        return text;
    }

    public boolean isInteract() {
        return interact;
    }

    public void setInteract(boolean interact) {
        this.interact = interact;
        text = "";

        setChanged();
        notifyObservers();
    }
}
