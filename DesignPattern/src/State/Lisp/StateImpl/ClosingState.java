package State.Lisp.StateImpl;

import State.Lisp.LispContext;
import State.Lisp.LiftState;

public class ClosingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(LispContext.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    @Override
    public void run() {
        super.context.setLiftState(LispContext.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(LispContext.stoppingState);
        super.context.getLiftState().stop();
    }
}
