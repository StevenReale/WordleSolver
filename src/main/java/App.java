import model.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {

    private View view;
    private Game game;
    private Set<String> wordDictionary = new HashSet<>();

    public App() {
        game = new Game();
        view = new View(game);
        populateDictionary();
    }

    public void run() {
        view.welcome();
        view.getWordProgress();
        view.getKnownLetters();
        view.getRemainingLetters();
        view.generateCombinations();
        view.outputPossibleAnswers(wordDictionary);

    }

    private void populateDictionary(){
        List<File> dictFiles = new ArrayList<>();
        dictFiles.add(new File("src/main/resources/wordle-La.txt"));
        dictFiles.add(new File("src/main/resources/wordle-Ta.txt"));

        for (File file : dictFiles) {
            try {
                Scanner fileData = new Scanner(file);
                while (fileData.hasNextLine()) {
                    String nextWord = fileData.nextLine();
                    wordDictionary.add(nextWord.toUpperCase());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + file.getPath() + " not found.");
                System.exit(-1);
            }

        }

    }

}
