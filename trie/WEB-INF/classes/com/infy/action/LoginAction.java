package com.infy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.infy.forms.LoginForm;
import com.infy.manager.ServiceManager;
import com.infy.util.FileNameRetriever;
/**
 * 
 * @author anoop_jadon
 *
 */
public class LoginAction extends DispatchAction
{
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		
		try
		{
		boolean isSuccess = true;
		LoginForm loginForm = (LoginForm) form;
		//ServiceManager serviceManager = new ServiceManager();
		//isSuccess = serviceManager.fetchLoginCredentials(loginForm);
		
		if(isSuccess){
			request.getSession().setAttribute("userName", loginForm.getUserName());
			//request.getSession().setAttribute("codeBasePath", loginForm.getSrcPath());
			FileNameRetriever retriever = new FileNameRetriever();
			List<String> fileNames = retriever.retrieveFileNames("E:\\Codebase\\LSIE");// D:\\LSIE\\Workspace\\IPC_1.0_DEV_MERGE_LATEST\\LSIE
			request.getSession().setAttribute("fileNames", fileNames);
			return mapping.findForward(SUCCESS);
		}
		else
		{
			loginForm.setLoginMessage("User Credentials do not match. Please try again !!");
			return mapping.getInputForward();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward(FAILURE);
		}
	}

}
