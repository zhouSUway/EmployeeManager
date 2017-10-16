package model;

import java.io.Serializable;
public class TbDutyInfo implements Serializable {

	public TbDutyInfo() {
		// TODO Auto-generated constructor stub
	}
	private int dutyid;
	private String dutyname;
	private int dutygrade;
	private String hiredate;
	private String firedate;
	public int getDutyid() {
		return dutyid;
	}
	public void setDutyid(int dutyid) {
		this.dutyid = dutyid;
	}
	public String getDutyname() {
		return dutyname;
	}
	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}
	public int getDutygrade() {
		return dutygrade;
	}
	public void setDutygrade(int dutygrade) {
		this.dutygrade = dutygrade;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getFiredate() {
		return firedate;
	}
	public void setFiredate(String firedate) {
		this.firedate = firedate;
	}

}
