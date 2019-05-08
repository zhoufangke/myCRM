package login;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import connection.connection;


public class zhuce {
	

	public  boolean yanz(int id,String name,String sex,String pwd,String qq,String phone,String email,String zhangh){
	Connection conn = connection.getConnction();
	QueryRunner qr = new QueryRunner();
	boolean istf = false;

	// String sql2 = " insert into user_table ( id,name,pwd ) values( '" + u.getId()
	// + "','" + u.getName() + "','"+ u.getPwd() + "')";
	// System.out.println(sql2);
	String sql = " insert into CRM_USER(id,name,sex,password,qq,phone,e_mail,create_date,zhanghao) values(?,?,?,?,?,?,?,sysdate,?)";

	Object[] params = new Object[] {id,name,sex,pwd,qq,phone,email,zhangh }; // ²ÎÊı
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
