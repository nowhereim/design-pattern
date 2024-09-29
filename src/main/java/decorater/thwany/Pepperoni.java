package decorater.thwany;

public class Pepperoni extends CondimentDecorator {
    public Pepperoni(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", 페퍼로니 추가";
    }

    @Override
    public double cost() {
        return pizza.cost() + 3.1;
    }
}
