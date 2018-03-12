package State.Lamp;

import State.Lamp.StateImpl.LampOffState;

public class Client {
    public static void main(String[] args) {
        LampContext lampContext = new LampContext();
        lampContext.setLampState(new LampOffState());
        lampContext.on();
        lampContext.off();
    }
}
