package State.Lamp;

import State.Lamp.StateImpl.LampOffState;
import State.Lamp.StateImpl.LampOnState;

public class LampContext {


    public final static LampOffState lampOffState = new LampOffState();
    public final static LampOnState lampOnState = new LampOnState();


    private LampState lampState;

    public LampState getLampState() {
        return lampState;
    }

    public void setLampState(LampState lampState) {
        this.lampState = lampState;
        this.lampState.setLampContext(this);
    }


    public void on(){
        this.lampState.on();
    }
    public void off(){
        this.lampState.off();
    }

}
