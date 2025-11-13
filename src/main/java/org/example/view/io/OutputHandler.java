package org.example.view.io;
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

    public void receiptDisplay(){
        // 영수증 출력
    }
}