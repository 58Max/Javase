package code.style;

public interface BMOFactory {
    public  BMO productBMO();
}
class BMOFactory3 implements  BMOFactory{
    @Override
    public BMO productBMO() {
        System.out.println("生产宝马3系车");
        return new BMO3();
    }
}

class  BMOFactory5 implements BMOFactory{
    @Override
    public BMO productBMO() {
        System.out.println("生产宝马5系车");
        return new BMO5();
    }
}
class BMOFactory7 implements  BMOFactory{
    @Override
    public BMO productBMO() {
        System.out.println("生产宝马7系车");
        return new BMO7();
    }
}
