package cs1302.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hold the main method for running the minesweeper game.
 *
 */
public class MinesweeperDriver {


    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        String seedPath = args[0];


        MinesweeperGame test = new MinesweeperGame(stdIn,seedPath);

        test.play();




    } //main
}
