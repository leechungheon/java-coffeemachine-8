package org.example.domain.menu.decorator;

import java.util.Map;
import org.example.domain.menu.Beverage;
import org.example.domain.menu.CustomOption;

public abstract class BeverageDecorator implements Beverage {

    protected Beverage decoratedBeverage;

    public BeverageDecorator(Beverage beverage) {
        this.decoratedBeverage = beverage;
    }

    @Override
    public String getName() {
        return decoratedBeverage.getName();
    }

    @Override
    public String getSize() {
        return decoratedBeverage.getSize();
    }

    @Override
    public Map<CustomOption, Integer> getOptions() {
        return decoratedBeverage.getOptions();
    }

    @Override
    public int getTotalPrice() {
        return decoratedBeverage.getTotalPrice();
    }

    @Override
    public int getBaseBeveragePrice() {
        return decoratedBeverage.getBaseBeveragePrice();
    }
}