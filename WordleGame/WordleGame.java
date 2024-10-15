
import java.io.FileNotFoundException;
public class WordleGame {
    private String WordOfThePuzzle;
    private WordleLetter[][] WordleArr=new WordleLetter[6][5];
    private int NumberOfGuesses;

    public WordleGame(int puzzleNumber) throws FileNotFoundException {
        this.WordOfThePuzzle = WordBank.getAnswerForPuzzleNumber(puzzleNumber);

    }

    public String getAnswer() {
        return WordOfThePuzzle;
    }


    public void guess(String guessWord) {

      WordleLetter[] arr=new WordleLetter[5];
      for(int i=0;i<=4;i++){
        WordleLetter letter=new WordleLetter(guessWord.charAt(i));
        if(guessWord.charAt(i)==WordOfThePuzzle.charAt(i)){
          letter.setColor("green");
        }else if(WordOfThePuzzle.contains(guessWord.charAt(i)+"")){
          letter.setColor("yellow");
        }else{
          letter.setColor("red");
        }
        arr[i]=letter;
      }
      WordleArr[NumberOfGuesses]=arr;
      NumberOfGuesses++;

    }


    public int getNumberGuessesSoFar() {
        return NumberOfGuesses;
    }

    public WordleLetter[] getGuess(int guessNumber) {
        return WordleArr[guessNumber];
    }

    public boolean isGameOver() {
        return isGameWin() || NumberOfGuesses >= 6;
    }

    public boolean isGameWin() {
      for(int j=0;j<WordleArr.length;j++){
        if(WordleArr[j][0]==null){
          return false;
        }
        if(WordleArr[j][0].isGreen()&&WordleArr[j][1].isGreen()&&WordleArr[j][2].isGreen()&&WordleArr[j][3].isGreen()&&WordleArr[j][4].isGreen()){
          return true;
        }
      }

      return false;
}


    // Add the provided toString() method here
    public String toString() {
    // result will be used to build the full answer String
    String result = "";
     // for each word guessed so far
     for (int i = 0; i < getNumberGuessesSoFar(); i++) {
       // get each letter of each word
       for (int j = 0; j < 5; j++) {
         // concatenate it to the result
         // WordleLetter's toString() is automatically invoked here.
         result += getGuess(i)[j];
       }
       // new line separator between each word
       result += "\n";
     }
    return result;
  }
}

