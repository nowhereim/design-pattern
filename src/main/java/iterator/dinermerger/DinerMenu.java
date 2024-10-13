package iterator.dinermerger;

public class DinerMenu implements Menu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		addItem("채식주의자 BLT",
				"(가짜) 베이컨과 양상추 & 토마토를 통밀빵에", true, 2.99);
		addItem("BLT",
				"베이컨과 양상추 & 토마토를 통밀빵에", false, 2.99);
		addItem("오늘의 수프",
				"오늘의 수프와 감자 샐러드 곁들임", false, 3.29);
		addItem("핫도그",
				"사우어크라우트, 렐리쉬, 양파, 치즈가 얹어진 핫도그",
				false, 3.05);
		addItem("찐 채소와 현미",
				"찐 채소를 현미밥 위에 얹음", true, 3.99);
		addItem("파스타",
				"마리나라 소스를 곁들인 스파게티와 사워도우 빵 한 조각",
				true, 3.89);
	}

	public void addItem(String name, String description,
						boolean vegetarian, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("죄송합니다, 메뉴가 가득 찼습니다! 더 이상 메뉴에 항목을 추가할 수 없습니다.");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
		// 교차 메뉴 항목을 테스트하려면 위 줄을 주석 처리하고,
		// 아래 줄의 주석을 해제하세요.
		// return new AlternatingDinerMenuIterator(menuItems);
	}

	// 여기에 다른 메뉴 메서드 추가
}