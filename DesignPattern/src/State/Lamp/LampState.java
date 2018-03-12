package State.Lamp;

public abstract class LampState {

    protected LampContext lampContext;

    public void setLampContext(LampContext _lampContext) {
        this.lampContext = _lampContext;
    }

    public abstract void on();
    public abstract void off();
}
