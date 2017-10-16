package frame;

import javax.swing.*;
import model.FrameInit;
import com.DAO;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class DeleteEmployee extends JFrame{
	JFrame de = new JFrame("ɾ��Ա����Ϣ");
	JPanel p = new JPanel();
	JPanel ptop = new JPanel();
	JLabel lblename = new JLabel("��ѡ��Ҫɾ����Ա������:");
	JComboBox cboename = new JComboBox();
	JButton btndelete = new JButton("ɾ��");
	public DeleteEmployee(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(de, p);
		p.setLayout(new BorderLayout());
		p.add(ptop, BorderLayout.CENTER);
		//�򿪴���ʱ���¼���������ʼ�������б�ename
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
		//ɾ����ť���¼���������
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name = cboename.getSelectedItem().toString().trim();
				boolean flag = DAO.deleteEmployee(name);
				if(flag){
					JOptionPane.showMessageDialog(null, "ɾ����Ϣ�ɹ���","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ����飡","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		de.setSize(500,80);
		de.setVisible(true);
	}
}
