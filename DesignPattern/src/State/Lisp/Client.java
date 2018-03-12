package State.Lisp;

import State.Lisp.StateImpl.ClosingState;

public class Client {
    public static void main(String[] args) {
        LispContext context = new LispContext();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
        context.open();
    }
}
