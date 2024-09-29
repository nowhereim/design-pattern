package decorater.thwany;

public class Olive extends CondimentDecorator {
    @Override
    public String getDescription() {
        return "올리브 추가";
    }

    @Override
    public double cost() {
        return this.pizza.cost() + 1.0;
    }
}
