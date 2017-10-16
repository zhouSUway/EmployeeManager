package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame{
	JFrame mainFrame = new JFrame("员工信息管理系统");
	JPanel p = new JPanel();
	JLabel label = new JLabel("欢迎使用企业部门员工信息管理系统");
	JLabel label2 = new JLabel("copy@Northeastern University 欧阳英");
	JMenuBar jmb = new JMenuBar();
	JMenu jm1 = new JMenu();
	JMenu jm2 = new JMenu();
	JMenu jm3 = new JMenu();
	JMenu jm4 = new JMenu();
	JMenu jm5 = new JMenu();
	JMenuItem jmi = new JMenuItem();
	JMenuItem jmi1 = new JMenuItem();
	JMenuItem jmi2 = new JMenuItem();
	JMenuItem jmi3 = new JMenuItem();
	JMenuItem jmi4 = new JMenuItem();
	JMenuItem jmi5 = new JMenuItem();
	JMenuItem jmi6 = new JMenuItem();
	JMenuItem jmi7 = new JMenuItem();
	JMenuItem jmi8 = new JMenuItem();
	JMenuItem jmi9 = new JMenuItem();
	JMenuItem jmi10 = new JMenuItem();
	JMenuItem jmi11 = new JMenuItem();
	/**
	 * @param args
	 */
	private void init(){
		//设置mainFrame的panel，关闭方式，大小
		mainFrame.add(p,BorderLayout.CENTER);
		//禁用了关闭按钮，只能从菜单栏中退出
		mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(screenSize.width,screenSize.height-40);
		
		//设置panel的Layout
		p.setLayout(new BorderLayout());
		
		//将标签初始化，将其加入到panel中
		label.setFont(new java.awt.Font("华文新魏",Font.BOLD,50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(50,73,55));
		
		label2.setFont(new java.awt.Font("宋体",Font.BOLD,20));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(50,73,55));
		p.add(label, BorderLayout.CENTER);
		p.add(label2, BorderLayout.SOUTH);
		
		//向窗体中添加菜单,并向菜单项添加事件监听程序
		jm4.setText("部门管理");
		jmi6.setText("部门信息查询与管理");
		jmi6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeptInfo di =new DeptInfo();
			}
		});
		jm4.add(jmi6);
		
		jm1.setText("信息查询");
		jmi.setText("查询全部员工信息");
		jmi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryAllEmployee qae = new QueryAllEmployee();
			}
		});
		jmi1.setText("条件查询");
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryCondition qc = new QueryCondition();
			}
		});
		jm1.add(jmi);
		jm1.add(jmi1);
		jm2.setText("员工信息操作");
		jmi7.setText("添加员工信息");
		jmi2.setText("修改员工信息");
		jmi3.setText("删除员工信息");
		jm2.add(jmi7);
		jm2.add(jmi2);
		jm2.add(jmi3);
		jmi2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateEmpInfo uei = new UpdateEmpInfo();
			}
		});
		jmi3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeleteEmployee de = new DeleteEmployee();
			}
		});
		jmi7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddEmployee ae = new AddEmployee();
			}
		});
		jm5.setText("基本信息管理");
		jmi8.setText("学历添加");
		jmi8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BasicInfoAdd bif = new BasicInfoAdd();
			}
		});
		jmi9.setText("职务添加");
		jmi9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDuty ad = new AddDuty();
			}
		});
		jmi10.setText("职称添加");
		jmi10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddSpecialDuty asd = new AddSpecialDuty();
			}
		});
		jmi11.setText("岗位添加");
		jmi11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStation as= new AddStation();
			}
		});
		jm5.add(jmi8);
		jm5.add(jmi9);
		jm5.add(jmi10);
		jm5.add(jmi11);
		
		jm3.setText("系统");
		jmi5.setText("有关本系统");
		jmi4.setText("退出系统");
		jm3.add(jmi5);
		jm3.add(jmi4);
		jmi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result = JOptionPane.showConfirmDialog(mainFrame, "您确定离开本系统吗？", "友情提示", JOptionPane.OK_CANCEL_OPTION);
				if(result==JOptionPane.OK_OPTION){
					System.exit(0);
				}else{
					
				}
			}
		});
		jmi5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				About a = new About();
			}
		});
		jmb.add(jm4);
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm5);
		jmb.add(jm3);
		
	
		mainFrame.setJMenuBar(jmb);
		
		
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf = new MainFrame();
		mf.init();

	}

}
