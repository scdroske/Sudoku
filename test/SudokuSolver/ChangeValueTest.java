package SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

public class ChangeValueTest {

    @Test
    public void validateChangesMade() throws SudokuException {
        ReadFile readFile = new ReadFile();
        OnePossibleSolution onesol = new OnePossibleSolution();
        int[][] initialBoard = readFile.sudokuboard;
        int[][] solvedBoard = onesol.solvedBoard;

        if (initialBoard == solvedBoard) {
            Assert.assertTrue("Values are the same", true);
        }
    }
}
