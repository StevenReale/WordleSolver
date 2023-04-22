package model;

public class KnownLetter {

    private String letter;
    private int[] indices;

    public KnownLetter(String letter) {
        this.letter = letter;
        indices = new int[5];
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }
}
