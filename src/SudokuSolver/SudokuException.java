package SudokuSolver;



@SuppressWarnings("WeakerAccess")
public class SudokuException extends Exception {
    /**
     * Create a default process exception
     */
    public SudokuException() { super(); }

    /**
     * Create a process exception with a specific message.
     *
     * @param message       A string contain a descriptive message about the exception
     */
    public SudokuException(String message) {
        super(message);
    }
}

