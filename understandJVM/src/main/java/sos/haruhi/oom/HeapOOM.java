package sos.haruhi.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {

    }

    /**
     * heap oom
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
//        List list = new ArrayList();

        while(true){
            list.add(new OOMObject());
        }
    }
}
