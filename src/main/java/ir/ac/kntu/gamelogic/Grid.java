package ir.ac.kntu.gamelogic;

public class Grid {

    private String [][]board;


    public void setPosition(int row, int col, String name) {
        this.board[row][col] = name;
    }

    public String[][] getBoard() {
        String[][] newBoard = board;
        return newBoard;
    }

    public Grid(int size) {
        board = new String[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.board[i][j] ="  ";
            }
        }
    }


    public void draw(Player player, OrdinarySnake ordinary,KindSnake kind) {

        int index = Roll.choose();
        while (player.getHealth() > 0) {
            ordinary.move(this);
            kind.move(this);
            player.steps(this, index);
            System.out.println("Dice:" + Dice.values()[index]);
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
            System.out.println("********************************");
            if(checkForEnd(player)){
                break;
            }
            if(index==8){
                index=Roll.rollDice();
            }else{
                index = Roll.choose();
            }
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
                System.out.print(this.board[row][j / 2]);
            }

        }

    }

    public boolean checkForEnd(Player player) {
        if (this.board[0][board.length-1].equals("* ") || this.board[0][board.length-1].equals(player.getCharacter())) {
            System.out.println("You Won!!!!!!!!");
            System.out.println("****************");
            return true;
        }else if(player.getHealth()==0){
            System.out.println("Game over!!!!");
            System.out.println("****************");
            return true;
        }else{
            return false;
        }
    }
}
