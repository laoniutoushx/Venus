package sos.haruhi.web.kit;

import sos.haruhi.auth.dto.LeftMenuDto;
import sos.haruhi.auth.iservice.IMenuResService;
import sos.haruhi.web.context.BeanFactoryContext;

import javax.servlet.ServletContext;
import java.util.List;

public class RefreshKit {
	public static void refreshLeftMenu(ServletContext ctx) {
		IMenuResService menuResService = (IMenuResService) BeanFactoryContext.getService("menuResService");
		List<LeftMenuDto> mds = menuResService.listLeftNav();
		ctx.setAttribute("leftMenus", mds);
	}
}
