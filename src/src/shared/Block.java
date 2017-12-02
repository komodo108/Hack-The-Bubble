package shared;

public class Block {

    /**
     * EMPTY '.'
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

    public final static char empty = '.';
    public final static char finish = 'Y';

    public final static char floor = 'f';
    public final static char lava = 'l';
    public final static char wall = 'w';
    public final static char spike = 's';

    public final static char door = 'D';
    public final static char key = 'K';
    public final static char lever1 = 'R';
    public final static char lever2 = 'Q';
    public final static char upgrade = 'U';

    public final static char blockage1 = 'B';
    public final static char blockage2 = 'C';

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
            case lever1: return lever1;
            case lever2: return lever2;
            case upgrade: return upgrade;
            case blockage1: return blockage1;
            case blockage2: return blockage2;
        }
        return ERROR;
    }

    public boolean isSolid() {
        switch (type) {
            case empty: return false;
            case floor: return true;
            case lava: return false;
            case wall: return true;
            case spike: return true;
            case door: return true;
            case finish: return false;
            case key: return true;
            case lever1: return true;
            case lever2: return true;
            case upgrade: return true;
            case blockage1: return true;
            case blockage2: return true;
        }
        return false;
    }
}
