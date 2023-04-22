package model;

import java.util.*;

public class Game {

    private List<String> wordToGuess;
    private List<String> remainingLetters;
    private List<KnownLetter> knownLetters;
    private List<List<String>> letterCombos;

    public Game() {
        wordToGuess = new ArrayList<>();
        knownLetters = new ArrayList<>();
        letterCombos = new ArrayList<>();
    }

    public List<String> getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(List<String> wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public List<String> getRemainingLetters() {
        return remainingLetters;
    }

    public void setRemainingLetters(List<String> remainingLetters) {
        this.remainingLetters = remainingLetters;
    }

    public List<List<String>> getLetterCombos() {
        return letterCombos;
    }

    public void setLetterCombos(List<List<String>> letterCombos) {
        this.letterCombos = letterCombos;
    }
}
