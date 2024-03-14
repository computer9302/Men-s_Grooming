package org.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AutoCommitCheck {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##compu", "1234");
        boolean autoCommit = connection.getAutoCommit();
		System.out.println("Auto-commit mode: " + autoCommit);

        
    	
		
	}

}
