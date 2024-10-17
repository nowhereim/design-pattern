## 🗂️ Observer Pattern
<details>
<summary> view </summary>

# 옵저버 패턴 (Observer Design Pattern)

## 📖 정의

**옵저버 패턴**은 객체의 상태 변화를 구독자에게 자동으로 통지하는 디자인 패턴이다. 이 패턴은 발행자(Subject)가 상태 변경 시 구독자(Observer)에게 알림을 전달하여, 상태 변화에 반응하는 동작을 구현한다.

### 예시
유튜브 채널 구독처럼, 구독자는 채널의 새로운 영상(상태 변화)을 알림으로 받아보게 된다.

## 🔧 주요 구성 요소

1. **발행자(Subject)**: 상태 변화를 감지하고 구독자에게 알림을 전달.
2. **구독자(Observer)**: 알림을 받고 그에 따른 동작을 수행.

### 예시 코드 (Java)
```java
// Subject 인터페이스
interface ISubject {
    void addObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers();
}

// 구체적 발행자
class ConcreteSubject implements ISubject {
    List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver o) {
        observers.add(o);
    }

    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update();
        }
    }
}

// Observer 인터페이스
interface IObserver {
    void update();
}

// ObserverA 클래스
class ObserverA implements IObserver {
    public void update() {
        System.out.println("ObserverA가 알림을 받았습니다.");
    }
}

// ObserverB 클래스
class ObserverB implements IObserver {
    public void update() {
        System.out.println("ObserverB가 알림을 받았습니다.");
    }
}
```
🔄 플로우

	1.	발행자(Subject)가 상태를 변경.
	2.	등록된 구독자(Observer)에게 상태 변경을 알림.
	3.	구독자는 알림을 받고 적절한 동작을 수행.

- 복잡하고 확장이 많이 되야할 경우는 반대로 옵저버가 필요한 속성을 요청할 수 있다.

🔍 패턴 사용 사례

	•	java.util.Observer 및 Observable 클래스 ( java 9 이후 Deprecated )
	•	RxJS의 Observable은 옵저버 패턴을 사용해 비동기 데이터 스트림을 처리.
    •       이외 다양한 Listener, Event Handler 내부에서 사용.

📊 장점

	•	상태 변경을 실시간으로 감지하여 효율적 반응.
	•	발행자와 구독자 간의 느슨한 결합으로 확장성 제공.

⚠️ 단점

	•	알림을 받는 순서를 제어할 수 없음.
	•	구독자를 관리하지 않으면 메모리 누수 가능성.
	•	복잡도가 올라갈 경우 디버깅 리소스 증가.
</details>

## 🗂️ Adapter & Facade Pattern
<details>
<summary> view</summary>

# 어댑터 패턴 (Adapter Design Pattern)

## 📖 정의

**어댑터 패턴**은 서로 다른 인터페이스를 가진 클래스들이 함께 동작할 수 있도록 중간에 어댑터 클래스를 끼워 맞추는 디자인 패턴이다. 클라이언트가 기대하는 인터페이스와 기존의 클래스(어댑티)가 일치하지 않을 때, 어댑터가 중재하여 둘을 호환시킨다.

### 예시
미국형 전원 플러그를 유럽형 소켓에 맞추기 위해 전기 어댑터를 사용하는 것과 같다.

## 🔧 주요 구성 요소

1. **타깃(Target)**: 클라이언트가 사용하려는 인터페이스.
2. **어댑티(Adaptee)**: 기존 클래스, 클라이언트가 바로 사용할 수 없는 객체.
3. **어댑터(Adapter)**: 타깃 인터페이스를 구현하고, 내부에서 어댑티의 기능을 호출하여 변환.

