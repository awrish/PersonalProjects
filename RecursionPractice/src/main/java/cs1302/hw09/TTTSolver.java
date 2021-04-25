package cs1302.hw09;

import java.util.Scanner;

/**
 * A Tic-Tac-Toe Solver class.
 */
public class TTTSolver {

    /**
     * The entry point for the program.
     * @param args command-line arguments
     */


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an initial board state " +
             "using 9 consecutive characters. Valid "  +
             "characters are X, O, and -.");
        String board = promptBoard(input);
//        printAllBoards(board);
        System.out.println("Count winning boards for which player (X or O)?");
        char answer = input.next().charAt(0);
        System.out.print("Number of ways " + answer + " can win: ");
        System.out.println(countAllWinningBoards(board, answer));
        System.out.print("The board is a cat : ");
        System.out.println(TTTUtility.isCat(board));

    } // main

    /**
     * Prompt the user for a valid board configuration.
     * @param input an input scanner
     * @return the board configuration
     */
    public static String promptBoard(Scanner input) {
        String board = input.nextLine();
        while (!TTTUtility.validGame(board)) {
            System.out.println("Invalid board. Try again.");
            board = input.nextLine();
        } // while
        return board;
    } // promptBoard

    /**
     * Given an initial board state, this method prints
     * all board states that can be reached via valid
     * sequence of moves by each player. Therefore, the
     * printout includes both intermediate board states
     * as well as completed board states.
     *
     * @param board the game board
     */
    public static void printAllBoards(String board) {
        char nextTurn = TTTUtility.whoseTurn(board);
        int length = TTTUtility.count(board, '-');
        String temp = board;
        if (TTTUtility.isWinner(board, 'X') || TTTUtility.isWinner(board, 'O')) {
            System.out.println(board);
        } else {
            System.out.println(temp);
            for (int i = 0; i < board.length(); i++) {
                if (board.charAt(i) == '-') {
                    temp = board.substring(0, i) + nextTurn + board.substring(i + 1,board.length());
                    printAllBoards(temp);
                }
            }

        } //else

    } // printAllBoards



/**
 * Given an initial board state, returns the
 * number of possible wins for a given player.
 *
 * @param board the board we start off with
 * @param player the player we want to count the win possibilities of.
 * @return the number of possible wins for a player
 *
 */
    public static int countAllWinningBoards(String board, char player) {
        char nextTurn = TTTUtility.whoseTurn(board);
        int length = TTTUtility.count(board, '-');
        String temp = board;
        char other;

        if ( player == 'X') {
            other = 'O';
        } else {
            other = 'X';
        }

        if (TTTUtility.isWinner(board, player)) {
            return 1;
        } else if (TTTUtility.isWinner(board, other)) {
            return 0;
        } else {
            int answer = 0;
            for (int i = 0; i < board.length(); i++) {
                if (board.charAt(i) == '-') {
                    temp = board.substring(0, i) + nextTurn + board.substring(i + 1,board.length());
                    answer += countAllWinningBoards(temp,player);
                }
            }
            return answer;
        } //else

    } // CAWB

} // TTTSolver
