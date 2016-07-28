package com.hsh24.mall.portal.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsh24.mall.api.weixin.IWeixinService;
import com.hsh24.mall.api.weixin.bo.Ticket;
import com.hsh24.mall.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
@Controller
@Scope("request")
public class PortalAction extends BaseAction {

	private static final long serialVersionUID = 2191525146456353749L;

	@Resource
	private IWeixinService weixinService;

	private Ticket ticket;

	/**
	 * 登录首页.
	 * 
	 * @return
	 */
	public String index() {
		return SUCCESS;
	}

	/**
	 * 移动商场.
	 * 
	 * @return
	 */
	public String homepage() {
		String requestURL = env.getProperty("appUrl") + "/homepage.htm";
		HttpServletRequest request = getServletRequest();
		String queryString = request.getQueryString();

		ticket =
			weixinService.getTicket(StringUtils.isEmpty(queryString) ? requestURL : requestURL + "?" + queryString);

		return SUCCESS;
	}

	public IWeixinService getWeixinService() {
		return weixinService;
	}

	public void setWeixinService(IWeixinService weixinService) {
		this.weixinService = weixinService;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
