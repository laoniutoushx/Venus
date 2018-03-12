package State.Lisp.StateImpl;

import State.Lisp.LispContext;
import State.Lisp.LiftState;

public class StoppingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(LispContext.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        super.context.setLiftState(LispContext.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止...");
    }
}
