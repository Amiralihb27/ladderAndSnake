package ir.ac.kntu.gamelogic;

import java.util.SplittableRandom;

public class Snake {

    private Point head;

    private Point tail;

    private String headName;

    private String tailName;

    public Snake(){
        this.head=new Point();
        this.tail=new Point();
        this.head.setRow(-1);
        this.head.setCol(-1);
        this.tail.setRow(-1);
        this.tail.setCol(-1);
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getTailName() {
        return tailName;
    }

    public void setTailName(String tailName) {
        this.tailName = tailName;
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public Point getTail() {
        return tail;
    }

    public void setTail(Point tail) {
        this.tail = tail;
    }

    public void move(Grid grid,int number) {
        while (true) {
            if(this.getTail().getRow()!=-1 && this.getTail().getCol()!=-1){
                grid.setPosition(this.getTail().getRow(), this.getTail().getCol(),"  ");
            }

            int tailRow = RandomHelper.nextInt( grid.getBoard().length);
            int tailCol = RandomHelper.nextInt(  grid.getBoard().length);
            if(!AllSnakes.isOtherSnake(grid,tailRow,tailCol,this.tailName)){
                if (tailRow < this.getHead().getRow()) {
                    continue;
                } else if (tailRow == this.getHead().getRow() && tailCol >= this.getHead().getCol()) {
                    continue;
                } else if (tailRow >= this.getHead().getRow()) {
                    this.tail.setRow(tailRow);
                    this.tail.setCol(tailCol);
                    grid.setPosition(head.getRow(), head.getCol(), this.headName);
                    grid.setPosition(tailRow,tailCol,this.tailName);
                    break;
                }

            }


        }
    }
}
