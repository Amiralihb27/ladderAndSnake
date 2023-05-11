package ir.ac.kntu.gamelogic;

public class RandomNumber {

    public static int randomWithinRange(int min, int max) {
        assert min < max;

        int range = (max - min) + 1;
        return (int)((Math.random() * range) + min);
    }
}
