package sos.haruhi.callback;

public class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment(){
        super.increment();
        System.out.println(i);
        i++;
    }
    private class Closure implements Incrementable{

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallback(){
        return new Closure();
    }
}
