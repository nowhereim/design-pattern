package decorater.thwany;

public class Cheeze extends CondimentDecorator {
    public Cheeze(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription()+ ", 치즈 추가";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1.45;
    }
}
