package code.style;

public class SingleHunger {
    private SingleHunger(){}
    private static SingleHunger  singleHunger = new SingleHunger();
    public static SingleHunger setSingleHunger(){
        return singleHunger;
    }
}
