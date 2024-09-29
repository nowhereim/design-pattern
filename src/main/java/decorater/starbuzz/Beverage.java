package decorater.starbuzz;

// 컴포넌트 추상 클래스
public abstract class Beverage {
	String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
}
