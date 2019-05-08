package jiemian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import connection.connection;


public class getUserInfo {
	public String[] get(String zhangh,String user[]) throws SQLException{
	Connection conn = connection.getConnction();
	@SuppressWarnings("unused")
	QueryRunner qr = new QueryRunner();
	
	// String sql2 = " insert into user_table ( id,name,pwd ) values( '" + u.getId()
	// + "','" + u.getName() + "','"+ u.getPwd() + "')";
	// System.out.println(sql2);
	String sql = " select * from CRM_user where zhanghao='"+zhangh+"'";

	Statement statement=conn.createStatement();
	
	ResultSet result = statement.executeQuery(sql);
	while(result.next()){
		
		user[1]=result.getString(1);
		user[2]=result.getString(2);
		user[3]=result.getString(3);
		user[4]=result.getString(4);
		user[5]=result.getString(5);
		user[6]=result.getString(6);
		user[7]=result.getString(7);
		user[8]=result.getString(8);
		user[9]=result.getString(9);
	}

			statement.close();
			conn.close();
		return user;
	}

}


