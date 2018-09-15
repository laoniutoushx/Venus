package sos.nagato.shiro.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/15 12:04
 * @Version 10032
 **/
@WebServlet(urlPatterns = "/login", name = "loginServlet")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 创建 shiro 用户主题
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);

            resp.sendRedirect("/");


        } catch (UnknownAccountException uae) {
            log.info("There is no user with username of " + token.getPrincipal());
            req.setAttribute("error_msg", uae.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
//            resp.sendRedirect("/error.html?error_msg=" + CodeUtil.encode(uae.getMessage()));
        } catch (IncorrectCredentialsException ice) {
            log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            req.setAttribute("error_msg", ice.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } catch (LockedAccountException lae) {
            log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
            req.setAttribute("error_msg", lae.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            //unexpected condition?  error?
            req.setAttribute("error_msg", ae.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } catch (Exception e){
            log.info("login fail:" + e.getMessage());
            req.setAttribute("error_msg", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
