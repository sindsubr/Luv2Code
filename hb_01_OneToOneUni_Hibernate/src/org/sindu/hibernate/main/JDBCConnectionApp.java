package org.sindu.hibernate.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionApp {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/hb_01_OneToOneUni_Hibernate?usessl=false";
		String user = "hb_01_OneToOneUni_Hibernate";
		String password = "hb_01_OneToOneUni_Hibernate";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		System.out.println("sql Connection successfully established..!");
	}
}
