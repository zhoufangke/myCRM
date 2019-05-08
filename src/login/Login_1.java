package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import login.yanzheng.*;
import javax.swing.*;
import javax.swing.JOptionPane;

import jiemian.Main_jm;
import jiemian.getUserInfo;

@SuppressWarnings({ "serial", "unused" })
public class Login_1 extends JFrame {

    // 定义组件
    JPanel jp1, jp2, jp3,jp4,jp5,jp6,jp7;
    JLabel zhanghao,mima,jl1;
    JButton jb1, jb2;
    JTextField jtf1;
    JPasswordField jpf1;
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Login_1 d1 = new Login_1();

    }

    // 构造函数
    public Login_1() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        zhanghao = new JLabel("用户名");
        mima = new JLabel("密    码");
        jl1 = new JLabel();
        
        
        jtf1 = new JTextField(12);
        jpf1 = new JPasswordField(12);
        
        jb1 = new JButton("注册");
        jb1.addActionListener(new ActionListener(){
       	 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Register d2 = new Register();
			}
			
		});
        jb2 = new JButton("登陆");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
            	        	
				String zh = jtf1.getText();
				String pwd = String.valueOf(jpf1.getPassword());
				
				if(zh.equals("")){JOptionPane.showMessageDialog(jp4, "请输入账号", "CRM提示",JOptionPane.ERROR_MESSAGE); }
				else if(pwd.equals("")){JOptionPane.showMessageDialog(jp5, "请输入密码", "CRM提示",JOptionPane.ERROR_MESSAGE);  }
				else{
					yanzheng y1=new yanzheng();
					if(y1.yanz(zh, pwd))
					{
						JOptionPane.showMessageDialog(jp7, "登陆成功", "CRM提示",JOptionPane.INFORMATION_MESSAGE);
						Login_1.this.dispose();
						getUserInfo g1= new getUserInfo();
						String user[]=new String[10];
						try {
							g1.get(zh,user);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Main_jm jiemian=new Main_jm();
						jiemian.get(user);
					}
					else{
						JOptionPane.showMessageDialog(jp6, "登陆失败", "CRM提示",JOptionPane.ERROR_MESSAGE);
					
					}
				}
            }
        });


        
        this.setLayout(new GridLayout(3, 1));

        // 加入各个组件
        jp1.add(zhanghao);
        jp1.add(jtf1);

        jp2.add(mima);
        jp2.add(jpf1);

        jp3.add(jb1);
        jp3.add(jb2);

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setSize(350, 250);
        this.setTitle("CRM登录");
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}