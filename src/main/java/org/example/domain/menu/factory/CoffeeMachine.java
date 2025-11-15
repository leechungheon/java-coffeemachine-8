package org.example.domain.menu.factory;

import org.example.domain.menu.Coffee;

public abstract class CoffeeMachine {

    protected abstract Coffee createCoffeeProduct(int menuCode, int sizeCode);
    public final Coffee orderCoffee(int menuCode, int sizeCode) {

        Coffee coffee = createCoffeeProduct(menuCode, sizeCode);

        return coffee;
    }
}