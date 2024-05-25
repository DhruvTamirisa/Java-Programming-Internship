import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = '-';
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (!isGameOver()) {
            playerMove();
            displayBoard();
            if (isGameOver()) {
                break;
            }
            switchPlayer();
        }

        char winner = checkWinner();
        if (winner != EMPTY) {
            System.out.println("Player " + winner + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playerMove() {
        if (currentPlayer == 'X') {
            System.out.print("Enter row (0-2) for X: ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2) for X: ");
            int col = scanner.nextInt();
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
            } else {
                System.out.println("Invalid move. Try again.");
                playerMove();
            }
        } else { // currentPlayer is 'O'
            int row, col;
            do {
                row = random.nextInt(3);
                col = random.nextInt(3);
            } while (!isValidMove(row, col));
            board[row][col] = currentPlayer;
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
    }

    private static boolean isGameOver() {
        return isBoardFull() || checkWinner() != EMPTY;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static char checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0];
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != EMPTY && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // Check diagonals
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2];
        }

        return EMPTY; // No winner yet
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
