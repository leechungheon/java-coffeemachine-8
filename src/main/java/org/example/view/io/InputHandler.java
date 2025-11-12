package org.example.view.io;

import java.util.Scanner;

public class InputHandler {
    // 각 입력은 해당 enum 클래스 id 의 범위를 넘어서면 안됨
    public int selectMainMenu(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int selectSize(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
