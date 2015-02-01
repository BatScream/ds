package com.infy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.infy.TO.AddPatchTO;
import com.infy.exceptions.AddPatchException;
/**
 * 
 * @author anoop_jadon
 *
 */
public class PatchManagerDAO {

	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement pstmt = null;

	/*public boolean fetchLoginCredentials(LoginForm loginForm,Connection connection) throws LoginException{
		try{
			String userName = loginForm.getUserName();
			pstmt = connection.prepareStatement("Select * from [LoginCredentials$] where [UserName]= ?");
			pstmt.setString(1, userName.toUpperCase());
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}

		} catch (SQLException e) {
			throw new LoginException(e.getMessage());
		}

		finally{
			try{

				if(statement != null){

					statement.close();
				}
			}
			catch(SQLException e){
				throw new LoginException(e.getMessage());
			}
		}
	}*/

	public List<LabelValueBean> fetchAttrValueList(Connection connection,String attrName) throws AddPatchException
	{

		try{
			List<LabelValueBean> attrValueList = new ArrayList<LabelValueBean>();
			LabelValueBean labelValueBean = null;

			pstmt = connection.prepareStatement("Select [AttributeValue] from [Common$] where [AttributeName] = ?");
			pstmt.setString(1,attrName);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				labelValueBean = new LabelValueBean();
				String attrValue = resultSet.getString(1);
				labelValueBean.setLabel(attrValue);
				labelValueBean.setValue(attrValue);
				attrValueList.add(labelValueBean);
			}
			connection.commit();
			return attrValueList;
		} catch (SQLException e) {
			throw new AddPatchException(e.getMessage());
		}

		finally{
			try{

				if(statement != null){

					statement.close();
				}
			}
			catch(SQLException e){
				throw new AddPatchException(e.getMessage());
			}
		}

	}

	public boolean persistPatchDetails(Connection connection,AddPatchTO patchTo, int maxSerialNo) throws AddPatchException{
	
		String InsertQuery = null;
		boolean isInsertSuccess = false;

		try{
			
			InsertQuery = "INSERT into [Patch$]([Serial No] ,[Patch_Date],[Code_Base],[Defect No in worksheet], [Block Point], [File Name Uniqueness], [Patch Taken], [Changed Description], [VSS Version], [Checked in By], [New File], [Critical defect], [Impact Flows], [Is Tested By Test Team], [Delivery Date],[File Name],[File Path]) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = connection.prepareStatement(InsertQuery);
			pstmt.setInt(1, maxSerialNo+1);
			pstmt.setString(2, patchTo.getPatchDate());
			pstmt.setString(3, patchTo.getCodeBase());
			pstmt.setInt(4, patchTo.getDefectNumber());
			pstmt.setString(5, patchTo.getBlockPoint());
			pstmt.setString(6, patchTo.getFileNameUniqueness());
			pstmt.setString(7, patchTo.getPatchTaken());
			pstmt.setString(8, patchTo.getChangedDescription());
			pstmt.setInt(9, patchTo.getVssVersion());
			pstmt.setString(10, patchTo.getCheckedInBy());
			pstmt.setString(11, patchTo.getNewFile());
			pstmt.setString(12, patchTo.getCriticalDefect());
			pstmt.setString(13, patchTo.getImpactFlows());
			pstmt.setString(14, patchTo.getIsTestedByTestTeam());
			pstmt.setString(15, patchTo.getDeliveryDate());
			pstmt.setString(16,patchTo.getFileName());
			pstmt.setString(17,patchTo.getFilePath());
			int insert = pstmt.executeUpdate();
			connection.commit();
			if(insert>0){
				isInsertSuccess = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddPatchException(e.getMessage());
		}

		finally{
			try{

				if(pstmt != null){

					pstmt.close();
				}
			}
			catch(SQLException e){
				throw new AddPatchException(e.getMessage());
			}
		}

		return isInsertSuccess;	

	}

	
	
	
	public int fetchMaxSno(Connection connection) throws AddPatchException
	{
		int maxSno = 0;
		List<Integer> serialNoList = null;

		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select [Serial No] from [Patch$]");

			while (resultSet.next()) 
			{
				if(null == serialNoList)
				{
					serialNoList = new ArrayList<Integer>();
				}
				serialNoList.add(resultSet.getInt(1));
				
			}
			if(null != serialNoList)
			{
				maxSno = Collections.max(serialNoList);
			}
		} catch (SQLException e) {
			throw new AddPatchException(e.getMessage());
		}

		finally{
			try{

				if(statement != null){

					statement.close();
					
				}
			}
			catch(SQLException e){
				throw new AddPatchException(e.getMessage());
			}
		}
		return maxSno;

	}
	

}