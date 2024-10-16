import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the name of the file to read: ");
    File file = new File(scanner.nextLine());
    scanner = new Scanner(file);




    // TODO: Add your implementation below here.
    // The following line is provided for you to modify and re-arrange.
    // More lines of code will need to be added.
    int WordCount = 0;
    boolean isNextAvailable = scanner.hasNext();
    
    while(isNextAvailable){
      
      WordCount++;
      String word = scanner.next();
      isNextAvailable = scanner.hasNext();;
      

    }
    scanner.close();
    //boolean isNextAvailable = scanner.hasNext();
    //String word = scanner.next();
    System.out.println(WordCount + " words");
  }
}
