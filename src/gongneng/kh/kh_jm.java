package gongneng.kh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import login.yanzheng.*;
import javax.swing.*;
import javax.swing.JOptionPane;

@SuppressWarnings({ "serial", "unused" })
public class kh_jm extends JFrame {

    // �������
    JPanel jp1,jp2;
    JLabel zhanghao;
    JButton jb1;
    JTextField jtf1;
    


    // ���캯��
    public   kh_jm() {
    	
        jp1 = new JPanel();
       jp2=new JPanel();

        
        zhanghao = new JLabel("�������ѯ����");
           
        
        jtf1 = new JTextField(12);//�˺�
       
        
        jb1 = new JButton("��ѯ");
        jb1.addActionListener(new ActionListener(){
       	 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 String name = jtf1.getText();
				kehu_cx k1 = new kehu_cx();
				String[] user=new String[20];
				try {
					k1.get(name, user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				kehu_show k2 = new kehu_show();
				k2.get(user);
			}
			
		});

        
        this.setLayout(new GridLayout(2, 1));

        // ����������
        jp1.add(zhanghao);
        jp1.add(jtf1);
        jp2.add(jb1);
       
        // ���뵽JFrame
        this.add(jp1);
        this.add(jp2);

        this.setSize(400, 300);
        this.setTitle("��ѯ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }}


