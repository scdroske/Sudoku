package SudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayout extends JFrame{


    ReadFile readFile = new ReadFile();
    OnePossibleSolution onesolution = new OnePossibleSolution();
    //size of the board
    int size = readFile.size;

    //the initial sudokuboard to be read into the gui
    int[][] initialsudokuboard = readFile.sudokuboard;

    //variables allowed to be used in the board
    int[] variables = readFile.variables;

    //solved sudokuboard
    //this is where we will read in the solved board to be checked (update to read in file)
    int[][] solvedBoard = onesolution.solvedBoard;



    //components:
    //private JButton[][] cells = new JButton[size][size];
    private JTextField[][] gridCells = new JTextField[size][size];

    //will need to update this to false if number is not to be edited during runtime

    private int[][] puzzle =
            {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                    {6, 7, 2, 1, 9, 5, 3, 4, 8},
                    {1, 9, 8, 3, 4, 2, 5, 6, 7},
                    {8, 5, 9, 7, 6, 1, 4, 2, 3},
                    {4, 2, 6, 8, 5, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 8, 5, 6},
                    {9, 6, 1, 5, 3, 7, 2, 8, 4},
                    {2, 8, 7, 4, 1, 9, 6, 3, 5},
                    {3, 4, 5, 2, 8, 6, 1, 7, 9}};

    //Sudoku Game Colors

    private Color whiteColor = Color.WHITE;
    public static final Color OPEN_CELL_Background = Color.YELLOW;
    public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  // RGB
    public static final Color OPEN_CELL_TEXT_NO = Color.RED;
    public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
    public static final Color CLOSED_CELL_TEXT = Color.BLACK;
    public static final int CELL_SIZE = 90;
    public static final int CANVAS_W  = CELL_SIZE * 4;
    public static final int CANVAS_H = CELL_SIZE * 4;


    //Images / Letters etc.
    private ImageIcon InitialBoardValue = new ImageIcon("C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\Sudoku\\1.jpg");
    //private ImageIcon

    //Current Position
    private int row = 1;
    private int col = 1;



    public GridLayout(){
        Container contents;
        contents = getContentPane();
        contents.setLayout(new java.awt.GridLayout(size, size));
        ButtonHandler buttonHandler = new ButtonHandler();

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

                if(mask[i][j]) {
                    gridCells[i][j].setText("");
                    gridCells[i][j].setEditable(true);
                    gridCells[i][j].setBackground(OPEN_CELL_Background);

                    //will need to add further to allow editing to cells
                    //add action listener to process input
                    gridCells[i][j].addActionListener(listener);
                }

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

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();

            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++ ){
                    //if (source == cells[i][j]){
                        //this is where process click will allow user to type number
                       // processClick(i,j);
                      //  return;
                   // }
                }
            }
        }
    }

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

            /*
             * [TODO 5]
             * 1. Get the input String via tfCells[rowSelected][colSelected].getText()
             * 2. Convert the String to int via Integer.parseInt().
             * 3. Assume that the solution is unique. Compare the input number with
             *    the number in the puzzle[rowSelected][colSelected].  If they are the same,
             *    set the background to green (Color.GREEN); otherwise, set to red (Color.RED).
             */

            /*
             * [TODO 6] Check if the player has solved the puzzle after this move.
             * You could update the masks[][] on correct guess, and check the masks[][] if
             * any input cell pending.
             */
        }
    }
}


