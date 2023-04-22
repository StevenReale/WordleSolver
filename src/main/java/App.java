import model.Game;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    private View view;
    private Game game;

    public App() {
        game = new Game();
        view = new View(game);
    }

    public void run() {
        game.setWordToGuess(new ArrayList<>(Arrays.asList(new String[] {"K", "A", "", "A", ""})));
        game.setRemainingLetters(new ArrayList<>(Arrays.asList(new String[] {"q", "w", "y", "a", "g", "k", "z", "x", "v"})));
        //view.dynamicForWithRecursion(5, new ArrayList<>(Arrays.asList(new String[]{"a", "b", "c"})), "");
        //view.welcome();
        //view.getWordProgress();
        //view.getKnownLetters();
        //view.getRemainingLetters();
        view.generateCombinations();
        view.outputPossibleAnswers();

    }

}
