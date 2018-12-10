package SudokuSolver;

public class Backtracking extends Solver{
    ReadFile readFile = new ReadFile();
    protected int[][] initialBoard = readFile.sudokuboard;
    protected int[] variables = readFile.variables;
    protected int size = readFile.size;
    protected int[][] solvedBoard;
    protected int uses;
    protected String name = "Backtracking";


    @Override
    protected void findApplicableCells() {
        OnePossibleSolution oneSol = new OnePossibleSolution();

    }
        /**
         *


        private boolean backtracking(String[][] sudokuboard) {
            int recursiveCalls = 0;
            recursiveCalls++;
            if (endOfGrid(sudokuboard)) {
                return true;
            }

            ArrayList<Integer> valuesCell = sudokuboard.get(cell); // get the domain of the cell on which im operating
            int value = 0;

            for (int i = 0; i < valuesCell.size(); i++) { // Iterate through the cells domain
                value = valuesCell.get(i);                  // get a value from the domain
                sudokuboard.setCell(value, cell.row, cell.col);  // set the value onto the board
                if (isValid(sudokuboard, cell, value)) {            // check for errors
                    if (backtrack(sudokuboard, cell.nextCell(sudokuboard))) {   // recursive call
                        return true;
                    }
                }
            }
            sudokuboard.setCell(0, cell.row, cell.col);  // restores the cell value

            return false;
        }

        private boolean endOfGrid(String[][] sudokuboard) { // returns true if the whole grid is full
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudokuboard.getCell(i, j) == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(Grid tablero, Cell cell, int value) { // Checks if the inserted value is correct
            for (int i = 0; i < 9; i++) { // check for repeated values in the row
                if (i != cell.col) {
                    if (tablero.getCell(cell.row, i) == value) {
                        return false;
                    }
                }
            }

            for (int j = 0; j < 9; j++) { // check for repeated values in the column
                if (j != cell.row) {
                    if (tablero.getCell(j, cell.col) == value) {
                        return false;
                    }
                }
            }

            if (!checkMatrix(tablero, cell, value)) {
                return false;
            }

            return true;
        }

        private boolean checkMatrix(Grid board, Cell cell, int value) { // check for repeated values on a 3x3 matrix
            float x1Calc = 3 * (cell.row / 3);
            float y1Calc = 3 * (cell.col / 3);
            int x1 = Math.round(x1Calc);
            int y1 = Math.round(y1Calc);
            int x2 = x1 + 2;
            int y2 = y1 + 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x != cell.row && y != cell.col) {
                        if (board.getCell(x, y) == value) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

    }
    }
         *
         */
    @Override
    protected int[][] applyChanges() {
        return new int[0][];
    }

    @Override
    protected long timeToComplete() {
        return 0;
    }
}

