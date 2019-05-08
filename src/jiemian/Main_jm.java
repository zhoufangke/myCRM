package jiemian;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import gongneng.kh.gn_kh;
import login.Login_1;
import login.yanzheng;
 
//实现接口ActionListener
public class Main_jm implements ActionListener {
 
	JFrame jf;
	JPanel jpanel;
	JButton jb1, jb2, jb3,jb4,jb5;
	JTextArea jta = null;
	JScrollPane jscrollPane;
 
	public void get(String user[]) {
 
		jf = new JFrame("CRM客户管理系统");
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
 
		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setFont(new Font("标楷体", Font.BOLD, 16));
		jta.setLineWrap(true);// 激活自动换行功能
		jta.setWrapStyleWord(true);// 激活断行不断字功能
		
 
		jscrollPane = new JScrollPane(jta);
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 5));
 
		jb2 = new JButton("客户功能界面");
		jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
            	try {
					int a = Integer.parseInt(user[1]);
					@SuppressWarnings("unused")
					gn_kh kh=new gn_kh(a);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        	
				
				}
        });
//		jb3 = new JButton("跟进管理");
//		jb4 = new JButton("合同管理");
//		jb5 = new JButton("联系人管理");
// 
//		jpanel.add(jb1);
		jpanel.add(jb2);
//		jpanel.add(jb3);
//		jpanel.add(jb4);
//		jpanel.add(jb5);
		jta.append("欢迎登陆");
		jta.append("\n");
		jta.append("你的个人信息如下：");
		jta.append("\n");
		jta.append("id:"+user[1]);
		jta.append("\n");
		jta.append("姓名:"+user[2]);
		jta.append("\n");
		jta.append("性别:"+user[3]);
		jta.append("\n");
		jta.append("QQ:"+user[5]);
		jta.append("\n");
		jta.append("电话:"+user[6]);
		jta.append("\n");
		jta.append("邮件:"+user[7]);
		jta.append("\n");
		jta.append("创建日期:"+user[8]);
		jta.append("\n");
		jta.append("账号:"+user[9]);
		
 
		contentPane.add(jscrollPane, BorderLayout.CENTER);
		contentPane.add(jpanel, BorderLayout.NORTH);
 
		jf.setSize(800, 600);
		jf.setLocation(400, 100);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
	
	}
 


 
//	public static void main(String[] args) throws SQLException {
//		getUserInfo g1= new getUserInfo();
//		String zh="zhoufangke";
//		String user[]=new String[10];
//		g1.get(zh,user);
//		Main_jm jiemian=new Main_jm();
//		jiemian.get(user);
//	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

