package org.example;

import org.example.domain.menu.Coffee;
import org.example.domain.menu.factory.CoffeeMachine;
import org.example.domain.menu.CustomOption;
import org.example.domain.menu.decorator.ExtraShotDecorator;
import org.example.domain.menu.decorator.SyrupDecorator;
import org.example.domain.menu.factory.MenuFactorySelector;
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

        CoffeeMachine factory = MenuFactorySelector.selectFactory(mainMenu);

        Coffee coffee = factory.orderCoffee(mainMenu, size);

        outputHandler.customOptionDisplay();
        int option;
        while(true) {
            option = inputHandler.selectOption();
            if(option == 7)break;

            CustomOption customOption = CustomOption.getCustomOptionByCode(option);
            if (customOption == CustomOption.EXTRA_SHOT) {
                coffee = new ExtraShotDecorator(coffee, customOption);
            }else if (customOption == CustomOption.VANILLA_SYRUP){
                coffee = new SyrupDecorator(coffee, customOption);
            }else if (customOption == CustomOption.HAZELNUT_SYRUP){
                coffee = new SyrupDecorator(coffee, customOption);
            }
        }
        outputHandler.receiptDisplay(coffee);
    }
}