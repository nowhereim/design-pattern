package decorater.starbuzz;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		// 콘크리트 컴포넌트 객체 생성
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());

		// 콘크리트 컴포넌트 객체 생성
		Beverage beverage2 = new DarkRoast();
		// 모카 데코레이터 객체 생성
		beverage2 = new Mocha(beverage2);
		// 모카 데코레이터 객체 생성
		beverage2 = new Mocha(beverage2);
		// 휘핑 데코레이터 객체 생성
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
 		// 콘크리트 컴포넌트 객체 생성
		Beverage beverage3 = new HouseBlend();
		// 소이 데코레이터 객체 생성
		beverage3 = new Soy(beverage3);
		// 모카 데코레이터 객체 생성
		beverage3 = new Mocha(beverage3);
		// 휘핑 데코레이터 객체 생성
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() 
				+ " $" + beverage3.cost());
	}
}
