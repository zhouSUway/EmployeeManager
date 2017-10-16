package model;
import java.io.Serializable;
public class TbSpecialdutyInfo implements Serializable {

	public TbSpecialdutyInfo() {
		// TODO Auto-generated constructor stub
	}
	private int sdid;
	private String sdname;
	private int sdgrade;
	private int sdsid;
	private String hiremark;
	private String hiredate;
	private String firedate;
	private int sdsalgrade;
	private int sdsal;
	private String sdsalmoddate;
	public int getSdid() {
		return sdid;
	}
	public void setSdid(int sdid) {
		this.sdid = sdid;
	}
	public String getSdname() {
		return sdname;
	}
	public void setSdname(String sdname) {
		this.sdname = sdname;
	}
	public int getSdgrade() {
		return sdgrade;
	}
	public void setSdgrade(int sdgrade) {
		this.sdgrade = sdgrade;
	}
	public int getSdsid() {
		return sdsid;
	}
	public void setSdsid(int sdsid) {
		this.sdsid = sdsid;
	}
	public String getHiremark() {
		return hiremark;
	}
	public void setHiremark(String hiremark) {
		this.hiremark = hiremark;
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
	public int getSdsalgrade() {
		return sdsalgrade;
	}
	public void setSdsalgrade(int sdsalgrade) {
		this.sdsalgrade = sdsalgrade;
	}
	public int getSdsal() {
		return sdsal;
	}
	public void setSdsal(int sdsal) {
		this.sdsal = sdsal;
	}
	public String getSdsalmoddate() {
		return sdsalmoddate;
	}
	public void setSdsalmoddate(String sdsalmoddate) {
		this.sdsalmoddate = sdsalmoddate;
	}
	
}
