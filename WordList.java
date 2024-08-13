
package wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList; // import the ArrayList class



public class WordList {
    
    
    private void  loadWords() {
        BufferedReader br = new BufferedReader(new FileReader("./resources/word_list.rtd"));
        ArrayList<String> words = new ArrayList<String>();
        //words.add(br);
    }
    
}
