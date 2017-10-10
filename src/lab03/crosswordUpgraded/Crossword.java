package lab03.crosswordUpgraded;

import lab02.crossword.Entry;
import lab02.crossword.InteliCwDB;

import java.util.Iterator;
import java.util.LinkedList;

public class Crossword {
    private LinkedList<CwEntry> entries;
    private Board b;
    private InteliCwDB cwdb;
    private final long ID = -1;

    public Iterator<CwEntry> getROEntryIter() {
        return null;
    }

    public Board getBoardCopy() {
        return null;
    }

    public InteliCwDB getCwDB() {
        return null;
    }

    public void setCwDB(InteliCwDB cwdb) {

    }

    public boolean contains(String word) {
        return false;
    }

    public final void addCwEntry(CwEntry cwe, Strategy s) {
        entries.add(cwe);
        s.updateBoard(b, cwe);
    }

    public final void generate(Strategy s) {
        Entry e = null;
        while ((e = s.findEntry(this)) != null) {
            addCwEntry((CwEntry) e, s);
        }
    }

}
