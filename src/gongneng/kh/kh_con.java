package gongneng.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
 
import javax.swing.JOptionPane;

import org.apache.commons.dbutils.QueryRunner;

import connection.connection;
 
public class kh_con {
	// 得到数据库表数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getRows(int sid) throws ClassNotFoundException{
		
		PreparedStatement preparedStatement = null;
 
		Vector rows = null;
		@SuppressWarnings("unused")
		Vector columnHeads = null;
		
		try {
			Connection conn = connection.getConnction();
			@SuppressWarnings("unused")
			QueryRunner qr = new QueryRunner();
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			int a= sid;
			preparedStatement = conn.prepareStatement("select * from kehu where sid='"+a+"'");
			ResultSet result1 = preparedStatement.executeQuery();
			
	
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		return rows;
	}
	
	// 得到数据库表头
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getHead(int sid) throws ClassNotFoundException{
	
		PreparedStatement preparedStatement = null;
 
		Vector columnHeads = null;
		
		try {
			Connection conn = connection.getConnction();
			@SuppressWarnings("unused")
			QueryRunner qr = new QueryRunner();
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			int a=sid;
			preparedStatement = conn.prepareStatement("select * from kehu");
			ResultSet result1 = preparedStatement.executeQuery();
			
			boolean moreRecords = result1.next();
			if(!moreRecords)
				JOptionPane.showMessageDialog(null, "结果集中无记录");
			
			columnHeads = new Vector();
			ResultSetMetaData rsmd = result1.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	// 得到数据库中下一行数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}

}
