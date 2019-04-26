package com.tris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean exit = false;
        System.out.println("Welcome in my Tris game");
        printMenu();
        try {
        while (!exit) {
            System.out.println("Do your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    Tris a = new Tris();
                    boolean gameOver = false;
                    int choiceMove = 0;
                    String gameTurn;
                    while (!gameOver) {
                        printGameMenu();
                        System.out.println("Do your choice");
                        choiceMove = scanner.nextInt();
                        switch (choiceMove) {
                            case 0:
                                System.out.println("Which player start the game? X or O");
                                scanner.nextLine();
                                String playerGame = scanner.nextLine();
                                System.out.println("Which position of row u want sign ?");
                                int xCoordinate = scanner.nextInt();
                                System.out.println("Which position of column u want sign?");
                                int yCoordinate = scanner.nextInt();
                                gameTurn = a.setSign(xCoordinate, yCoordinate, playerGame);
                                System.out.println(gameTurn);
                                break;

                            case 1:
                                gameOver = true;
                                printMenu();
                                break;

                            default:
                                System.out.println("Please, insert right choice");
                        }
                    }
                    break;

                case 1:
                    System.out.println("Thanks for test my game, star my project :)");
                    exit = true;
                    break;

                default:
                    System.out.println("Please, insert right choice");
                    break;
            }

        }
        } catch(java.util.InputMismatchException excNumber){
        System.out.println("Insert a number of that printed");
    }

    }
    public static void printMenu(){
        System.out.println("What do you want?");
        System.out.println("\t 0 - New Game");
        System.out.println("\t 1 - Exit");
    }

    public static void printGameMenu(){
        System.out.println("What do you want ?");
        System.out.println("\t 0 - Insert your move");
        System.out.println("\t 1 - Return to main menu");
    }

}
