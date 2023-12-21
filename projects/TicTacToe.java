import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * This is a GUI for a simple TicTacToe game
 * Players will go up against a random number generator
 * until the player wins, loses, or all the spaces are used up
 * A filewriter will write the result of the last game in a text file
 *
 * @author Ligeralde James
 * @assignment A06-TicTacToe
 * @date October 8, 2022
 */

public class TicTacToe extends JFrame {

  private JLabel label = new JLabel("Tic-Tac-Toe");
  
  private final int WIDTH = 800;
  private final int HEIGHT = 800;
  
  
  // Game spaces; only 9 should be set
  // Using an array for quick checking with for loops
  private JButton[] spaces = new JButton[9];
  // playerTurn will be used to help switch between the player and "cpu"
  boolean playerTurn = true;
  // gameOver will trigger true to prent the rng from making extra moves
  boolean gameOver = false;
  // counter will be used to end the game if all 9 spaces are taken
  private int counter = 0;
  
  
  
  // Frame
  public TicTacToe() {
    this.setSize(WIDTH, HEIGHT);  
    this.setTitle("Tic-Tac-Toe");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);
  }
  
  public void initializeGame() {
    ActionListener al = new Recorder();
    
    label.setBackground(new Color(255,253,209));
    label.setForeground(new Color(50,117,0));
	 label.setFont(new Font("Helvetica",Font.BOLD,75));
	 label.setHorizontalAlignment(JLabel.CENTER);
	 label.setOpaque(true);
    
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new BorderLayout());
    titlePanel.add(label);
    
    JPanel spacesPanel = new JPanel();
    spacesPanel.setLayout(new GridLayout(3,3));
    spacesPanel.setBackground(new Color(50,117,0));
    
    // For loop will be used to set each array index to a space in the grid
    for(int i = 0;i < 9;i++) {
	   spaces[i] = new JButton();
		spacesPanel.add(spaces[i]);
      spaces[i].setBackground(new Color(255,253,209));
		spaces[i].setFont(new Font("Helvetica",Font.BOLD,120));
      spaces[i].setText("*");
      spaces[i].setForeground(Color.WHITE);
      // All buttons should be useable so ActionListener is added to each
		spaces[i].addActionListener(al);
    }
    
    // Adds titlePanel to top of he GUI
    this.add(titlePanel,BorderLayout.NORTH);
    this.add(spacesPanel);
    
  
  }
  
  private class Recorder implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    
      // Player move
      //Random rndm = new Random();
      //int cpuMove = rndm.nextInt(9);
      for(int i = 0; i < 9; i++) {
		  if(event.getSource() == spaces[i]) {
		    if(playerTurn) {
			   if(spaces[i].getText() == "*") {
				  spaces[i].setForeground(new Color(255,0,0));
				  spaces[i].setText("X");
              // Counts additional game turn
              counter++;
              // Checks the board at the end of the move
				  endgameCheck();
              if(!gameOver) {
                // Switches player turns
				    playerTurn = false;
              }
                  
				}
			 }
		  }			
		} // Closes for loop
      
      // "cpu" move
      for(int i = 0; i < 9; i++) {
        if(!playerTurn) {
          Random rndm = new Random();
          int cpuMove = rndm.nextInt(9);
          // cpu needs validation for each move
          // First checks to make sure space isn't already
          // taken by player
		    if(spaces[cpuMove].getText() != "X") {
            // Second check of validation
            // Ensure space is also "empty"
			   if(spaces[cpuMove].getText() == "*") {
				  spaces[cpuMove].setForeground(new Color(0,0,255));
				  spaces[cpuMove].setText("O");
              // Counts additional game turn
              counter++;
              // Checks the board at the end of the move
				  endgameCheck();
              // Switches player turns
				  playerTurn = true;
                  
				}
			 }
			
        }			
		} // Closes for loop
    
    }
  } // Closes Recorder Class
    
  private void endgameCheck() {
    // There are 8 winning conditions for each player
    // These are the listed winning conditions for the player
	 if((spaces[0].getText()=="X") && (spaces[1].getText()=="X") &&
		 (spaces[2].getText()=="X")) {
	   playerWins(0,1,2);
	 }
	 else if((spaces[3].getText()=="X") && (spaces[4].getText()=="X") &&
				(spaces[5].getText()=="X")) {
		playerWins(3,4,5);
	 }
	 else if((spaces[6].getText()=="X") && (spaces[7].getText()=="X") &&
				(spaces[8].getText()=="X")) {
		playerWins(6,7,8);
	 }
	 else if((spaces[0].getText()=="X") && (spaces[3].getText()=="X") &&
				(spaces[6].getText()=="X")) {
		playerWins(0,3,6);
	 }
	 else if((spaces[1].getText()=="X") && (spaces[4].getText()=="X") &&
				(spaces[7].getText()=="X")) {
		playerWins(1,4,7);
	 }
	 else if((spaces[2].getText()=="X") && (spaces[5].getText()=="X") &&
				(spaces[8].getText()=="X")) {
		playerWins(2,5,8);
	 }
	 else if((spaces[0].getText()=="X") && (spaces[4].getText()=="X") &&
				(spaces[8].getText()=="X")) {
		playerWins(0,4,8);
	 }
	 else if((spaces[2].getText()=="X") && (spaces[4].getText()=="X") &&
				(spaces[6].getText()=="X")) {
		playerWins(2,4,6);
	 }
	 // These are the listed winning conditions for the CPU
	 else if((spaces[0].getText()=="O") && (spaces[1].getText()=="O") &&
				(spaces[2].getText()=="O")) {
		cpuWins(0,1,2);
	 }
	 else if((spaces[3].getText()=="O") && (spaces[4].getText()=="O") &&
				(spaces[5].getText()=="O")) {
		cpuWins(3,4,5);
	 }
	 else if((spaces[6].getText()=="O") && (spaces[7].getText()=="O") &&
				(spaces[8].getText()=="O")) {
		cpuWins(6,7,8);
	 }
	 else if((spaces[0].getText()=="O") && (spaces[3].getText()=="O") &&
				(spaces[6].getText()=="O")) {
		cpuWins(0,3,6);
	 }
	 else if((spaces[1].getText()=="O") && (spaces[4].getText()=="O") &&
				(spaces[7].getText()=="O")) {
		cpuWins(1,4,7);
	 }
	 else if((spaces[2].getText()=="O") && (spaces[5].getText()=="O") &&
				(spaces[8].getText()=="O")) {
		cpuWins(2,5,8);
	 }
	 else if((spaces[0].getText()=="O") && (spaces[4].getText()=="O") &&
				(spaces[8].getText()=="O")) {
	   cpuWins(0,4,8);
	 }
	 else if((spaces[2].getText()=="O") && (spaces[4].getText()=="O") &&
				(spaces[6].getText()=="O")) {
		cpuWins(2,4,6);
	 }
    // Only in the event that all spaces are taken should draw occur
    else {
      if(counter == 9) {
        draw();
      }
      
    }
  } // Closes endgameCheck Method
  
  // Win, lose, and draw methods below 
  private void playerWins(int first,int second,int third) {
		
	 // Ensures cpu does not make any more moves
    gameOver = true;
    File outFH = new File("Tfile.txt");
    for(int i = 0;i < 9; i++) {
      // Turns off the board to prevent any mishaps by user
		spaces[i].setEnabled(false);
	 }
    // Displays a victory message up top
    label.setText("You Win!");
    
    String[][] result = {{" ", " ", " "},
                         {" ", " ", " "},
                         {" ", " ", " "}
                        };
    result[0][0] = spaces[0].getText();
    result[0][1] = spaces[1].getText();
    result[0][2] = spaces[2].getText();
    result[1][0] = spaces[3].getText();
    result[1][1] = spaces[4].getText();
    result[1][2] = spaces[5].getText();
    result[2][0] = spaces[6].getText();
    result[2][1] = spaces[7].getText();
    result[2][2] = spaces[8].getText();
        
    try {
      FileWriter outFW = new FileWriter(outFH,false);
      outFW.write("Result: You won against the computer\n");
      outFW.write("KEY: \"X\" = Player \"O\" = CPU \"*\" = Unused Space\n");
      outFW.write(result[0][0] + " - " + result[0][1] + " - " + result[0][2] + "\n");
      outFW.write(result[1][0] + " - " + result[1][1] + " - " + result[1][2] + "\n");
      outFW.write(result[2][0] + " - " + result[2][1] + " - " + result[2][2] + "\n");
      outFW.close();
    
    }
    catch (IOException ioe) {
    
      System.out.format("Could not write to file: %s%n",outFH.getAbsolutePath());
    }
    // Has alert window appear to inform player where result file is stored
    JOptionPane.showMessageDialog(new JFrame(),
                                  "Your result is saved with" +
                                  " the game file", "You won", +
                                  JOptionPane.INFORMATION_MESSAGE);
  }
  private void cpuWins(int a,int b,int c) {
		
	 gameOver = true;
    File outFH = new File("Tfile.txt");
    for(int i = 0; i < 9; i++) {
      // Turns off the board to prevent any mishaps
		spaces[i].setEnabled(false);
	 }
    // Displays a defeat message up top
	 label.setText("You Lose");
    
    String[][] result = {{" ", " ", " "},
                         {" ", " ", " "},
                         {" ", " ", " "}
                        };
    result[0][0] = spaces[0].getText();
    result[0][1] = spaces[1].getText();
    result[0][2] = spaces[2].getText();
    result[1][0] = spaces[3].getText();
    result[1][1] = spaces[4].getText();
    result[1][2] = spaces[5].getText();
    result[2][0] = spaces[6].getText();
    result[2][1] = spaces[7].getText();
    result[2][2] = spaces[8].getText();
    
    try {
      FileWriter outFW = new FileWriter(outFH,false);
      outFW.write("Result: You lost againt the computer\n");
      outFW.write("KEY: \"X\" = Player \"O\" = CPU \"*\" = Unused Space\n");
      outFW.write(result[0][0] + " - " + result[0][1] + " - " + result[0][2] + "\n");
      outFW.write(result[1][0] + " - " + result[1][1] + " - " + result[1][2] + "\n");
      outFW.write(result[2][0] + " - " + result[2][1] + " - " + result[2][2] + "\n");
      outFW.close();
    
    }
    catch (IOException ioe) {
    
      System.out.format("Could not write to file: %s%n",outFH.getAbsolutePath());
    }
    
    JOptionPane.showMessageDialog(new JFrame(), 
                                  "Your result is saved with" +
                                  " the game file", "You Lost", +
                                  JOptionPane.INFORMATION_MESSAGE);
  }
  private void draw() {
    
    gameOver = true;
    File outFH = new File("Tfile.txt");
    for(int i = 0; i < 9; i++) {
      // Turns off the board to prevent any mishaps
	   spaces[i].setEnabled(false);
	 }
    // Displays a tie message up top
    label.setText("Draw");
    
    String[][] result = {{" ", " ", " "},
                         {" ", " ", " "},
                         {" ", " ", " "}
                        };
    result[0][0] = spaces[0].getText();
    result[0][1] = spaces[1].getText();
    result[0][2] = spaces[2].getText();
    result[1][0] = spaces[3].getText();
    result[1][1] = spaces[4].getText();
    result[1][2] = spaces[5].getText();
    result[2][0] = spaces[6].getText();
    result[2][1] = spaces[7].getText();
    result[2][2] = spaces[8].getText();
    
    try {
      FileWriter outFW = new FileWriter(outFH,false);
      outFW.write("Result: The game eneded in a draw\n");
      outFW.write("KEY: \"X\" = Player \"O\" = CPU \"*\" = Unused Space\n");
      outFW.write(result[0][0] + " - " + result[0][1] + " - " + result[0][2] + "\n");
      outFW.write(result[1][0] + " - " + result[1][1] + " - " + result[1][2] + "\n");
      outFW.write(result[2][0] + " - " + result[2][1] + " - " + result[2][2] + "\n");
      outFW.close();
    
    }
    catch (IOException ioe) {
    
      System.out.format("Could not write to file: %s%n",outFH.getAbsolutePath());
    }
    
    JOptionPane.showMessageDialog(new JFrame(), 
                                  "Your result is saved with" +
                                  " the game file", "Draw", +
                                  JOptionPane.INFORMATION_MESSAGE);
  }
  
  private void printResult() {
  
    String[][] result = {{" ", " ", " "},
                         {" ", " ", " "},
                         {" ", " ", " "}
                        };
                        
    result[0][0] = spaces[0].getText();
    result[0][1] = spaces[1].getText();
    result[0][2] = spaces[2].getText();
    result[1][0] = spaces[3].getText();
    result[1][1] = spaces[4].getText();
    result[1][2] = spaces[5].getText();
    result[2][0] = spaces[6].getText();
    result[2][1] = spaces[7].getText();
    result[2][2] = spaces[8].getText();
    
    
    
    System.out.println(result[0][0] + " " + result[0][1] + " " + result[0][2]);
    System.out.println(result[1][0] + " " + result[1][1] + " " + result[1][2]);
    System.out.println(result[2][0] + " " + result[2][1] + " " + result[2][2]);
  }  

} // Closes TicTacToe class