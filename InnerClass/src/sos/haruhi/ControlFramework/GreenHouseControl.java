package sos.haruhi.ControlFramework;

/**
 * Description sos.haruhi.ControlFramework in Venus
 * Created by SuzumiyaHaruhi on 2017/11/12.
 */
public class GreenHouseControl {
    public static void main(String[] args) {
        GreenHouse gh = new GreenHouse();
        gh.addEvent(gh.new Bell(900));
        Event[] eventList = {
            gh.new ThermostatOff(0),
            gh.new LightOn(200),
            gh.new LightOff(400),
            gh.new WaterOn(600),
            gh.new WaterOff(800),
            gh.new ThermostatOn(1400)
        };
        gh.addEvent(gh.new Restart(2000, eventList));
        //if(args.length == 1){
            gh.addEvent(new GreenHouse.Terminal(1000000000));
        //}5
        gh.run();
    }
}
