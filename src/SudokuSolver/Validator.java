package SudokuSolver;

public class Validator {
    public static void validateBoard(double size, String errorMessage) throws SudokuException{
        if(Double.isInfinite(size) || Double.isNaN(size)){
            throw new SudokuException(errorMessage);
        }

    }

    public static void validatePositiveDouble(double value, String errorMessage) throws SudokuException {
        validateBoard(value, errorMessage);
        if (value<0)
            throw new SudokuException(errorMessage);
    }

    public static void validateSquareBoard(double size, double length, String errorMessage) throws SudokuException{
        if(size != length){
            throw new SudokuException(errorMessage);
        }
    }

    public static void validateBoardExists(double size, String errorMessage) throws SudokuException{
        if(size<=0){
            throw new SudokuException(errorMessage);
        }
    }
}
