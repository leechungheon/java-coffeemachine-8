package org.example.domain.menu.factory;

import org.example.domain.menu.Beverage;
import org.example.domain.menu.CustomOption;
import org.example.domain.menu.decorator.ExtraShotDecorator;
import org.example.domain.menu.decorator.SyrupDecorator;

public class CustomOptionDecoratorFactory {

    public static Beverage createDecorator(Beverage beverage, CustomOption customOption) {
        switch (customOption) {
            case EXTRA_SHOT:
                return new ExtraShotDecorator(beverage, customOption);
            case VANILLA_SYRUP:
                return new SyrupDecorator(beverage, customOption);
            case HAZELNUT_SYRUP:
                return new SyrupDecorator(beverage, customOption);
            case SOY_MILK:
                return new SyrupDecorator(beverage, customOption);
            case DECAF:
                return new SyrupDecorator(beverage, customOption);
            case WHIPPED_CREAM:
                return new SyrupDecorator(beverage, customOption);
            default:
                return beverage;
        }
    }
}
