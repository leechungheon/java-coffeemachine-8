package org.example.domain.menu.controller;

import org.example.domain.menu.product.Beverage;
import org.example.domain.menu.CustomOption;
import org.example.domain.menu.factory.BeverageMachine;
import org.example.domain.menu.factory.CustomOptionDecoratorFactory;
import org.example.domain.menu.factory.MenuFactorySelector;
import org.example.view.io.InputHandler;
import org.example.view.io.OutputHandler;

public class CoffeeShopApplication {

    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;

    public CoffeeShopApplication(OutputHandler outputHandler, InputHandler inputHandler) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
    }

    public void run() {
        // 1. 메뉴 및 크기 선택
        int mainMenu = selectMainMenu();
        int size = selectBeverageSize();

        // 2. 음료 객체 생성 (팩토리 메서드 패턴, 템플릿 메서드 패턴)
        BeverageMachine beverageMachine = MenuFactorySelector.selectFactory(mainMenu);
        Beverage beverage = beverageMachine.orderCoffee(mainMenu, size);

        // 3. 커스텀 옵션 적용 (데코레이터 패턴)
        beverage = applyCustomOptions(beverage);

        // 4. 결과 영수증 출력 (퍼사드 패턴)
        outputHandler.receiptDisplay(beverage);
    }

    private int selectMainMenu() {
        outputHandler.menuDisplay();
        return inputHandler.selectMainMenu();
    }

    private int selectBeverageSize() {
        outputHandler.sizeOptionDisplay();
        return inputHandler.selectSize();
    }

    private Beverage applyCustomOptions(Beverage beverage) {
        outputHandler.customOptionDisplay();
        Beverage currentBeverage = beverage;

        while (true) {
            int option = inputHandler.selectOption();
            if (option == 0) break;
            try {
                CustomOption customOption = CustomOption.getCustomOptionByCode(option);
                currentBeverage = CustomOptionDecoratorFactory.createDecorator(currentBeverage, customOption);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return currentBeverage;
    }
}