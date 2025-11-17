package org.example;

import org.example.domain.menu.Beverage;
import org.example.domain.menu.factory.beverageMachine;
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

        beverageMachine beverageMachine = MenuFactorySelector.selectFactory(mainMenu);

        Beverage beverage = beverageMachine.orderCoffee(mainMenu, size);

        outputHandler.customOptionDisplay();
        int option;
        while(true) {
            option = inputHandler.selectOption();
            if(option == 7)break;

            CustomOption customOption = CustomOption.getCustomOptionByCode(option);
            if (customOption == CustomOption.EXTRA_SHOT) {
                beverage = new ExtraShotDecorator(beverage, customOption);
            }else if (customOption == CustomOption.VANILLA_SYRUP){
                beverage = new SyrupDecorator(beverage, customOption);
            }else if (customOption == CustomOption.HAZELNUT_SYRUP){
                beverage = new SyrupDecorator(beverage, customOption);
            }
        }
        outputHandler.receiptDisplay(beverage);
    }
}