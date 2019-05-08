package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connection {

	public static Connection getConnction() {
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		Connection conn = null;

		// 1.×¢²áÇý¶¯
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "xsm", "123456");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
		
	}



