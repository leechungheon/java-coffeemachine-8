package org.example.domain.menu.factory;

import org.example.domain.menu.Beverage;

public abstract class beverageMachine {

    protected abstract Beverage createBeverageProduct(int menuCode, int sizeCode);
    public final Beverage orderCoffee(int menuCode, int sizeCode) {

        Beverage beverage = createBeverageProduct(menuCode, sizeCode);

        return beverage;
    }
}