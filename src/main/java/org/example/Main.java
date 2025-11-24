package org.example;

import org.example.domain.menu.controller.CoffeeShopApplication;
import org.example.view.io.InputHandler;
import org.example.view.io.OutputHandler;

public class Main {

    public Main(OutputHandler outputHandler, InputHandler  inputHandler) {
    }

    public static void main(String[] args){
        OutputHandler outputHandler = new OutputHandler();
        InputHandler inputHandler = new InputHandler();

        CoffeeShopApplication app = new CoffeeShopApplication(outputHandler, inputHandler);
        app.run();
    }
}