package sos.haruhi.actor;

import akka.actor.Actor$;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class UseHollywoodActor {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HollywoodSystem");
        ActorRef johnnyDepp = system.actorOf(Props.create(HollywoodActor.class), "johnnyDepp");
        johnnyDepp.tell(HollywoodActor);
    }
}
