package gongneng.kh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import connection.connection;

public class kehu_cx {
 public  String[] get(String name,String user[]) throws SQLException{
	 Connection conn = connection.getConnction();
		@SuppressWarnings("unused")
		QueryRunner qr = new QueryRunner();
		String kname =name;
		// String sql2 = " insert into user_table ( id,name,pwd ) values( '" + u.getId()
		// + "','" + u.getName() + "','"+ u.getPwd() + "')";
		// System.out.println(sql2);
		String sql = " select * from kehu where name='"+kname+"'";

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
			user[10]=result.getString(10);
			user[11]=result.getString(11);
			user[12]=result.getString(12);
			user[13]=result.getString(13);
			user[14]=result.getString(14);
		}

				statement.close();
				conn.close();
			return user;
 }
}
