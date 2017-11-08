package sos.haruhi.callback;

public class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        System.out.println(i);
        i++;
    }
}
