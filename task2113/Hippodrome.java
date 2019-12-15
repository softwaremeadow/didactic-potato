package com.codegym.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    public Horse getWinner() {
        Horse fastestHorse = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (fastestHorse.getDistance() < horses.get(i).getDistance()) {
                fastestHorse = horses.get(i);
            }
        }
        return fastestHorse;
    }

    public void printWinner() {
        System.out.println("The winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse brownie = new Horse("Brownie", 3, 0);
        Horse belle = new Horse("Belle", 3, 0);
        Horse beau = new Horse("Beau", 3, 0);
        game.getHorses().add(brownie);
        game.getHorses().add(belle);
        game.getHorses().add(beau);
        game.run();
        game.printWinner();
    }
}
