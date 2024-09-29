package decorater.starbuzz;

// 콘크리트 컴포넌트 클래스
public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

