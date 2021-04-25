package cs1302.game;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



/**
 * This class holds methods, variables, and most information
 * for a minesweeper game. Each {@code MinesweeperGame} object
 * has a inputted {@code seedPath} and {@code stdIn} user input.
 *
 */
public class MinesweeperGame  {

    public int rows;
    public int cols;
    int numMines;
    int rounds;
    private final Scanner stdIn;
    String [][] grid ;
    boolean [][] mines;
    int xArray;
    int yArray;
    boolean noFog = false;
    int mineCount = 0;




    /**
     *
     * This is the default constructor. Should initialize some of
     * the instance variables and setup the game using info from
     * the seedfile. Construcs a {@code MinesweeperGame} object
     * with the {@code seedPath} and {@code stdIn}.
     *
     *
     * @param seedPath the seed path file which gives information about the grid
     * @param stdIn the user input
     */
    MinesweeperGame(Scanner stdIn, String seedPath) {
        this.stdIn = stdIn;   //initializes scanner for user input
        readSeedFile(seedPath);
    }


    /**
     * Indicates whether or not the square is in same grid.
     *
     * @param row the row index of the square
     * @param col the column index of the square
     *
     * @return true if the square is in the game grid; false otherwise
     */
    boolean isInBound(int row, int col) {
        boolean bound = false;
        if ((row >= 0) && (col >= 0) && (row < grid.length) && (col < grid[row].length)) {
            bound = true;
        }
        return bound;
    }


