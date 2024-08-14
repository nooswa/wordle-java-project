
package com.mycompany.wordleproject;

import java.util.Scanner;
import java.util.List;

public class InputHandler {
    private Scanner scanner;
    private WordList wordList;
    private static final int WORD_LENGTH = 5;

    // Constructor 
    public InputHandler(WordList wordList) {
        this.scanner = new Scanner(System.in);
        this.wordList = wordList;
    }

    // Method to get the user's input
    public String getUserInput() {
        String input;
        do {
            System.out.println("Enter Your Guess: ");
            input = scanner.nextLine().trim();
            input = input.toUpperCase();//Words in uppercase
        } while (!isValidInput(input));
        return input;
    }

    // Check if the word is valid
    private boolean isValidInput(String input) {
        if (input.length() != WORD_LENGTH) {
            System.out.println("Your guess must be a 5 letter word. Please try again.");
            return false;
        }
        if (!wordList.getValidWords().contains(input)) { //error here
            System.out.println("Input is not a valid word.");
            return false;
        }
        return true;
    }
}
