package lab02.crossword;

import java.io.*;
import java.util.LinkedList;

public class CwDB {
    protected LinkedList<Entry> dict = new LinkedList<>();

    public CwDB(String filename) {
        try {
            createDB(filename);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }

    public void add(String word, String clue) {
        dict.add(new Entry(word, clue));

    }

    public Entry get(String word) {
        for (Entry e : dict) {
            if (word.equals(e.getWord())) return e;
        }
        return null;
    }

    public void remove(String word) {
        for (Entry e : dict) {
            if (word.equals(e.getWord())) {
                dict.remove(e);
                break;
            }
        }

    }

    public void saveDB(String filename) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Entry e :
                dict) {
            writer.write(e.getWord());
            writer.newLine();
            writer.write(e.getClue());
            writer.newLine();
        }
        writer.close();
    }

    public int getSize() {
        return dict.size();
    }

    protected void createDB(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String word, clue;

        while ((word = reader.readLine()) != null) {
            clue = reader.readLine();
            this.add(word, clue);
        }

        reader.close();
    }


    public class Entry {
        private String word;
        private String clue;

        public Entry(String word, String clue) {
            this.word = word;
            this.clue = clue;
        }

        public String getWord() {
            return word;
        }

        public String getClue() {
            return clue;
        }

        @Override
        public String toString() {
            return String.format("%s", this.getWord());
        }
    }

}
