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

    public void paymentMethodDisplay(){
        System.out.println("(필수)결제 방식을 선택하세요.");
        System.out.println("1. 카드 결제");
        System.out.println("2. 페이/간편 결제");
        System.out.println("3. 현금 결제");
    }

    public void confirmOrderDisplay(){
        System.out.println("주문하시겠습니까? (y/n)");
    }

    public void receiptDisplay(Coffee coffee){
        receiptHeader();
        receiptOptionDisplay(coffee);
        receiptBaseCoffeeDisplay(coffee);
        receiptTotalPriceDisplay(coffee);
    }

    private void receiptHeader(){
        System.out.println("=".repeat(40));
        System.out.println("        ☕️ C O F F E E   R E C E I P T ☕️");
        System.out.println("=".repeat(40));

        System.out.printf("%-25s %7s %7s\n", "상품 / 옵션", "수량", "금액");
        System.out.println("-".repeat(40));
    }

    private void receiptOptionDisplay(Coffee coffee){
        Map<CustomOption, Integer> options = coffee.getOptions();

        for (Map.Entry<CustomOption, Integer> entry : options.entrySet()) {
            CustomOption option = entry.getKey();
            int quantity = entry.getValue();

            int unitPrice = option.getExtraPrice();

            int lineTotal = unitPrice * quantity;

            System.out.printf("%-23s %7d %7d\n", option.getDisplayName(), quantity, lineTotal);
        }
    }

    private void receiptBaseCoffeeDisplay(Coffee coffee){
        String baseName = coffee.getName() + " (" + coffee.getSize() + ")";
        System.out.printf("%-23s %7d %7d\n", baseName, 1, coffee.getBaseCoffeePrice());
    }

    private void receiptTotalPriceDisplay(Coffee coffee){
        System.out.println("=".repeat(40));
        System.out.printf("%-25s %15d 원\n", "총 상품 금액 (Grand Total)", coffee.getTotalPrice());
        System.out.println("=".repeat(40));
    }
}