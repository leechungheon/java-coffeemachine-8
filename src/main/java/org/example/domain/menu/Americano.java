package org.example.domain.menu;

public class Americano implements Coffee {

    private final SizeOption size;
    private final int price;

    public Americano(SizeOption size) {
        this.size = size;
        this.price = calculateFinalPrice();
    }

    private int calculateFinalPrice() {
        int basePrice = MainMenu.AMERICANO.getPrice();

        int sizeIncrement = this.size.getExtraPrice();

        return basePrice + sizeIncrement;
    }

    @Override
    public String getName() {
        return "아메리카노";
    }

    @Override
    public String getSize() {
        return "";
    }

    @Override
    public String[] getOptions() {
        return new String[0];
    }

    @Override
    public int getPrice() {
        return price;
    }
}
