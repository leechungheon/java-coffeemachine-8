package org.example.domain.menu;

import java.util.HashMap;
import java.util.Map;

public class Americano implements Coffee {

    private final SizeOption size;
    private final int price;

    public Americano(SizeOption size) {
        this.size = size;

        int basePrice = MainMenu.AMERICANO.getPrice();
        int sizeIncrement = this.size.getExtraPrice();

        this.price = basePrice + sizeIncrement;
    }

    @Override
    public String getName() {
        return MainMenu.AMERICANO.getDisplayName();
    }

    @Override
    public String getSize() {
        return this.size.getDisplayName();
    }

    @Override
    public Map<String, Integer> getOptions() {
        return new HashMap<>();
    }

    @Override
    public int getPrice() {
        return price;
    }
}
