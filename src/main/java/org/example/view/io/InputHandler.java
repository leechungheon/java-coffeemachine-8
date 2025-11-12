package org.example.view.io;

import java.util.Scanner;

public class InputHandler {
    public int selectMainMenu(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
