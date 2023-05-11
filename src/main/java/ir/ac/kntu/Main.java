package ir.ac.kntu;

import ir.ac.kntu.gamelogic.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Snake a=new Snake();
        System.out.println("Enter the size of the board: ");
        ScannerWrapper sc=new ScannerWrapper();
        int size = ScannerWrapper.getInt();
        Grid g=new Grid(size);
        Player player=new Player();
        player.setRow(size-1);
        OrdinarySnake ordinary=new OrdinarySnake();
        g.draw(player,ordinary);

    }
}