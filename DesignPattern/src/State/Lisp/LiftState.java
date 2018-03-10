package State.Lisp;

/**
 * 生命周期
 * 状态模式
 * 抽象类
 * 定义各个状态
 * 包括环境类 Context
 * 委托实现类 调用 context
 */
public abstract class LiftState {

    protected Context context;
    public void setContext(Context _context){
        this.context = _context;
    }

    public abstract void open();    //  电梯打开

    public abstract void close();   // 电梯关闭

    public abstract void run();     // 电梯运行

    public abstract void stop();    // 电梯停止
}