### 예시 코드 (Java)
```java
// 타깃 인터페이스
interface Target {
    void request();
}

// 어댑티 클래스
class Adaptee {
    public void specificRequest() {
        System.out.println("어댑티의 요청 처리");
    }
}

// 어댑터 클래스
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest(); // 어댑티의 메서드를 호출
    }
}
```
## 🔄 플로우
```
1. 클라이언트는 타깃 인터페이스를 통해 메서드 호출.
2. 어댑터는 타깃 인터페이스를 구현하여 어댑티의 메서드를 호출.
3. 어댑티의 기능을 변환하여 클라이언트에게 제공.
```

## 🔍 패턴 사용 사례
```
•	자바 IO 스트림에서 InputStreamReader는 바이트 스트림을 문자 스트림으로 변환하는 어댑터 패턴을 사용.
•	외부 라이브러리의 API가 클라이언트 코드와 맞지 않을 때 어댑터 사용.
```

## 📊 장점
```
•	기존 코드를 수정하지 않고 새 시스템과 통합 가능.
•	클라이언트와 어댑티 간의 결합도를 낮출 수 있음.
```

## ⚠️ 단점
```
•	어댑터 클래스가 많아지면 코드 복잡도 증가.
•	어댑터 클래스가 많아지면 유지보수가 어려워질 수 있음.
```

# 파사드 패턴 (Facade Design Pattern)

## 📖 정의

파사드 패턴은 복잡한 서브시스템에 대한 간단한 인터페이스를 제공하여, 클라이언트가 서브시스템의 내부 세부 사항을 몰라도 쉽게 사용할 수 있게 하는 디자인 패턴이다. 여러 복잡한 클래스나 메서드를 하나의 간단한 인터페이스로 감싸서 사용을 단순화한다.

예시

호텔의 리셉션 데스크가 여러 부서(청소, 룸 서비스, 안내)를 대신하여 요청을 처리해 주는 것과 같다.

## 🔧 주요 구성 요소

1.	파사드(Facade): 클라이언트가 사용하기 위한 간단한 인터페이스를 제공.
2.	서브시스템(Subsystems): 파사드가 간단한 인터페이스로 감싸고 있는 실제 시스템의 복잡한 구성 요소들.

예시 코드 (Java)
```java
class Amplifier {
    public void on() { System.out.println("Amplifier on"); }
    public void off() { System.out.println("Amplifier off"); }
}

class DVDPlayer {
    public void play() { System.out.println("DVD playing"); }
    public void stop() { System.out.println("DVD stopped"); }
}

// 파사드 클래스
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd) {
        this.amp = amp;
        this.dvd = dvd;
    }

    public void watchMovie() {
        amp.on();
        dvd.play();
    }

    public void endMovie() {
        dvd.stop();
        amp.off();
    }
}
```
## 🔄 플로우
```
1. 클라이언트는 파사드의 간단한 메서드를 호출.
2. 파사드는 여러 서브시스템의 복잡한 메서드들을 호출하여 동작을 처리.
3. 클라이언트는 서브시스템의 내부 동작을 알 필요 없이 간단한 인터페이스만 사용.
```
## 🔍 패턴 사용 사례
```
•	스프링 프레임워크에서 JdbcTemplate은 복잡한 JDBC 코드들을 감싸 간단한 인터페이스로 제공.
•	WAS에서 클라이언트 요청을 처리하기 위해 여러 서브시스템을 사용하는 경우 파사드 패턴 사용.
```
## 📊 장점
```
•	복잡한 서브시스템을 간단하게 사용할 수 있어 클라이언트 코드를 단순화.
•	서브시스템과 클라이언트 간의 결합도를 낮춰 유지보수성 향상.
```
## ⚠️ 단점
```
•	지나치게 단순화 하려다 보면 파사드 클래스가 지나치게 비대해질 수 있음을 주의.
```

</details>

## 🗂️ Iterator & Composite Pattern
<details>
<summary> view </summary>

# 반복자 패턴 (Iterator Design Pattern)

## 📖 정의

**반복자 패턴**은 컬렉션(집합체) 내의 요소들을 순차적으로 접근할 수 있도록 해주는 디자인 패턴이다. 이 패턴은 내부 구현 방식을 노출하지 않고도 집합체의 모든 요소를 탐색할 수 있게 한다.

