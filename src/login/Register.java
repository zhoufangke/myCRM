package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.yanzheng.*;
import javax.swing.*;
import javax.swing.JOptionPane;

@SuppressWarnings({ "serial", "unused" })
public class Register extends JFrame {

    // 定义组件
    JPanel jp1, jp2, jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12,jp13,jp14,jp15;
    JLabel zhanghao,mima,jl1,mima2,uid,uname,usex,uqq,uphone,uemail,udate;
    JButton jb1;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
    JPasswordField jpf1,jpf2;
    

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Register d2 = new Register();
//
//    }

    // 构造函数
    public Register() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();
        jp9 = new JPanel();
        jp10 = new JPanel();

        
        zhanghao = new JLabel("账         号");
        mima = new JLabel("密         码");
        mima2 = new JLabel("重复密码");
        uid = new JLabel("           ID");
        uname = new JLabel("姓         名");
        usex = new JLabel("性         别");
        uqq = new JLabel("           QQ");
        uphone = new JLabel("电话号码");
        uemail = new JLabel("邮         箱");
        jl1 = new JLabel();
        
    

     
        
        
        jtf1 = new JTextField(12);//账号
        jpf1 = new JPasswordField(12);//密码
        jpf2 = new JPasswordField(12);//密码确定
        jtf2 = new JTextField(12);//id
        jtf3 = new JTextField(12);//姓名
        jtf4 = new JTextField(12);//性别
        jtf5 = new JTextField(12);//QQ
        jtf6 = new JTextField(12);//电话号码
        jtf7 = new JTextField(12);//邮箱
        
        
        jb1 = new JButton("注册");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
            	String zh = jtf1.getText();
				String pwd = String.valueOf(jpf1.getPassword());
				String pwd2 = String.valueOf(jpf2.getPassword());
				String uid1 = jtf2.getText();
				int uid = Integer.parseInt(uid1);
				String uname = jtf3.getText();
				String uqq=jtf5.getText();
				String uphone=jtf6.getText();
				String usex = jtf4.getText();
				String uemail = jtf7.getText();
		
				
				if(zh.equals("")){JOptionPane.showMessageDialog(jp11, "请输入账号", "CRM提示",JOptionPane.ERROR_MESSAGE); }
				else if(pwd.equals("")){JOptionPane.showMessageDialog(jp12, "请输入密码", "CRM提示",JOptionPane.ERROR_MESSAGE);  }
				else if(pwd.equals(pwd2)==false){JOptionPane.showMessageDialog(jp13, "两次密码不一致，请重新输入", "CRM提示",JOptionPane.ERROR_MESSAGE);}
				else{
					idyanzheng y1=new idyanzheng();
					if(y1.yanz(zh,uid1 ))
					{
						JOptionPane.showMessageDialog(jp14, "该ID或账号已经存在，请重新输入", "注册失败",JOptionPane.ERROR_MESSAGE);
					}
					else{
						zhuce z1 = new zhuce();
						z1.yanz(uid, uname, usex, pwd, uqq, uphone, uemail, zh);
						JOptionPane.showMessageDialog(jp15, "注册成功", "CRM提示",JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				
            }
        });
        
        this.setLayout(new GridLayout(10, 1));

        // 加入各个组件
        jp1.add(zhanghao);
        jp1.add(jtf1);

        jp2.add(mima);
        jp2.add(jpf1);

        jp3.add(mima2);
        jp3.add(jpf2);
        
        jp4.add(uid);
        jp4.add(jtf2);
        
        jp5.add(uname);
        jp5.add(jtf3);
        
        jp6.add(usex);
        jp6.add(jtf4);;
        
        jp7.add(uqq);
        jp7.add(jtf5);
        
        jp8.add(uphone);
        jp8.add(jtf6);
        
        jp9.add(uemail);
        jp9.add(jtf7);
        
        jp10.add(jb1);

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        this.add(jp8);
        this.add(jp9);
        this.add(jp10);

        this.setSize(400, 1000);
        this.setTitle("CRM注册");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}