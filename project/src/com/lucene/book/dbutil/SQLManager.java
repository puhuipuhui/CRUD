package com.lucene.book.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {
	
	public ResultSet execQury(final Connection connection,final String strSQL,Object...params) {
		try {
			PreparedStatement pstmt=connection.prepareStatement(strSQL);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			ResultSet rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int execUpdate(final Connection connection,final String strSQL,Object...params) {
		try {
			PreparedStatement pstmt=connection.prepareStatement(strSQL);
			for(int i=0;i<params.length;i++)
			{
				pstmt.setObject(i+1, params[i]);
			}
			int affectedRows=pstmt.executeUpdate();
			return affectedRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}


	}
}
