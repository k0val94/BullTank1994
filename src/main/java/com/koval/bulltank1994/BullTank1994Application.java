package com.koval.bulltank1994;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BullTank1994Application {

    public static void main(String[] args) {
        SpringApplication.run(BullTank1994Application.class, args);
        System.setProperty("java.awt.headless", "false");
        startGame();
    }

    private static void startGame() {
        // Start the game
        Game game = new Game();
        game.start();
    }
}