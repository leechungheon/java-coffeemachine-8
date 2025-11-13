package org.example.domain.menu;

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
    public String[] getOptions() {
        return decoratedCoffee.getOptions();
    }

    @Override
    public int getPrice() {
        return decoratedCoffee.getPrice();
    }
}