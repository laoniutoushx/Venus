package sos.haruhi.callback;

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Callee callee1 = new Callee(c1);
        Callee callee2 = new Callee(c2.getCallback());
        callee1.go();
//        callee1.go();
//        callee2.go();
        callee2.go();
    }
}
