package ir.ac.kntu.gamelogic;

public class SavageSnake extends Snake {


    @Override
    public void move(Grid grid, int number) {

        if (hasMoved()) {
            grid.getBoard()[super.getHead().getRow()][super.getHead().getCol()] = "  ";
        }
        int headRow = grid.getBoard().length - 1;
        int headCol = 0;
        super.setHeadName("$" + number);
        super.setTailName("D" + number);
        while (true/*&& headCol == 0*/) {
            headRow = RandomHelper.nextInt(grid.getBoard().length);
            headCol = RandomHelper.nextInt(grid.getBoard().length);
            if (!AllSnakes.isOtherSnake(grid, headRow, headCol, this.getHeadName())
                    && headRow != grid.getBoard().length - 1 /*&& headCol != 0*/) {
                break;
            }

        }
        Point newPoint = new Point(headRow, headCol);
        super.setHead(newPoint);
        super.move(grid, number);

    }

    public boolean hasMoved() {
        if (super.getHead().getRow() >= 0 && super.getHead().getCol() >= 0) {
            return true;
        }
        return false;
    }
}
