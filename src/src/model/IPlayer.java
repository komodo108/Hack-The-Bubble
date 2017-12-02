package model;

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
    void checkWall(int x, int y);

}
