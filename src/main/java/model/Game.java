package model;

import java.util.*;

public class Game {

    private char[] wordToGuess;
    private Set<String> remainingLetters;
    private List<String> remainingLettersAsList;
    private List<KnownLetter> knownLetters;
    private List<List<String>> letterCombos;

    public Game() {
        remainingLetters = new HashSet<>();
        knownLetters = new ArrayList<>();
        letterCombos = new ArrayList<>();
    }

    public char[] getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(char[] wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public Set<String> getRemainingLetters() {
        return remainingLetters;
    }

    public void setRemainingLetters(Set<String> remainingLetters) {
        this.remainingLetters = remainingLetters;
    }

    public List<List<String>> getLetterCombos() {
        return letterCombos;
    }

    public void setLetterCombos(List<List<String>> letterCombos) {
        this.letterCombos = letterCombos;
    }

    public void generateRemainingLettersList() {
        remainingLettersAsList = new ArrayList<>(remainingLetters);
    }

    public List<String> getRemainingLettersAsList() {
        return remainingLettersAsList;
    }
}
