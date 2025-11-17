package org.example.domain.menu.factory;

import org.example.domain.menu.DrinkType;
import org.example.domain.menu.MainMenu;

public class MenuFactorySelector {
    public static BeverageMachine selectFactory(int menuCode) {
        MainMenu menu = MainMenu.getMainMenuByCode(menuCode);

        DrinkType type = menu.getDrinkType();

        return switch (type) {
            case COFFEE -> new CoffeeMachine();
            case NON_COFFEE -> new BlenderMachine();
            default -> throw new IllegalArgumentException("지원되지 않는 메뉴 타입입니다: " + menu.getDisplayName());
        };
    }
}
