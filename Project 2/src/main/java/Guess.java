// Setota Assefa
// This program allows the user to play a game.
// It thinks of a random integer and accepts guesses until the user guesses the number correctly.

import java.util.*;

public class Guess {
   public static final int MAX = 20;
   
   public static void main(String [] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      introdution();
      
      int games = 0;
      int min = 1000000;
      int totalGuesses = 0;
      String answer = "y";
      
      while(answer.startsWith("y")) {
         int numberOfGuesses = playGame(console,rand);
         games++;
         totalGuesses += numberOfGuesses;
         
         if (numberOfGuesses < min) {
            min = numberOfGuesses;
         }
         System.out.print("Do you want to play again? ");
         answer = console.next().toLowerCase();
         System.out.println();
      }
      
   }
   
   //This method prints out the introduction. 
   public static void introdution() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("20 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // This method plays one game with the user.
   // In each game the computer chooses a random number between 1 and 100 inclusive.
   // Once the user types the correct number, the game ends.
   // The console handles the input and output ,the random parameter is to get random numbers.
   // The method returns how many guesses were needed.
   public static int playGame(Scanner console, Random rand) {
      int numberOfGuesses = 0;
      int guess = 0;
      int rightNumber = rand.nextInt(MAX) + 1;
      System.out.println("I'm thinking of a number between 1 and "+ MAX + "...");
      
      while (guess != rightNumber) {
         System.out.print("Take a guess");
         guess = console.nextInt();
         numberOfGuesses ++;
         
         if(guess > rightNumber) {
            System.out.println("Your guess is too high.");
            
         } else if(guess < rightNumber) {
            System.out.println("Your guess is too low.");
         }
      }
      if (numberOfGuesses == guess) {
         System.out.println("Good job! You guessed my number in  " + numberOfGuesses + " guesses");
         
      } else {
         System.out.println ("You got it right in " + numberOfGuesses + " guesses");
      }
      return numberOfGuesses;
   }
   
   
}