package org.example.domain.menu;

public enum MainMenu {
    AMERICANO(1,"아메리카노", 3000, true),
    CAFE_LATTE(2,"카페 라떼", 4000, true),
    CAPPUCCINO(3,"카푸치노", 4500, false),
    CARAMEL_MACCHIATO(4,"카라멜 마끼아또", 5000, true),
    CAFE_MOCHA(5,"카페 모카", 5000, true),
    ESPRESSO(6,"에스프레소", 3000, false),
    CHOCOLATE_LATTE(7,"초코 라떼", 4500, true),
    GREEN_TEA_LATTE(8,"녹차 라떼", 4800, true),
    BLACK_TEA(9,"블랙 티", 3500, true),
    FRESH_JUICE(10,"생과일 주스", 6000, false);
    private final int code;
    private final String displayName;
    private final int price;
    private final boolean isAvailableIced;

    MainMenu(int code, String displayName, int price,  boolean isAvailableIced) {
        this.code = code;
        this.displayName = displayName;
        this.price = price;
        this.isAvailableIced = isAvailableIced;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailableIced() {
        return isAvailableIced;
    }

    public static MainMenu getMainMenuByCode(int code) {
        for(MainMenu mainMenu : MainMenu.values()) {
            if(mainMenu.code == code) {
                return mainMenu;
            }
        }
        throw new IllegalArgumentException("[ERROR]Invalid code " + code);
    }
}