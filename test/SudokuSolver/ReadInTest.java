package SudokuSolver;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ReadInTest {

    @Test
    public void testValidInput() throws SudokuException{
            ReadFile readFile = new ReadFile();

            // Arrange
            final int expected1 = 9;
            final int expected2 = 4;

            // Act
            final int sizeActual = readFile.size;
            final int lengthActual = readFile.length;
            // Assert
            Assert.assertEquals(sizeActual, expected1);
            Assert.assertEquals(lengthActual,expected1);
            Assert.assertEquals(sizeActual, lengthActual);
        }
    }
