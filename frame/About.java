package frame;

import javax.swing.*;
import model.FrameInit;
import java.awt.*;
public class About extends JFrame{
	JFrame a = new JFrame("�йر�ϵͳ");
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	public About(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(a, p);
		p.add(l,BorderLayout.CENTER);
		a.setSize(new Dimension(250,150));
		l.setText("<html><body>������ѧ���ѧԺ  ŷ��Ӣ ������<br> ���н��飬����ϵ��xxxxxxxxxxxx<br>Email:xxxxxxxx</body></html>");
		a.setVisible(true);
	}

}
