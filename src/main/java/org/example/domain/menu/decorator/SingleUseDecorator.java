package org.example.domain.menu.decorator;

import java.util.HashMap;
import java.util.Map;
import org.example.domain.menu.Beverage;
import org.example.domain.menu.CustomOption;

public class SingleUseDecorator extends BeverageDecorator {

    private final CustomOption customOption;

    public SingleUseDecorator(Beverage beverage, CustomOption customOption) {
        super(beverage);
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
        if(options.containsKey(customOption))throw new IllegalArgumentException("[ERROR] Custom Option already exists");
        options.put(this.customOption, 1);
        return options;
    }

    @Override
    public int getTotalPrice() {
        int existingPrice = super.getTotalPrice();

        int shotPrice = this.customOption.getExtraPrice();

        return existingPrice + shotPrice;
    }
}
