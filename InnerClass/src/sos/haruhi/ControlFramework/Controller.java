package sos.haruhi.ControlFramework;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Controller {
    private List<Event> events = new ArrayList<>();
    public Controller(){}
    public Event addEvent(Event event){
        this.events.add(event);
        return event;
    }
    public void run(){
        while(this.events.size() > 0){
            for(Event e:new ArrayList<Event>(this.events)){
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    events.remove(e);
                }
            }
        }
    }
}
