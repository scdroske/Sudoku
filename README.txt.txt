This README file explains the changes/improvements made to the Sudoku Homework assignment

The main improvement made for the purpose of this assignment was the addition of a GUI that allows players to 
play the Sudoku game. This gui can be ran through the main class. The board is loaded using the existing ReadFile
class that was created in a previous assignment. The ReadFile class was slightly modified in order to create better
abstraction which allows the size and the initial board to be easily taken and read into the GUI/other areas. The 
gui is then loaded and the User is able to modify the empty cells. The cells that are already given a value are unable to
be modified in the GUI. When the user enters a cell value to the empty cell, if the number is correct, the cell turns green,
if the number is incorrect, the cell turns red. The GUI is checking if the cell's value is the same as the solved board that 
is created from the previous assignment. The output file that is created was modified in order to easily parse through and extract
the necessary board information upon completion. The reason that the board was created this way was to allow users to easily see at
runtime, if they had entered the correct solution or not as they were playing the game. The way that the board is set up, easily 
allows for improvements to be made if necessary. If desired, additional buttons and functionality could be added to the board
using the GridLayout class, which would not effect any other classes in this project. 

In addition to the Sudoku game GUI created, Unit Testing was added. During the previous assignment, the use of Unit Testing was not
fully implemented. During this assignment, Unit Testing was added throughout the design process. The board is checked to see if the
size being read is valid, positive and square. The variables are then checked to ensure that they are single digit, positive as well 
as other tests throughout. Additional Unit Testing with the GUI includes checking the board is valid and is the same as the intial board
read in through the ReadFile class. 

When looking through the structure of the previous assignment, the majority of the implementation was kept the same. However, there 
were several changes made such as changing variables from public to protected and making variables that were only used within the 
class private. These changes increased the encapsulation of the project while still allowing for abstraction of the elements that were
necessary for extendability.

  