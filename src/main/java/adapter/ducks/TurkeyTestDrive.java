package adapter.ducks;

public class TurkeyTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		Turkey duckAdapter = new DuckAdapter(duck);
 
		for(int i=0;i<10;i++) {
			System.out.println("오리어댑터가 말하기를...");
			duckAdapter.gobble();
			duckAdapter.fly();
		}
	}
}
