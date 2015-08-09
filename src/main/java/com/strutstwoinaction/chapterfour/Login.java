package com.strutstwoinaction.chapterfour;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.strutstwoinaction.chapterfour.utils.PortfolioService;
import com.strutstwoinaction.chapterfour.utils.User;
import com.strutstwoinaction.chapterfour.utils.Struts2PortfolioConstants;

/*
 * The Login action takes a username and password from the request
 * and authenticate those tokens against the portfolioService objects
 * authenticate methods. If the user is valid, the user object
 * is stored in the session map.
 * 
 * To receive the session map, this action implements the sessionAware
 * interface. This decouples the action from the servlet API. Of course,
 * the action could use the ActionContext to get this map, or even the 
 * underlying Servlet Session object, but these would be needless bindings
 * to the Servlet API, certainly complicating testing.
 */

public class Login extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4757241791020642925L;


	@Override
	public String execute() throws Exception {
		
		User user = getPortfolioService().authenticateUser(getUsername(), getPassword());
		if(user == null){
			/* User not valid, return to input page */
			return INPUT;
		}else{
			session.put(Struts2PortfolioConstants.USER, user);
		}
		
		return SUCCESS;
	}
	
	/* JavaBeans Properties to Receive Request Parameters */
	
	private String username;
	private String password;
	private Map<String, Object> session;


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
	
	@Override
	public void validate() {
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
		
		/* Check that fields are not empty */
		if ( getPassword().length() == 0 ){			
			addFieldError( "password", getText("password.required") );
		}
		if ( getUsername().length() == 0 ){			
			addFieldError( "username", getText("username.required") );
		}
	}
	/*  
	 * Simple way to retrieve our business logic and data peristence
	 * object.  Late versions of the portfolio app will intergrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}	

}
