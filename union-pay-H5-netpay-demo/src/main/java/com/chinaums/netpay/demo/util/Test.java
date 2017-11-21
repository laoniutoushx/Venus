package com.chinaums.netpay.demo.util;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Description com.chinaums.netpay.demo.util in Venus
 * Created by SuzumiyaHaruhi on 2017/11/21.
 */
public class Test extends HttpServlet {
    /**
     * Dispatches client requests to the protected
     * <code>service</code> method. There's no need to
     * override this method.
     *
     * @param req the {@link HttpServletRequest} object that
     *            contains the request the client made of
     *            the servlet
     * @param res the {@link HttpServletResponse} object that
     *            contains the response the servlet returns
     *            to the client
     * @throws IOException      if an input or output error occurs
     *                          while the servlet is handling the
     *                          HTTP request
     * @throws ServletException if the HTTP request cannot
     *                          be handled
     * @see Servlet#service
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
