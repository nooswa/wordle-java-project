package wordle;

public class Wordle {
    public static void main(String[] args) {
        // Initialize components
        WordList wordList = new WordList();
        wordList.initialiseSecretWord();  // This will select a random secret word

        ValidGuess validGuess = new ValidGuess();  // Load valid guesses
        Rules rules = new Rules();  // Handle rules display
        InputHandler inputHandler = new InputHandler(validGuess, rules);  // Handle user input with validation

        // Display the rules the first time
        rules.displayRulesFirstRun();

        // Get the secret word from the WordList
        String secretWord = wordList.getSecretWord();

        // Create and start the game processor
        WordleProcessor gameProcessor = new WordleProcessor(secretWord, inputHandler);
        gameProcessor.startGame(6);  // 6 attempts
    }
}
