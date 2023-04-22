import model.Game;
import model.KnownLetter;

import java.util.*;

public class View {

    private Scanner scanner;
    private Game game;

    public View(Game game) {
        scanner = new Scanner(System.in);
        this.game = game;
    }

    public void welcome() {
        System.out.println("==================================");
        System.out.println("       Wordle Solver Mk. 3");
        System.out.println("==================================");
        System.out.println();
    }

    public void getWordProgress() {
        System.out.print("Input current word progress, indicating blanks with spaces: ");
        boolean valid = false;
        String regex = "^[A-Za-z\\s]{5}$";
        while (!valid) {
            String input = scanner.nextLine();

            if (input.matches(regex)) {
                char[] wordInProgress = input.toUpperCase().toCharArray();
                for (int i = 0; i < wordInProgress.length; i++) {
                    if (wordInProgress[i] == ' ') {
                        wordInProgress[i] = '_';
                    } else {
                        game.getRemainingLetters().add(String.valueOf(wordInProgress[i]));
                    }
                }
                game.setWordToGuess(wordInProgress);
                valid = true;
            } else {
                System.out.println("Invalid entry. You must enter 5 letters and/or blank spaces");
            }

        }
        System.out.println("You entered: " + new String(game.getWordToGuess()) + ".");
        boolean verify = verifyInput();

        if (!verify) {
            game.setRemainingLetters(new HashSet<>());
            getWordProgress();
        }

    }

//    public Game oldgetWordProgress() {
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Enter letter " + (i + 1) + " or leave blank if unknown");
//            game.getWordToGuess().add(i, getLetter());
//        }
//        System.out.println("You have entered: ");
//        for (String letter : game.getWordToGuess()) {
//            if (letter.equals("")) {
//                System.out.print("_");
//            } else {
//                System.out.print(letter);
//            }
//        }
//        System.out.println();
//        boolean verify = verifyInput();
//
//        if (verify) {
//            return game;
//
//        } else {
//            game.setWordToGuess(new ArrayList<>());
//            return getWordProgress();
//        }
//    }

    public Game getRemainingLetters() {

        boolean validAnswer = false;

        while (!validAnswer) {
            validAnswer = true;
            System.out.println("Enter all remaining letters separated by spaces:");
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                if (input[i].matches("[A-Za-z]")) {
                    game.getRemainingLetters().add(input[i].toUpperCase());
                } else {
                    System.out.println(input[i] + " is an invalid entry. Please try again.");
                    validAnswer = false;
                    break;
                }
            }
        }

        System.out.println("The remaining available letters, including those already found in the puzzle word, are: ");
        for (String letter : game.getRemainingLetters()) {
            System.out.print(letter + " ");
        }

        System.out.println();

        boolean verify = verifyInput();

        if (verify) {
            return game;

        } else {
            game.setRemainingLetters(null);
            return getRemainingLetters();
        }
    }

    public void getKnownLetters() {

        List<KnownLetter> knownLetters = new ArrayList<>();

        while (true) {
            KnownLetter known;
            String letter;
            System.out.println("Add next known letter or hit return to finish");
            letter = scanner.nextLine();
            if (letter.equals("")) {
                return;
            } else {
                known = new KnownLetter(letter);
            }

            boolean validInput = false;
            while (!validInput) {
                System.out.println("Enter the blanks where it is known that this letter does not appear as a space-delimited list");
                String[] input = scanner.nextLine().split(" ");
                Set<Integer> indices = new HashSet<>();
                for (int i = 0; i < input.length; i++) {
                    try {
                        int currentDigit = Integer.parseInt(input[i]);
                        if (currentDigit < 1 || currentDigit > 5) {
                            indices.add(currentDigit);
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid entry. Please try again.");
                    }

                }
            }
        }

    }

    public void generateCombinations() {
        List<Integer> blankIndexes = new ArrayList<>();
        for (int i = 0; i < game.getWordToGuess().length; i++) {
            if (game.getWordToGuess()[i] == '_') {
                blankIndexes.add(i);
            }
        }
        int blanks = blankIndexes.size();

        game.generateRemainingLettersList();
        getCombinationsOfLetters(blanks, new ArrayList<>());

    }

    private void getCombinationsOfLetters(int depth, List<String> combinations) {
        if (depth == 0) {
            game.getLetterCombos().add(combinations);
            return;
        }
        for (int i = 0; i < game.getRemainingLettersAsList().size(); i++) {
            List<String> combinationsCopy = new ArrayList<>(combinations.subList(0, combinations.size()));
            combinationsCopy.add(game.getRemainingLettersAsList().get(i));
            getCombinationsOfLetters(depth-1, combinationsCopy);
        }
        return;
    }

    public void outputPossibleAnswers() {
        int counter = 1;
        for (List<String> list : game.getLetterCombos()) {
            int listIndex = 0;

            String answer = "";
            for (char entry : game.getWordToGuess()) {
                if (entry == '_') {
                    answer += list.get(listIndex);
                    listIndex++;
                } else {
                    answer += entry;
                }

            }
            System.out.println(counter + ". " + answer);
            counter++;
        }
    }

    private String getLetter() {

        boolean validAnswer = false;
        String returnValue = "";

        while (validAnswer == false) {
            String input = scanner.nextLine();
            if (input.matches("[A-Za-z]?")) {
                returnValue = input.toUpperCase();
                validAnswer = true;
            } else {
                System.out.println("That was not a valid input. Please try again.");
            }

        }
        return returnValue;
    }

    private boolean verifyInput() {
        System.out.print("Is this correct? (Y/N) : ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("N")) {
                return false;
            } else if (input.equalsIgnoreCase("Y")) {
                return true;
            }
            System.out.print("Invalid input. Please type Y or N : ");
        }
    }


    public void dynamicFor() {

        /**
         * The variables in the first two rows can be set to any desired values
         */
        String[] readArray = new String[]{"a", "b", "c"}; // Values to permute through
        int nestedLoops = 5; //Number of nested loops

        int maxIncrement = readArray.length - 1;
        int innerIndex = nestedLoops - 1;
        int currentIndex;
        int[] forArray = new int[nestedLoops];

        while (forArray[0] <= maxIncrement) {
            currentIndex = innerIndex;
            for (int i = 0; i < forArray.length; i++) {
                System.out.print(readArray[forArray[i]]);
            }
            System.out.println();

                forArray[currentIndex]++;

                while (forArray[currentIndex] > maxIncrement && currentIndex != 0) {

                    if (currentIndex > 0) {
                        forArray[currentIndex] = 0;
                        forArray[currentIndex - 1]++;
                        currentIndex--;
                    }
                }
            }

        }







}
