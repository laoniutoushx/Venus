package State.Lamp.StateImpl;

import State.Lamp.LampContext;
import State.Lamp.LampState;

public class LampOnState extends LampState {
    @Override
    public void on() {
        System.out.println("开灯......");
    }

    @Override
    public void off() {
        super.lampContext.setLampState(LampContext.lampOffState);
        super.lampContext.getLampState().off();
    }
}
