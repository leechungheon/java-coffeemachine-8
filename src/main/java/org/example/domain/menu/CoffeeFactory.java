package org.example.domain.menu;

public class CoffeeFactory {

    public static Coffee createCoffee(int menuCode, int sizeCode) {
        MainMenu selectedMenu = MainMenu.getMainMenuByCode(menuCode);
        SizeOption selectedSize = SizeOption.getSizeOptionByCode(sizeCode);

        switch (selectedMenu) {
            case AMERICANO:
                return new Americano(selectedSize);
            case CAFE_LATTE:
                //return new CAFE_LATTE(selectedSize);
            case CAPPUCCINO:
                //return new CAPPUCCINO(selectedSize);
            case CARAMEL_MACCHIATO:
                //return new CARAMEL_MACCHIATO(selectedSize);
            case CAFE_MOCHA:
                //return new CAFE_MOCHA(selectedSize);
            case ESPRESSO:
                //return new ESPRESSO(selectedSize);
            case CHOCOLATE_LATTE:
                //return new CHOCOLATE_LATTE(selectedSize);
            case GREEN_TEA_LATTE:
                //return new GREEN_TEA_LATTE(selectedSize);
            case BLACK_TEA:
                //return new BLACK_TEA(selectedSize);
            case FRESH_JUICE:
                //return new FRESH_JUICE(selectedSize);
            default:
                throw new IllegalStateException("처리할 수 없는 메뉴입니다: " + selectedMenu.getDisplayName());
        }
    }
}
