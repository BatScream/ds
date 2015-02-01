package com.infy.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
/**
 * 
 * @author anoop_jadon
 *
 */
public class LoginForm extends ActionForm{

	private String userName ;
	private String loginMessage ;
	private String srcPath;

	public LoginForm() {
		super();
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		loginMessage = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if(userName == null || userName.trim().equalsIgnoreCase("")){
			errors.add("userName",
					new ActionMessage("error.userName.required"));
		}
 		return errors;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
