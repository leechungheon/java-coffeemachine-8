package org.example;

import org.example.view.io.InputHandler;
import org.example.view.io.OutputHandler;

public class Main {
    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;
    public Main(OutputHandler outputHandler, InputHandler  inputHandler) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
    }

    public static void main(String[] args){
        OutputHandler outputHandler = new OutputHandler();
        InputHandler inputHandler = new InputHandler();

        outputHandler.menuDisplay();
        int mainMenu = inputHandler.selectMainMenu();

        outputHandler.sizeOptionDisplay();
        int size = inputHandler.selectSize();


        outputHandler.customOptionDisplay();
    }
}