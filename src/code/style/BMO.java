package code.style;

public interface BMO {
    public void showInfo();
}
class BMO3 implements BMO{

    @Override
    public void showInfo() {
       System.out.println("���Ǳ���3ϵ��");
    }
}
class BMO5 implements BMO{

    @Override
    public void showInfo() {
        System.out.println("���Ǳ���5ϵ��");
    }
}
class BMO7 implements BMO{

    @Override
    public void showInfo() {
        System.out.println("���Ǳ���7ϵ��");
    }
}
