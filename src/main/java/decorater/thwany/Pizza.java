package decorater.thwany;

public abstract class Pizza {
    public String description = "무슨 피자일까요?";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
