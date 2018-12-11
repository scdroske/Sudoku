package SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

public class GUIValueTest {
    /**
     * These tests check the values of the GUI before Runtime
     */

    @Test
    public void testValidGridSize() throws SudokuException {
        ReadFile readFile = new ReadFile();
        GridLayout gridLayout = new GridLayout();

        int readSize = readFile.size;
        int gridSize = gridLayout.size;


        Assert.assertEquals(gridSize, readSize);
    }

    @Test
        public void testValidGridBoard() throws SudokuException {
        ReadFile readFile = new ReadFile();
        GridLayout gridLayout = new GridLayout();

        int[][] sizeboard = readFile.sudokuboard;
        int[][] gridboard = gridLayout.initialsudokuboard;

        Assert.assertEquals(gridboard, sizeboard);

    }

    @Test
        public void testValidGridVariables() throws SudokuException{
        ReadFile readFile = new ReadFile();
        GridLayout gridLayout = new GridLayout();

        int variables = readFile.variables.length;
        int gridVariables = gridLayout.variables.length;

        Assert.assertEquals(variables,gridVariables);
    }

}


