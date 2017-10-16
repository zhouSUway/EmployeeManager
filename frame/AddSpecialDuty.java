package frame;

import javax.swing.*;

import java.awt.*;
import model.*;
import java.awt.event.*;
import com.DAO;
import java.sql.*;
public class AddSpecialDuty extends JFrame{
	JFrame asd = new JFrame("ְ�����");
	JPanel p = new JPanel();
	JLabel lblduty = new JLabel("ְ������:");
	JTextField txtduty = new JTextField(10);
	JLabel lg = new JLabel("ְ�Ƶȼ�:");
	JComboBox cbodg = new JComboBox();
	JLabel ls = new JLabel("ְ������:");
	JComboBox cbos = new JComboBox();
	JLabel lmark = new JLabel("Ƹ�α�־:");
	JTextField txtmark = new JTextField(10);
	JLabel lhd = new JLabel("Ƹ������:");
	JTextField thd = new JTextField(10);
	JLabel lfd = new JLabel("��Ƹ����:");
	JTextField tfd = new JTextField(10);
	JLabel lsaldg = new JLabel("���ʵȼ�:");
	JTextField txtsaldg = new JTextField(10);
	JLabel lsal = new JLabel("���ʽ��:");
	JTextField txtsal = new JTextField(10);
	JLabel lsdmd = new JLabel("���ʵ���ʱ��:");
	JTextField tsdmd = new JTextField(10);
	JButton btnduty = new JButton("���ְ��");
	public AddSpecialDuty() {
		// ��ʼ��
		FrameInit.InitFrame(asd, p);
		asd.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				ResultSet rs1 = DAO.getSpecialDutygrade();
				ResultSet rs2 = DAO.getSpecialserial();
				try{
					//��ʼ���ȼ�������
					while(rs1.next()){
						cbodg.addItem(new Integer(rs1.getInt("sdgrade")));
					}
					//��ʼ������������
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
		//��Ӱ�ť���¼�����
		btnduty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//���Ʋ���Ϊ��
				if(txtduty.getText().equals("")){
					JOptionPane.showMessageDialog(null, "������ְ������!","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//��װ��ʵ��
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
				//ִ�в���
				boolean flag = DAO.addSpecialduty(info);
				//�ж��Ƿ�ִ�гɹ�
				if(flag){
					JOptionPane.showMessageDialog(null, "���ְ�Ƴɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "���ְ��ʧ��!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		asd.setVisible(true);
	}

}
