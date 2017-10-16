package frame;

import javax.swing.*;

import java.awt.*;
import model.FrameInit;
import java.awt.event.*;
import com.DAO;
public class BasicInfoAdd extends JFrame{
	JFrame bif = new JFrame("������Ϣ���");
	JPanel p = new JPanel();
	
	JLabel lblxl = new JLabel("������ѧ������:");
	JTextField txtxl= new JTextField(10);
	JButton btnxl = new JButton("���ѧ��");
	public BasicInfoAdd(){
		FrameInit.InitFrame(bif, p);
		bif.setSize(new Dimension(300,100));
		bif.add(p,BorderLayout.CENTER);
		p.setLayout(new FlowLayout());
		p.add(lblxl);
		p.add(txtxl);
		p.add(btnxl);
		//���ѧ����ť�¼�����
		btnxl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String degree = txtxl.getText();
				if(degree.equals("")){
					JOptionPane.showMessageDialog(null, "������ѧ������!","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				boolean flag = DAO.addDegree(degree);
				if(flag){
					JOptionPane.showMessageDialog(null, "���ѧ���ɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "���ѧ��ʧ��!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		bif.setVisible(true);
		
	}
}
