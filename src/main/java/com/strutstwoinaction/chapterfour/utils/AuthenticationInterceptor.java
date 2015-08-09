package com.strutstwoinaction.chapterfour.utils;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor{

	private static final long serialVersionUID = 8238891855246436107L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		/**
		 * The interceptor uses the ActionInvocation object to obtain information pertaining
		 * to the request. In this case we're getting the session map.
		 */
		Map session = actionInvocation.getInvocationContext().getSession();
		User user = (User) session.get(Struts2PortfolioConstants.USER);
		
		/*
		 * If the user object is null, then the user hasn't been authenticated through the
		 * login action.
		 * 
		 * If use doesn't exist return the LOGIN control string.  This will cause the 
		 * execution of this action to stop and the request will return the globally defined
		 * login result. 
		 */
		if(user == null){
			return Action.LOGIN;
		} else{
			Action action = (Action) actionInvocation.getAction();
			
			if(action instanceof UserAware){
				((UserAware)action).setUser(user);
			}
			return actionInvocation.invoke();
		}
	}
}
