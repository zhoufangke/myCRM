package gongneng;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import login.yanzheng.*;
import javax.swing.*;
import javax.swing.JOptionPane;

@SuppressWarnings({ "serial", "unused" })
public class user_yz extends JFrame {

    // 定义组件
    JPanel jp1,jp2,jp4;
    JLabel zhanghao;
    JButton jb1;
    JTextField jtf1;
    


    // 构造函数
    public   user_yz() {
    	
        jp1 = new JPanel();
       jp2=new JPanel();
       jp4=new JPanel();

        
        zhanghao = new JLabel("请输入管理员密码");
           
        
        jtf1 = new JTextField(12);//账号
       
        
        jb1 = new JButton("登陆");
        jb1.addActionListener(new ActionListener(){
       	 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 String name = jtf1.getText();
				 if (name.equals("admin"))
				 {try {
					 user_yz.this.setVisible(false);
					gn_user jiemian=new gn_user();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				 else{JOptionPane.showMessageDialog(jp4, "密码错误", "CRM提示",JOptionPane.ERROR_MESSAGE);}
			}
			
		});

        
        this.setLayout(new GridLayout(2, 1));

        // 加入各个组件
        jp1.add(zhanghao);
        jp1.add(jtf1);
        jp2.add(jb1);
       
        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);

        this.setSize(400, 300);
        this.setTitle("查询");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }}


