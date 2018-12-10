package SudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayout extends JFrame{
    private Container contents;
    ReadFile readFile = new ReadFile();

    int size = readFile.size;

    //components:
    private JButton[][] cells = new JButton[size][size];

    //grid color
    private Color whiteColor = Color.WHITE;


    //Images / Letters etc.
    private ImageIcon InitialBoardValue = new ImageIcon("1.jpg");


    //Current Position
    private int row = 0;
    private int col = 0;

    public GridLayout(){
        contents = getContentPane();
        contents.setLayout(new java.awt.GridLayout(size, size));


        ButtonHandler buttonHandler = new ButtonHandler();

        //board comp
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                cells[i][j] = new JButton();

                contents.add(cells[i][j]);
                cells[i][j].addActionListener(buttonHandler);

            }
        }

        //set size and disp

        setSize(500,500);
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
        cells[i][j].setIcon(InitialBoardValue);
        row = i;
        col = i;
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();

            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++ ){
                    if (source == cells[i][j]){
                        //this is where process click will allow user to type number
                        processClick(i,j);
                        return;
                    }
                }
            }
        }
    }
}
