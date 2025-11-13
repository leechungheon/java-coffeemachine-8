package org.example.domain.menu.decorator;

import java.util.Map;
import org.example.domain.menu.Coffee;
import org.example.domain.menu.CustomOption;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getName() {
        return decoratedCoffee.getName();
    }

    @Override
    public String getSize() {
        return decoratedCoffee.getSize();
    }

    @Override
    public Map<CustomOption, Integer> getOptions() {
        return decoratedCoffee.getOptions();
    }

    @Override
    public int getTotalPrice() {
        return decoratedCoffee.getTotalPrice();
    }

    @Override
    public int getBaseCoffeePrice() {
        return decoratedCoffee.getBaseCoffeePrice();
    }
}