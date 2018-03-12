package State.Lamp.StateImpl;

import State.Lamp.LampContext;
import State.Lamp.LampState;

public class LampOffState extends LampState {
    @Override
    public void on() {
        super.lampContext.setLampState(LampContext.lampOnState);
        super.lampContext.getLampState().on();
    }

    @Override
    public void off() {
        System.out.println("关灯......");
    }
}
