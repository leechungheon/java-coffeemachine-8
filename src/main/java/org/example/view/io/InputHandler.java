package org.example.view.io;

import java.util.Scanner;

public class InputHandler {
    public int selectMainMenu(){
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                int input = sc.nextInt();
                isValidateMainMenuRange(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidateMainMenuRange(int number){
        if(number < 1 || number > 9){
            throw new IllegalArgumentException("[ERROR] Invalid code " + number);
        }
    }

    public int selectSize(){
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                int input = sc.nextInt();
                isValidateSizeRange(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidateSizeRange(int number){
        if(number < 1 || number > 3){
            throw new IllegalArgumentException("[ERROR] Invalid code " + number);
        }
    }

    public int selectOption(){
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                int input = sc.nextInt();
                isValidateOptionRange(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isValidateOptionRange(int number){
        if(number < 0 || number > 6){
            throw new IllegalArgumentException("[ERROR] Invalid code " + number);
        }
    }
}
