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
        view.welcome();
        view.getWordProgress();
        //view.getKnownLetters();
        view.getRemainingLetters();
        view.generateCombinations();
        view.outputPossibleAnswers();

    }

}
