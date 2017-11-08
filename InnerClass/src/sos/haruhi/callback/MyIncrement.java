package sos.haruhi.callback;

public class MyIncrement {
    public void increment(){
        System.out.println("other operation");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}
