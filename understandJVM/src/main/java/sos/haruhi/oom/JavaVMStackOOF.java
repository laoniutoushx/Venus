package sos.haruhi.oom;

/**
 * VM Args: -Xss2M
 * 可能造成死机
 */
public class JavaVMStackOOF {

//    private void dontStop(){
//        while(true){
//
//        }
//    }
//
//    public void stackLeakByThread(){
//        while (true){
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    dontStop();
//                }
//            });
//            thread.start();
//        }
//    }
//
//    public static void main(String[] args) {
//        JavaVMStackOOF oom = new JavaVMStackOOF();
//        oom.stackLeakByThread();
//    }
}
