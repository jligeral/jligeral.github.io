/**
 *
 * This is the driver class for the TicTacToe game
 *
 * @author Ligeralde James
 * @assignment A06-TicTacToe
 * @date October 8, 2022
 */


public class TicTacToeDriver {

  public static void main(String[ ] arg) {
    TicTacToe t = new TicTacToe();
    t.initializeGame();
    t.setVisible(true);
  }
}