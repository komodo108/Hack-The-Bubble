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
     * LEVER 'r'
     *
     * ERROR 'E'
     */

    public char type;

    public final static char empty = ' ';
    public final static char floor = 'f';
    public final static char lava = 'l';
    public final static char wall = 'w';
    public final static char spike = 's';
    public final static char door = 'd';
    public final static char finish = 'Y';
    public final static char key = 'k';
    public final static char lever = 'r';

    public final static char ERROR = 'E';

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
            case lever: return lever;
        }
        return ERROR;
    }
}
