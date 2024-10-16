import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name for the player X: ");
        String playerXName = scanner.nextLine();
        System.out.print("Enter the name for the player O: ");
        String playerOName = scanner.nextLine();

        TicTacToe round = new TicTacToe(playerXName, playerOName);
        boolean AnotherRound = false; 

        do{
            do{
                System.out.println("Board:");
                round.displayBoard();
                System.out.println("Player " + round.getCurrentPlayer() + "'s turn.");

                System.out.print("Enter your coordinates by separeting them with a comma e.g(x,y): ");
                String input = scanner.next();
                
                String[] coordinates = input.split(",");

                if (coordinates.length == 2){
                    int row = Integer.parseInt(coordinates[0]);
                    int col = Integer.parseInt(coordinates[1]);

                    if (round.makeMove(row, col)) {
                        // Check for a win
                        if (round.checkWin()) {
                            System.out.println("Final win counts:");
                            System.out.println("Player X: " + round.getXWins() + " wins");
                            System.out.println("Player O: " + round.getOWins() + " wins");
                            System.out.print("Do you want to play another round? (true or false): ");
                            AnotherRound = scanner.nextBoolean();
                            if (AnotherRound==true) {
                                round.resetBoard(); 
                            }
                        } else if (round.isBoardFull()) {
                            System.out.println("It's a draw!");
                            System.out.print("Do you want to play another round? (true or false) ");
                            AnotherRound = scanner.nextBoolean();;
                            if (AnotherRound==true) {
                                round.resetBoard(); 
                            }
                        } else {
                            round.changePlayer();
                        }
                    } else {
                        System.out.println("Invalid move. Insert another one");
                    }
                } else {
                    System.out.println("Invalid coordinates. Make sure you type them correctly");
                    scanner.nextLine(); 
                }

            }while (!round.checkWin() && !round.isBoardFull());

        }while(AnotherRound);
    }

}
