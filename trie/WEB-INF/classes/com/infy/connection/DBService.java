package com.infy.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author anoop_jadon
 *
 */
public class DBService {

	public Connection getConnectionObj() {

		Connection connection = null;

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:BPFS1.5_Patch");
		}
		catch (SQLException e) {

			System.err.print("Exception: ");
			System.err.println(e.getMessage());

		} catch (ClassNotFoundException e) {

			System.err.print("Exception: ");
			System.err.println(e.getMessage());
		}
		return connection;
	}
}
