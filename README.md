
# ☕ Java Coffee Machine (Design Pattern Practice)

> **디자인 패턴을 활용하여 설계한 확장 가능한 커피 주문 시스템** > 우아한테크코스 프리코스 학습 내용을 바탕으로, 객체 지향 원칙(SOLID)과 다양한 디자인 패턴을 실제 비즈니스 로직에 적용해본 프로젝트입니다.

<br>

## 📖 프로젝트 소개

단순한 콘솔 기반의 커피 주문 애플리케이션처럼 보이지만, 내부적으로는 **변경에 유연하고 확장에 열려 있는 구조**를 지향합니다.
옵션(샷, 시럽 등)이 늘어날 때 발생하는 '클래스 폭발' 문제나, 객체 생성의 복잡성 문제를 해결하기 위해 **데코레이터, 팩토리 메서드, 템플릿 메서드, 퍼사드 패턴** 등을 적재적소에 활용했습니다.

<br>

## 🛠️ 기술 스택 (Tech Stack)

- **Language:** Java 21
- **Build Tool:** Gradle
- **IDE:** IntelliJ IDEA
- **Version Control:** Git / GitHub

<br>

## 🏗️ 아키텍처 및 적용된 디자인 패턴 (Key Design Patterns)

이 프로젝트의 핵심은 **"왜 이 패턴을 사용했는가?"**에 대한 고민과 해결 과정입니다.

| 패턴 (Pattern) | 적용 위치 (Location) | 도입 이유 및 해결한 문제 (Why & Solution) |
| :--- | :--- | :--- |
| **Decorator** | `CoffeeDecorator`<br>`ExtraShotDecorator`<br>`SyrupDecorator` | **클래스 폭발(Class Explosion) 해결**<br>상속만으로 모든 옵션 조합(예: 샷추가라떼, 시럽추가아메리카노..)을 구현할 수 없어, 객체를 동적으로 감싸 기능을 확장하는 방식을 채택했습니다. **방어적 복사**를 통해 원본 객체의 불변성을 유지하며 옵션을 누적합니다. |
| **Factory Method** | `CoffeeFactory`<br>`EspressoDrinkFactory`<br>`LatteDrinkFactory` | **생성과 사용의 분리 (OCP 준수)**<br>클라이언트(`Main`)가 구체적인 클래스를 직접 알지 못하게 하고, 제조 방식(에스프레소 계열 vs 라떼 계열)에 따라 객체 생성 책임을 서브 클래스로 분리했습니다. |
| **Template Method** | `CoffeeFactory.orderCoffee()` | **알고리즘 구조의 재사용**<br>주문의 공통 흐름(로깅 -> 생성 -> 검증)은 상위 클래스에서 `final`로 고정하고, 실제 객체 생성(`createCoffeeProduct`)만 하위 클래스에 위임하여 중복 코드를 제거했습니다. |
| **Simple Factory** | `MenuFactorySelector` | **객체 선택 로직의 캡슐화**<br>사용자의 메뉴 입력값에 따라 적절한 `Factory` 구현체를 선택하여 반환하는 역할을 담당합니다. |
| **Facade** | `OutputHandler.receiptDisplay()` | **복잡성 은닉**<br>데코레이터 패턴 특성상 최종 가격만 남고 상세 내역이 숨겨지는 문제를 해결하기 위해, 가격 역산 및 복잡한 출력 로직을 퍼사드 뒤로 숨기고 클라이언트는 단순한 인터페이스만 호출하도록 설계했습니다. |
| **Composition** | `BasicCoffee` | **상속보다는 합성**<br>메뉴별로 클래스를 계속 생성하는 비효율을 막기 위해, `MainMenu` Enum(데이터)을 주입받는 단일 `BasicCoffee` 클래스로 통합했습니다. |

<br>

## 📂 디렉토리 구조 (Directory Structure)

