package org.example.domain.menu.product;

import java.util.HashMap;
import java.util.Map;
import org.example.domain.menu.Beverage;
import org.example.domain.menu.CustomOption;
import org.example.domain.menu.MainMenu;
import org.example.domain.menu.SizeOption;

public class BasicCoffee implements Beverage {

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
    public int getTotalPrice() {
        return price;
    }

    @Override
    public int getBaseBeveragePrice() {
        return price;
    }
}
