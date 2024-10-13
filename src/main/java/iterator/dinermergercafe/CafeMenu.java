package iterator.dinermergercafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu implements Menu {
	HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

	public CafeMenu() {
		addItem("채식 버거와 에어 프라이",
				"통밀 번에 채식 버거, 양상추, 토마토, 그리고 감자튀김",
				true, 3.99);
		addItem("오늘의 수프",
				"샐러드가 곁들여진 오늘의 수프 한 컵",
				false, 3.69);
		addItem("부리또",
				"통 핀토콩, 살사, 아보카도를 곁들인 큰 부리또",
				true, 4.29);
	}

	public void addItem(String name, String description,
						boolean vegetarian, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(name, menuItem);
	}

	public Map<String, MenuItem> getItems() {
		return menuItems;
	}

	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}