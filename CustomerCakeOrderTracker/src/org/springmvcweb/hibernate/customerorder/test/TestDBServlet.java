package org.springmvcweb.hibernate.customerorder.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String url = "jdbc:mysql://localhost:3306/CustomerCakeOrderTracker?usessl=false";
		String user = "CustomerCakeOrderTracker";
		String pass = "CustomerCakeOrderTracker";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection con;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pass);
			out.print("success");
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
