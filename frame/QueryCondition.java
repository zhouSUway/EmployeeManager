package frame;

import java.sql.*;
import java.util.Vector;

import com.DAO;
import java.awt.*;
import model.FrameInit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
public class QueryCondition extends JFrame{
	JFrame qc = new JFrame("������ѯԱ����Ϣ");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JComboBox cbo = new JComboBox();
	JComboBox cbocon = new JComboBox();
	JLabel lblcon = new JLabel("��ѡ���ѯ����");
	JButton btnquery = new JButton("��ѯ");
	JTable tb = new JTable();
	JScrollPane scroll = new JScrollPane(tb);
	public QueryCondition(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(qc, p);
		qc.add(scroll,BorderLayout.CENTER);
		qc.add(p1,BorderLayout.NORTH);
		p1.add(lblcon);
		cbo.addItem("��Ա����");
		cbo.addItem("����");
		cbo.addItem("ְ��");
		cbo.addItem("����");
		cbo.addItem("�Ա�");
		cbo.addItem("ְ��");
		cbo.addItem("����");
		cbo.addItem("��Ƹʱ��");
		cbo.addItem("����");
		cbo.addItem("ѧλ");
		cbo.addItem("������ò");
		p1.add(cbo);
		cbo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String con = cbo.getSelectedItem().toString().trim();
				if(con.equals("��Ա����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getEmployeeId();
						while(rs.next()){
							cbocon.addItem(new Integer((rs.getInt("empid"))));
						}
						return;
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				}
				else if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getEmployeeName();
						while(rs.next()){
							cbocon.addItem(rs.getString("ename"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("ְ��")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getDutyName();
						while(rs.next()){
							cbocon.addItem(rs.getString("dutyname"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getEmployeeAge();
						while(rs.next()){
							
							cbocon.addItem(rs.getString("birthday"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("�Ա�")){
					cbocon.removeAllItems();
					cbocon.addItem("��");
					cbocon.addItem("Ů");
					return;
				}
				else if(con.equals("ְ��")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getSpecialDuty();
						while(rs.next()){
							cbocon.addItem(rs.getString("sdname"));
						}
						return;
					}catch(Exception ex){
						System.out.println(ex.getMessage());
						return;
					}
				}
				else if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getDeptKind();
						while(rs.next()){
							cbocon.addItem(rs.getString("dkind"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("��Ƹʱ��")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getHiredate();
						while(rs.next()){
							cbocon.addItem(rs.getString("beginworkdate"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getNativePlace();
						while(rs.next()){
							cbocon.addItem(rs.getString("npname"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("ѧλ")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = DAO.getDegree();
						while(rs.next()){
							cbocon.addItem(rs.getString("degree"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("������ò")){
					cbocon.removeAllItems();
					cbocon.addItem("Ⱥ��");
					cbocon.addItem("��Ա");
					cbocon.addItem("�й���Ա");
					cbocon.addItem("����������ʿ");
				}
				
			}
		});
		p1.add(cbocon);
		p1.add(btnquery);
		btnquery.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String con = cbo.getSelectedItem().toString().trim();
				String conc = cbocon.getSelectedItem().toString();
				System.out.println(conc);
				ResultSet rs = DAO.getConditionEmp(con, conc);
				//TableModel��һ��ʵ�֣�ʹ��һ��Vector���洢��Ԫ����ֵ���󣬹���һ���������еı�
				DefaultTableModel dt = new DefaultTableModel();
				try{
					//���ڻ�ȡResultSet�������е����ͺ����ԵĶ���
					ResultSetMetaData rsmd = rs.getMetaData();
					//�õ��е�����
					int numOfCol = rsmd.getColumnCount();
					int b = 1;
					//��TableModel�������
					while(b<=numOfCol){
						dt.addColumn(rsmd.getColumnName(b));
						b++;
					}
					tb.getTableHeader().setVisible(true);
					
					//��������е�ÿ����¼��װ��vector������
					while(rs.next()){
						Vector newRow = new Vector();
						int c = 1;
						while(c<=numOfCol){
							newRow.addElement(rs.getString(c));
							c++;
						}
						//��TableModel�������
						dt.addRow(newRow);
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				//��Table������ģ������Ϊdt
				tb.setModel(dt);
				
			}
		});
		
		qc.setVisible(true);
		
	}
}
