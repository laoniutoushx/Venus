package sos.haruhi.clz;

/**
 * Description sos.haruhi.clz in Venus
 * Created by SuzumiyaHaruhi on 2017/11/5.
 * 内部类与向上转型
 */
public class InnerClzAndUpCase {
    private class IContents implements Contents{

        @Override
        public int value() {
            return 0;
        }
    }

    protected class IDestination implements Destination{
        private String label;
        private IDestination(String toWhere){
            this.label = toWhere;
        }
        @Override
        public String readLabel() {
            return this.label;
        }
    }

    public IContents getContents(){
        return new IContents();
    }

    public IDestination getDestination(String label){
        return new IDestination(label);
    }
}
