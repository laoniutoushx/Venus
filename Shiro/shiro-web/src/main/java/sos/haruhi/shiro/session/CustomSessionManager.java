package sos.haruhi.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * @ClassName CustomSessionManager
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/10/11 21:05
 * @Version 10032
 **/
public class CustomSessionManager extends DefaultWebSessionManager {
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;

        if(sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }
        if(request != null && sessionId != null){
            Session session = (Session) request.getAttribute(sessionId.toString());
            if(session != null){
                return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        if(request != null && sessionId != null){
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }
}
