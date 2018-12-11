package SudokuSolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {
    ReadFile readFile = new ReadFile();
    protected int size = readFile.size;
    //protected int[] variables = readFile.variables;
    protected int[][] initialboard = readFile.sudokuboard;


    public void WriteFile(String name, int uses, long time, int[][] finishedboard){

        String outputfile = "C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\Sudoku\\src\\SudokuSolver\\output.txt";
        String data = "Initial Puzzle: \n";

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                data += initialboard[x][y];
            }
            data += "\n";

        }

        data += "\n \nSolved Puzzle:  \n";

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                data += finishedboard[x][y];
            }
            data += "\n";

        }

        data += "\nStrategy:                Uses:          Time: \n";
        data += name + "       " + uses + "             " + time + "\n";



        writeToFile(outputfile,data);
    }



    public static void writeToFile(String file, String data) {
        OutputStream os = null;
        try {
            //write input and then corresponding output to file
            os = new FileOutputStream(new File(file));
            os.write(data.getBytes(), 0, data.length());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}