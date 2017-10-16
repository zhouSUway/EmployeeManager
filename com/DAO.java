package com;

import java.sql.*;
import model.*;
public class DAO {
	private static Connection conn = null;
	private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	//private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:odbc:JDBC_ODBC";
	//private static String url = "jdbc:oracle:thin:@localhost:1521:NEUSOFT";
	//private static String user = "SCOTT";
	//private static String pwd = "TIGER";
	/**
	 * �������ݿ�
	 * @return
	 */
	public static Connection getConnection(){
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url);
			if(conn!=null){
				System.out.println("����sql server���ݿ�ɹ���");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return conn;
	}
	/**
	 * ��ѯרҵ����
	 * @return
	 */
	public static ResultSet getSpecialname(){
		String sql = "select sname from tb_special";
		ResultSet rs = DAO.getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯ��λ����
	 * @return
	 */
	public static ResultSet getStationname(){
		String sql = "select stationname from tb_stationinfo";
		ResultSet rs = DAO.getResultSet(sql);
		return rs;
	}
	/**
	 *  �õ����в���
	 * @return
	 */
	public static ResultSet getDeptKind(){
		conn = DAO.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select dkind from tb_deptkind");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return rs;
	}
	/**
	 * �õ���������
	 * @param dname
	 * @return
	 */
	public static ResultSet getDeptName(String name){
		conn = DAO.getConnection();
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try{
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery("select dkid from tb_deptkind where dkind='"+name+"'");
			while(rs1.next()){
				rs2 = stmt.executeQuery("select dname from tb_deptinfo where dkid="+rs1.getInt(1)+"");
			}
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return rs2;
	}
	/**
	 * ��ѯ����id
	 * @return
	 */
	public static ResultSet getDeptID(){
		String sql = "select dkid from tb_deptkind";
		ResultSet rs = DAO.getResultSet(sql);
		return rs;
	}
	/**
	 * �õ�Ա����Ϣ
	 * @return
	 */
	public static ResultSet getEmployee(){
		conn = DAO.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_employee");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	/**
	 * ��ѯָ����Ա����Ϣ
	 * @param id
	 * @return
	 */
	public static TbEmployeeInfo getSpeEmployee(int id){
		TbEmployeeInfo info = new TbEmployeeInfo();
		conn = DAO.getConnection();
		
		ResultSet rs = null;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_employee where empid="+id+"");
			while(rs.next()){
				info.setEname(rs.getString("ename"));
				info.setEyname(rs.getString("eyname"));
				info.setSex(rs.getString("sex"));
				info.setBirthday(rs.getString("birthday"));
				info.setNativeplace(rs.getString("nativeplace"));
				info.setNation(rs.getString("nation"));
				info.setHkszd(rs.getString("hkszd"));
				info.setBornaddress(rs.getString("bornaddress"));
				info.setCommnityname(rs.getString("commnityname"));
				info.setFirstedu(rs.getString("firstedu"));
				info.setEducation(rs.getString("education"));
				info.setSchool(rs.getString("school"));
				info.setSpecialname(rs.getString("specialname"));
				info.setIntoschooldate(rs.getString("intoschooldate"));
				info.setGraduatedate(rs.getString("graduatedate"));
				info.setIsfirstedu(rs.getString("isfirstedu"));
				info.setDegree(rs.getString("degree"));
				info.setEduyears(rs.getInt("eduyears"));
				info.setStudyway(rs.getString("studyway"));
				info.setPolityface(rs.getString("polityface"));
				info.setIntopartydate(rs.getString("intoparydate"));
				info.setWorkway(rs.getString("workway"));
				info.setDutyname(rs.getString("dutyname"));
				info.setBeginworkdate(rs.getString("beginworkdate"));
				info.setIntodeptdate(rs.getString("intodeptdate"));
				info.setWorkstate(rs.getString("workstate"));
				info.setRetireddate(rs.getString("retireddate"));
				info.setGrsf(rs.getString("grsf"));
				info.setBgphone(rs.getString("bgphone"));
				info.setSjphone(rs.getString("sjphone"));
				info.setHomephone(rs.getString("homephone"));
				info.setFyzymark(rs.getString("fyzymark"));
				info.setIdcard(rs.getString("idcard"));
				info.setXxdate(rs.getString("xxdate"));
				info.setLdhtid(rs.getString("ldhtid"));
				info.setDeptno(rs.getInt("deptno"));
				info.setClassname(rs.getString("classname"));
				info.setMenu(rs.getString("menu"));
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return info;
	}
	
	/**
	 *  �޸�Ա����Ϣ
	 * @param info
	 * @return
	 */
	public static boolean updateSpeEmployee(TbEmployeeInfo info){
		String sql = "update tb_employee set ename='"+info.getEname()+"',eyname='"+info.getEyname()+
		"',sex='"+info.getSex()+"',birthday='"+info.getBirthday()+"',nativeplace='"+info.getNativeplace()+
		"',nation='"+info.getNation()+"',hkszd='"+info.getHkszd()+"',bornaddress='"+info.getBornaddress()+
		"',commnityname='"+info.getCommnityname()+"',firstedu='"+info.getFirstedu()+"',education='"+info.getEducation()+
		"',school='"+info.getSchool()+"',intoschooldate='"+info.getIntoschooldate()+
		"',graduatedate='"+info.getGraduatedate()+"',isfirstedu='"+info.getIsfirstedu()+"',degree='"+info.getDegree()+
		"',eduyears="+info.getEduyears()+",studyway='"+info.getStudyway()+"',polityface='"+info.getPolityface()+
		"',intoparydate='"+info.getIntopartydate()+"',workway='"+info.getWorkway()+"',dutyname='"+info.getDutyname()+
		"',spedutyname='"+info.getSpedutyname()+"',beginworkdate='"+info.getBeginworkdate()+"',intodeptdate='"+info.getIntodeptdate()+
		"',workstate='"+info.getWorkstate()+"',retireddate='"+info.getRetireddate()+"',grsf='"+info.getGrsf()+"',bgphone='"+info.getBgphone()+
		"',sjphone='"+info.getSjphone()+"',homephone='"+info.getHomephone()+"',fyzymark='"+info.getFyzymark()+
		"',idcard='"+info.getIdcard()+"',xxdate='"+info.getXxdate()+"',ldhtid='"+info.getLdhtid()+
		"',deptno="+info.getDeptno()+",classname='"+info.getClassname()+"',menu='"+info.getMenu()+"' where empid="+info.getEmpid()+"";
		conn = DAO.getConnection();
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			if(count>0)
				return true;
			else
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * ��Ӳ�������
	 * @param name
	 * @return
	 */
	public static boolean addDept(String name){
		conn = DAO.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_deptkind where dkind='"+name+"'");
			if(!rs.next()){
				int count = stmt.executeUpdate("insert into tb_deptkind values('"+name+"')");
				if(count>0){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * �޸Ĳ�������
	 * @param yname
	 * @param nname
	 * @return
	 */
	public static boolean updateDept(String yname,String nname){
		conn = DAO.getConnection();
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			int count = stmt.executeUpdate("update tb_deptkind set dkind='"+nname+"' where dkind='"+yname+"'");
			if(count>0)
				return true;
			else
				return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	/**
	 * ɾ������
	 * @param name
	 * @return
	 */
	public static boolean deleteDept(String name){
		conn = DAO.getConnection();
		int id = 0;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select dkid from tb_deptkind where dkind='"+name+"'");
			while(rs.next()){
				id = rs.getInt(1);
			}
			rs1 = stmt.executeQuery("select * from tb_deptinfo where dkid="+id+"");
			if(rs1.next()){
				return false;
			}else{
				int count = stmt.executeUpdate("delete from tb_deptkind where dkind='"+name+"'");
				if(count>0){
					return true;
				}else{
					return false;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	/**
	 * ��ѯempid
	 * @return
	 */
	public static ResultSet getEmployeeId(){
		conn = DAO.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select empid from tb_employee");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return rs;
	}
	/**
	 * ��ѯename
	 * @return
	 */
	public static ResultSet getEmployeeName(){
		String sql = "select ename from tb_employee";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯdutyname
	 * @return
	 */
	public static ResultSet getDutyName(){
		String sql = "select dutyname from tb_duty";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯԱ����������
	 * @return
	 */
	public static ResultSet getEmployeeAge(){
		String sql = "select birthday from tb_employee";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯְ��
	 * @return
	 */
	public static ResultSet  getSpecialDuty(){
		String sql = "select sdname from tb_specialduty";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯ��Ƹ����
	 * @return
	 */
	public static ResultSet getHiredate(){
		String sql = "select beginworkdate from tb_employee";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯ����
	 * @return
	 */
	public static ResultSet getNation(){
		String sql = "select nation from tb_nation";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯ����
	 * @return
	 */
	public static ResultSet getNativePlace(){
		String sql ="select npname from tb_nativeplace";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯѧλ
	 * @return
	 */
	public static ResultSet getDegree(){
		String sql ="select degree from tb_degree";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	
	
	/**
	 * ������ѯ
	 * @param col
	 * @param val
	 * @return
	 */
	public static ResultSet getConditionEmp(String col,String val){
		String sql ="select * from tb_employee where ";
		if(col.equals("��Ա����")){
			sql = sql+"empid='"+val+"'";
		}else if(col.equals("����")){
			sql = sql + "ename='"+val+"'";
		}else if(col.equals("ְ��")){
			sql = sql+"dutyname='"+val+"'";
		}else if(col.equals("��������")){
			sql = sql+"birthday='"+val+"'";
		}else if(col.equals("ְ��")){
			sql = sql+"specialname='"+val+"'";
		}else if(col.equals("��Ƹ����")){
			sql = sql+"beginworkdate='"+val+"'";
		}else if(col.equals("����")){
			sql = sql+"nativeplacce='"+val+"'";
		}else if(col.equals("ѧλ")){
			sql = sql+"degree='"+val+"'";
		}else if(col.equals("�Ա�")){
			sql = sql+"sex='"+val+"'";
		}else{
			sql = sql+"polityface='"+val+"'";
		}
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	/**
	 * ִ�в�ѯ
	 * @param sql
	 * @return
	 */
	private static ResultSet getResultSet(String sql){
		ResultSet rs = null;
		Statement stmt = null;
		conn = DAO.getConnection();
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return rs;
	}
	
	/**
	 * ����Ա����Ϣ
	 * @param info
	 * @return
	 */
	public static boolean addEmployee(TbEmployeeInfo info){
		conn = DAO.getConnection();
		Statement stmt = null;
		String sql = "insert into tb_employee values('"+info.getEname()+
		"','"+info.getEyname()+"','"+info.getSex()+"','"+info.getBirthday()+
		"','"+info.getNativeplace()+"','"+info.getNation()+"','"+info.getHkszd()+
		"','"+info.getBornaddress()+"','"+info.getCommnityname()+"','"+info.getFirstedu()+
		"','"+info.getEducation()+"','"+info.getSchool()+"','"+info.getSpecialname()+
		"','"+info.getIntoschooldate()+"','"+info.getGraduatedate()+"','"+info.getIsfirstedu()+
		"','"+info.getDegree()+"',"+info.getEduyears()+",'"+info.getStudyway()+"','"+
		info.getPolityface()+"','"+info.getIntopartydate()+"','"+info.getWorkway()+
		"','"+info.getDutyname()+"','"+info.getStationname()+"','"+info.getSpedutyname()+"','"+info.getBeginworkdate()+
		"','"+info.getIntodeptdate()+"','"+info.getWorkstate()+"','"+info.getRetireddate()+
		"','"+info.getGrsf()+"','"+info.getBgphone()+"','"+info.getSjphone()+"','"+info.getHomephone()+
		"','"+info.getFyzymark()+"','"+info.getIdcard()+"','"+info.getXxdate()+"','"+info.getLdhtid()+
		"',"+info.getDeptno()+",'"+info.getClassname()+"','"+info.getMenu()+"')";
		try{
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			if(count>0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * ɾ��Ա����Ϣ
	 * @param name
	 * @return
	 */
	public  static boolean deleteEmployee(String name){
		conn = DAO.getConnection();
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			int count = stmt.executeUpdate("delete from tb_employee where ename='"+name+"'");
			if(count>0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * ���ѧ��
	 */
	public static boolean addDegree(String xl){
		conn = DAO.getConnection();
		try{
			Statement stmt = conn.createStatement();
			//�ж��Ƿ��Ѵ���
			ResultSet rs = stmt.executeQuery("select * from tb_degree where degree='"+xl+"'");
			if(rs.next())
				return false;
			int count = stmt.executeUpdate("insert into tb_degree values('"+xl+"')");
			if(count>0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * ���ְ��
	 * @param duty
	 * @return
	 */
	public static boolean addduty(TbDutyInfo info){
		conn = DAO.getConnection();
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tb_duty where dutyname='"+info.getDutyname()+"'");
			if(rs.next())
				return false;
			int count = stmt.executeUpdate("insert into tb_duty values('"+info.getDutyname()+"',"+info.getDutygrade()+
					",'"+info.getHiredate()+"','"+info.getFiredate()+"')");
			if(count>0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * ��ѯְ�Ƶȼ�
	 * @return
	 */
	public static ResultSet getSpecialDutygrade(){
		String sql = "select sdgrade from tb_specialdutygrade";
		ResultSet rs = DAO.getResultSet(sql);
		return rs;
	}
	/**
	 * ��ѯְ������
	 * @return
	 */
	public static ResultSet getSpecialserial(){
		String sql = "select sdsid from tb_specialdutyserial";
		ResultSet rs = DAO.getResultSet(sql);
		return rs;
	}
	/**
	 * ���ְ��
	 * @param info
	 * @return
	 */
	public static boolean addSpecialduty(TbSpecialdutyInfo info){
		conn = DAO.getConnection();
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tb_specialduty where sdname='"+info.getSdname()+"'");
			if(rs.next())
				return false;
			int count = stmt.executeUpdate("insert into tb_specialduty values('"+info.getSdname()+
					"',"+info.getSdgrade()+","+info.getSdsid()+",'"+info.getHiremark()+
					"','"+info.getHiredate()+"','"+info.getFiredate()+"',"+info.getSdsalgrade()+
					","+info.getSdsal()+",'"+info.getSdsalmoddate()+"')");
			if(count > 0)
				return true;
			else
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * ��ѯ��λ�ȼ�
	 * @return
	 */
	public static ResultSet getStationkind(){
		String sql = "select stkindid from tb_stationkind";
		ResultSet rs = DAO.getResultSet(sql);
		return rs;
	}
	/**
	 * ��Ӹ�λ
	 * @param info
	 * @return
	 */
	public static boolean addStation(TbStation info){
		conn = DAO.getConnection();
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tb_stationinfo where stationname='"+info.getStationname()+"'");
			if(rs.next())
				return false;
			int count = stmt.executeUpdate("insert into tb_stationinfo values('"+info.getStationname()+
					"',"+info.getStkindid()+","+info.getStsal()+",'"+info.getStsalmoddate()+"')");
			if(count>0)
				return true;
			else
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/**
	 * �ر�����Դ
	 *
	 */
	/*public static void closeconn(){
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try{
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}*/

}
