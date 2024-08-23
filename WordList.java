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

public class WordList {

    static int WORD_LENGTH = 5;
    private String secretWord;  

    public String getSecretWord() {
        return secretWord;
    }

    public void selectRandomWord() {
        BufferedReader br = null;
        ArrayList<String> words = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader("./resources/Word_List.txt"));
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

    
  



 
        
    




