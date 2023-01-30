import java.util.Scanner;
public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        Board board = new Board();
        board.printBoard();
        while(board.checkWinner() == null){
            System.out.print("Player " + board.getSymbol() + ", enter row and column separated by a space: ");
            try {
                int x = Integer.parseInt(scan.next());
                int y = Integer.parseInt(scan.next());
                board.makeMove(x, y);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            board.printBoard();
        }
        System.out.println(board.checkWinner());

    }
}