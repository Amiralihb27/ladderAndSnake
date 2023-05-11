package ir.ac.kntu;

import ir.ac.kntu.gamelogic.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("hello");
        Snake a=new Snake();
       // a.move();
        ScannerWrapper sc=new ScannerWrapper();
        Grid g=new Grid();
        Player player=new Player();
        OrdinarySnake ordinary=new OrdinarySnake();
        g.draw(player,ordinary);

    }
}