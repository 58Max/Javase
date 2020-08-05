package code.style;

public class SingleLazy {
    private SingleLazy(){}
    private static SingleLazy singleLazy = null;
    public static SingleLazy setSingleLazy(){
        if(singleLazy==null){
            singleLazy = new SingleLazy();
        }
        return singleLazy;
    }
}
