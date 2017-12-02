import model.IMap;
import shared.Block;

import java.util.Observable;

public class Map extends Observable implements IMap {
    private int size = 25;
    private Block[][] map = new Block[size][size];
    private char[][] board = new char[size][size];
    private final char FREE = '.';
    private final char INVALID = ' ';
    private final char  = '*';
    private final char GOOSE = 'o';


    private void makeBoard(){
        // this will set the initial empty board
        //defines valid and invalid

        for (int x = 0; x < size; x++){
            for (int y = 0; y < size; y++){


                    board[x][y] = FREE;

            }
        }
    }

    public void setBoard(){
        //this will put the players on the board
        //clears the board
        makeBoard();

        //putting the geese on the board
        for (int i = 0; i < gooseNum; i++){

        }

        board[] = FOX;
    }

    //return single tile from grid
    public char getTile(int x, int y){
        //check if in range
        boolean inRange = true;

        if(x < 0 || x >= size || y < 0 || y >= size){
            inRange = false;
        }


        if (inRange){
            return board[x][y];
        } else {
            return INVALID;
        }
    }


    void printBoard(){
        //this will print the board
        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                System.out.print(" "+board[col][row]);
            }
            System.out.println();
        }
    }

    void




    //return size
    int getSize(){
        return size;
    }

    @Override
    public Block[][] getMap() {
        return map;
    }

    @Override
    public void updateTile(int x, int y, Block block) {

    }

    @Override
    public Block getTileAt(int x, int y) {
        return map[x][y];
    }
}

        /*
        * floor tile
        * empty
        * player tile
        *
        *
        *
        *
        *
        * */