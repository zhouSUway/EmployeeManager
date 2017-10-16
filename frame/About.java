package frame;

import javax.swing.*;
import model.FrameInit;
import java.awt.*;
public class About extends JFrame{
	JFrame a = new JFrame("有关本系统");
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	public About(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(a, p);
		p.add(l,BorderLayout.CENTER);
		a.setSize(new Dimension(250,150));
		l.setText("<html><body>东北大学软件学院  欧阳英 制作！<br> 如有建议，请联系：xxxxxxxxxxxx<br>Email:xxxxxxxx</body></html>");
		a.setVisible(true);
	}

}
