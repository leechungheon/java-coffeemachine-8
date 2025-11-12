package org.example.domain.menu;

public class Americano implements Coffee {

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
        return 3000;
    }
}
