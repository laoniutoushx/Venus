package sos.haruhi.ws.servlet;

import com.sun.xml.internal.ws.developer.WSBindingProvider;
import org.w3c.dom.Document;
import sos.haruhi.ws.util.WebUtil;
import sos.haruhi.ws.webservice.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@WebServlet(name = "list", urlPatterns = "/list")
public class UserServlet extends HttpServlet {

    private IUserService port = null;
    private UserService userService = null;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");

        userService = new UserService();
        port = userService.getUserServicePort();

        if(method == null || "".equals(method)){
            list(req, resp);
        } else if("add".equals(method)){

            try {
                add(req, resp);
            } catch (JAXBException | ParserConfigurationException e) {
                e.printStackTrace();
            }

        } else if("login".equals(method)){
            login(req, resp);
        } else if("del".equals(method)){
            del(req, resp);
        }
    }


    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", port.list());
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, JAXBException, ParserConfigurationException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");

        WebUtil.addLicenseHeader(port, req);


        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setNickname(nickname);

        try {
            port.add(u);
        } catch (UserException_Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("users", port.list());
        resp.sendRedirect("/list");
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = null;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            u = port.login(username, password);
        } catch (UserException_Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("loginUser", u);
        resp.sendRedirect("/list");
    }
    public void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        port.del(req.getParameter("username"));
        resp.sendRedirect("/list");
    }
}
