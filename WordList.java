
package wordle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

public class WordList {
    
    public static void main(String[] args) {
        // Create an instance of the WordList class
        WordList wordList = new WordList();

        // Call the method to initialize the secret word
        wordList.initialiseSecretWord();

        // Print out the selected secret word
        String secretWord = wordList.getSecretWord();
        if (secretWord != null) {
            System.out.println("The secret word is: " + secretWord);
        } else {
            System.out.println("No secret word could be selected. Please check the word list file.");
        }
    }
    
    private String secretWord; 
    private List<String> validWords = new ArrayList<>(); 


    public String getSecretWord() {
        return secretWord;
    }
    
    public List<String> getValidWords() {
        return validWords; 
    }

    public void selectRandomWord() {
        BufferedReader br = null;
        ArrayList<String> words = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\noooo\\Downloads\\valid_guess_list.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrOfStr = line.split(" ");
                words.addAll(Arrays.asList(arrOfStr));
            }

            Random random = new Random();
            if (!words.isEmpty()) {
                secretWord = words.get(random.nextInt(words.size()));
            } else {
                Logger.getLogger(WordList.class.getName()).log(Level.SEVERE, "The word list is empty.");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordList.class.getName()).log(Level.SEVERE, "File not found.", ex);
        } catch (IOException ex) {
            Logger.getLogger(WordList.class.getName()).log(Level.SEVERE, "Failed to read the file.", ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(WordList.class.getName()).log(Level.SEVERE, "idk what to put here", ex);
                }
            }
        }
    }

    public void initialiseSecretWord() {
     selectRandomWord();
    }
}
  


