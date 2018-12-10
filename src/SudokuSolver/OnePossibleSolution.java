package SudokuSolver;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class OnePossibleSolution extends Solver {

    ReadFile readFile = new ReadFile();

    protected int[][] initialBoard = readFile.sudokuboard;
    protected int[] variables = readFile.variables;
    protected int size = readFile.size;
    protected int[][] solvedBoard;
    protected int uses;
    protected String name = "OnePossibleSolution";




    @Override
    protected void findApplicableCells() {
        int tempuses = 0;
        int[][] tempBoard = new int[size][size];
        System.out.println("Initial Sudoku Board: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(initialBoard[i][j]);
            }
            System.out.print("\n");
        }

        /**
         *  This is where we will loop through initial board and if 0, replace with variable
         *  Since only one solution, use variable that isn't used in line
         */
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tempBoard[row][col] = initialBoard[row][col];
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                 if (tempBoard[row][col] == 0) {
                    /**
                     * check the row of the initial board and compare with variables
                     */
                    //sets temp board 0 value = first variable
                    tempBoard[row][col] = variables[0];
                    //checks if duplicate rows exist, changes variable till it fits.
                    for(int i = 0; i < size; i++) {
                        if (hasDuplicatesInRows(tempBoard)) {
                            tempBoard[row][col] = variables[i];
                            tempuses++;
                        }
                    }
                     for(int i = 0; i < size; i++) {
                         if (hasDuplicatesInCols(tempBoard)) {
                             tempBoard[row][col] = variables[i];
                             tempuses++;
                         }
                     }
                }
                else {
                    continue;
                     // System.out.println("Error in initial board");
                }
            }
        }
        this.uses = tempuses;
        this.solvedBoard = tempBoard;
    }

    @Override
    protected int[][] applyChanges() {
        return  solvedBoard;
    }

    @Override
    protected long timeToComplete() {
        long time = this.stopTimer() - this.startTimer();
        String timeTaken = "" + time;
        long durationinMS = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);
        time = time*-1;
        System.out.println("Time in milliseconds: " + time);
        return time;
    }

    public boolean hasDuplicatesInRows(int[][] inArray)
    {
        for (int row = 0; row < inArray.length; row++)
        {
            for (int col = 0; col < inArray[row].length; col++)
            {
                int num = inArray[row][col];
                for (int otherCol = col + 1; otherCol < inArray.length; otherCol++)
                {
                    if (num == inArray[row][otherCol])
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasDuplicatesInCols(int[][] inArray)
    {
        for (int row = 0; row < inArray.length; row++)
        {
            for (int col = 0; col < inArray[row].length; col++)
            {
                int num = inArray[row][col];
                for (int otherRow = row + 1; otherRow < inArray.length; otherRow++)
                {
                    if (num == inArray[otherRow][col])
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
