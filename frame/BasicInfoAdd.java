package frame;

import javax.swing.*;

import java.awt.*;
import model.FrameInit;
import java.awt.event.*;
import com.DAO;
public class BasicInfoAdd extends JFrame{
	JFrame bif = new JFrame("基本信息添加");
	JPanel p = new JPanel();
	
	JLabel lblxl = new JLabel("请输入学历名称:");
	JTextField txtxl= new JTextField(10);
	JButton btnxl = new JButton("添加学历");
	public BasicInfoAdd(){
		FrameInit.InitFrame(bif, p);
		bif.setSize(new Dimension(300,100));
		bif.add(p,BorderLayout.CENTER);
		p.setLayout(new FlowLayout());
		p.add(lblxl);
		p.add(txtxl);
		p.add(btnxl);
		//添加学历按钮事件监听
		btnxl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String degree = txtxl.getText();
				if(degree.equals("")){
					JOptionPane.showMessageDialog(null, "请输入学历名称!","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				boolean flag = DAO.addDegree(degree);
				if(flag){
					JOptionPane.showMessageDialog(null, "添加学历成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "添加学历失败!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		bif.setVisible(true);
		
	}
}
