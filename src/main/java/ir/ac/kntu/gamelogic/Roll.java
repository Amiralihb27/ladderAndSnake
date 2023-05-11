package ir.ac.kntu.gamelogic;

public class Roll {

    public static int rollDice(){
        while(true){
            System.out.println("Press 'r' o roll the dice.");
            String input=ScannerWrapper.getString();
            if(input.equalsIgnoreCase("r")){
                return RandomNumber.randomWithinRange(0,9);
            }else{

            }
            System.out.println("Wrong input.Try again!");
        }

    }
}
