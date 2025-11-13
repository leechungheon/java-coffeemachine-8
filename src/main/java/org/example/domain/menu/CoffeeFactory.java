package org.example.domain.menu;

public class CoffeeFactory {

    public static Coffee createCoffee(int menuCode, int sizeCode) {
        MainMenu selectedMenu = MainMenu.getMainMenuByCode(menuCode);
        SizeOption selectedSize = SizeOption.getSizeOptionByCode(sizeCode);
        return new BasicCoffee(selectedMenu, selectedSize);
    }
}
