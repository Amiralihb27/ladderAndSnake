package ir.ac.kntu.gamelogic;

public class Player {

    private int health = 3;

    private int row;

    private int col = 0;

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


    public void steps(Grid grid, int index,AllSnakes allSnakes) {
        // grid.setPosition(this.row, this.col, this.character);
        if (index % 2 == 0 && index != 8) {
            direction(index, 1, grid,allSnakes);
        } else if (index % 2 == 1) {
            direction(index, 2, grid,allSnakes);
        } else {
            if (this.health < 3) {
                this.health++;
            }
            grid.setPosition(this.row, this.col, this.character);
        }
    }

    public void direction(int index, int steps, Grid grid,AllSnakes allSnakes) {
        switch (index) {
            case 0:
                steps *= -1;
                verticalMove(steps, grid,allSnakes);
                break;
            case 1:
                steps *= -1;
                verticalMove(steps, grid,allSnakes);
                break;
            case 2:
                verticalMove(steps, grid,allSnakes);
                break;
            case 3:
                verticalMove(steps, grid,allSnakes);
                break;
            case 4:
                steps *= -1;
                horizontal(steps, grid,allSnakes);
                break;
            case 5:
                steps *= -1;
                horizontal(steps, grid,allSnakes);
                break;
            case 6:
                horizontal(steps, grid,allSnakes);
                break;
            case 7:
                horizontal(steps, grid,allSnakes);
                break;
            default:
                break;
        }
    }

    public void verticalMove(int steps, Grid grid,AllSnakes allSnakes) {


        if (this.row + steps >= 0 && this.row + steps < grid.getBoard().length) {
            if (grid.getBoard()[row][col] == this.character) {
                grid.setPosition(this.row, this.col, "  ");
            }
            this.row = row + steps;
        }
        isSnake(grid, row, col,allSnakes);
    }

    public void horizontal(int steps, Grid grid,AllSnakes allSnakes) {

        if (this.col + steps >= 0 && this.col + steps < grid.getBoard().length) {
            if (grid.getBoard()[row][col] == this.character) {
                grid.setPosition(this.row, this.col, "  ");
            }
            this.col = this.col + steps;
        }
        isSnake(grid, row, col,allSnakes);
    }

    public void isSnake(Grid grid, int row, int col, AllSnakes allSnakes) {
        for (int i = 0; i < allSnakes.getSnakes().size(); i++) {
            if (grid.getBoard()[row][col].equals(allSnakes.getSnakes().get(i).getHeadName())) {
                //System.out.println("nish khordi!");
                Point point = find(allSnakes.getSnakes().get(i).getTailName(), allSnakes);
                System.out.println(grid.getBoard()[row][col] +
                        " bited you.move to [" + point.getRow() + "," + point.getCol() + "]");
                if (isSavage(grid, row, col)) {
                    this.health = this.health - 1;
                }
                grid.setPosition(point.getRow(), point.getCol(), this.character);
                this.row = point.getRow();
                this.col = point.getCol();
            } else if (i == allSnakes.getSnakes().size() - 1) {
                grid.setPosition(this.row, this.col, this.character);
            }
        }


    }


    public boolean isSavage(Grid grid, int row, int col) {
        if (grid.getBoard()[row][col].startsWith("$")) {
            return true;
        }
        return false;
    }

    public Point find(String tailName, AllSnakes allSnakes) {
        int index = allSnakes.wichSnake(tailName);
        int row = allSnakes.getSnakes().get(index).getTail().getRow();
        int col = allSnakes.getSnakes().get(index).getTail().getCol();
        Point point = new Point(row, col);
        return point;
        /*for (int i = 0; i < grid.getBoard().length; i++) {
            for (int j = 0; j < grid.getBoard().length; j++) {
                if (grid.getBoard()[i][j].equals(tailName)) {
                    Point point = new Point(i, j);
                    System.out.println(grid.getBoard()[i][j]);
                    return point;
                }
            }
        }
        Point point = new Point(0, 0);
        return point;*/
    }
}
