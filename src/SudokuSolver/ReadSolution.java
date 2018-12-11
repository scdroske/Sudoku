package SudokuSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadSolution {
    private Scanner scanner;
    private String file = "C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\Sudoku\\Solutions\\Puzzle-9x9-0001.txt";
    protected String[] contents; //contains everything in file
    public int size; //contains the size of the array
    public int length; //contains the length of the array to check that length = size
    public int[][] solvedSudokuBoard; //contains the initial board
    public int[] variables; //contains the variables to use

    public ReadSolution(){
        openFile();
        readFile();
    }



    public void openFile() {
        try {
            Scanner scanner;
            scanner = new Scanner(new File(file));
            this.scanner = scanner;
        } catch (Exception e) {
            System.out.println("Cannot Find File");
        }
    }


    public void readFile() {

        //count how many lines are in file
        //create array and copy elements in
        try {
            int counter = 0;
            Scanner readinPuzzle = new Scanner(new File(file));

            try {
                while (readinPuzzle.hasNext()) {
                    /**
                     * establishes the size of the board to be made
                     */


                    if (counter == 0) {
                        int size;
                        size = readinPuzzle.nextInt();
                        // System.out.print(size + "\n");
                        this.size = size;
                        counter++;
                        continue;
                    }

                    if (counter > 0) {
                        int[][] sudokuboard = new int[size][size];
                        for (int x = 0; x < size; x++) {
                            for (int y = 0; y < size; y++) {
                                sudokuboard[x][y] = readinPuzzle.nextInt();

                            }
                        }

                        for (int x = 0; x < size; x++) {
                            for (int y = 0; y < size; y++) {
                                //System.out.println(sudokuboard[x][y]);
                            }
                            // System.out.println("\n");
                        }
                        this.solvedSudokuBoard = sudokuboard;
                    }

                    else
                        continue;
                    //counter++;
                    //readinPuzzle.next();
                }
                //System.out.println(counter);
            }
            catch(NoSuchElementException e){
                System.out.println("Mismatched element");
            }


        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");

        }
    }

}
