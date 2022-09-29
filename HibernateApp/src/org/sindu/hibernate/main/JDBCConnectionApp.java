package org.sindu.hibernate.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionApp {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/student_schema?user=student?usessl=false";
		String user = "student";
		String password = "student@123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		System.out.println("sql Connection successfully established..!");
	}
}
