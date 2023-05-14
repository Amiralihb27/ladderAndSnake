package ir.ac.kntu.gamelogic;

import java.util.ArrayList;

public class AllSnakes {

    private static ArrayList<Snake> snakes;


    public AllSnakes() {
        snakes = new ArrayList<>();
    }

    public static void addSnake(Snake snake) {
        snakes.add(snake);
    }

    public static ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public static void setSnakes(ArrayList<Snake> snakes) {
        AllSnakes.snakes = snakes;
    }

    public static int wichSnake(String name) {
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getHeadName().equals(name) || snakes.get(i).getTailName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isOtherSnake(Grid grid, int row, int col, String name) {

        String string = grid.getBoard()[row][col];
        String headName;
        String tailName;
        int index = wichSnake(name);
        for (int i = 0; i < snakes.size(); i++) {
            headName = AllSnakes.getSnakes().get(i).getHeadName();
            tailName = AllSnakes.getSnakes().get(i).getTailName();
          /*  if (isTailName(name) && (string.equals(tailName))) {
                return false;
            }*/ if ((string.equals(headName) || string.equals(tailName)) && index != i) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTailName(String name) {
        for (int i = 0; i < snakes.size(); i++) {
            if (snakes.get(i).getTailName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
