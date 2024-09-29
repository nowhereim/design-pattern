package decorater.thwany;

public class ThwanyPizza {
    public static void main(String[] args) {
       Pizza pizza = new MonsterPizza();
         System.out.println(pizza.getDescription() + " : " + pizza.cost() + "원");
            pizza = new Cheeze(pizza);
            pizza = new Pepperoni(pizza);
            System.out.println(pizza.getDescription() + " : " + pizza.cost() + "원");
    }
}
