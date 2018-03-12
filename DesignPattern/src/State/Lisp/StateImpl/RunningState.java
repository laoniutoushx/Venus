package State.Lisp.StateImpl;

import State.Lisp.LispContext;
import State.Lisp.LiftState;

public class RunningState extends LiftState {
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯运行中...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(LispContext.stoppingState);
        super.context.getLiftState().stop();
    }
}
