package org.example.domain.menu.product;

import java.util.Map;
import org.example.domain.menu.CustomOption;

public interface Beverage {
    String getName();
    String getSize();
    Map<CustomOption, Integer> getOptions();
    int getTotalPrice();
    int getBaseBeveragePrice();
}
