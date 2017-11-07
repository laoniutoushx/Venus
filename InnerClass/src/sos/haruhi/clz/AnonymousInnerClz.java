package sos.haruhi.clz;

/**
 * Description sos.haruhi.clz in Venus
 * Created by SuzumiyaHaruhi on 2017/11/5.
 *  匿名内部类   &   作用域中内部类
 */
public class AnonymousInnerClz {



    public Contents getContents(){
        return new Contents() { // `匿名内部类
            @Override
            public int value() {
                return 222;
            }
        };
    }

    public Destination getDest(String s){
        if(s != null && "h".equals(s)){     // if 作用域 内部类
            class InnerDest implements Destination{
                private String label;
                InnerDest(String label){
                    this.label = label;
                }
                @Override
                public String readLabel() {
                    return this.label;
                }
            }
            return new InnerDest(s);
        }else{
            return new Destination() {         // 匿名内部类 参数

                @Override
                public String readLabel() {
                    return "ijklmn";
                }
            };
        }
    }

    public static void main(String[] args) {
        System.out.println(new AnonymousInnerClz().getContents().value());
        System.out.println(new AnonymousInnerClz().getDest("h").readLabel());
        System.out.println(new AnonymousInnerClz().getDest("a").readLabel());
    }
}
