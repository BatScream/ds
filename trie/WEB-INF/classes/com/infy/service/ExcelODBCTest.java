package com.infy.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infy.connection.DBService;
import com.infy.exceptions.AddPatchException;

public class ExcelODBCTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String InsertQuery = null;
		String updateQuery = null;
		Map<String,String> mapps = new HashMap<String, String>();

		//try {
			DBService ds = new DBService();
			connection = ds.getConnectionObj();
			
			
			
			int maxSno = 0;
			List<Integer> serialNoList = new ArrayList<Integer>();
			

			try{
				
				statement = connection.createStatement();
				resultSet = statement.executeQuery("Select [Serial No] from [Patch$]");

				while (resultSet.next()) {
					
					serialNoList.add(resultSet.getInt(1));
				
				}
				maxSno = Collections.max(serialNoList);
				connection.commit();

		} catch (Exception ex) {
			System.err.print("Exception: ");
			ex.printStackTrace();
			System.err.println(ex.getMessage());
		}
		finally{
			try{
				if(statement != null){
					statement.close();


				}
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
}
	
