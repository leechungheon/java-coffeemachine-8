package org.example.domain.menu.factory;

import org.example.domain.menu.product.BasicEspresso;
import org.example.domain.menu.Coffee;
import org.example.domain.menu.MainMenu;
import org.example.domain.menu.SizeOption;

public class EspressoDrinkFactory extends CoffeeFactory {

    @Override
    protected Coffee createCoffeeProduct(int menuCode, int sizeCode) {
        MainMenu selectedMenu = MainMenu.getMainMenuByCode(menuCode);
        SizeOption selectedSize = SizeOption.getSizeOptionByCode(sizeCode);

        return new BasicEspresso(selectedMenu, selectedSize);
    }
}