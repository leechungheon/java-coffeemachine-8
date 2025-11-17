package org.example.view.io;
import java.util.Map;
import org.example.domain.menu.*;

public class OutputHandler {
    public void menuDisplay(){
        System.out.println("(필수)메뉴를 선택하세요.");
        int index=1;
        for (MainMenu menu : MainMenu.values()) {

            System.out.printf(
                    "%d. %s (%d원)\n",
                    index++,
                    menu.getDisplayName(),
                    menu.getPrice()
            );
        }
    }

    public void sizeOptionDisplay(){
        System.out.println("(필수)사이즈를 선택하세요.");
        int index=1;
        for (SizeOption option : SizeOption.values()) {

            System.out.printf(
                    "%d. %s (%d원)\n",
                    index++,
                    option.getDisplayName(),
                    option.getExtraPrice()
            );
        }
    }

    public void customOptionDisplay(){
        System.out.println("(선택)옵션을 선택하세요.");
        int index=1;
        for (CustomOption option : CustomOption.values()) {

            System.out.printf(
                    "%d. %s (%d원)\n",
                    index++,
                    option.getDisplayName(),
                    option.getExtraPrice()
            );
        }
        System.out.println("7. 다음");
    }

    public void receiptDisplay(Beverage beverage){
        receiptHeader();
        receiptOptionDisplay(beverage);
        receiptBaseCoffeeDisplay(beverage);
        receiptTotalPriceDisplay(beverage);
    }

    private void receiptHeader(){
        System.out.println("=".repeat(40));
        System.out.println("        ☕️ C O F F E E   R E C E I P T ☕️");
        System.out.println("=".repeat(40));

        System.out.printf("%-25s %7s %7s\n", "상품 / 옵션", "수량", "금액");
        System.out.println("-".repeat(40));
    }

    private void receiptOptionDisplay(Beverage beverage){
        Map<CustomOption, Integer> options = beverage.getOptions();

        for (Map.Entry<CustomOption, Integer> entry : options.entrySet()) {
            CustomOption option = entry.getKey();
            int quantity = entry.getValue();

            int unitPrice = option.getExtraPrice();

            int lineTotal = unitPrice * quantity;

            System.out.printf("%-23s %7d %7d\n", option.getDisplayName(), quantity, lineTotal);
        }
    }

    private void receiptBaseCoffeeDisplay(Beverage beverage){
        String baseName = beverage.getName() + " (" + beverage.getSize() + ")";
        System.out.printf("%-23s %7d %7d\n", baseName, 1, beverage.getBaseBeveragePrice());
    }

    private void receiptTotalPriceDisplay(Beverage beverage){
        System.out.println("=".repeat(40));
        System.out.printf("%-25s %15d 원\n", "총 상품 금액 (Grand Total)", beverage.getTotalPrice());
        System.out.println("=".repeat(40));
    }
}