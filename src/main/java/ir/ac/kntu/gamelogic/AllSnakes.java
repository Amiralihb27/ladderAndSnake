package ir.ac.kntu.gamelogic;

import java.util.ArrayList;

public class AllSnakes {

    private ArrayList<Snake> snakes;


    public AllSnakes() {
        snakes = new ArrayList<>();
    }

    public void addSnake(Snake snake) {
        snakes.add(snake);
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(ArrayList<Snake> snakes) {
        this.snakes = snakes;
    }

    public int wichSnake(String name) {
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getHeadName().equals(name) || snakes.get(i).getTailName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isOtherSnake(Grid grid, int row, int col, String name) {

        String string = grid.getBoard()[row][col];
        String headName;
        String tailName;
        int index = wichSnake(name);
        for (int i = 0; i < snakes.size(); i++) {
            headName = this.getSnakes().get(i).getHeadName();
            tailName = this.getSnakes().get(i).getTailName();
          /*  if (isTailName(name) && (string.equals(tailName))) {
                return false;
            }*/
            if ((string.equals(headName) || string.equals(tailName)) && index != i) {
                return true;
            }
        }
        return false;
    }


    /*public  boolean isTailName(String name) {
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getTailName().equals(name)) {
                return true;
            }
        }
        return false;
    }*/
}
