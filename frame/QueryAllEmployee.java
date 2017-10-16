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
	JFrame qae = new JFrame("全部员工信息表");
	JTable table = new JTable();
	JLabel label = new JLabel();
	//将JTable放入JScrollPane中
	JScrollPane scroll = new JScrollPane(table);
	
	public QueryAllEmployee(){
		init();
	}
	public void init(){
		qae.add(scroll,BorderLayout.CENTER);
		qae.pack();
		//确定mainFrame的显示位置(显示器中间)
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
		label.setText("员工的信息如下：");
		qae.add(label,BorderLayout.NORTH);
		//初始化表
		getEmployee();
		
		qae.setVisible(true);
	}
	public void getEmployee(){
		//TableModel的一个实现，使用一个Vector来存储单元个的值对象，构造一个零行零列的表
		DefaultTableModel dt = new DefaultTableModel();
		//从数据库得到结果集
		ResultSet rs = DAO.getEmployee();
		try{
			//用于获取ResultSet对象中列的类型和属性的对象
			ResultSetMetaData rsmd = rs.getMetaData();
			//得到列的数量
			int numOfCol = rsmd.getColumnCount();
			int b = 1;
			//向TableModel中添加列
			while(b<=numOfCol){
				dt.addColumn(rsmd.getColumnName(b));
				b++;
			}
			table.getTableHeader().setVisible(true);
			//table.setAutoCreateColumnsFromModel(true);
			//将结果集中的每条记录封装到vector向量中
			while(rs.next()){
				Vector newRow = new Vector();
				int c = 1;
				while(c<=numOfCol){
					newRow.addElement(rs.getString(c));
					c++;
				}
				//向TableModel中添加行
				dt.addRow(newRow);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		//将Table的数据模型设置为dt
		table.setModel(dt);
		//scroll.setViewportView(table);
		
	}

}
