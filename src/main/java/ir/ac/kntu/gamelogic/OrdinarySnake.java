package ir.ac.kntu.gamelogic;

public class OrdinarySnake extends Snake {


    @Override
    public void move(Grid grid) {
        if (!hasMoved()) {
            int headRow=0;
            int headCol=0;
            super.setHeadName("s1");
            super.setTailName("d1");
            while (true) {
                headRow = RandomHelper.nextInt(grid.getBoard().length - 1);
                headCol = RandomHelper.nextInt(grid.getBoard().length - 1);
                if (!AllSnakes.isOtherSnake(grid, headRow, headCol, this.getHeadName())
                        || headRow == 0 && headCol == 0) {
                    break;
                }

            }

            Point newPoint = new Point(headRow, headCol);
            super.setHead(newPoint);
        }
        super.move(grid);

    }

    public boolean hasMoved() {
        if (super.getHead().getRow() >= 0 && super.getHead().getCol() >= 0) {
            return true;
        }
        return false;
    }
}
