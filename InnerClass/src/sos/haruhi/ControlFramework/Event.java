package sos.haruhi.ControlFramework;

/**
 * common method for any control method
 */
public abstract class Event {
    private long eventime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }
    public void start(){
        eventime = System.nanoTime() + this.delayTime;
    }
    public boolean ready(){
        return System.nanoTime() > this.eventime;
    }
    public abstract void action();
    public long getEventime(){
        return this.eventime;
    }
}
