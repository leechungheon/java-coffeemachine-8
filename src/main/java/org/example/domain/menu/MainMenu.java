package org.example.domain.menu;

public enum MainMenu {
    AMERICANO(1,"아메리카노", 3000, DrinkType.COFFEE),
    CAFE_LATTE(2,"카페 라떼", 4000, DrinkType.COFFEE),
    CAPPUCCINO(3,"카푸치노", 4500, DrinkType.COFFEE),
    CARAMEL_MACCHIATO(4,"카라멜 마끼아또", 5000, DrinkType.COFFEE),
    CAFE_MOCHA(5,"카페 모카", 5000, DrinkType.COFFEE),
    ESPRESSO(6,"에스프레소", 3000, DrinkType.COFFEE);
    private final int code;
    private final String displayName;
    private final int price;
    private final DrinkType drinkType;

    MainMenu(int code, String displayName, int price,  DrinkType drinkType) {
        this.code = code;
        this.displayName = displayName;
        this.price = price;
        this.drinkType = drinkType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public static MainMenu getMainMenuByCode(int code) {
        for(MainMenu mainMenu : MainMenu.values()) {
            if(mainMenu.code == code) {
                return mainMenu;
            }
        }
        throw new IllegalArgumentException("[ERROR] Invalid code " + code);
    }
}