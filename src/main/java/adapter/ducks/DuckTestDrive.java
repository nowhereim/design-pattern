package adapter.ducks;

import adapter.ducks.challenge.Drone;
import adapter.ducks.challenge.DroneAdapter;
import adapter.ducks.challenge.SuperDrone;

public class DuckTestDrive  {
	public static void main(String[] args) {
		Duck duck = new MallardDuck();

		Turkey turkey = new WildTurkey();
		//오리와 칠면조를 연결하는 어댑터 생성 원래 칠면조는 오리와 호환되지 않음
		Duck turkeyAdapter = new TurkeyAdapter(turkey);

		System.out.println("찰면조가 말하기를...");
		turkey.gobble();
		turkey.fly();

		System.out.println("\n오리가 말하기를...");
		testDuck(duck);

		System.out.println("\n칠면조어댑터가 말하기를...");
		testDuck(turkeyAdapter);
		
		// Challenge
//		Drone drone = new SuperDrone();
//		Duck droneAdapter = new DroneAdapter(drone);
//		testDuck(droneAdapter);
	}

	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}

/**
 * 가장 핵심은 호환되지 않는 인터페이스를 사용하는 객체를 어댑터를 통해 호환되는 인터페이스로 변환하는 것이다.
 * 즉 클라이언트가 사용하려는 인터페이스가 현재 구상된 인터페이스와 다를 때 어댑터를 사용하여 호환되는 인터페이스로 변환한다.
 * 이러면 어댑터에 변경내용이 캡슐화되기 때문에 클라이언트와 구상된 인터페이스 사이의 결합도를 낮출 수 있다. 이게 핵심이다.
 *
 *
 */