package frame;

import com.DAO;
import java.awt.*;
import java.awt.event.*;
import model.FrameInit;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;
import java.util.*;
public class QueryAllEmployee extends JFrame{
	JFrame qae = new JFrame("ȫ��Ա����Ϣ��");
	JTable table = new JTable();
	JLabel label = new JLabel();
	//��JTable����JScrollPane��
	JScrollPane scroll = new JScrollPane(table);
	
	public QueryAllEmployee(){
		init();
	}
	public void init(){
		qae.add(scroll,BorderLayout.CENTER);
		qae.pack();
		//ȷ��mainFrame����ʾλ��(��ʾ���м�)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = qae.getSize();
		if(frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if(frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		qae.setSize(screenSize.width,screenSize.height);
		scroll.setAutoscrolls(true);
		label.setText("Ա������Ϣ���£�");
		qae.add(label,BorderLayout.NORTH);
		//��ʼ����
		getEmployee();
		
		qae.setVisible(true);
	}
	public void getEmployee(){
		//TableModel��һ��ʵ�֣�ʹ��һ��Vector���洢��Ԫ����ֵ���󣬹���һ���������еı�
		DefaultTableModel dt = new DefaultTableModel();
		//�����ݿ�õ������
		ResultSet rs = DAO.getEmployee();
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
			table.getTableHeader().setVisible(true);
			//table.setAutoCreateColumnsFromModel(true);
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
		table.setModel(dt);
		//scroll.setViewportView(table);
		
	}

}
