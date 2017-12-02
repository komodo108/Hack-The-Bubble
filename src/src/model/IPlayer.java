package model;

import java.awt.*;
import java.util.Observer;

public interface IPlayer {

    /**
     * Attempts to move the player in a direction
     * @param direction the direction to move in
     */
    void move(char direction);

    /**
     * Will be called by move(); checks if the given tile is a wall and calls methods related to keys
     * @param x x coord
     * @param y y coord
     */
    boolean checkWall(int x, int y);

    /**
     * Returns a new Dimension object with the players x and y coordinates
     * @return a new Dimension object with the players x and y coordinates
     */
    Dimension getPos();

    /**
     * Gets the number of jumps the player has before they start falling
     * @return jumps the player has before they start falling
     */
    int getJumps();

    /**
     * Set true if the player has won
     * @return true if win
     */
    boolean hasWon();

    /**
     * Set true if the player has lost
     * @return true if lost
     */
    boolean hasLost();

    /**
     * Adds o as an observer
     * @param o an Observer
     */
    void addAnObserver(Observer o);
}
