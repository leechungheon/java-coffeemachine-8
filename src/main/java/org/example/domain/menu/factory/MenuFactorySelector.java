package org.example.domain.menu.factory;

import org.example.domain.menu.DrinkType;
import org.example.domain.menu.MainMenu;

public class MenuFactorySelector {
    public static CoffeeMachine selectFactory(int menuCode) {
        MainMenu menu = MainMenu.getMainMenuByCode(menuCode);

        DrinkType type = menu.getDrinkType();

        return switch (type) {
            case LATTE_BASED -> new LatteDrinkMachine();
            case ESPRESSO_BASED -> new EspressoDrinkMachine();
            default -> throw new IllegalArgumentException("지원되지 않는 메뉴 타입입니다: " + menu.getDisplayName());
        };
    }
}
