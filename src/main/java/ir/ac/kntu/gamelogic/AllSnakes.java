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
}
