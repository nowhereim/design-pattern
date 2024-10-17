package iterator.dinermerger;

import java.util.Arrays;
import java.util.List;

public class MenuTestDrive {
	public static void main(String args[]) {
		Menu pancakeHouseMenu = new PancakeHouseMenu();
		Menu dinerMenu = new DinerMenu();

		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

		// 이터레이터를 이용해 메뉴찍기.
		waitress.printMenu();

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
