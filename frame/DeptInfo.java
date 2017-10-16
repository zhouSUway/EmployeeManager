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
	JFrame di = new JFrame("���Ź���");
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
		//	ȷ��mainFrame����ʾλ��(��ʾ���м�)
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
		p2.add(new JLabel("���벿������:"));
		p2.add(txtdname);
		JButton btnadd = new JButton("���");
		p2.add(btnadd);
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(txtdname.getText().equals("")){
					JOptionPane.showMessageDialog(null, "��������Ӳ������ƣ�","����",JOptionPane.WARNING_MESSAGE);
				}
				boolean flag = DAO.addDept(txtdname.getText().trim());
				if(flag){
					di.dispose();
					DeptInfo di= new DeptInfo();
					JOptionPane.showMessageDialog(null,"��Ӳ��ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"��Ӳ���ʧ�ܣ�������ٲ���!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		p1.add(p3);
		p3.setLayout(new FlowLayout());
		p3.add(new JLabel("����ԭ��������:"));
		p3.add(txtyname);
		p3.add(new JLabel("�����²�������:"));
		p3.add(txtnname);
		JButton btnupdate = new JButton("�޸�");
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean flag = DAO.updateDept(txtyname.getText().trim(), txtnname.getText().trim());
				if(flag){
					di.dispose();
					DeptInfo di = new DeptInfo();
					JOptionPane.showMessageDialog(null,"�޸Ĳ��ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"�޸Ĳ���ʧ�ܣ�������ٲ���!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		p3.add(btnupdate);
		p1.add(p4);
		p4.setLayout(new FlowLayout());
		p4.add(new JLabel("ѡ���ţ�"));
		p4.add(cbo);
		JButton btndele = new JButton("ɾ��");
		btndele.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean flag = DAO.deleteDept(cbo.getSelectedItem().toString());
				if(flag){
					di.dispose();
					DeptInfo di = new DeptInfo();
					JOptionPane.showMessageDialog(null,"ɾ�����ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null,"ɾ������ʧ�ܣ�������ٲ���!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		p4.add(btndele);
		di.setVisible(true);
	}
	
	
	
	public void initTree(){
		
		//�������ڵ�
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��˾��������");
		//����֧�ڵ�
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
