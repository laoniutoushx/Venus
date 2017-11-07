package sos.haruhi.clz;

/**
 * Description sos.haruhi.clz in Venus
 * Created by SuzumiyaHaruhi on 2017/11/5.
 */
public class GetOutClass {
    private int i = 0;
    public class InnerClass{
        public GetOutClass getOutClass(){
            return GetOutClass.this;
        }
    }
    public InnerClass innerClass(){
        return new InnerClass();
    }


    public static void main(String[] args) {
        GetOutClass out = new GetOutClass();
        GetOutClass.InnerClass inner = out.innerClass();
        System.out.println(inner.getOutClass());
        System.out.println(out.new InnerClass());
    }
}
