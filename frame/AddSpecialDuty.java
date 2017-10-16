package frame;

import javax.swing.*;

import java.awt.*;
import model.*;
import java.awt.event.*;
import com.DAO;
import java.sql.*;
public class AddSpecialDuty extends JFrame{
	JFrame asd = new JFrame("职称添加");
	JPanel p = new JPanel();
	JLabel lblduty = new JLabel("职称名称:");
	JTextField txtduty = new JTextField(10);
	JLabel lg = new JLabel("职称等级:");
	JComboBox cbodg = new JComboBox();
	JLabel ls = new JLabel("职称序列:");
	JComboBox cbos = new JComboBox();
	JLabel lmark = new JLabel("聘任标志:");
	JTextField txtmark = new JTextField(10);
	JLabel lhd = new JLabel("聘任日期:");
	JTextField thd = new JTextField(10);
	JLabel lfd = new JLabel("解聘日期:");
	JTextField tfd = new JTextField(10);
	JLabel lsaldg = new JLabel("工资等级:");
	JTextField txtsaldg = new JTextField(10);
	JLabel lsal = new JLabel("工资金额:");
	JTextField txtsal = new JTextField(10);
	JLabel lsdmd = new JLabel("工资调整时间:");
	JTextField tsdmd = new JTextField(10);
	JButton btnduty = new JButton("添加职称");
	public AddSpecialDuty() {
		// 初始化
		FrameInit.InitFrame(asd, p);
		asd.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				ResultSet rs1 = DAO.getSpecialDutygrade();
				ResultSet rs2 = DAO.getSpecialserial();
				try{
					//初始化等级下拉框
					while(rs1.next()){
						cbodg.addItem(new Integer(rs1.getInt("sdgrade")));
					}
					//初始化序列下拉框
					while(rs2.next()){
						cbos.addItem(new Integer(rs2.getInt("sdsid")));
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				
			}
		});
		asd.setSize(new Dimension(300,500));
		p.setLayout(new GridLayout(10,1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		JPanel p10 = new JPanel();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		p.add(p8);
		p.add(p10);
		p.add(p9);
		
		p1.add(lblduty);
		p1.add(txtduty);
		
		p2.add(lg);
		p2.add(cbodg);
		
		p3.add(ls);
		p3.add(cbos);
		
		p4.add(lmark);
		p4.add(txtmark);
		
		p5.add(lhd);
		p5.add(thd);
		
		p6.add(lfd);
		p6.add(tfd);
		
		p7.add(lsaldg);
		p7.add(txtsaldg);
		
		p8.add(lsal);
		p8.add(txtsal);
		
		p10.add(lsdmd);
		p10.add(tsdmd);
		p9.add(btnduty);
		//添加按钮的事件监听
		btnduty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//名称不能为空
				if(txtduty.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入职称名称!","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//封装到实体
				TbSpecialdutyInfo info = new TbSpecialdutyInfo();
				info.setSdname(txtduty.getText().trim());
				info.setSdgrade(Integer.parseInt(cbodg.getSelectedItem().toString().trim()));
				info.setSdsalgrade(Integer.parseInt(cbos.getSelectedItem().toString().trim()));
				info.setHiremark(txtmark.getText().trim());
				info.setHiredate(thd.getText().trim());
				info.setFiredate(tfd.getText().trim());
				info.setSdsalgrade(Integer.parseInt(txtsaldg.getText().trim()));
				info.setSdsal(Integer.parseInt(txtsal.getText().trim()));
				info.setSdsalmoddate(tsdmd.getText().trim());
				//执行插入
				boolean flag = DAO.addSpecialduty(info);
				//判断是否执行成功
				if(flag){
					JOptionPane.showMessageDialog(null, "添加职称成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "添加职称失败!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		asd.setVisible(true);
	}

}
