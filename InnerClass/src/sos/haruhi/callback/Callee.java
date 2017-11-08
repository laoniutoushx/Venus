package sos.haruhi.callback;

public class Callee {
    private Incrementable callbackReference;
    Callee(Incrementable cbh){this.callbackReference = cbh;}
    void go(){
        this.callbackReference.increment();
    }
}
