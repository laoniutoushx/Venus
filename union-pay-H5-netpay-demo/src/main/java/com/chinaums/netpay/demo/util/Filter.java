package com.chinaums.netpay.demo.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description ${PACKAGE_NAME} in Venus
 * Created by SuzumiyaHaruhi on 2017/11/21.
 */
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
