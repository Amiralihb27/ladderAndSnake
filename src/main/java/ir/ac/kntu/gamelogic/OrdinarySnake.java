package ir.ac.kntu.gamelogic;

public class OrdinarySnake extends Snake {


    public void setPosition() {


    }

    @Override
    public void move(Grid grid) {
        if (!hasMoved()) {
            int headRow=0;
            int headCol=0;
            while (headRow == 0 && headCol == 0) {
                headRow =  RandomHelper.nextInt( grid.getBoard().length-1);
                headCol =  RandomHelper.nextInt( grid.getBoard().length-1);
            }

            Point newPoint = new Point(headRow, headCol);
            super.setHead(newPoint);
        }
        super.setHeadName("s1");
        super.setTailName("d1");
        super.move(grid);

    }

    public boolean hasMoved() {
        if (super.getHead().getRow() >= 0 && super.getHead().getCol() >= 0) {
            return true;
        }
        return false;
    }
}
