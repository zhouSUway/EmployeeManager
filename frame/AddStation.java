package frame;

import javax.swing.*;

import com.DAO;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import model.FrameInit;
public class AddStation extends JFrame{
	JFrame as = new JFrame("��Ӹ�λ");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JLabel lblname = new JLabel("�����λ����:");
	JTextField txtname = new JTextField(10);
	JLabel lblkind = new JLabel("��λ���:");
	JComboBox cbokind = new JComboBox();
	JLabel lblsal = new JLabel("��λ����:");
	JTextField txtsal = new JTextField(10);
	JLabel lblmoddate = new JLabel("�����޸�����:");
	JTextField txtmoddate = new JTextField(10);
	JButton btnadd = new JButton("��Ӹ�λ");
	public AddStation() {
		// TODO Auto-generated constructor stub
		FrameInit.InitFrame(as, p);//��ʼ��frame
		as.setSize(new Dimension(300,300));
		//��ʼ����λ���������,��������ʱ���¼���Ӧ
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
		//��Ӱ�ť���¼���������
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//���Ʋ���Ϊ��
				if(txtname.getText().equals("")){
					JOptionPane.showMessageDialog(null, "�������λ����!","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//����Ϣ��װ��JavaBean
				TbStation info = new TbStation();
				info.setStationname(txtname.getText().trim());
				info.setStkindid(Integer.parseInt(cbokind.getSelectedItem().toString().trim()));
				info.setStsal(Integer.parseInt(txtsal.getText().trim()));
				info.setStsalmoddate(txtmoddate.getText().trim());
				//ִ�����
				boolean flag = DAO.addStation(info);
				//�ж��Ƿ�ɹ�
				if(flag){
					JOptionPane.showMessageDialog(null, "��Ӹ�λ�ɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "��Ӹ�λʧ��!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		as.setVisible(true);
	}

}
