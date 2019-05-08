package gongneng.kh;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.dbutils.QueryRunner;

import connection.connection;
import gongneng.user_con;
import gongneng.user_yz;
import gongneng.genjin.gn_genjin;
import gongneng.hetong.gn_hetong;
import gongneng.lianxi.gn_lianxi;
 
//实现接口ActionListener
public class gn_kh implements ActionListener {
 
	JFrame jf;
	JPanel jpanel,jp1,jp2,jp3;
	JButton jb1, jb2, jb3,jb4,jb5,
			jb6,jb7,jb8,jb9,jb10;
	DefaultTableModel tableModel;		// 默认显示的表格
	JTable table;		// 表格
//	JTextArea jta = null;
//	JScrollPane jscrollPane;
	@SuppressWarnings("rawtypes")
	public  gn_kh(int sid) throws ClassNotFoundException, SQLException {
 
		jf = new JFrame("CRM客户管理");
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
 
		
//		jta = new JTextArea(10, 15);
//		jta.setTabSize(4);
//		jta.setFont(new Font("标楷体", Font.BOLD, 16));
//		jta.setLineWrap(true);// 激活自动换行功能
//		jta.setWrapStyleWord(true);// 激活断行不断字功能
//
//		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 4));
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(5, 1));
		jp3 = new JPanel();
		jp3.setLayout(new GridLayout(1, 3));
		
		jb1 = new JButton("用户管理");
		jb2 = new JButton("客户管理");
		jb3 = new JButton("跟进管理");
		jb4 = new JButton("合同管理");
		jb5 = new JButton("联系人管理");
		
		jb6 = new JButton("增加");
		jb7 = new JButton("删除");
		jb10=new JButton("查询");
		jb8 = new JButton("保存");
		jb9 = new JButton("退出");

//		jta.append("id:");
//		jta.append("\n");
		
		int id=sid;
		// 取得数据库的表的各行数据
		Vector rowData = kh_con.getRows(id);
		// 取得数据库的表的表头数据
		Vector columnNames = kh_con.getHead(id);
				
		// 新建表格
		tableModel = new DefaultTableModel(rowData,columnNames);	
		table = new JTable(tableModel);
				
		JScrollPane s = new JScrollPane(table);
		jpanel.add(jb1);
		jpanel.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		
		jp2.add(jb6);
		jp2.add(jb7);
		jp2.add(jb10);
		jp2.add(jb8);
		jp2.add(jb9);
		

		
		
 
		contentPane.add(s, BorderLayout.CENTER);
		contentPane.add(jpanel, BorderLayout.NORTH);
		contentPane.add(jp2, BorderLayout.WEST);
		contentPane.add(jp3, BorderLayout.SOUTH);
//		contentPane.add(jscrollPane, BorderLayout.SOUTH);
 

		// 事件处理
		MyEvent();
		
		
		jf.setSize(800, 600);
		jf.setLocation(400, 100);
		jf.setVisible(true);
 
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
 


 
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		@SuppressWarnings("unused")
//		gn_kh jiemian=new gn_kh(1);
//	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// 事件处理
		public void MyEvent(){
			
			// 增加
			jb6.addActionListener(new ActionListener(){
	 
				@SuppressWarnings("rawtypes")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// 增加一行空白区域
					tableModel.addRow(new Vector());
				}
				
			});
			
			// 删除
			jb7.addActionListener(new ActionListener(){
	 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					// 删除指定行
					int rowcount = table.getSelectedRow();
					if(rowcount >= 0){
						tableModel.removeRow(rowcount);
					}
				}
				
			});
			//查询
			jb10.addActionListener(new ActionListener(){
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
				kh_jm k1= new kh_jm();
				}
			
				
			});
			//用户
			jb1.addActionListener(new ActionListener(){
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					// 删除指定行
					 @SuppressWarnings("unused")
					user_yz user_y=new  user_yz();
				}
				
			});
			//跟进
			jb3.addActionListener(new ActionListener(){
				 
				@SuppressWarnings("rawtypes")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String a = table.getValueAt(table.getSelectedRow(),1).toString();
					int b= Integer.parseInt(a);
					try {
						@SuppressWarnings("unused")
						gn_genjin genjin=new gn_genjin(b);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
			//合同
			jb4.addActionListener(new ActionListener(){
				 
				@SuppressWarnings("rawtypes")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String a = table.getValueAt(table.getSelectedRow(),1).toString();
					int b= Integer.parseInt(a);
					try {
						@SuppressWarnings("unused")
						gn_hetong hetong=new gn_hetong(b);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			//联系人
			jb5.addActionListener(new ActionListener(){
				 
				@SuppressWarnings("rawtypes")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String a = table.getValueAt(table.getSelectedRow(),1).toString();
					int b= Integer.parseInt(a);
					try {
						@SuppressWarnings("unused")
						gn_lianxi lainxiren=new gn_lianxi(b);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
			/**
			 * 保存
			 * 我的解决办法是直接将表中的全部数据删除，
			 * 将表格中的所有内容获取到,
			 * 然后将表格数据重新写入表
			 */
			jb8.addActionListener(new ActionListener(){
	 
				@Override
				public void actionPerformed(ActionEvent e) {	
					int column = table.getColumnCount();		// 表格列数
					int row = table.getRowCount();		// 表格行数
					
					
					// value数组存放表格中的所有数据
					String[][] value = new String[row][column];
					
					for(int i = 0; i < row; i++){
						for(int j = 0; j < column; j++){

							  if(table.getValueAt(i, j)==null){
								  value[i][j] =null;
						      }
						      else{
						    	  value[i][j] = table.getValueAt(i, j).toString();
						      }
						}
					}
					int a =Integer.parseInt(value[0][0]);
					// 以下均为对数据库的操作
					
					
	 
					try {
						Connection conn = connection.getConnction();
						@SuppressWarnings("unused")
						QueryRunner qr = new QueryRunner();
						PreparedStatement preparedStatement = null;
						
						// 删除表中所有数据
						int sid =  Integer.parseInt(value[0][0]);
						preparedStatement = conn.prepareStatement("delete from kehu where sid='"+ sid +"'");
						preparedStatement.executeUpdate();
						
						// 将value数组中的数据依次存放到aa表中
						for(int i = 0; i < row; i++){
							preparedStatement = conn.prepareStatement("insert into kehu values('" + Integer.parseInt(value[i][0]) + "','" + Integer.parseInt(value[i][1]) + "','" + value[i][2] + "','" + value[i][3] + "','" + value[i][4] + "','" + value[i][5] + "','" + Integer.parseInt(value[i][6]) + "','" + Integer.parseInt(value[i][7]) + "','" + value[i][8] + "','" + value[i][9] + "','" + value[i][10] + "','" + value[i][11] + "','" + value[i][12] + "','" + Integer.parseInt(value[i][13]) + "')");
							preparedStatement.executeUpdate();
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// 保存后退出
					jf.setVisible(false);
					try {
						gn_kh jm2=new gn_kh(a);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			// 退出
			jb9.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					System.exit(0);
				}
					
			});
		}
}

