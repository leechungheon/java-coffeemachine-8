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
    public Map<CustomOption, Integer> getOptions() {
        Map<CustomOption, Integer> options = new HashMap<>(super.getOptions());
        options.put(this.customOption, options.getOrDefault(this.customOption, 0) + 1);
        return options;
    }

    @Override
    public int getPrice() {
        int existingPrice = super.getPrice();

        int shotPrice = this.customOption.getExtraPrice();

        return existingPrice + shotPrice;
    }
}
