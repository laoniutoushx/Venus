package sos.haruhi.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>sos.haruhi.servlet</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/6/11 13:32:15
 * @Version v1.0
 */
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("bingo!");
        super.doGet(req, resp);
        //req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