```text
src
└── main
    └── java
        └── org.example
            ├── Main.java                 # 프로그램 진입점
            ├── domain
            │   └── menu                  # 핵심 도메인 패키지
            │       ├── controller        # 애플리케이션 로직 제어
            │       │   └── CoffeeShopApplication.java
            │       │
            │       ├── decorator         # 데코레이터 패턴 (옵션 추가)
            │       │   ├── BeverageDecorator.java  # Decorator 추상 클래스
            │       │   ├── ExtraShotDecorator.java
            │       │   ├── SingleUseDecorator.java # (일회용 컵 등)
            │       │   └── SyrupDecorator.java
            │       │
            │       ├── factory           # 팩토리 패턴 (객체 생성)
            │       │   ├── BeverageMachine.java    # 추상 팩토리
            │       │   ├── BlenderMachine.java     # (Non-Coffee 생성)
            │       │   ├── CoffeeMachine.java      # (Coffee 생성)
            │       │   ├── CustomOptionDecoratorFactory.java # 옵션 적용 팩토리
            │       │   └── MenuFactorySelector.java # 팩토리 선택자 (Simple Factory)
            │       │
            │       ├── product           # 제품 구현체
            │       │   ├── Beverage.java           # 최상위 인터페이스
            │       │   ├── BasicCoffee.java        # 기본 커피 구현체
            │       │   └── BasicNonCoffee.java     # 기본 음료(주스 등) 구현체
            │       │
            │       ├── CustomOption.java # 옵션 데이터 Enum
            │       ├── DrinkType.java    # 음료 타입 Enum (Coffee/Non-Coffee)
            │       ├── MainMenu.java     # 메뉴 데이터 Enum
            │       └── SizeOption.java   # 사이즈 데이터 Enum
            │
            └── view                      # 입출력 처리 (UI)
                ├── InputHandler.java
                └── OutputHandler.java
````

<br>

## 🚀 주요 기능 (Features)

1.  **메뉴 및 사이즈 선택**

    * 사용자는 기본 메뉴와 사이즈(Small, Medium, Large)를 선택합니다.
    * 사이즈에 따라 기본 가격이 변동됩니다.

2.  **동적 옵션 추가 (Dynamic Options)**

    * 원하는 만큼 샷 추가, 시럽 추가(바닐라, 헤이즐넛)가 가능합니다.
    * 데코레이터 패턴을 통해 옵션이 추가될 때마다 가격이 누적되고 설명이 업데이트됩니다.

3.  **영수증 출력**

    * 주문이 완료되면 상세 내역이 포함된 영수증을 출력합니다.
    * 최종 금액에서 옵션 단가를 역추적하여 베이스 음료 가격과 옵션 비용을 분리하여 표시합니다.

<br>

## 💻 실행 방법 (How to Run)

```bash
# Repository Clone
git clone [https://github.com/leechungheon/java-coffeemachine-8.git](https://github.com/leechungheon/java-coffeemachine-8.git)

# Project Directory 이동
cd java-coffeemachine-8

# Application 실행 (Linux/Mac)
./gradlew run

# Application 실행 (Windows)
gradlew run
```

<br>

## 📝 회고 및 배운 점

* **설계의 중요성:** 요구사항 변경(옵션 추가)에 유연하게 대처하기 위해서는 초기 설계 단계에서 올바른 디자인 패턴의 선택이 필수적임을 깨달았습니다.
* **패턴의 Trade-off:** 데코레이터 패턴이 유연함을 주지만, 객체의 정체성(Identity) 확인이나 데이터 추적에는 어려움이 있을 수 있음을 경험하고 이를 Facade와 역산 로직으로 보완했습니다.
* **리팩토링의 즐거움:** 상속으로 인한 강한 결합을 합성(Composition)으로 풀어내고, 문자열 기반의 데이터 처리를 Enum과 Map으로 타입 안전하게 변경하는 과정에서 코드 품질의 향상을 체감했습니다.

-----

© 2024 Lee Chung Heon. All Rights Reserved.

```
```
