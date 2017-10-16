package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class FrameInit {
	
	public static void InitFrame(JFrame f,JPanel p){
		f.add(p, BorderLayout.CENTER);
		f.pack();
		f.setSize(new Dimension(500,400));
		//确定mainFrame的显示位置(显示器中间)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = f.getSize();
		if(frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if(frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		f.setLocation((screenSize.width-frameSize.width)/2,
				(screenSize.height-frameSize.height)/2);
		p.setLayout(new BorderLayout());
	}

}
