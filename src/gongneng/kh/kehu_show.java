package gongneng.kh;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class kehu_show {
	JFrame jf;
	JTextArea jta = null;
	JScrollPane jscrollPane;
	public void get(String user[]) {
		 
		jf = new JFrame("��ѯ���");
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
 
		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setFont(new Font("�꿬��", Font.BOLD, 16));
		jta.setLineWrap(true);// �����Զ����й���
		jta.setWrapStyleWord(true);// ������в����ֹ���
		
 
		jscrollPane = new JScrollPane(jta);
		
		jta.append("sid:"+user[1]);
		jta.append("\n");
		jta.append("id:"+user[2]);
		jta.append("\n");
		jta.append("����"+user[3]);
		jta.append("\n");
		jta.append("����:"+user[5]);
		jta.append("\n");
		jta.append("URL:"+user[6]);
		jta.append("\n");
		jta.append("�����ʼ�:"+user[7]);
		jta.append("\n");
		jta.append("phone:"+user[8]);
		jta.append("\n");
		jta.append("����:"+user[9]);
		jta.append("\n");
		jta.append("��ϵ��ʽ:"+user[10]);
		jta.append("\n");
		jta.append("��ע:"+user[11]);
		jta.append("\n");
		jta.append("�������ʱ��:"+user[14]);
		
 
		contentPane.add(jscrollPane, BorderLayout.CENTER); 
		jf.setSize(600, 400);
		jf.setLocation(400, 200);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
 
		
		};
	}


