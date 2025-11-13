package org.example.domain.menu;

import java.util.HashMap;
import java.util.Map;

public class BasicCoffee implements Coffee {

    private final MainMenu mainMenu;
    private final SizeOption size;
    private final int price;

    public BasicCoffee(MainMenu mainMenu, SizeOption size) {
        this.mainMenu = mainMenu;
        this.size = size;

        int basePrice = this.mainMenu.getPrice();
        int sizeIncrement = this.size.getExtraPrice();

        this.price = basePrice + sizeIncrement;
    }

    @Override
    public String getName() {
        return this.mainMenu.getDisplayName();
    }

    @Override
    public String getSize() {
        return this.size.getDisplayName();
    }

    @Override
    public Map<CustomOption, Integer> getOptions() {
        return new HashMap<>();
    }

    @Override
    public int getPrice() {
        return price;
    }
}
