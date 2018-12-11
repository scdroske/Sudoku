package SudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayout extends JFrame{


    ReadFile readFile = new ReadFile();
    ReadSolution readSolution = new ReadSolution();
    //size of the board
    int size = readFile.size;

    //the initial sudokuboard to be read into the gui
    int[][] initialsudokuboard = readFile.sudokuboard;

    //variables allowed to be used in the board
    int[] variables = readFile.variables;

    //solved sudokuboard
    //this is where we will read in the solved board to be checked (update to read in file)
    int[][] solvedBoard = readSolution.solvedSudokuBoard;



    //components:
    private JButton submit;
    private JTextField[][] gridCells = new JTextField[size][size];

    //will need to update this to false if number is not to be edited during runtime

    //Sudoku Game Colors

    private Color whiteColor = Color.WHITE;
    public static final Color OPEN_CELL_Background = Color.YELLOW;
    public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  // RGB
    public static final Color OPEN_CELL_TEXT_NO = Color.RED;
    public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
    public static final Color CLOSED_CELL_TEXT = Color.BLACK;
    public static final int CELL_SIZE = 150;
    public static final int CANVAS_W  = CELL_SIZE * 4;
    public static final int CANVAS_H = CELL_SIZE * 4;


    //Current Position
    private int row = 1;
    private int col = 1;


    /**
     * This is the layout that takes the size of the Sudoku Puzzle and creates a board that implements the Initial Sudoku Puzzle
     *
     */
    public GridLayout(){
        Container contents;
        contents = getContentPane();
        contents.setLayout(new java.awt.GridLayout(size, size));
        InputListener listener = new InputListener();

        boolean[][] mask = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (initialsudokuboard[i][j] == 0) {

                    mask[i][j] = true;
                }
                else
                    mask[i][j] = false;
            }
        }

        //board components
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){

                String buttonValue;
                gridCells[i][j] = new JTextField();
                contents.add(gridCells[i][j]);


                //If the cell is to be modified:
                if(mask[i][j]) {
                    gridCells[i][j].setText("");
                    gridCells[i][j].setEditable(true);
                    gridCells[i][j].setBackground(OPEN_CELL_Background);

                    //will need to add further to allow editing to cells
                    //add action listener to process input
                    gridCells[i][j].addActionListener(listener);
                }

                //if the cell already contains a fixed value:
                else{
                    gridCells[i][j].setText(initialsudokuboard[i][j] + "");
                    gridCells[i][j].setEditable(false);
                    gridCells[i][j].setBackground(CLOSED_CELL_BGCOLOR);
                    gridCells[i][j].setForeground(CLOSED_CELL_TEXT);
                }


                gridCells[i][j].setHorizontalAlignment(JTextField.CENTER);
                gridCells[i][j].setFont(new Font("Arial", Font.PLAIN, 40));


               // cells[i][j].addActionListener(buttonHandler);

            }
        }

        //set size and disp
        contents.setPreferredSize(new Dimension(CANVAS_W, CANVAS_H));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SUDOKU GAME!");
        //setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean isValidMove(int i, int j){
        //logic to check if number is 1-9 or a letter
        return true;
    }

    private void processClick(int i, int j){
        if (isValidMove(i, j) == false){
            System.out.println("Invalid number/letter entered");
            return;
        }

        //cells[row][col].setIcon(null);
        //this is where we will set the cell to the digit entered.
        //cells[i][j].setIcon(InitialBoardValue);
        row = i;
        col = i;
    }



    /**
     * This class checks the board when new values are imputted (enter key is hit)
     * If new values are Correct, changes cell to Green
     * If new values are Incorrect, changes cell to Red
     */
    private class InputListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            int rowSelected = -1;
            int colSelected = -1;


            // Get the source object that fired the event
            JTextField source = (JTextField)e.getSource();
            // Scan JTextFileds for all rows and columns, and match with the source object
            boolean found = false;
            for (int row = 0; row < size && !found; ++row) {
                for (int col = 0; col < size && !found; ++col) {
                    if (gridCells[row][col] == source) {
                        rowSelected = row;
                        colSelected = col;
                        found = true;  // break the inner/outer loops
                    }
                }
            }

            int inputtedNumber = Integer.parseInt(gridCells[rowSelected][colSelected].getText());

            if(inputtedNumber == solvedBoard[rowSelected][colSelected]){
                gridCells[rowSelected][colSelected].setBackground(Color.GREEN);

            }
            else{
                gridCells[rowSelected][colSelected].setBackground(Color.RED);
            }
        }
    }
}