### 예시코드

```java
package iterator.dinermerger;

import java.util.Arrays;
import java.util.List;

public class MenuTestDrive {
	public static void main(String args[]) {
		Menu pancakeHouseMenu = new PancakeHouseMenu();
		Menu dinerMenu = new DinerMenu();

		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

		// 이터레이터를 이용해 메뉴찍기.
//		waitress.printMenu();

		printMenus();
	}

	/*
	 * 웨이트리스가 없다면..? ( 반복자 패턴 안쓸때는 아래와같이 개판 난리 )
	 */
	public static void printMenus() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();

		List<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
		MenuItem[] lunchItems = dinerMenu.getMenuItems();

		// print as Iterable
		printMenu(breakfastItems);
		printMenu(Arrays.asList(lunchItems));

		// print with forEach
		System.out.println("=== forEach ===");
		breakfastItems.forEach(item -> System.out.println(item));
		Arrays.asList(lunchItems).forEach(item -> System.out.println(item));
		System.out.println("=== forEach ===");

		// Using enhanced for loop
		System.out.println("향상된 for문 사용");
		for (MenuItem menuItem : breakfastItems) {
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}
		for (MenuItem menuItem : lunchItems) {
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}

		// Exposing implementation
		System.out.println("일반 for문 사용");
		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = (MenuItem) breakfastItems.get(i);
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}

		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = lunchItems[i];
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}
	}

	public static void printMenu(Iterable<MenuItem> a) {
		for (MenuItem menuItem : a) {
			System.out.print(menuItem.getName());
			System.out.println("\t\t" + menuItem.getPrice());
			System.out.println("\t" + menuItem.getDescription());
		}
	}
}

//반복자 패턴은 타입이 다른 컬렉션들을 하나의 인터페이스로 접근할 수 있게 하여 구체적인 내부 구현체를 노출시키지않는다는 특징이 있다.
// 반복 잡업을 별도로 캡슐화 할 수 있기 때문이다.
//반복자 패턴을 쓰면 반복잡업은 동일한 인터페이스를 적용할 수 있어 다형성을 적극 활용할 수 있게된다.

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
 
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
 
	public void printMenu() {
		//이터레이터 생성
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();

		//이터레이터를 이용해서 프린트.
		System.out.println("MENU\n----\n아침 식사");
		printMenu(pancakeIterator);
		System.out.println("\n점심 식사");
		printMenu(dinerIterator);

	}



	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

```

## 🔧 주요 구성 요소

1. **반복자(Iterator)**: 요소들을 순차적으로 접근하는 인터페이스를 정의한다.
2. **구체적인 반복자(Concrete Iterator)**: 반복자 인터페이스를 구현하여 실제 요소들을 탐색한다.
3. **집합체(Aggregate)**: 반복자를 생성하는 인터페이스를 정의한다.
4. **구체적인 집합체(Concrete Aggregate)**: 집합체 인터페이스를 구현하여 반복자를 반환한다.

🔄 플로우

1. **집합체**는 **반복자**를 생성한다.
2. 클라이언트는 반복자를 사용하여 요소들을 순차적으로 접근한다.
3. 내부 구현 방식에 상관없이 모든 요소를 탐색할 수 있다.

🔍 패턴 사용 사례 ( 자바스크립트 )

- for...of 루프: 배열, 문자열, Map, Set 등 이터러블 객체를 순회할 때 사용.
- 제너레이터 함수: function* 문법을 사용하여 이터레이터 객체를 생성.
- 스프레드 연산자 (...): 이터러블 객체의 요소를 개별 요소로 펼칠 때 사용.
- Map과 Set 컬렉션: 이터러블 인터페이스를 구현하여 요소를 순회.
- 구조 분해 할당: 이터러블 객체의 값을 변수에 할당할 때 활용.
- Promise.all, Promise.race 등: 이터러블 객체를 인수로 받아 여러 프로미스를 동시에 처리.

* 주의: Array.prototype.forEach 는 단순 배열 순회. 이터레이터 X

