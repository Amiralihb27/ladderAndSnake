package ir.ac.kntu.gamelogic;

public class CreateObject {

    public void create(){
        System.out.println("Enter the size of the board: ");
        ScannerWrapper sc=new ScannerWrapper();
        int size = ScannerWrapper.getInt();
        Grid g=new Grid(size);
        System.out.println("How many ordinary snake do you wana have?");
        int numOfOrdinary = ScannerWrapper.getInt();
        AllSnakes allSnakes=new AllSnakes();
        for(int i=0;i<numOfOrdinary;i++){
            Snake ordinary=new OrdinarySnake();
            AllSnakes.addSnake(ordinary);
        }
        System.out.println("How many ordinary snake do you wana have?");
        int numOfKind = ScannerWrapper.getInt();
        for(int i=0;i<numOfKind;i++){
            Snake kind=new KindSnake();
            AllSnakes.addSnake(kind);
        }
        Player player=new Player();
        player.setRow(size-1);
        g.draw(player);
    }
}
