package model;

import shared.Block;

public interface IMap {

    /**
     * Gets the map 2D array
     * @return the map 2D array
     */
    Block[][] getMap();

    /**
     * Updates the tile at (x, y) to block
     * @param x x coord
     * @param y y coord
     * @param block the block
     */
    void updateTile(int x, int y, Block block);

    /**
     * Gets the block at (x, y)
     * @param x x coord
     * @param y y coord
     * @return the block at (x, y)
     */
    Block getTileAt(int x, int y);

    /**
     * Reads in a map file and sets the map to that file
     * @param pathname the path to the map file
     */
    void readMapFromFile(String pathname);

}
