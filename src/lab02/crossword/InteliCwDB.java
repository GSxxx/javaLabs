package lab02.crossword;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InteliCwDB extends CwDB {

    public InteliCwDB(String filename) {
        super(filename);
    }

    public LinkedList<Entry> findAll(String pattern) {
        LinkedList<Entry> result = new LinkedList<>();
        Pattern p = Pattern.compile(pattern);
        for (Entry e :
                dict) {
            Matcher regex = p.matcher(e.getWord());
            if (regex.find()) result.add(e);
        }
        return result;
    }

    public Entry getRandom() {
        return dict.get(ThreadLocalRandom.current().nextInt(0, this.getSize()));
    }

    public Entry getRandom(int length) {
        LinkedList<Entry> result = findAll(String.format(".{%d}",length));
        return result.get(ThreadLocalRandom.current().nextInt(0, result.size()));
    }

    public Entry getRandom(String pattern) {

        LinkedList<Entry> result = findAll(pattern);
        return result.get(ThreadLocalRandom.current().nextInt(0, result.size()));
    }
}
