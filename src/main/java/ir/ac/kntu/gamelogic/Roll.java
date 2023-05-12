package ir.ac.kntu.gamelogic;

public class Roll {


    public static int choose(){
        while(true){
            System.out.println("Press 'r' to roll the dice.");
            String input=ScannerWrapper.getString();
            if(input.equalsIgnoreCase("r")){
                return rollDice();
            }else{
                System.out.println("Wrong input.Try again!");
            }

        }

    }

    public static int rollDice(){
        return RandomHelper.nextInt(9);
    }


}