📊 장점

- **캡슐화 유지**: 컬렉션의 내부 구조를 노출하지 않고도 요소에 접근 가능.
- **일관된 인터페이스 제공**: 다양한 컬렉션 구조에 대해 동일한 방식으로 접근 가능.
- **책임 분리**: 컬렉션과 순회 방법을 분리하여 코드의 유연성 증가.

⚠️ 단점

- **추가 클래스 필요**: 반복자를 위해 별도의 클래스나 인터페이스를 생성해야 함.
- **단방향 순회**: 기본적인 반복자는 단방향으로만 순회가 가능하며, 역순이나 건너뛰기 등이 어려울 수 있음.

# 컴포지트 패턴 (Composite Design Pattern)

## 📖 정의

**컴포지트 패턴**은 객체들을 트리 구조로 구성하여 부분-전체 계층 구조를 표현하는 패턴이다. 이 패턴을 통해 클라이언트가 개별 객체와 객체 그룹을 동일하게 처리할 수 있다.

### 예시코드

```java
//핵심은 개별 객체냐 객체 그룹이냐 상관없이 전부 처리할 수 있다는것!

// 컴포넌트 인터페이스

public abstract class MenuComponent {
   
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
  
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}
  
	public void print() {
		throw new UnsupportedOperationException();
	}
}


// 메뉴
public class Menu extends MenuComponent {
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;
	String description;
  
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
 
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
 
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
 
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
  
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = 
				(MenuComponent)iterator.next();
			menuComponent.print();
		}
	}
}


// 클라이언트 코드

public class MenuTestDrive {
	public static void main(String args[]) {
		MenuComponent pancakeHouseMenu =
				new Menu("팬케이크 하우스 메뉴", "아침 식사");
		MenuComponent dinerMenu =
				new Menu("다이너 메뉴", "점심 식사");
		MenuComponent cafeMenu =
				new Menu("카페 메뉴", "저녁 식사");
		MenuComponent dessertMenu =
				new Menu("디저트 메뉴", "물론 디저트!");
		MenuComponent coffeeMenu = new Menu("커피 메뉴", "오후 커피와 함께하는 메뉴");

		MenuComponent allMenus = new Menu("모든 메뉴", "모든 메뉴 통합");

		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);

		pancakeHouseMenu.add(new MenuItem(
				"K&B 팬케이크 아침 식사",
				"스크램블 에그와 토스트가 곁들여진 팬케이크",
				true,
				2.99));
		pancakeHouseMenu.add(new MenuItem(
				"일반 팬케이크 아침 식사",
				"프라이드 에그와 소시지가 곁들여진 팬케이크",
				false,
				2.99));
		pancakeHouseMenu.add(new MenuItem(
				"블루베리 팬케이크",
				"신선한 블루베리와 블루베리 시럽이 곁들여진 팬케이크",
				true,
				3.49));
		pancakeHouseMenu.add(new MenuItem(
				"와플",
				"블루베리 또는 딸기를 선택할 수 있는 와플",
				true,
				3.59));

		//리프노드 추가 ( 디저트 )
		dinerMenu.add(new MenuItem(
				"채식주의자 BLT",
				"(가짜) 베이컨과 양상추 & 토마토를 통밀빵에",
				true,
				2.99));
		dinerMenu.add(new MenuItem(
				"BLT",
				"베이컨과 양상추 & 토마토를 통밀빵에",
				false,
				2.99));
		dinerMenu.add(new MenuItem(
				"오늘의 수프",
				"감자 샐러드를 곁들인 오늘의 수프 한 그릇",
				false,
				3.29));
		dinerMenu.add(new MenuItem(
				"핫도그",
				"사우어크라우트, 렐리쉬, 양파, 치즈가 얹어진 핫도그",
				false,
				3.05));
		dinerMenu.add(new MenuItem(
				"찐 채소와 현미밥",
				"찐 채소를 현미밥 위에 얹음",
				true,
				3.99));

		dinerMenu.add(new MenuItem(
				"파스타",
				"마리나라 소스를 곁들인 스파게티와 사워도우 빵 한 조각",
				true,
				3.89));

		dinerMenu.add(dessertMenu);

		dessertMenu.add(new MenuItem(
				"애플 파이",
				"바삭한 크러스트가 있는 애플 파이, 바닐라 아이스크림을 얹음",
				true,
				1.59));

		dessertMenu.add(new MenuItem(
				"치즈케이크",
				"뉴욕 스타일의 크리미한 치즈케이크, 초콜릿 그레이엄 크러스트와 함께",
				true,
				1.99));
		dessertMenu.add(new MenuItem(
				"샤베트",
				"라즈베리 한 스쿱과 라임 한 스쿱",
				true,
				1.89));

		cafeMenu.add(new MenuItem(
				"채식 버거와 에어 프라이",
				"통밀 번에 채식 버거, 양상추, 토마토, 그리고 감자튀김",
				true,
				3.99));
		cafeMenu.add(new MenuItem(
				"오늘의 수프",
				"샐러드가 곁들여진 오늘의 수프 한 컵",
				false,
				3.69));
		cafeMenu.add(new MenuItem(
				"부리또",
				"통 핀토콩, 살사, 아보카도를 곁들인 큰 부리또",
				true,
				4.29));

		cafeMenu.add(coffeeMenu);

		coffeeMenu.add(new MenuItem(
				"커피 케이크",
				"계피와 호두가 얹어진 부드러운 케이크",
				true,
				1.59));
		coffeeMenu.add(new MenuItem(
				"베이글",
				"참깨, 양귀비씨, 시나몬 건포도, 호박 맛 포함",
				false,
				0.69));
		coffeeMenu.add(new MenuItem(
				"비스코티",
				"아몬드 또는 헤이즐넛 비스코티 3개",
				true,
				0.89));

		Waitress waitress = new Waitress(allMenus);

		waitress.printMenu();
	}
}

//얘는 개별객체,복합객체를 모두 담을 수 있게된다.
//메뉴는 메뉴와 요소(리프 노드)를 가질 수 있다. ( ex.디너 메뉴 하위에 디저트 메뉴 )
```

