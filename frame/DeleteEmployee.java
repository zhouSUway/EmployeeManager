package frame;

import javax.swing.*;
import model.FrameInit;
import com.DAO;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class DeleteEmployee extends JFrame{
	JFrame de = new JFrame("删除员工信息");
	JPanel p = new JPanel();
	JPanel ptop = new JPanel();
	JLabel lblename = new JLabel("请选择要删除的员工姓名:");
	JComboBox cboename = new JComboBox();
	JButton btndelete = new JButton("删除");
	public DeleteEmployee(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(de, p);
		p.setLayout(new BorderLayout());
		p.add(ptop, BorderLayout.CENTER);
		//打开窗口时的事件监听，初始化下拉列表ename
		de.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				ResultSet rs = DAO.getEmployeeName();
				try{
					while(rs.next()){
						cboename.addItem(rs.getString("ename"));
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
	
		ptop.add(lblename);
		ptop.add(cboename);
		ptop.add(btndelete);
		//删除按钮的事件监听程序
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name = cboename.getSelectedItem().toString().trim();
				boolean flag = DAO.deleteEmployee(name);
				if(flag){
					JOptionPane.showMessageDialog(null, "删除信息成功！","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "删除失败！请检查！","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		de.setSize(500,80);
		de.setVisible(true);
	}
}
