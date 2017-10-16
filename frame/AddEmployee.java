package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.FrameInit;
import com.DAO;
import java.sql.*;
import model.TbEmployeeInfo;
public class AddEmployee extends JFrame{
	JFrame ae = new JFrame("员工信息添加");
	JPanel p = new JPanel();
	JTextField ename;
	JTextField eyname = new JTextField(10);
	JComboBox sex = new JComboBox();
	JTextField birthday = new JTextField(10);
	JComboBox nativeplace = new JComboBox();
	JComboBox nation = new JComboBox();
	JTextField hkszd = new JTextField(10);
	JLabel lhkszd = new JLabel("户口所在地:");
	JTextField bornaddress = new JTextField(10);
	JLabel lba = new JLabel("出生地:");
	JTextField commnityname = new JTextField(10);
	JLabel lcn = new JLabel("社区名称:");
	JTextField firstedu = new JTextField(10);
	JLabel lfedu = new JLabel("最初学历:");
	JTextField education = new JTextField(10);
	JLabel ledu = new JLabel("学历");
	JTextField school = new JTextField(10);
	JLabel lschool = new JLabel("毕业院校:");
	JLabel lsn = new JLabel("专业名称:");
	JComboBox cbospecialname = new JComboBox();
	JTextField intoschooldate = new JTextField(10);
	JLabel lisd = new JLabel("入学日期:");
	JTextField graduatedate = new JTextField(10);
	JLabel lgd = new JLabel("毕业日期:");
	JLabel life = new JLabel("是否第一学历:");
	JComboBox isfirstedu = new JComboBox();
	JLabel ldg = new JLabel("学位:");
	JComboBox degree = new JComboBox();
	JLabel ley = new JLabel("受教育年限:");
	JTextField eduyears = new JTextField(10);
	JLabel lsw = new JLabel("学习形式");
	JTextField studyway = new JTextField(10);
	JLabel lpf = new JLabel("政治面貌:");
	JComboBox ploityface = new JComboBox();
	JLabel lipd = new JLabel("入党时间:");
	JTextField intoparydate = new JTextField(10);
	JLabel lww = new JLabel("用工形式:");
	JTextField workway = new JTextField(10);
	JLabel ldn = new JLabel("职务:");
	JComboBox dutyname =new JComboBox();
	JLabel ls = new JLabel("岗位名称:");
	JComboBox cbos = new JComboBox();
	JLabel lsdn = new JLabel("专业技术职务:");
	JComboBox spedutyname = new JComboBox();
	JLabel lbwd = new JLabel("开始工作时间:");
	JTextField beginworkdate = new JTextField(10);
	JLabel lidd = new JLabel("入本单位时间:");
	JTextField intodeptdate = new JTextField(10);
	JLabel lws = new JLabel("工作状态:");
	JTextField workstate = new JTextField(10);
	JLabel lrdd = new JLabel("退休时间:");
	JTextField retireddate = new JTextField(10);
	JLabel lgrsf = new JLabel("个人身份:");
	JTextField grsf = new JTextField(10);
	JLabel lbgphone = new JLabel("办公电话:");
	JTextField bgphone = new JTextField(10);
	JLabel lsjphone = new JLabel("手机:");
	JTextField sjphone = new JTextField(10);
	JLabel lhp = new JLabel("家庭电话:");
	JTextField homephone = new JTextField(10);
	JLabel lfyzym = new JLabel("复原转业标识:");
	JTextField fyzymark = new JTextField(10);
	JLabel lidcard = new JLabel("身份证号:");
	JTextField idcard = new JTextField(10);
	JLabel lxxdate = new JLabel("下乡日期:");
	JTextField xxdate = new JTextField(10);
	JLabel lldhtid = new JLabel("劳动合同编号:");
	JTextField ldhtid = new JTextField(10);
	JLabel lden = new JLabel("部门编号:");
	JComboBox deptno = new JComboBox();
	JLabel lcln = new JLabel("班组名称:");
	JTextField classname = new JTextField(10);
	JLabel lmenu = new JLabel("备注:");
	JTextArea menu = new JTextArea();
	JButton btnadd = new JButton("添加");
	JButton btnreset = new JButton("重置");
	public AddEmployee(){
		FrameInit.InitFrame(ae, p);
		//添加打开窗口时的事件监听器，初始化下拉列表
		ae.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				ResultSet rs1 = DAO.getNativePlace();
				ResultSet rs2 = DAO.getDegree();
				ResultSet rs3 = DAO.getNation();
				ResultSet rs4 = DAO.getDutyName();
				ResultSet rs5 = DAO.getSpecialDuty();
				ResultSet rs6 = DAO.getDeptID();
				ResultSet rs7 = DAO.getSpecialname();
				ResultSet rs8 = DAO.getStationname();
				try{
					while(rs1.next()){
						nativeplace.addItem(rs1.getString("npname"));
					}
					while(rs2.next()){
						degree.addItem(rs2.getString("degree"));
					}
					while(rs3.next()){
						nation.addItem(rs3.getString("nation"));
					}
					while(rs4.next()){
						dutyname.addItem(rs4.getString("dutyname"));
					}
					while(rs5.next()){
						spedutyname.addItem(rs5.getString("sdname"));
					}
					while(rs6.next()){
						deptno.addItem(new Integer(rs6.getInt("dkid")));
					}
					while(rs7.next()){
						cbospecialname.addItem(rs7.getString("sname"));
					}
					while(rs8.next()){
						cbos.addItem(rs8.getString("stationname"));
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
		ae.setSize(new Dimension(900,400));
		p.setLayout(new GridLayout(11,8));
		JLabel lblename = new JLabel("员工姓名:");
		p.add(lblename);
		ename = new JTextField(10);
		p.add(ename);
		JLabel lblyename = new JLabel("曾用名:");
		p.add(lblyename);
		p.add(eyname);
		JLabel lsex = new JLabel("性别:");
		p.add(lsex);
		sex.addItem("男");
		sex.addItem("女");
		p.add(sex);
		JLabel lsr = new JLabel("出生日期:");
		p.add(lsr);
		p.add(birthday);
		JLabel ljg = new JLabel("籍贯");
		p.add(ljg);
		p.add(nativeplace);
		JLabel lmz = new JLabel("民族");
		p.add(lmz);
		p.add(nation);
		p.add(lhkszd);
		p.add(hkszd);
		p.add(lba);
		p.add(bornaddress);
		p.add(lcn);
		p.add(commnityname);
		p.add(lfedu);
		p.add(firstedu);
		p.add(ledu);
		p.add(education);
		p.add(lschool);
		p.add(school);
		p.add(lsn);
		p.add(cbospecialname);
		p.add(lisd);
		p.add(intoschooldate);
		p.add(lgd);
		p.add(graduatedate);
		isfirstedu.addItem("是");
		isfirstedu.addItem("否");
		p.add(life);
		p.add(isfirstedu);
		p.add(ldg);
		p.add(degree);
		p.add(ley);
		p.add(eduyears);
		p.add(lsw);
		p.add(studyway);
		p.add(lpf);
		ploityface.addItem("群众");
		ploityface.addItem("团员");
		ploityface.addItem("中共党员");
		ploityface.addItem("其他党派人士");
		p.add(ploityface);
		p.add(lipd);
		p.add(intoparydate);
		p.add(lww);
		p.add(workway);
		p.add(ldn);
		p.add(dutyname);
		p.add(ls);
		p.add(cbos);
		p.add(lsdn);
		p.add(spedutyname);
		p.add(lbwd);
		p.add(beginworkdate);
		p.add(lidd);
		p.add(intodeptdate);
		p.add(lws);
		p.add(workstate);
		p.add(lrdd);
		p.add(retireddate);
		p.add(lgrsf);
		p.add(grsf);
		p.add(lbgphone);
		p.add(bgphone);
		p.add(lsjphone);
		p.add(sjphone);
		p.add(lhp);
		p.add(homephone);
		p.add(lfyzym);
		p.add(fyzymark);
		p.add(lidcard);
		p.add(idcard);
		p.add(lxxdate);
		p.add(xxdate);
		p.add(lldhtid);
		p.add(ldhtid);
		p.add(lden);
		p.add(deptno);
		p.add(lcln);
		p.add(classname);
		p.add(lmenu);
		p.add(menu);
		p.add(new JLabel());
		p.add(new JLabel());
		p.add(new JLabel());
		p.add(btnadd);
		p.add(btnreset);
		//添加按钮事件监听程序
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ename.equals("") || dutyname.equals("") || spedutyname.equals("") || idcard.equals("") ||
						deptno.equals("") || idcard.equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的员工信息！","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}else{
					//封装到人员实体
					TbEmployeeInfo info = new TbEmployeeInfo();
					info.setEname(ename.getText().trim());
					info.setEyname(eyname.getText().trim());
					info.setSex(sex.getSelectedItem().toString().trim());
					info.setBirthday(birthday.getText().trim());
					info.setNativeplace(nativeplace.getSelectedItem().toString().trim());
					info.setNation(nation.getSelectedItem().toString().trim());
					info.setHkszd(hkszd.getText().trim());
					info.setBornaddress(bornaddress.getText());
					info.setCommnityname(commnityname.getText().trim());
					info.setFirstedu(firstedu.getText().trim());
					info.setEducation(education.getText().trim());
					info.setSchool(school.getText().trim());
					info.setSpecialname(cbospecialname.getSelectedItem().toString().trim());
					info.setIntoschooldate(intoschooldate.getText().trim());
					info.setGraduatedate(graduatedate.getText().trim());
					info.setIsfirstedu(isfirstedu.getSelectedItem().toString().trim());
					info.setDegree(degree.getSelectedItem().toString().trim());
					info.setEduyears(Integer.parseInt(eduyears.getText().trim()));
					info.setStudyway(studyway.getText().trim());
					info.setPolityface(ploityface.getSelectedItem().toString().trim());
					info.setIntopartydate(intoparydate.getText().trim());
					info.setWorkway(workway.getText().trim());
					info.setDutyname(dutyname.getSelectedItem().toString().trim());
					info.setStationname(cbos.getSelectedItem().toString().trim());
					info.setSpedutyname(spedutyname.getSelectedItem().toString().trim());
					info.setBeginworkdate(beginworkdate.getText().trim());
					info.setIntodeptdate(intodeptdate.getText().trim());
					info.setWorkstate(workstate.getText().trim());
					info.setRetireddate(retireddate.getText().trim());
					info.setGrsf(grsf.getText().trim());
					info.setBgphone(bgphone.getText().trim());
					info.setSjphone(sjphone.getText());
					info.setHomephone(homephone.getText().trim());
					info.setFyzymark(fyzymark.getText().trim());
					info.setIdcard(idcard.getText().trim());
					info.setXxdate(xxdate.getText().trim());
					info.setLdhtid(ldhtid.getText());
					info.setDeptno(Integer.parseInt(deptno.getSelectedItem().toString().trim()));
					info.setClassname(classname.getText().trim());
					info.setMenu(menu.getText().trim());
					boolean flag = DAO.addEmployee(info);
					if(flag){
						JOptionPane.showMessageDialog(null, "添加员工成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null, "添加员工失败!","发生错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		//重置按钮事件监听程序
		btnreset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ename.setText("");
				eyname.setText("");
				birthday.setText("");
				hkszd.setText("");
				bornaddress.setText("");
				education.setText("");
				commnityname.setText("");
				firstedu.setText("");
				school.setText("");
				intoschooldate.setText("");
				graduatedate.setText("");
				eduyears.setText("");
				studyway.setText("");
				intoparydate.setText("");
				workway.setText("");
				beginworkdate.setText("");
				intodeptdate.setText("");
				retireddate.setText("");
				grsf.setText("");
				bgphone.setText("");
				sjphone.setText("");
				homephone.setText("");
				fyzymark.setText("");
				idcard.setText("");
				xxdate.setText("");
				ldhtid.setText("");
				classname.setText("");
				menu.setText("");
			}
		});
		ae.setVisible(true);
	}
	
}
