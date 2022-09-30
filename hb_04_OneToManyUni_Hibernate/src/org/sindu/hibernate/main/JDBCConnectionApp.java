package org.sindu.hibernate.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionApp {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/hb_04_OneToManyUni_Hibernate?usessl=false";
		String user = "hb_04_OneToManyUni_Hibernate";
		String password = "hb_04_OneToManyUni_Hibernate";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		System.out.println("sql Connection successfully established..!");
	}
}
