package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.yanzheng.*;
import javax.swing.*;
import javax.swing.JOptionPane;

@SuppressWarnings({ "serial", "unused" })
public class Register extends JFrame {

    // �������
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

    // ���캯��
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

        
        zhanghao = new JLabel("��         ��");
        mima = new JLabel("��         ��");
        mima2 = new JLabel("�ظ�����");
        uid = new JLabel("           ID");
        uname = new JLabel("��         ��");
        usex = new JLabel("��         ��");
        uqq = new JLabel("           QQ");
        uphone = new JLabel("�绰����");
        uemail = new JLabel("��         ��");
        jl1 = new JLabel();
        
    

     
        
        
        jtf1 = new JTextField(12);//�˺�
        jpf1 = new JPasswordField(12);//����
        jpf2 = new JPasswordField(12);//����ȷ��
        jtf2 = new JTextField(12);//id
        jtf3 = new JTextField(12);//����
        jtf4 = new JTextField(12);//�Ա�
        jtf5 = new JTextField(12);//QQ
        jtf6 = new JTextField(12);//�绰����
        jtf7 = new JTextField(12);//����
        
        
        jb1 = new JButton("ע��");
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
		
				
				if(zh.equals("")){JOptionPane.showMessageDialog(jp11, "�������˺�", "CRM��ʾ",JOptionPane.ERROR_MESSAGE); }
				else if(pwd.equals("")){JOptionPane.showMessageDialog(jp12, "����������", "CRM��ʾ",JOptionPane.ERROR_MESSAGE);  }
				else if(pwd.equals(pwd2)==false){JOptionPane.showMessageDialog(jp13, "�������벻һ�£�����������", "CRM��ʾ",JOptionPane.ERROR_MESSAGE);}
				else{
					idyanzheng y1=new idyanzheng();
					if(y1.yanz(zh,uid1 ))
					{
						JOptionPane.showMessageDialog(jp14, "��ID���˺��Ѿ����ڣ�����������", "ע��ʧ��",JOptionPane.ERROR_MESSAGE);
					}
					else{
						zhuce z1 = new zhuce();
						z1.yanz(uid, uname, usex, pwd, uqq, uphone, uemail, zh);
						JOptionPane.showMessageDialog(jp15, "ע��ɹ�", "CRM��ʾ",JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
				
            }
        });
        
        this.setLayout(new GridLayout(10, 1));

        // ����������
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

        // ���뵽JFrame
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
        this.setTitle("CRMע��");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}