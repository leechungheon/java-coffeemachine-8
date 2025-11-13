package org.example.domain.menu;

public enum SizeOption {
    REGULAR(1, "Regular", 0),
    LARGE(2, "Large", 500),
    VENTI(3, "Venti", 1000);

    private final int code;
    private final String displayName;
    private final int extraPrice;

    SizeOption(int code, String displayName, int extraPrice) {
        this.code = code;
        this.displayName = displayName;
        this.extraPrice = extraPrice;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getExtraPrice() {
        return extraPrice;
    }

    public static SizeOption getSizeOptionByCode(int code) {
        for(SizeOption option : SizeOption.values()) {
            if(option.code == code) {
                return option;
            }
        }
        throw new IllegalArgumentException("[ERROR]Invalid code " + code);
    }
}