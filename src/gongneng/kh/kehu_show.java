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
		 
		jf = new JFrame("查询结果");
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new BorderLayout());
 
		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setFont(new Font("标楷体", Font.BOLD, 16));
		jta.setLineWrap(true);// 激活自动换行功能
		jta.setWrapStyleWord(true);// 激活断行不断字功能
		
 
		jscrollPane = new JScrollPane(jta);
		
		jta.append("sid:"+user[1]);
		jta.append("\n");
		jta.append("id:"+user[2]);
		jta.append("\n");
		jta.append("姓名"+user[3]);
		jta.append("\n");
		jta.append("国家:"+user[5]);
		jta.append("\n");
		jta.append("URL:"+user[6]);
		jta.append("\n");
		jta.append("电子邮件:"+user[7]);
		jta.append("\n");
		jta.append("phone:"+user[8]);
		jta.append("\n");
		jta.append("传真:"+user[9]);
		jta.append("\n");
		jta.append("联系方式:"+user[10]);
		jta.append("\n");
		jta.append("备注:"+user[11]);
		jta.append("\n");
		jta.append("最近跟进时间:"+user[14]);
		
 
		contentPane.add(jscrollPane, BorderLayout.CENTER); 
		jf.setSize(600, 400);
		jf.setLocation(400, 200);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
 
		
		};
	}


