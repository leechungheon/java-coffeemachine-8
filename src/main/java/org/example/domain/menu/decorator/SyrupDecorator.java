package org.example.domain.menu.decorator;

import java.util.HashMap;
import java.util.Map;
import org.example.domain.menu.Coffee;
import org.example.domain.menu.CustomOption;

public class SyrupDecorator extends CoffeeDecorator{

    private final CustomOption customOption;

    public SyrupDecorator(Coffee coffee, CustomOption customOption) {
        super(coffee);
        this.customOption = customOption;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSize() {
        return super.getSize();
    }

    @Override
    public Map<String, Integer> getOptions() {
        Map<String, Integer> options = new HashMap<>(super.getOptions());
        String optionName = this.customOption.getDisplayName();
        options.put(optionName, options.getOrDefault(optionName, 0) + 1);
        return options;
    }

    @Override
    public int getPrice() {
        int existingPrice = super.getPrice();

        int shotPrice = this.customOption.getExtraPrice();

        return existingPrice + shotPrice;
    }
}
