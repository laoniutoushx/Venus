package sos.haruhi.actor;

import akka.actor.UntypedActor;

public class HollywoodActor extends UntypedActor {

    @Override
    public void onReceive(final Object role) throws Throwable {
        System.out.println("Playing " + role +
                " from Thread " + Thread.currentThread().getName());
    }
}
