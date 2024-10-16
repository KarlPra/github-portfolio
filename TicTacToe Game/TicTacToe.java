import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    private int xWins;
    private int oWins;

    private String playerXName;
    private String playerOName;

        public TicTacToe(String playerXName, String playerOName) {
        resetBoard();
        currentPlayer = 'X';
        xWins = 0;
        oWins = 0;
        
        this.playerXName = playerXName;
        this.playerOName = playerOName;
    }

    public void resetBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        // Check rows
        for (int z = 0; z < 3; z++) {
            if (board[z][0] != '-' && board[z][0] == board[z][1] && board[z][1]== board[z][2]) {
                incrementWins();
                displayWin();
                return true;
            }
        }
    
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[j][0] == board[j][1] && board[j][1]== board[j][2]) {
                incrementWins();
                displayWin();
                return true;
            }
        }
    
        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] &&board[1][1]== board[2][2]) {
            incrementWins();
            displayWin();
            return true;
        }
    

        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1]==board[2][0]) {
            incrementWins();
            displayWin();
            return true;
        }
    
        return false;
    }
    
    private void incrementWins() {
        if (currentPlayer == 'X') {
            xWins++;
        } else {
            oWins++;
        }
    }
    

    private void displayWin() {
        String winner = (currentPlayer == 'X') ? playerXName : playerOName;
        System.out.println("Congratulations, " + winner + ", you won the game!");
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean isBoardFull() {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (board[j][k] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public int getXWins() {
        return xWins;
    }

    public int getOWins() {
        return oWins;
    }

}


