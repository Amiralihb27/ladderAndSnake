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


    public void steps(Grid grid,int index) {
        grid.setPosition(this.row, this.col, this.character);
        if (index % 2==0 && index!=8) {

            direction(index,1, grid);
        } else if(index % 2==1) {
            direction(index, 2,grid);
        }else{

            this.health++;
        }
    }

    public void direction(int index,int steps, Grid grid) {
        switch (index) {
            case 0:
                steps *= -1;
                verticalMove(steps, grid);
                break;
            case 1:
                steps *= -1;
                verticalMove(steps, grid);
                break;
            case 2:
                verticalMove(steps, grid);
                break;
            case 3:
                verticalMove(steps, grid);
                break;
            case 4:
                steps *= -1;
                horizontal(steps, grid);
                break;
            case 5:
                steps *= -1;
                horizontal(steps, grid);
                break;
            case 6:
                horizontal(steps, grid);
                break;
            case 7:
                horizontal(steps, grid);
                break;
            default:
                break;
        }
    }

    public void verticalMove(int steps, Grid grid) {


        if (this.row + steps >= 0 && this.row + steps < grid.getBoard().length) {
            if(grid.getBoard()[row][col]==this.character){
                grid.setPosition(this.row, this.col, "  ");
            }
            this.row = row + steps;
            isSnake(grid,row,col);
        }

       // grid.setPosition(this.row, this.col, this.character);
    }

    public void horizontal(int steps, Grid grid) {

        if (this.col + steps >= 0 && this.col + steps <  grid.getBoard().length) {
            if(grid.getBoard()[row][col]==this.character){
                grid.setPosition(this.row, this.col, "  ");
            }
            this.col = this.col + steps;
            isSnake(grid,row,col);
        }
       // grid.setPosition(this.row, this.col, this.character);
    }

    public void isSnake(Grid grid,int row,int col){
        for(int i=0;i<AllSnakes.getSnakes().size();i++){
            if(grid.getBoard()[row][col].equals(AllSnakes.getSnakes().get(i).getHeadName())){
                Point point=find(grid,AllSnakes.getSnakes().get(i).getTailName());
                System.out.println(point.getRow()+" "+point.getCol());
                grid.setPosition(point.getRow(), point.getCol(), this.character);
            }else if(i==AllSnakes.getSnakes().size()-1){
                grid.setPosition(this.row, this.col, this.character);
            }
        }


    }

    public Point find(Grid grid,String tailName){
        for(int i=0;i<grid.getBoard().length;i++){
            for(int j=0;j<grid.getBoard().length;j++){
                if(grid.getBoard()[i][j].equals(tailName)){
                    Point point=new Point(i,j);
                    return point;
                }
            }
        }
        Point point=new Point(0,0);
        return point;
    }
}
