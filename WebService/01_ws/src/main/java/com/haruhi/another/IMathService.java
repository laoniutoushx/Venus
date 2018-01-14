package com.haruhi.another;

import javax.jws.WebService;

@WebService
public interface IMathService {
    int sum(int a, int b);
}
