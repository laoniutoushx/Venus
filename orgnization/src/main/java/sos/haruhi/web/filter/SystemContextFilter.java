package sos.haruhi.web.filter;


import sos.nagato.pojo.SystemRequest;
import sos.nagato.pojo.SystemRequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SystemContextFilter implements Filter {
	private Integer pageSize;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
						 FilterChain chain) throws IOException, ServletException {
		Integer offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {}
		try {
			SystemRequest systemRequest =  new SystemRequest();
			systemRequest.setOrder(req.getParameter("order"));
			systemRequest.setPageOffset(offset);
			systemRequest.setPageSize(pageSize);
			systemRequest.setRequest((HttpServletRequest)req);
			systemRequest.setSort(req.getParameter("sort"));
			SystemRequestHolder.initRequestHolder(systemRequest);
			chain.doFilter(req,resp);
		} finally {
			SystemRequestHolder.remove();
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 15;
		}
	}

}
