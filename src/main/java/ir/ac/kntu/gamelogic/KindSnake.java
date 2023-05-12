package ir.ac.kntu.gamelogic;

public class KindSnake extends Snake {



    @Override
    public void move(Grid grid) {
        if (!hasMoved()) {
            int headRow = 0;
            int headCol = 0;
            super.setHeadName("L1");
            super.setTailName("r1");

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

        setTailPoint(grid);


    }

    public void setTailPoint(Grid grid){
        while (true) {
            if(this.getTail().getRow()!=-1 && this.getTail().getCol()!=-1){
                grid.setPosition(this.getTail().getRow(), this.getTail().getCol(),"  ");
            }

            int tailRow = RandomHelper.nextInt( grid.getBoard().length-1);
            int tailCol = RandomHelper.nextInt(  grid.getBoard().length-1);
            if(!AllSnakes.isOtherSnake(grid,tailRow,tailCol,this.getTailName())) {
                if (tailRow > this.getHead().getRow()) {
                    continue;
                } else if (tailRow == this.getHead().getRow() && tailCol <= this.getHead().getCol()) {
                    continue;
                } else if (tailRow <= this.getHead().getRow()) {
                    this.getTail().setRow(tailRow);
                    this.getTail().setCol(tailCol);
                    grid.setPosition(getHead().getRow(), getHead().getCol(), this.getHeadName());
                    grid.setPosition(tailRow,tailCol,this.getTailName());
                    break;
                }
            }



        }
    }


    public boolean hasMoved() {
        if (super.getHead().getRow() >= 0 && super.getHead().getCol() >= 0) {
            return true;
        }
        return false;
    }


}
