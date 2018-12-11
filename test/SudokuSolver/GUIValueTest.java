package SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

public class GUIValueTest {
    /**
     * These tests check the values of the GUI before Runtime
     */

    @Test
    public void testValidGrid() throws SudokuException{
        ReadFile readFile = new ReadFile();
        GridLayout gridLayout = new GridLayout();

        int readSize = readFile.size;
        int gridSize = gridLayout.size;


        Assert.assertEquals(gridSize, readSize);


        int[][] sizeboard = readFile.sudokuboard;
        int[][] gridboard = gridLayout.initialsudokuboard;

        Assert.assertEquals(gridboard, sizeboard);
    }


    @Test
    public void testCorrectSolution() throws SudokuException{
        OnePossibleSolution oneSol = new OnePossibleSolution();
        ReadFile readFile = new ReadFile();
        GridLayout gridLayout = new GridLayout();
        ReadSolution readSol = new ReadSolution();
        int[][] solvedboard = oneSol.solvedBoard;
        int[][] actualSolved = readSol.solvedSudokuBoard;

        if(readFile.size == 4){
            Assert.assertEquals(solvedboard, actualSolved);
        }
    }

}


