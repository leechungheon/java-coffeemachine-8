package org.example.domain.menu;

import java.util.Map;

public interface Coffee {
    String getName();
    String getSize();
    Map<String, Integer> getOptions();
    int getPrice();
}