## 🔧 주요 구성 요소

1. **컴포넌트(Component)**: 객체들의 인터페이스를 정의하며, 공통된 연산을 선언한다.
2. **잎(Leaf)**: 실제 작업을 수행하는 개별 객체를 나타낸다.
3. **복합체(Composite)**: 자식을 포함하는 복합 객체로, 자식들에 대한 연산을 구현한다.

🔄 플로우

1. 클라이언트는 컴포넌트 인터페이스를 통해 객체에 접근한다.
2. **복합체**는 자식 객체들을 관리하며, 연산을 자식들에게 위임하거나 자체적으로 수행한다.
3. **잎**은 실제 연산을 수행하며, 더 이상 하위 요소가 없다.

🔍 패턴 사용 사례

- **GUI 구성 요소**: 버튼, 패널 등 위젯들을 트리 구조로 관리.
- **그래픽 편집기**: 도형들을 그룹화하여 단일 객체처럼 취급.
- **파일 시스템 구조**: 파일과 디렉토리를 트리 구조로 관리.

📊 장점

- **부분-전체 계층 구조 표현**: 객체들을 트리 형태로 구성하여 구조화.
- **일관된 인터페이스 제공**: 개별 객체와 복합 객체를 동일하게 처리 가능.
- **유연성 향상**: 새로운 컴포넌트 추가 시 기존 코드를 변경할 필요가 적음.

⚠️ 단점

- **설계 복잡도 증가**: 트리 구조를 관리하기 위한 추가 설계 필요.
- **안전성 문제**: 일부 연산은 특정 객체에서만 유효하지만, 모든 객체에 노출될 수 있음.
</details>


## 🗂️ Compound Patterns
<details>
<summary> view</summary>

# 복합 패턴 (Compound Design Patterns)

## 📖 정의

