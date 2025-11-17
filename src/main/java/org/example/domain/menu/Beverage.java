package org.example.domain.menu;

import java.util.Map;

public interface Beverage {
    String getName();
    String getSize();
    Map<CustomOption, Integer> getOptions();
    int getTotalPrice();
    int getBaseBeveragePrice();
}
