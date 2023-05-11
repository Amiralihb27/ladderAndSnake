package ir.ac.kntu.gamelogic;

public class Grid {

    private String board[][];


    public void setPosition(int row, int col, String name) {
        this.board[row][col] = name;
        System.out.println(row);
        System.out.println(col);
        System.out.println(board[row][col]);


    }

    public String[][] getBoard() {
        String[][] newBoard=board;
        return newBoard;
    }

    public Grid() {
        boardSize();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i][j] = "  ";
            }
        }
    }

    public void boardSize() {
        System.out.println("Enter the size of the board: ");
        int size = ScannerWrapper.getInt();
        board = new String[size][size];

    }

    public void draw(Player player, OrdinarySnake ordinary) {

        ordinary.move(this);
        System.out.println("Dice:" + Dice.values()[0]);
        System.out.println("Health:" + player.getHealth());
        int row = 0;
        for (int i = 0; i < 2 * this.board.length - 1; i++) {

            if (i % 2 == 0) {
                eachRow(row);
                row++;
            } else {
                line();
            }
            System.out.println("");
        }
    }

    public void line() {
        for (int j = 0; j < 3 * this.board.length; j++) {
            if (j % 2 == 0) {
                System.out.print("-");
            } else {
                System.out.print(" ");
            }

        }
    }

    public void eachRow(int row) {
        for (int j = 0; j < (2 * this.board.length); j++) {
            if (j % 2 == 1) {
                System.out.print("|");
            } else {
                System.out.print(this.board[row][j/2]);
            }

        }

    }
}
