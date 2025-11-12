package org.example.domain.menu;

public enum CustomOption {
    EXTRA_SHOT(1, "샷 추가", 500),
    VANILLA_SYRUP(2, "바닐라 시럽 추가", 500),
    HAZELNUT_SYRUP(3, "헤이즐넛 시럽 추가", 500),
    SOY_MILK(4, "두유 변경", 500),
    DECAF(5, "디카페인 변경", 700),
    WHIPPED_CREAM(6, "휘핑 크림 추가", 0);

    private final int id;
    private final String displayName;
    private final int extraPrice;

    CustomOption(int id, String displayName, int extraPrice) {
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