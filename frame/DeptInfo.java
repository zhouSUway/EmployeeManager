package frame;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;
import com.DAO;
import java.sql.*;
import java.awt.event.*;
import javax.swing.event.*;
public class DeptInfo{
	JFrame di = new JFrame("部门管理");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JTree tree;
	JTextField txtdname = new JTextField(20);
	JTextField txtyname = new JTextField(20);
	JTextField txtnname = new JTextField(20);
	JComboBox cbo = new JComboBox();
	public DeptInfo(){
		init();	
	}
	
	public void init(){
		di.add(p,BorderLayout.CENTER);
		di.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				try{
					ResultSet rs = DAO.getDeptKind();
					while(rs.next()){
						cbo.addItem(rs.getString("dkind"));
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
		di.setSize(new Dimension(500,400));
		//	确定mainFrame的显示位置(显示器中间)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = di.getSize();
		if(frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if(frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		di.setLocation((screenSize.width-frameSize.width)/2,
				(screenSize.height-frameSize.height)/2);
		p.setLayout(new BorderLayout());
		initTree();
		
		p.add(p1,BorderLayout.CENTER);
		p1.setLayout(new GridLayout(3,1));
		p1.add(p2);
		
		p2.setLayout(new FlowLayout());
		p2.add(new JLabel("输入部门名称:"));
		p2.add(txtdname);
		JButton btnadd = new JButton("添加");
		p2.add(btnadd);
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtdname.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入添加部门名称！","警告",JOptionPane.WARNING_MESSAGE);
				}
				boolean flag = DAO.addDept(txtdname.getText().trim());
				if(flag){
					di.dispose();
					DeptInfo di= new DeptInfo();
					JOptionPane.showMessageDialog(null,"添加部门成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"添加部门失败，请检查后再操作!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		p1.add(p3);
		p3.setLayout(new FlowLayout());
		p3.add(new JLabel("输入原部门名称:"));
		p3.add(txtyname);
		p3.add(new JLabel("输入新部门名称:"));
		p3.add(txtnname);
		JButton btnupdate = new JButton("修改");
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean flag = DAO.updateDept(txtyname.getText().trim(), txtnname.getText().trim());
				if(flag){
					di.dispose();
					DeptInfo di = new DeptInfo();
					JOptionPane.showMessageDialog(null,"修改部门成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"修改部门失败，请检查后再操作!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		p3.add(btnupdate);
		p1.add(p4);
		p4.setLayout(new FlowLayout());
		p4.add(new JLabel("选择部门："));
		p4.add(cbo);
		JButton btndele = new JButton("删除");
		btndele.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean flag = DAO.deleteDept(cbo.getSelectedItem().toString());
				if(flag){
					di.dispose();
					DeptInfo di = new DeptInfo();
					JOptionPane.showMessageDialog(null,"删除部门成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"删除部门失败，请检查后再操作!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		p4.add(btndele);
		di.setVisible(true);
	}
	
	
	
	public void initTree(){
		
		//创建根节点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("公司部门名称");
		//创建支节点
		ResultSet rs1 = DAO.getDeptKind();
		ResultSet rs2 = null;
		try{
			while(rs1.next()){
				String name = rs1.getString("dkind");
				DefaultMutableTreeNode banch = new DefaultMutableTreeNode(name);
				root.add(banch);
				rs2 = DAO.getDeptName(name);
				while(rs2.next()){
					DefaultMutableTreeNode node = new DefaultMutableTreeNode(rs2.getString("dname"));
					banch.add(node);
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		} 
		tree = new JTree(root);
		tree.setEditable(true);
		p.add(tree,BorderLayout.WEST);
	}

}
