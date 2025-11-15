package org.example.domain.menu.factory;

import org.example.domain.menu.Coffee;
import org.example.domain.menu.MainMenu;
import org.example.domain.menu.SizeOption;
import org.example.domain.menu.product.BasicLatte;

public class LatteDrinkMachine extends CoffeeMachine {

    @Override
    protected Coffee createCoffeeProduct(int menuCode, int sizeCode) {
        MainMenu selectedMenu = MainMenu.getMainMenuByCode(menuCode);
        SizeOption selectedSize = SizeOption.getSizeOptionByCode(sizeCode);

        return new BasicLatte(selectedMenu, selectedSize);
    }
}