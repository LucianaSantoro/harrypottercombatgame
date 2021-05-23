package Juego;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("");

        game.printGameName();

        game.choosePlayer(keyboard);

        game.startFight();
    }
}
