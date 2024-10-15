import java.io.FileNotFoundException;

/**
 * Tester file.
 *
 * Use this main method to test classes and methods as you create them.
 * Feel free to modify this file as you wish.
 */
public class Tester {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(WordBank.checkInDictionary("hello"));  // true
    System.out.println(WordBank.checkInDictionary("asdfg"));  // false

    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(1)); // plumb

    // TODO add tests for Wordle Letter

    // TODO add tests for Wordle Game

    // TODO add tests for Main
  }
}
