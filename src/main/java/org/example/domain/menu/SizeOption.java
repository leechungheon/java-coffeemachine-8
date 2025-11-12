package org.example.domain.menu;

public enum SizeOption {
    REGULAR(1, "Regular", 0),
    LARGE(2, "Large", 500),
    VENTI(3, "Venti", 1000);

    private final int id;
    private final String displayName;
    private final int extraPrice;

    SizeOption(int id, String displayName, int extraPrice) {
        this.id = id;
        this.displayName = displayName;
        this.extraPrice = extraPrice;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getExtraPrice() {
        return extraPrice;
    }
}