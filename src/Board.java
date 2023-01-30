public class Board {
    private String[][] grid = new String[3][3];
    private char symbol;

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " ";
            }
        }
        this.symbol = 'X';
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
public char getSymbol(){
        return symbol;
}
    public String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = grid[0][0] + grid[0][1] + grid[0][2];
                    break;
                case 1:
                    line = grid[1][0] + grid[1][1] + grid[1][2];
                    break;
                case 2:
                    line = grid[2][0] + grid[2][1] + grid[2][2];
                    break;
                case 3:
                    line = grid[0][0] + grid[1][0] + grid[2][0];
                    break;
                case 4:
                    line = grid[0][1] + grid[1][1] + grid[2][1];
                    break;
                case 5:
                    line = grid[0][2] + grid[1][2] + grid[2][2];
                    break;
                case 6:
                    line = grid[0][0] + grid[1][1] + grid[2][2];
                    break;
                case 7:
                    line = grid[0][2] + grid[1][1] + grid[2][0];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X wins";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O wins";
            }
        }

        //For draw
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != " ") {
                    a++;
                }
                if (a == 9) {
                    return "Draw";
                }
            }
        }

        return null;
    }
    public boolean makeMove(int row, int col) {
        if (grid[row - 1][col - 1] == " ") {
            grid[row - 1][col - 1] = String.valueOf(symbol);
            symbol = symbol == 'X' ? 'O' : 'X';
            return true;
        }
        return false;
    }
}
