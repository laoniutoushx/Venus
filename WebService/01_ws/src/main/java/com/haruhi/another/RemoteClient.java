package com.haruhi.another;

import com.haruhi.com.haruhi.other.IMathService;
import com.haruhi.com.haruhi.other.MathServiceImplService;

public class RemoteClient {
    public static void main(String[] args) {
        IMathService service = new MathServiceImplService().getMathServiceImplPort();
        System.out.println(service.sum(1253, 55));
    }
}
