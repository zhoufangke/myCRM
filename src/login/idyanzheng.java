package login;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import connection.connection;


public class idyanzheng {
	public boolean yanz(String zhangh,String uid){
	Connection conn = connection.getConnction();
	QueryRunner qr = new QueryRunner();
	boolean istf = false;

	// String sql2 = " insert into user_table ( id,name,pwd ) values( '" + u.getId()
	// + "','" + u.getName() + "','"+ u.getPwd() + "')";
	// System.out.println(sql2);
	String sql = " select * from CRM_user where zhanghao=? or id=?  ";

	Object[] params = new Object[] {zhangh,uid  }; // ²ÎÊı
	int resulst = 0;
	try {
		resulst = qr.update(conn, sql, params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if (resulst > 0) {
		istf = true;
	}
	return istf;
}
}

