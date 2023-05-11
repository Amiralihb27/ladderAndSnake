package ir.ac.kntu.gamelogic;

public class Player {

    private int health = 3;
    private int row;
    private int col;

    private final String character = "* ";

    public Player() {
        this.row = 0;
        this.col = 0;
    }


    public String getCharacter() {
        return character;
    }

    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public int getRow() {
        return row;
    }


    public void setRow(int row) {
        this.row = row;
    }


    public int getCol() {
        return col;
    }


    public void setCol(int col) {
        this.col = col;
    }


    public void move() {
        int index = Roll.rollDice();
    }
}
