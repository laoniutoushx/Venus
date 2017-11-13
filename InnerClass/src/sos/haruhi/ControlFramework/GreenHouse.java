package sos.haruhi.ControlFramework;

/**
 * Description sos.haruhi.ControlFramework in Venus
 * Created by SuzumiyaHaruhi on 2017/11/12.
 * 温室控制灯光、水分、阳光
 */
public class GreenHouse extends Controller {
    private boolean light = false;
    public class LightOn extends Event{
        public LightOn(long delay){super(delay);}
        @Override
        public void action() {
            GreenHouse.this.light = true;
        }
        @Override
        public String toString() {
            return "light is on";
        }
    }
    public class LightOff extends Event{
        public LightOff(long delay){super(delay);}

        @Override
        public void action() {
            GreenHouse.this.light = false;
        }
        @Override
        public String toString(){
            return "light is off";
        }
    }
    private boolean water = false;
    public class WaterOn extends Event{
        public WaterOn(long delay){super(delay);}
        @Override
        public void action() {
            GreenHouse.this.water = true;
        }
        @Override
        public String toString(){
            return "water is on";
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delay){super(delay);}

        @Override
        public void action() {
            GreenHouse.this.light = true;
        }
        @Override
        public String toString(){
            return "water is off";
        }
    }
    String thermostat = "night";
    public class ThermostatOn extends Event{
        public ThermostatOn(long delay){super(delay);}

        @Override
        public void action() {
            GreenHouse.this.thermostat = "day";
        }
        @Override
        public String toString(){
            return "thermostat on day setting";
        }
    }
    public class ThermostatOff extends Event{
        public ThermostatOff(long delay){super(delay);}

        @Override
        public void action() {
            GreenHouse.this.thermostat = "night";
        }
        @Override
        public String toString(){
            return "thermostat on night setting";
        }
    }
    public class Bell extends Event{
        public Bell(long delay){super(delay);}

        @Override
        public void action() {
            GreenHouse.this.addEvent(new Bell(this.delayTime));
        }
        @Override
        public String toString(){
            return "Bing!";
        }
    }
    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delay, Event[] eventList){
            super(delay);
            this.eventList = eventList;
            for(Event e:eventList){
                GreenHouse.this.addEvent(e);
            }
        }
        @Override
        public void action() {
            for(Event e:eventList){
                e.start();
                GreenHouse.this.addEvent(e);
            }
            this.start();
            GreenHouse.this.addEvent(this);
        }
        public String toString(){
            return "restart system";
        }
    }
    public static class Terminal extends Event{
        public Terminal(long delay){super(delay);}
        @Override
        public void action() {
            System.exit(0);
        }
        public String toString(){
            return "terminaling";
        }
    }
}
