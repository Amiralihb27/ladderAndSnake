package ir.ac.kntu.gamelogic;

public class OrdinarySnake extends Snake {


    @Override
    public void move(Grid grid, int number) {
        if (!hasMoved()) {
            int headRow = grid.getBoard().length - 1;
            int headCol = 0;
            super.setHeadName("s" + number);
            super.setTailName("d" + number);
            while (headRow == grid.getBoard().length - 1 && headCol == 0) {
                headRow = RandomHelper.nextInt(grid.getBoard().length);
                headCol = RandomHelper.nextInt(grid.getBoard().length);
                if (!AllSnakes.isOtherSnake(grid, headRow, headCol, this.getHeadName())
                        && headRow != grid.getBoard().length - 1 && headCol != 0) {
                    break;
                }

            }

            Point newPoint = new Point(headRow, headCol);
            super.setHead(newPoint);
        }
        super.move(grid, number);

    }

    public boolean hasMoved() {
        if (super.getHead().getRow() >= 0 && super.getHead().getCol() >= 0) {
            return true;
        }
        return false;
    }
}
