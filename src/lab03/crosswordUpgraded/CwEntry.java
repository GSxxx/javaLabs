package lab03.crosswordUpgraded;

import lab02.crossword.Entry;

public class CwEntry extends Entry {
    public CwEntry(String word, String clue) {
        super(word, clue);
    }

    private int x;
    private int y;
    private Direction d;

    public enum Direction {
        HORIZ, VERT
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDir() {
        return d;
    }
}