    /**
     * Returns the number of mines adjacent to the specified
     * square in the grid.
     *
     * @param row the row index of the square
     * @param col the column index of the square
     * @return the number of adjacent mines
     */
    private int getNumAdjMines(int row, int col) {
        mineCount = 0;
        //these if statements go through different
        //mine location possibilites, verify if it is in bounds
        //and if it is in bounds check if there is a mine there.
        try {
            if (isInBound(row + 1, col) == true) {
                if (mines[row + 1][col] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row, col + 1) == true) {
                if (mines[row][col + 1] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row, col - 1) == true) {
                if (mines[row][col - 1] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row - 1, col - 1) == true) {
                if (mines[row - 1][col - 1] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row - 1, col + 1) == true) {
                if (mines[row - 1][col + 1] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row + 1, col + 1) == true) {
                if (mines[row + 1][col + 1] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row + 1, col - 1) == true) {
                if (mines[row + 1][col - 1] == true) {
                    mineCount++;
                }
            }
            if (isInBound(row - 1, col) == true) {
                if (mines[row - 1][col] == true) {
                    mineCount++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException aob) {
            System.err.println();
            System.err.println("Invalid Command:  " + aob.getMessage());
            rounds--;
        }
        return mineCount;
    }
    //method


    /**
     * initilizes grid by removing null values.
     * used for isWon method.
     */
    void intializeField() {
        for (int len = 0; len < rows; len++) {
            for (int wid = 0; wid < cols; wid++) {
                if (grid[len][wid] == null) {
                    grid[len][wid] = " ";
                }
            }
        }
    }

    /**
     * Prints out grid for minesweeper game.
     *
     */
    void printMineField() {
        System.out.println(" Rounds Completed: " + rounds + "\n");
        for (int len = 0; len < rows; len++) { //changes null values to an empty space
            for (int wid = 0; wid < cols; wid++) {
                if (grid[len][wid] == null) {
                    grid[len][wid] = " ";
                }
            }
        }
        if (noFog == true) {          //if nofog is true, formats grid according and prints it out
            for (int i = 0; i < rows; i++) {  //sets up values in grid
                for (int c = 0; c < cols; c++) {
                    if (mines[i][c] == true) {
                        if (grid[i][c].equals("F")) {
                            grid[i][c] = "<F>";
                        } else {
                            grid[i][c] = "< >";
                        }
                    }
                } //for
            } //for
            for (int i = 0; i < rows; i++) {   //prints out the grid
                System.out.print(" " + i + " |");
                for (int c = 0; c < cols; c++) {
                    if (grid[i][c].equals("< >")) {
                        System.out.print(grid[i][c] + "|");
                    } else if (grid[i][c].equals("<F>")) {
                        System.out.print(grid[i][c] + "|");
                    } else {
                        System.out.print(" " +  grid[i][c] + " |");
                    }
                }
                System.out.println();
            }
            System.out.print("  ");
            for (int count = 0; count < cols; count++) {   //prints out column labels
                System.out.print("   " + count);
            }
            System.out.println();
            noFog = false;
            rounds++;
            System.out.println();
            noFogReset();  //calls on method to make sure normal grid is printed in next iteration
        } else {  //prints out normal game grid if noFog == false
            for (int i = 0; i < rows; i++) {
                System.out.print(" " + i + " |");
                for (int c = 0; c < cols; c++) {
                    System.out.print(" " + grid[i][c] + " |");
                }
                System.out.println();
            }
            System.out.print("  ");
            for (int count = 0; count < cols; count++) {
                System.out.print("   " + count);
            }
            rounds++;
            System.out.println();
            System.out.println();
        }
    }


    /**
     * Changes values back to pre-noFog values.
     */
    void noFogReset() {  //changes values back to normal after nofog command is used
        for (int i = 0; i < rows; i++) {
            for (int b = 0; b < cols; b++) {
                if (grid[i][b].equals("<F>")) {
                    grid[i][b] = "F";
                }
                if (grid[i][b].equals("< >")) {
                    grid[i][b] = " ";
                }
            }
        }
    }


    /**
     * Reads the seed file and sets up game based on
     * values in file.
     *
     * @param seedPath file to read
     *
     */
    void readSeedFile(String seedPath) {
        try {
            File reader = new File(seedPath);
            Scanner fileScan = new Scanner(reader);
            if (fileScan.hasNextInt()) {
                rows = fileScan.nextInt();
                if ((rows < 5) || (rows > 10)) {
                    System.err.println();
                    String rowError = "Seed File Malformed Error: " +
                        "Cannot create a mine field with that many rows and/or columns!";
                    System.err.println(rowError);
                    System.exit(3);
                }
                cols = fileScan.nextInt();
                if ((cols < 5) || (cols > 10)) {
                    System.err.println();
                    String colError = "Seed File Malformed Error: " +
                        "Cannor create a mine field with that many rows and/or columns!";
                    System.err.println(colError);
                    System.exit(3);
                }
                numMines = fileScan.nextInt();
                if ((numMines < 1) || (numMines > ((rows * cols) - 1))) {
                    System.err.println();
                    System.err.println("Seed File Malformed Error: invalid number of mines");
                    System.exit(3);
                }


                grid = new String[rows][cols];
                mines = new boolean[rows][cols];

                for (int i = 0; i < numMines; i++) {
                    xArray = fileScan.nextInt();
                    yArray = fileScan.nextInt();
                    if (isInBound(xArray,yArray)) {
                        mines[xArray][yArray] = true;
                    }  else {
                        System.err.println();
                        System.err.println("Seed File Malformed Error: mine not in bounds");
                        System.exit(3);
                    }
                }
            } //if
        } catch (FileNotFoundException fne) {
            System.err.println();
            System.err.println("File Reading Error: " + fne.getMessage());
            System.exit(2);
        }
    } //readSeedFile



    /**
     * Helps with error handling for user commands like r, m, and g.
     *
     */
    void moreInt() {
        System.out.println("Invalid Command: Command not recognized!");
        rounds--;
    }

    /**
     * If there is no 2nd int for r, g, or m, prints error message.
     */
    void message() {
        System.err.println();
        System.err.println("Invalid Command: null");
        System.err.println();
        rounds--;
        printMineField();
        promptUser();

    }

    /**
     * prints list of commands after help input.
     */
    void helpMes() {
        System.out.println();
        System.out.println("Comands Available...");    //NOTE help DOES use up a round
        System.out.println(" - Reveal: r/reveal row col");
        System.out.println(" -   Mark: m/mark   row col");
        System.out.println(" -  Guess: g/guess  row col");
        System.out.println(" -   Help: h/help");
        System.out.println(" -   Quit: q/quit");
    }

    /**
     * saves space in promptUser method, calls printloss method.
     */
    void callLoss() {
        System.out.println();
        printLoss();
    }

    /**
     * helper for promptUser method, quits minesweeper game.
     */
    void quit() {
        System.out.println();
        System.out.print("Quitting the game...\nBye!\n");
        System.exit(0);
    }

    /**
     * Prints the game prompt and takes in user input.
     * Also calls helper methods to handle user input.
     *
     */
    void promptUser() {
        System.out.print("minesweeper-alpha: ");
        String fullCommand = stdIn.nextLine();
        Scanner commandScan = new Scanner(fullCommand);
        String command = commandScan.next();
        if (command.equals("help") || command.equals("h")) {
            helpMes();  //call to helper method
        } else if (command.equals("q") || command.equals("quit")) {
            quit(); //helper method
        } else if (command.equals("r") || command.equals("reveal")) {
            int x = commandScan.nextInt();
            if (!commandScan.hasNextInt()) {
                message(); //helper method
            }
            int y = commandScan.nextInt();
            if (commandScan.hasNextInt()) {
                moreInt();  //helper method
            } else {
                try {
                    if (mines[x][y] == true) {
                        callLoss();
                    } else {
                        grid[x][y] = "" +  getNumAdjMines(x,y);
                    }
                } catch (ArrayIndexOutOfBoundsException aoe) {
                    System.err.println();
                    System.err.println("Invalid Command: " + aoe.getMessage());
                    rounds--;
                }
            }
        } else if (command.equals("m") || command.equals("mark")) {
            int markX = commandScan.nextInt();
            if (!commandScan.hasNextInt()) {
                message();
            }
            int markY = commandScan.nextInt();
            if (commandScan.hasNextInt()) {
                moreInt();
            } else {
                grid[markX][markY] = "F";
            }
        } else if (command.equals("g") || command.equals("guess")) {
            int guessX = commandScan.nextInt();
            if (!commandScan.hasNextInt()) {
                message();
            }
            int guessY = commandScan.nextInt();
            if (commandScan.hasNextInt()) {
                moreInt();
            } else {
                grid[guessX][guessY] = "?";
            }
        } else if (command.equals("nofog")) {
            noFog = true;
        } else {
            invalid();
        }
        System.out.println();
    }

    /**
     * If user inputs command that is not recognized.
     */
    void invalid() {
        System.out.println("Invalid Command! Command not recognized.");
        rounds--;
    }

    /**
     * This method takes the welcome.txt file from the resources
     * directory and prints it out.
     *
     *
     */
    void  printWelcome() {
        try {
            String filename = "/home/myid/aak98615/cs1302-minesweeper-alpha/resources/welcome.txt";
            File welcome = new File(filename);
            Scanner fileRead = new Scanner(welcome);
            String line;
            while (fileRead.hasNextLine()) {
                line = fileRead.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException fne) {
            System.err.println();
            System.err.println("Error: " + fne.toString());
        }
        System.out.println();
    }


    /**
     * Prints the winning message.
     *
     *
     */
    void printWin() {
        try {
            String filename = "/home/myid/aak98615/cs1302-minesweeper-alpha/resources/gamewon.txt";
            File win = new File(filename);
            Scanner filo = new Scanner(win);
            while (filo.hasNextLine()) {
                String line = filo.nextLine();
                System.out.print(line);
                if (filo.hasNextLine()) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException fne) {
            System.err.println("Error: " + fne.toString());
        }
        Double score = 100.0 * rows * cols / rounds;
        System.out.printf(" %.2f\n", score);
        System.out.println();
        System.exit(0);
    }

    /**
     * Prints out message and banner if player loses game.
     *
     *
     */
    void printLoss() {
        try {
            String filename = "/home/myid/aak98615/cs1302-minesweeper-alpha/resources/gameover.txt";
            File lost = new File(filename);
            Scanner loser = new Scanner(lost);
            while (loser.hasNextLine()) {
                String line = loser.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException fne) {
            System.err.println();
            System.err.println("Error: " + fne.getMessage());
        }
        System.out.println();
        System.exit(0);
    } //printloss



    // game is won when only BOTH conditions are met
    // All squares containing a mine are marked as definitly containing an mine
    // All sqaures not containing a mine are revealed
    /**
     * Determines if game has been won based on conditions.
     * @return win true if game is won, false otherwise.
     */
    boolean isWon() {
        boolean win = false;
        boolean rev = false;
        boolean flag = true;

        intializeField();  //changes null values to empty strings
        for (int i = 0; i < rows; i++) {    //checks if grid is marked where mines are
            for (int t = 0; t < cols; t++) {
                if (mines[i][t] == true) {
                    if (!grid[i][t].equals("F")) {
                        flag = false;
                    } //if
                } //if
            } //for
        } //for
        for (int i = 0; i < rows; i++) {  //checks if all spots have been revealed on grid
            for (int t = 0; t < cols; t++) {
                if (mines[i][t] != true) {
                    if (grid[i][t].equals("" + getNumAdjMines(i,t))) {
                        rev = true;
                    } else {
                        rev = false;
                    }
                }
            }
        }
        if ((rev == true) && (flag == true)) {  //if conditions are met
            win = true;
        }
        return win;

    } //isWon


    /**
     * Provides the main game loop by invoking other instance methods.
     *
     *
     */

    void play() {
        printWelcome();

        while (!isWon()) {
            printMineField();
            if (isWon() == true) {
                printWin();
            }
            promptUser();
        }
        printWin();
    }
}
