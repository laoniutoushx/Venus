package State.Lisp.StateImpl;

import State.Lisp.Context;
import State.Lisp.LiftState;

public class OpenningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯门打开...");
    }

    @Override
    public void close() {
        // 修改状态
        super.context.setLiftState(Context.closingState);
        // 动作委托 CloseState 来执行
        super.context.getLiftState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
