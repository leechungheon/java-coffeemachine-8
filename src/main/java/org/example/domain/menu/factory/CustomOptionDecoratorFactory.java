package org.example.domain.menu.factory;

import org.example.domain.menu.product.Beverage;
import org.example.domain.menu.CustomOption;
import org.example.domain.menu.decorator.ExtraShotDecorator;
import org.example.domain.menu.decorator.SingleUseDecorator;
import org.example.domain.menu.decorator.SyrupDecorator;

public class CustomOptionDecoratorFactory {

    public static Beverage createDecorator(Beverage beverage, CustomOption customOption) {
        switch (customOption) {
            case EXTRA_SHOT:
                return new ExtraShotDecorator(beverage, customOption);
            case VANILLA_SYRUP, HAZELNUT_SYRUP:
                return new SyrupDecorator(beverage, customOption);
            case SOY_MILK, DECAF, WHIPPED_CREAM:
                return new SingleUseDecorator(beverage, customOption);
            default:
                return beverage;
        }
    }
}
