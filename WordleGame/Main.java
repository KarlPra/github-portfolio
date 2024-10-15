import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class Main {
    Scanner input=new Scanner(System.in);
    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {
        System.out.println("Starting the Wordle Game...");
        System.out.println("Enter the puzzle number: ");
        int puzzleNum=scanner.nextInt();
        while(puzzleNum<0 || puzzleNum>2315){
            System.out.println("The puzzle number just inserted is not on the catalogue. Please insert a number between 0 and 2315");
            System.out.println("Enter the puzzle number");
            puzzleNum=scanner.nextInt();
        }
        WordleGame game= new WordleGame(puzzleNum);
        return game;  // TODO - implement and replace me
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
        // TODO - implement
        while(game.isGameOver()==false&&game.isGameWin()==false){
            System.out.println("Enter a word:");
            String GuessUser=scanner.next();
            if(WordBank.checkInDictionary(GuessUser)==false){
                System.out.println("The word inserted doesn't exist. Please try again.");
            }else{
                game.guess(GuessUser);
                System.out.println(game.toString());
            }
        }
        if(game.isGameOver()==true&&game.isGameWin()==false){
            System.out.println("You run out of your attempts. You lost.");
        }
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        if(game.isGameWin()==true){
            System.out.println("You guessed the word!");
        }
        if(game.isGameOver()==true&& game.isGameWin()==false){
            System.out.println("The secret word was "+game.getAnswer());
        }
        // TODO - implement
    }

    // This main method body should not be modified.
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}
