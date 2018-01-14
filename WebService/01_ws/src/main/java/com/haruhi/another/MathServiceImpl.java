package com.haruhi.another;

import javax.jws.WebService;

@WebService(endpointInterface = "com.haruhi.another.IMathService")
public class MathServiceImpl implements IMathService {
    public int sum(int a, int b) {
        return a + b;
    }
}
