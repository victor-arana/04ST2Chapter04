package com.strutstwoinaction.chapterfour;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.strutstwoinaction.chapterfour.utils.PortfolioService;
import com.strutstwoinaction.chapterfour.utils.User;
/*
 * This is our first version of the Register action.  This version uses
 * the basic validation and message localization services provided by the 
 * ActionSupport help class.  By extending this class, we automatically
 * receive implementations of several interfaces that allow us to do
 * validation and localize our message texts with out polluting the
 * execute() method of our action.   
 */
public class Register extends ActionSupport implements ModelDriven{

	private static final long serialVersionUID = 3327714661652096128L;

	@Override
	public String execute() throws Exception {
		getPortfolioService().createAccount(user);
		return SUCCESS;
	}
	
	
	/* JavaBeans Properties to Receive Request Parameters */
	private User user = new User();
	@Override
	public Object getModel() {
		return user;
	}

	/* Validateable Implementation 
	 * 
	 * The validate method validates, invoked by the validation interceptor in
	 * the default stack, will validate the data already set on the action
	 * by the params interceptor, also in the default stack.
	 * 
	 * If this method finds problems in validation it stores error messages via
	 * the methods exposed by the ValidationAware interface -- already implemented
	 * by the ActionSupport class that this action extends.  To complete the 
	 * the validation process, the workflow interceptor fires next in the default
	 * stack.  It checks for error messages on the action, and if it finds them 
	 * it diverts workflow back to the input page where the error messages are 
	 * displayed to the user.  In this case, the execute method of the action
	 * will not be called because the workflow was diverted, due to validation
	 * problems, before execution reached the action itself.	 * 
	 */
	@Override
	public void validate() {
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
		
		/* Check that fields are not empty */
		if(user.getPassword().length() == 0){
			addFieldError("password", getText("password.required"));
		}
		if(user.getUsername().length() == 0){
			addFieldError("username", getText("username.required"));
		}
		if(user.getPortfolioName().length() == 0){
			addFieldError("portfolioName", getText("portfolioName.required"));
		}
		/* Make sure user doesn't already have an account */
		if(ps.userExists(user.getUsername())){
			addFieldError("username", getText("user.exists"));
		}
	}
	
	/*  
	 * Simple way to retrieve our business logic and data persistence
	 * object.  Late versions of the portfolio app will integrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}

}