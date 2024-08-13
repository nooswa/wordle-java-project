/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.util.Scanner;
public class Wordle {
    
    public static void main(String[] args) {
        // Get random answer from word lsit;
        
        // prompt user for input
        boolean IsInvalidWord = true;
               
        
        while(IsInvalidWord) {
        System.out.println("Enter a 5 Letter Word");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
 
        
        boolean isAlphabetic = true;
        
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isAlphabetic(userInput.charAt(i))){
                isAlphabetic = false;
            break;
            }
        }
                
         if(!isAlphabetic){
            System.out.println("Invalid input, word must only contain letters");
        }
         else if(userInput.length() != 5) {
            System.out.println("Invalid input, word must be 5 letters");
        }
         else {
             IsInvalidWord = false;
         }
        }   
        
        //link back to input iunihnib
        
        // Check is a word (Optional)
        // Check word is 5 letter
        
        
        //for (int i = 0; i < 5; i++) {
            
        }
    
    
    
        
    }