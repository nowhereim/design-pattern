package decorater.thwany;

public class SuperPizza extends Pizza {

    public SuperPizza() {
        this.description = "슈퍼 피자";
    }
    @Override
    public double cost() {
        return 1.22;
    }
}
