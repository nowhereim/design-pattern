package decorater.thwany;

public class MonsterPizza extends Pizza {
    public MonsterPizza(){
        this.description = "몬스터 피자";
    };


    @Override
    public double cost() {
        return 9.99;
    }
}
