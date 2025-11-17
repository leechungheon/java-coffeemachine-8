package org.example.domain.menu.factory;

import org.example.domain.menu.product.BasicEspresso;
import org.example.domain.menu.Beverage;
import org.example.domain.menu.MainMenu;
import org.example.domain.menu.SizeOption;

public class CoffeeMachine extends beverageMachine {

    @Override
    protected Beverage createBeverageProduct(int menuCode, int sizeCode) {
        MainMenu selectedMenu = MainMenu.getMainMenuByCode(menuCode);
        SizeOption selectedSize = SizeOption.getSizeOptionByCode(sizeCode);
        return new BasicEspresso(selectedMenu, selectedSize);
    }
}