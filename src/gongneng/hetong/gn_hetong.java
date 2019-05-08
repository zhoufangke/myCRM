package gongneng.hetong;
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
 
//ʵ�ֽӿ�ActionListener
public class gn_hetong implements ActionListener {
 
	JFrame jf;
	JPanel jpanel,jp1,jp2,jp3;
	JButton jb1, jb2, jb3,jb4,jb5,
			jb6,jb7,jb8,jb9,jb10;
	DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
	JTable table;		// ���
//	JTextArea jta = null;
//	JScrollPane jscrollPane;
	@SuppressWarnings("rawtypes")
	public  gn_hetong(int sid) throws ClassNotFoundException, SQLException {
 
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
		Vector rowData = hetong_con.getRows(id);
		// ȡ�����ݿ�ı�ı�ͷ����
		Vector columnNames = hetong_con.getHead(id);
				
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
//		gn_hetong jiemian=new gn_hetong(1);
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
					
					// ���¾�Ϊ�����ݿ�Ĳ���
					
					
	 
					try {
						Connection conn = connection.getConnction();
						@SuppressWarnings("unused")
						QueryRunner qr = new QueryRunner();
						PreparedStatement preparedStatement = null;
						
						// ɾ��������������
						int sid =  Integer.parseInt(value[0][0]);
						preparedStatement = conn.prepareStatement("delete from hetong where id='"+ sid +"'");
						preparedStatement.executeUpdate();
						
						// ��value�����е��������δ�ŵ�aa����
						for(int i = 0; i < row; i++){
							preparedStatement = conn.prepareStatement("insert into hetong values('" + Integer.parseInt(value[i][0]) + "','" + value[i][1] + "','" + value[i][2] + "','" + value[i][3] + "','" + value[i][4] + "','" + value[i][5] + "')");
							preparedStatement.executeUpdate();
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// ������˳�
					System.exit(0);
					
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

