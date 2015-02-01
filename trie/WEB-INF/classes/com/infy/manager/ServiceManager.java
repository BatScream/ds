package com.infy.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.infy.TO.AddPatchTO;
import com.infy.connection.DBService;
import com.infy.exceptions.AddPatchException;
import com.infy.service.PatchManagerDAO;
/**
 * 
 * @author anoop_jadon
 *
 */
public class ServiceManager {
private Connection connection = null;
	/*public boolean fetchLoginCredentials(LoginForm loginForm) throws LoginException{
		try
		{
		DBService dbService = new DBService();
		connection = dbService.getConnectionObj();
		PatchManagerDAO patchManagerDAO = new PatchManagerDAO();
		return patchManagerDAO.fetchLoginCredentials(loginForm,connection);
		}
		catch(LoginException e){
			throw new LoginException(e.getMessage());
		}
		finally{
			try{
				
				if(connection != null){

					connection.close();
				}
			}
			catch(SQLException e){
				System.err.print("Exception: ");
				System.err.println(e.getMessage());
			}
		}
	}*/
	
	public List<LabelValueBean> fetchCodeBaseList(String attrName) throws AddPatchException{
		try
		{
		DBService dbService = new DBService();
		connection = dbService.getConnectionObj();
		PatchManagerDAO patchManagerDAO = new PatchManagerDAO();
		return patchManagerDAO.fetchAttrValueList(connection,attrName);
		}
		catch(AddPatchException e){
			throw new AddPatchException(e.getMessage());
		}
		finally{
			try{
				
				if(connection != null){

					connection.close();
				}
			}
			catch(SQLException e){
				System.err.print("Exception: ");
				System.err.println(e.getMessage());
			}
		}
	}
	
	
	public boolean persistPatchDetails(AddPatchTO patchTo) throws AddPatchException{
		
		boolean isSuccess = false;
		try
		{
		DBService dbService = new DBService();
		connection = dbService.getConnectionObj();
		PatchManagerDAO patchManagerDAO = new PatchManagerDAO();
		int maxSNo = patchManagerDAO.fetchMaxSno(connection);
		
		isSuccess = patchManagerDAO.persistPatchDetails(connection,patchTo,maxSNo);
		}
		catch(AddPatchException e){
			throw new AddPatchException(e.getMessage());
		}
		finally{
			try{
				
				if(connection != null){

					connection.close();
				}
			}
			catch(SQLException e){
				System.err.print("Exception: ");
				System.err.println(e.getMessage());
			}
		}
		return isSuccess;
		
	}
	
	
	
	/*public int fetchMaxSno() throws AddPatchException
	{
		int maxNo = 0;
		try
		{
		DBService dbService = new DBService();
		connection = dbService.getConnectionObj();
		PatchManagerDAO PatchManagerDAO = new PatchManagerDAO();
		maxNo = PatchManagerDAO.fetchMaxSno(connection);
		}
		catch(AddPatchException e){
			throw new AddPatchException(e.getMessage());
		}
		finally{
			try{
				
				if(connection != null){

					connection.close();
				}
			}
			catch(SQLException e){
				System.err.print("Exception: ");
				System.err.println(e.getMessage());
			}
		}
		
		return maxNo;
	}
	*/
	
}
