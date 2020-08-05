package code.style;

public interface BMO {
    public void showInfo();
}
class BMO3 implements BMO{

    @Override
    public void showInfo() {
       System.out.println("这是宝马3系车");
    }
}
class BMO5 implements BMO{

    @Override
    public void showInfo() {
        System.out.println("这是宝马5系车");
    }
}
class BMO7 implements BMO{

    @Override
    public void showInfo() {
        System.out.println("这是宝马7系车");
    }
}
