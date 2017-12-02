package shared;

public class Block {

    /**
     * EMPTY ' '
     * FLOOR 'f'
     * LAVA 'l'
     * WALL 'w'
     * SPIKE 's'
     * DOOR 'd'
     * FINISH 'Y'
     * KEY 'k'
     *
     * ERROR 'E'
     */

    public char type;

    public final char empty = ' ';
    public final char floor = 'f';
    public final char lava = 'l';
    public final char wall = 'w';
    public final char spike = 's';
    public final char door = 'd';
    public final char finish = 'Y';
    public final char key = 'k';
    
    public final char ERROR = 'E';

    public Block(char type) {
        this.type = type;
    }

    public char getChar(Block b) {
        switch (b.type) {
            case empty: return empty;
            case floor: return floor;
            case lava: return lava;
            case wall: return wall;
            case spike: return spike;
            case door: return door;
            case finish: return finish;
            case key: return key;
        }
        return ERROR;
    }
}
