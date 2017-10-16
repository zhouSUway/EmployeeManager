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
	JFrame qc = new JFrame("条件查询员工信息");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JComboBox cbo = new JComboBox();
	JComboBox cbocon = new JComboBox();
	JLabel lblcon = new JLabel("请选择查询条件");
	JButton btnquery = new JButton("查询");
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
		cbo.addItem("人员编码");
		cbo.addItem("姓名");
		cbo.addItem("职务");
		cbo.addItem("年龄");
		cbo.addItem("性别");
		cbo.addItem("职称");
		cbo.addItem("部门");
		cbo.addItem("受聘时间");
		cbo.addItem("籍贯");
		cbo.addItem("学位");
		cbo.addItem("政治面貌");
		p1.add(cbo);
		cbo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String con = cbo.getSelectedItem().toString().trim();
				if(con.equals("人员编码")){
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
				else if(con.equals("姓名")){
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
				else if(con.equals("职务")){
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
				else if(con.equals("年龄")){
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
				else if(con.equals("性别")){
					cbocon.removeAllItems();
					cbocon.addItem("男");
					cbocon.addItem("女");
					return;
				}
				else if(con.equals("职称")){
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
				else if(con.equals("部门")){
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
				else if(con.equals("受聘时间")){
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
				else if(con.equals("籍贯")){
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
				else if(con.equals("学位")){
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
				else if(con.equals("政治面貌")){
					cbocon.removeAllItems();
					cbocon.addItem("群众");
					cbocon.addItem("团员");
					cbocon.addItem("中共党员");
					cbocon.addItem("其他党派人士");
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
				//TableModel的一个实现，使用一个Vector来存储单元个的值对象，构造一个零行零列的表
				DefaultTableModel dt = new DefaultTableModel();
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
					tb.getTableHeader().setVisible(true);
					
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
				tb.setModel(dt);
				
			}
		});
		
		qc.setVisible(true);
		
	}
}
