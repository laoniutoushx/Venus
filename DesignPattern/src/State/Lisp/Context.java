package State.Lisp;

import State.Lisp.StateImpl.ClosingState;
import State.Lisp.StateImpl.OpenningState;
import State.Lisp.StateImpl.RunningState;
import State.Lisp.StateImpl.StoppingState;

public class Context {
    // 定义出所有电梯状态
    public final static OpenningState openningState = new OpenningState();

    public final static ClosingState closingState = new ClosingState();

    public final static RunningState runningState = new RunningState();

    public final static StoppingState stoppingState = new StoppingState();

    private LiftState liftState;

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        // 把当前的环境通知到各个实现类中
        this.liftState.setContext(this);
    }

    public LiftState getLiftState() {
        return liftState;
    }

    public void open(){
        this.liftState.open();
    }

    public void close(){
        this.liftState.close();
    }

    public void run(){
        this.liftState.run();
    }

    public void stop(){
        this.liftState.stop();
    }
}
