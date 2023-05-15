package ir.ac.kntu.gamelogic;

public class CreateObject {

    public void create() {
        System.out.println("Enter the size of the board: ");
        ScannerWrapper sc = new ScannerWrapper();
        int size = ScannerWrapper.getInt();
        Grid g = new Grid(size);
        AllSnakes allSnakes = new AllSnakes();
        warning();
        createOrdinary(allSnakes);
        createKind(allSnakes);
        createSavage(allSnakes);
        information();
        Player player = new Player();
        player.setRow(size - 1);
        g.draw(player, allSnakes);
    }


    public void warning() {
        System.out.println("lotfan nesbat mar ha be safhe bazi ra raayat konid :) ");
    }

    public void createOrdinary(AllSnakes allSnakes) {
        System.out.println("How many ordinary snakes do you wana have?");
        while (true) {
            int numOfOrdinary = ScannerWrapper.getInt();
            if (numOfOrdinary > 0) {
                for (int i = 0; i < numOfOrdinary; i++) {
                    Snake ordinary = new OrdinarySnake();
                    allSnakes.addSnake(ordinary);
                }
                break;
            } else {
                System.out.println("Number of these snakes should be more than 0.Try again.");
            }

        }

    }

    public void createKind(AllSnakes allSnakes) {
        System.out.println("How many Kind snakes do you wana have?");
        while (true) {
            int numOfKind = ScannerWrapper.getInt();
            if (numOfKind > 0) {
                for (int i = 0; i < numOfKind; i++) {
                    Snake kind = new KindSnake();
                    allSnakes.addSnake(kind);
                }
                break;
            } else {
                System.out.println("Number of these snakes should be more than 0.Try again.");
            }

        }
    }

    public void createSavage(AllSnakes allSnakes) {
        System.out.println("How many Savage snakes do you wana have?");
        while (true) {
            int numOfSavage = ScannerWrapper.getInt();
            if (numOfSavage > 0) {
                for (int i = 0; i < numOfSavage; i++) {
                    Snake savage = new SavageSnake();
                    allSnakes.addSnake(savage);
                }
                break;
            } else {
                System.out.println("Number of these snakes should be more than 0.Try again.");
            }

        }
    }

    public void information() {
        System.out.println("Be aware that:");
        System.out.println("s and d belongs to ordinary snakes.");
        System.out.println("L and r belongs to kind snakes. ");
        System.out.println("$ and D belongs to Savage snakes.");
        System.out.println("* belongs to player.");
        System.out.println("***********************************");
        System.out.println("If the player moves to the tail of one snake , the grid only shows the players character.");
        System.out.println("*****************************************************************************************");
    }

}
