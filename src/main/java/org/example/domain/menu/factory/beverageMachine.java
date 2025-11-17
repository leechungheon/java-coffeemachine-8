package org.example.domain.menu.factory;

import org.example.domain.menu.Beverage;

public abstract class beverageMachine {

    protected abstract Beverage createBeverageProduct(int menuCode, int sizeCode);
    public final Beverage orderCoffee(int menuCode, int sizeCode) {

        System.out.println("음료가 주문되었습니다.");

        Beverage beverage = createBeverageProduct(menuCode, sizeCode);

        System.out.println("음료가 나왔습니다.");

        return beverage;
    }
}