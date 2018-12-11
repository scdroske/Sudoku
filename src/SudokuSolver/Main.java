package SudokuSolver;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ReadFile readFile = new ReadFile();
        //readFile.readFile();
        Solver OnePossibleSolution = new OnePossibleSolution();
        OnePossibleSolution.execute();
        Solver Backtracking = new Backtracking();
        Backtracking.execute();
        Solver NakedTwins = new NakedTwins();
        NakedTwins.execute();

        /**
         * Get data from One Possible Solution
         */

        int[][] solvedBoard = ((OnePossibleSolution) OnePossibleSolution).solvedBoard;
        String name = ((OnePossibleSolution) OnePossibleSolution).name;
        int uses = ((OnePossibleSolution) OnePossibleSolution).uses;
        long time = OnePossibleSolution.timeToComplete();



        WriteFile writeFile = new WriteFile();
        writeFile.WriteFile(name, uses, time, solvedBoard);


        int size = readFile.size;
        System.out.println("Solved Board: \n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(solvedBoard[i][j]);
            }
            System.out.print("\n");
        }


        GridLayout gui = new GridLayout();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



