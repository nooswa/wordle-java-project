
package wordle;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;
    private final ValidGuess validGuess;
    private static final int WORD_LENGTH = 5;

    // Constructor 
    public InputHandler(ValidGuess validGuess) {
        this.scanner = new Scanner(System.in);
        this.validGuess = validGuess; 
    }

    // Method to get the user's input
    public String getUserInput() {
        String input;
        do {
            System.out.println("Enter Your Guess: ");
            input = scanner.nextLine().trim();
            input = input.toUpperCase();
        } while (!isValidInput(input));
        return input;
    }

    // Check if the word is valid
    private boolean isValidInput(String input) {
        if (input.length() != WORD_LENGTH) {
            System.out.println("Your guess must be a 5-letter word. Please try again.");
            return false;
        }
        if (!input.matches("[A-Z]+")) {
            System.out.println("Invalid input, the word must only contain letters.");
            return false;
        }

        if (validGuess.getValidWords().contains(input)) { 
            System.out.println(input + "is not a valid word.");
            return false;
        }
        return true;
    }
}
