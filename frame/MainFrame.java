package frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame{
	JFrame mainFrame = new JFrame("Ա����Ϣ����ϵͳ");
	JPanel p = new JPanel();
	JLabel label = new JLabel("��ӭʹ����ҵ����Ա����Ϣ����ϵͳ");
	JLabel label2 = new JLabel("copy@Northeastern University ŷ��Ӣ");
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
		//����mainFrame��panel���رշ�ʽ����С
		mainFrame.add(p,BorderLayout.CENTER);
		//�����˹رհ�ť��ֻ�ܴӲ˵������˳�
		mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(screenSize.width,screenSize.height-40);
		
		//����panel��Layout
		p.setLayout(new BorderLayout());
		
		//����ǩ��ʼ����������뵽panel��
		label.setFont(new java.awt.Font("������κ",Font.BOLD,50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(50,73,55));
		
		label2.setFont(new java.awt.Font("����",Font.BOLD,20));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(50,73,55));
		p.add(label, BorderLayout.CENTER);
		p.add(label2, BorderLayout.SOUTH);
		
		//��������Ӳ˵�,����˵�������¼���������
		jm4.setText("���Ź���");
		jmi6.setText("������Ϣ��ѯ�����");
		jmi6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeptInfo di =new DeptInfo();
			}
		});
		jm4.add(jmi6);
		
		jm1.setText("��Ϣ��ѯ");
		jmi.setText("��ѯȫ��Ա����Ϣ");
		jmi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryAllEmployee qae = new QueryAllEmployee();
			}
		});
		jmi1.setText("������ѯ");
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryCondition qc = new QueryCondition();
			}
		});
		jm1.add(jmi);
		jm1.add(jmi1);
		jm2.setText("Ա����Ϣ����");
		jmi7.setText("���Ա����Ϣ");
		jmi2.setText("�޸�Ա����Ϣ");
		jmi3.setText("ɾ��Ա����Ϣ");
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
		jm5.setText("������Ϣ����");
		jmi8.setText("ѧ�����");
		jmi8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BasicInfoAdd bif = new BasicInfoAdd();
			}
		});
		jmi9.setText("ְ�����");
		jmi9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDuty ad = new AddDuty();
			}
		});
		jmi10.setText("ְ�����");
		jmi10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddSpecialDuty asd = new AddSpecialDuty();
			}
		});
		jmi11.setText("��λ���");
		jmi11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStation as= new AddStation();
			}
		});
		jm5.add(jmi8);
		jm5.add(jmi9);
		jm5.add(jmi10);
		jm5.add(jmi11);
		
		jm3.setText("ϵͳ");
		jmi5.setText("�йر�ϵͳ");
		jmi4.setText("�˳�ϵͳ");
		jm3.add(jmi5);
		jm3.add(jmi4);
		jmi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result = JOptionPane.showConfirmDialog(mainFrame, "��ȷ���뿪��ϵͳ��", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
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
