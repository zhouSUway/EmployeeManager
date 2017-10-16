package frame;

import javax.swing.*;

import com.DAO;
import model.TbDutyInfo;
import java.awt.*;
import java.awt.event.*;

import model.FrameInit;
public class AddDuty extends JFrame{
	JFrame ad = new JFrame("职务添加");
	JPanel p = new JPanel();
	JLabel lblduty = new JLabel("职务名称:");
	JTextField txtduty = new JTextField(10);
	JLabel lg = new JLabel("职务等级:");
	JTextField tdg = new JTextField(10);
	JLabel lhd = new JLabel("聘任日期:");
	JTextField thd = new JTextField(10);
	JLabel lfd = new JLabel("解聘日期:");
	JTextField tfd = new JTextField(10);
	JButton btnduty = new JButton("添加职务");
	public AddDuty(){
		FrameInit.InitFrame(ad, p);
		ad.setSize(new Dimension(300,300));
		ad.add(p,BorderLayout.CENTER);
		p.setLayout(new GridLayout(5,1));
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p1 = new JPanel();
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		
		p.add(p1);
		p2.add(lblduty);
		p2.add(txtduty);
		
		p3.add(lg);
		p3.add(tdg);
		
		p4.add(lhd);
		p4.add(thd);
		
		p5.add(lfd);
		p5.add(tfd);
		
		p1.add(btnduty);
		btnduty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtduty.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入职务名称!","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				TbDutyInfo info = new TbDutyInfo();
				info.setDutyname(txtduty.getText().trim());
				info.setDutygrade(Integer.parseInt(tdg.getText().trim()));
				info.setHiredate(thd.getText().trim());
				info.setFiredate(tfd.getText().trim());
				boolean flag = DAO.addduty(info);
				if(flag){
					JOptionPane.showMessageDialog(null, "添加职务成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "添加职务失败!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		ad.setVisible(true);
	}
}