**복합 패턴**은 두 개 이상의 디자인 패턴을 조합하여 일반적인 솔루션보다 더 유연하고 확장 가능한 설계를 만드는 것을 의미한다. 이러한 패턴은 개별 패턴의 강점을 활용하여 복잡한 소프트웨어 구조나 행동을 효과적으로 관리한다.
( 그렇다고 패턴 두개이상 그냥 넣기만 한다고 복합패턴이 되는게 아니라 하나의 로직으로 밀접하게 연결되어 있어야한다. )

### 예시코드

```java
// Observer 인터페이스 (옵저버 패턴 적용)
interface Observer {
    void update();
}

// Subject 인터페이스
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// 모델 클래스
class Model implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String data;

    public void setData(String data) {
        this.data = data;
        notifyObservers();
    }

    public String getData() {
        return data;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

// 뷰 클래스
class View implements Observer {
    private Model model;

    public View(Model model) {
        this.model = model;
        model.registerObserver(this);
    }

    public void display() {
        System.out.println("현재 데이터: " + model.getData());
    }

    public void update() {
        display();
    }
}

// 전략 인터페이스 (전략 패턴 적용)
interface ControllerStrategy {
    void execute(Model model);
}

// 구체적인 전략 클래스
class InputController implements ControllerStrategy {
    public void execute(Model model) {
        // 사용자 입력을 받아 모델 업데이트
        Scanner scanner = new Scanner(System.in);
        System.out.print("데이터를 입력하세요: ");
        String inputData = scanner.nextLine();
        model.setData(inputData);
    }
}

// 컨텍스트 클래스
class Controller {
    private ControllerStrategy strategy;

    public void setStrategy(ControllerStrategy strategy) {
        this.strategy = strategy;
    }

    public void handleInput(Model model) {
        strategy.execute(model);
    }
}

// 메인 클래스
public class MVCPatternDemo {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller();

        controller.setStrategy(new InputController());
        controller.handleInput(model);
    }
}

//전략패턴은 클래스를 캡슐화 하고 확장성을 높인다. 궁금하면 첫 단원 전략패턴 참고.
```

## 🔧 주요 구성 요소

1. **모델(Model)**: 애플리케이션의 데이터와 비즈니스 로직을 관리하며, 옵저버 패턴을 사용하여 뷰에 상태 변화를 알린다.
2. **뷰(View)**: 사용자에게 정보를 표시하며, 모델의 상태를 관찰한다.
3. **컨트롤러(Controller)**: 사용자 입력을 처리하고 모델과 뷰를 업데이트하며, 전략 패턴을 활용하여 행동을 캡슐화한다.

🔄 플로우

1. **컨트롤러**가 사용자 입력을 처리하고 **모델**의 데이터를 변경한다.
2. **모델**은 상태 변화가 발생하면 **옵저버 패턴**을 통해 **뷰**에게 알린다.
3. **뷰**는 **모델**의 새로운 상태를 표시한다.

🔍 패턴 사용 사례

- **MVC 프레임워크**: 스프링 MVC, 장고, 루비 온 레일즈 등에서 사용.
- **GUI 애플리케이션**: 여러 패턴을 조합하여 복잡한 사용자 인터페이스 구현.
- **시뮬레이션 시스템**: 전략 패턴과 옵저버 패턴을 조합하여 유연한 시스템 설계.

📊 장점

- **유연성 향상**: 여러 패턴의 장점을 결합하여 더 강력한 설계 가능.
- **재사용성 증가**: 코드의 모듈화로 인해 재사용 및 유지보수가 용이.
- **확장성 제공**: 시스템 변경 시 영향 범위를 최소화하여 확장에 유리.

⚠️ 단점

- **복잡도 증가**: 여러 패턴을 조합함으로써 구조가 복잡해질 수 있음.
- **학습 곡선**: 팀원이 여러 패턴의 조합을 이해하는 데 시간이 필요할 수 있음.
- **디버깅 어려움**: 패턴 간의 상호작용으로 인해 문제 원인 파악이 어려울 수 있음.

</details>