package com.bridgelabs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchDataServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e) {
			
		}
	}
}
