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
 
//ʵ�ֽӿ�ActionListener
public class gn_kh implements ActionListener {
 
	JFrame jf;
	JPanel jpanel,jp1,jp2,jp3;
	JButton jb1, jb2, jb3,jb4,jb5,
			jb6,jb7,jb8,jb9,jb10;
	DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	JTable table;		// ���
//	JTextArea jta = null;
//	JScrollPane jscrollPane;
	@SuppressWarnings("rawtypes")
	public  gn_kh(int sid) throws ClassNotFoundException, SQLException {
 
		jf = new JFrame("CRM�ͻ�����");
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
 
		
//		jta = new JTextArea(10, 15);
//		jta.setTabSize(4);
//		jta.setFont(new Font("�꿬��", Font.BOLD, 16));
//		jta.setLineWrap(true);// �����Զ����й���
//		jta.setWrapStyleWord(true);// ������в����ֹ���
//
//		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 4));
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(5, 1));
		jp3 = new JPanel();
		jp3.setLayout(new GridLayout(1, 3));
		
		jb1 = new JButton("�û�����");
		jb2 = new JButton("�ͻ�����");
		jb3 = new JButton("��������");
		jb4 = new JButton("��ͬ����");
		jb5 = new JButton("��ϵ�˹���");
		
		jb6 = new JButton("����");
		jb7 = new JButton("ɾ��");
		jb10=new JButton("��ѯ");
		jb8 = new JButton("����");
		jb9 = new JButton("�˳�");

//		jta.append("id:");
//		jta.append("\n");
		
		int id=sid;
		// ȡ�����ݿ�ı�ĸ�������
		Vector rowData = kh_con.getRows(id);
		// ȡ�����ݿ�ı�ı�ͷ����
		Vector columnNames = kh_con.getHead(id);
				
		// �½����
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
 

		// �¼�����
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
	
	// �¼�����
		public void MyEvent(){
			
			// ����
			jb6.addActionListener(new ActionListener(){
	 
				@SuppressWarnings("rawtypes")
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// ����һ�пհ�����
					tableModel.addRow(new Vector());
				}
				
			});
			
			// ɾ��
			jb7.addActionListener(new ActionListener(){
	 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					// ɾ��ָ����
					int rowcount = table.getSelectedRow();
					if(rowcount >= 0){
						tableModel.removeRow(rowcount);
					}
				}
				
			});
			//��ѯ
			jb10.addActionListener(new ActionListener(){
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
				kh_jm k1= new kh_jm();
				}
			
				
			});
			//�û�
			jb1.addActionListener(new ActionListener(){
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					// ɾ��ָ����
					 @SuppressWarnings("unused")
					user_yz user_y=new  user_yz();
				}
				
			});
			//����
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
			
			//��ͬ
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
			//��ϵ��
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
			 * ����
			 * �ҵĽ���취��ֱ�ӽ����е�ȫ������ɾ����
			 * ������е��������ݻ�ȡ��,
			 * Ȼ�󽫱����������д���
			 */
			jb8.addActionListener(new ActionListener(){
	 
				@Override
				public void actionPerformed(ActionEvent e) {	
					int column = table.getColumnCount();		// �������
					int row = table.getRowCount();		// �������
					
					
					// value�����ű���е���������
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
					// ���¾�Ϊ�����ݿ�Ĳ���
					
					
	 
					try {
						Connection conn = connection.getConnction();
						@SuppressWarnings("unused")
						QueryRunner qr = new QueryRunner();
						PreparedStatement preparedStatement = null;
						
						// ɾ��������������
						int sid =  Integer.parseInt(value[0][0]);
						preparedStatement = conn.prepareStatement("delete from kehu where sid='"+ sid +"'");
						preparedStatement.executeUpdate();
						
						// ��value�����е��������δ�ŵ�aa����
						for(int i = 0; i < row; i++){
							preparedStatement = conn.prepareStatement("insert into kehu values('" + Integer.parseInt(value[i][0]) + "','" + Integer.parseInt(value[i][1]) + "','" + value[i][2] + "','" + value[i][3] + "','" + value[i][4] + "','" + value[i][5] + "','" + Integer.parseInt(value[i][6]) + "','" + Integer.parseInt(value[i][7]) + "','" + value[i][8] + "','" + value[i][9] + "','" + value[i][10] + "','" + value[i][11] + "','" + value[i][12] + "','" + Integer.parseInt(value[i][13]) + "')");
							preparedStatement.executeUpdate();
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// ������˳�
					jf.setVisible(false);
					try {
						gn_kh jm2=new gn_kh(a);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			// �˳�
			jb9.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					System.exit(0);
				}
					
			});
		}
}

