package iterator.dinermergeri;

public class MenuTestDrive {
	public static void main(String args[]) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		//waitress.printMenu();
		// -- added 12/30/2016
		waitress.printMenu(1);
		// ---
		//waitress.printVegetarianMenu();

		System.out.println("\n고객이 묻습니다, 핫도그는 채식주의자용인가요?");
		System.out.print("웨이트리스가 말합니다: ");
		if (waitress.isItemVegetarian("Hotdog")) {
			System.out.println("예");
		} else {
			System.out.println("아니오");
		}
		System.out.println("\n고객이 묻습니다, 와플은 채식주의자용인가요?");
		System.out.print("웨이트리스가 말합니다: ");
		if (waitress.isItemVegetarian("Waffles")) {
			System.out.println("예");
		} else {
			System.out.println("아니오");
		}

	}
}