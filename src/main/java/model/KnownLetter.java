package model;

import java.util.HashSet;
import java.util.Set;

public class KnownLetter {

    private String letter;
    private Set<Integer> indices;

    public KnownLetter(String letter) {
        this.letter = letter;
        indices = new HashSet<>();
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Set<Integer> getIndices() {
        return indices;
    }

    public void setIndices(Set<Integer> indices) {
        this.indices = indices;
    }
}
