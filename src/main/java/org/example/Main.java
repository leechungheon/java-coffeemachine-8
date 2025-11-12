package org.example;

import org.example.view.io.OutputHandler;

public class Main {
    private final OutputHandler outputHandler;
    public Main(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public static void main(String[] args){
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.menuDisplay();

        outputHandler.sizeOptionDisplay();
        outputHandler.customOptionDisplay();
    }
}