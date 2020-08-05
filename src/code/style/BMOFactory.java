package code.style;

public interface BMOFactory {
    public  BMO productBMO();
}
class BMOFactory3 implements  BMOFactory{
    @Override
    public BMO productBMO() {
        System.out.println("��������3ϵ��");
        return new BMO3();
    }
}

class  BMOFactory5 implements BMOFactory{
    @Override
    public BMO productBMO() {
        System.out.println("��������5ϵ��");
        return new BMO5();
    }
}
class BMOFactory7 implements  BMOFactory{
    @Override
    public BMO productBMO() {
        System.out.println("��������7ϵ��");
        return new BMO7();
    }
}
