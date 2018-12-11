package SudokuSolver;

import org.junit.Test;
import static org.junit.Assert.*;


public class ValidatorTest {

        @Test
        public void testValidateBoard() throws SudokuException{
            Validator.validateBoard(4, "Test message");
            Validator.validateBoardExists(4, "Test message");
            Validator.validateSquareBoard(4,4, "Test message");


            try {
                Validator.validateBoard(Double.POSITIVE_INFINITY,"Invalid");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Invalid", ex.getMessage());
            }

            try {
                Validator.validateBoardExists(Double.NEGATIVE_INFINITY,"Invalid");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Invalid", ex.getMessage());
            }

            try {
                Validator.validateSquareBoard(Double.NaN, Double.NaN,"Invalid");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Invalid", ex.getMessage());
            }
        }

        @Test
        public void testValidatePositiveDouble()  throws SudokuException {
            Validator.validateBoard(456, "Test message");
            Validator.validateBoard(0.34523, "Test message");

            try {
                Validator.validatePositiveDouble(-123, "Negative not allowed");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Negative not allowed", ex.getMessage());
            }

            try {
                Validator.validatePositiveDouble(-0.123, "Negative not allowed");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Negative not allowed", ex.getMessage());
            }

            try {
                Validator.validatePositiveDouble(Double.POSITIVE_INFINITY,"Invalid");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Invalid", ex.getMessage());
            }

            try {
                Validator.validatePositiveDouble(Double.NEGATIVE_INFINITY,"Invalid");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Invalid", ex.getMessage());
            }

            try {
                Validator.validatePositiveDouble(Double.NaN,"Invalid");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertEquals("Invalid", ex.getMessage());
            }
        }

        @Test
        public void validateSquareBoard() throws SudokuException{
            Validator.validateSquareBoard(4,4, "Test message");

            try{
                Validator.validateSquareBoard(Double.NaN, 4,"No inf. allowed");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertTrue("Invalid", true);
            }

            try{
                Validator.validateSquareBoard(4, Double.NaN,"No inf. allowed");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertTrue("Invalid", true);
            }

            try{
                Validator.validateSquareBoard(5, 4,"Board Not Square");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertTrue("Invalid", true);
            }

            try{
                Validator.validateSquareBoard(9, 8,"Board Not Square");
                fail("Expected exception not thrown");
            } catch (SudokuException ex) {
                assertTrue("Invalid", true);
            }
    }
}

