package frame;

import javax.swing.*;

import com.DAO;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import model.FrameInit;
public class AddStation extends JFrame{
	JFrame as = new JFrame("添加岗位");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JLabel lblname = new JLabel("输入岗位名称:");
	JTextField txtname = new JTextField(10);
	JLabel lblkind = new JLabel("岗位类别:");
	JComboBox cbokind = new JComboBox();
	JLabel lblsal = new JLabel("岗位工资:");
	JTextField txtsal = new JTextField(10);
	JLabel lblmoddate = new JLabel("工资修改日期:");
	JTextField txtmoddate = new JTextField(10);
	JButton btnadd = new JButton("添加岗位");
	public AddStation() {
		// TODO Auto-generated constructor stub
		FrameInit.InitFrame(as, p);//初始化frame
		as.setSize(new Dimension(300,300));
		//初始化岗位类别下拉框,创建窗口时的事件响应
		as.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				ResultSet rs = DAO.getStationkind();
				try{
					while(rs.next()){
						cbokind.addItem(new Integer(rs.getInt("stkindid")));
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
		p.setLayout(new GridLayout(5,1));
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p1.add(lblname);
		p1.add(txtname);
		p2.add(lblkind);
		p2.add(cbokind);
		p3.add(lblsal);
		p3.add(txtsal);
		p4.add(lblmoddate);
		p4.add(txtmoddate);
		p5.add(btnadd);
		//添加按钮的事件监听程序
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//名称不能为空
				if(txtname.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入岗位名称!","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//将信息封装到JavaBean
				TbStation info = new TbStation();
				info.setStationname(txtname.getText().trim());
				info.setStkindid(Integer.parseInt(cbokind.getSelectedItem().toString().trim()));
				info.setStsal(Integer.parseInt(txtsal.getText().trim()));
				info.setStsalmoddate(txtmoddate.getText().trim());
				//执行添加
				boolean flag = DAO.addStation(info);
				//判断是否成功
				if(flag){
					JOptionPane.showMessageDialog(null, "添加岗位成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "添加岗位失败!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		as.setVisible(true);
	}

}
