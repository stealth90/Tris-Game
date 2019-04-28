package com.tris;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean exit = false;
        System.out.println("Welcome in my Tris game");
        printMenu();
        while (!exit) {
            choice=getIntForMenu();
            switch (choice) {
                case 0:
                    Tris a = new Tris();
                    boolean gameOver = false;
                    int choiceMove = 0;
                    String gameTurn;
                    while (!gameOver) {
                        printGameMenu();
                        choiceMove = getIntForMenu();
                        switch (choiceMove) {
                            case 0:
                                System.out.println("Which player start the game? X or O");
                                String playerGame = scanner.nextLine();
                                System.out.println("Which position of row u want sign ?");
                                int xCoordinate = getCoordinate();
                                System.out.println("Which position of column u want sign?");
                                int yCoordinate = getCoordinate();
                                try{
                                    gameTurn = a.setSign(xCoordinate, yCoordinate, playerGame);
                                    System.out.println(gameTurn);
                                }catch (ArrayIndexOutOfBoundsException invalidIndexArray){
                                    System.out.println("Insert a valid coordinate");
                                    System.out.println("Turn invalid");
                                }
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

    public static int getCoordinate(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                return scanner.nextInt();
            }catch(InputMismatchException inputNotANumber){
                scanner.nextLine();
                System.out.println("Please insert a valid number");
            }
        }
    }

    public static int getIntForMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do your choice");
        while(true){
            try{
                return scanner.nextInt();
            }catch (InputMismatchException inputNotANumber){
                scanner.nextLine();
                System.out.println("Please insert a number");
            }
        }
    }

}
