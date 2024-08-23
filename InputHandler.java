
package wordle;

import java.util.Scanner;

public class InputHandler {

    private final ValidGuess validGuess;
    private final Rules rules;
    private final Scanner scanner;

    public InputHandler(ValidGuess validGuess, Rules rules) {
        this.validGuess = validGuess;
        this.rules = rules;
        this.scanner = new Scanner(System.in);
    }

   public String getUserInput() {
    String input;

    do {
        System.out.println("Enter Your Guess:");
        input = scanner.nextLine().trim().toUpperCase();

    } while (handleSpecialCommands(input) || !isValidInput(input));

    return input;
}

    private boolean handleSpecialCommands(String input) {
        if (input.equalsIgnoreCase("show rules")) {
            rules.displayRulesFirstRun();  // Show the rules
            return true;  // Command processed
        }

        if (input.equalsIgnoreCase("exit game")) {
            ExitGame.checkForExitCommand(input);  // Exit the game
            return true;  // Command processed
        }

        return false;  // No command was processed
    }

    private boolean isValidInput(String input) {
        if (input.length() != WordList.WORD_LENGTH) {
            System.out.println("Your guess must be a 5-letter word. Please try again.");
            return false;
        }
        if (!validGuess.getValidWords().contains(input)) {
            System.out.println(input + " is not a valid word.");
            return false;
        }
        return true;
    }
}
