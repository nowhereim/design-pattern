package iterator.dinermerger;

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
 
//	public void printVegetarianMenu() {
//		printVegetarianMenu(pancakeHouseMenu.createIterator());
//		printVegetarianMenu(dinerMenu.createIterator());
//	}
//
//	public boolean isItemVegetarian(String name) {
//		Iterator breakfastIterator = pancakeHouseMenu.createIterator();
//		if (isVegetarian(name, breakfastIterator)) {
//			return true;
//		}
//		Iterator dinnerIterator = dinerMenu.createIterator();
//		if (isVegetarian(name, dinnerIterator)) {
//			return true;
//		}
//		return false;
//	}


//	private void printVegetarianMenu(Iterator iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = iterator.next();
//			if (menuItem.isVegetarian()) {
//				System.out.print(menuItem.getName());
//				System.out.println("\t\t" + menuItem.getPrice());
//				System.out.println("\t" + menuItem.getDescription());
//			}
//		}
//	}
//
//	private boolean isVegetarian(String name, Iterator iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = iterator.next();
//			if (menuItem.getName().equals(name)) {
//				if (menuItem.isVegetarian()) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
}
