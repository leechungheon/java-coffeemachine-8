package org.example.domain.menu.factory;

import org.example.domain.menu.product.Beverage;

public abstract class BeverageMachine {

    protected abstract Beverage createBeverageProduct(int menuCode, int sizeCode);
    public final Beverage orderCoffee(int menuCode, int sizeCode) {

        Beverage beverage = createBeverageProduct(menuCode, sizeCode);

        return beverage;
    }
}