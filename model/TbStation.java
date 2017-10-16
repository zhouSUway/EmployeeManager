package model;

import java.io.Serializable;
public class TbStation implements Serializable {

	public TbStation() {
		// TODO Auto-generated constructor stub
	}
	private int stid;
	private String stationname;
	private int stkindid;
	private int stsal;
	private String stsalmoddate;
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public int getStkindid() {
		return stkindid;
	}
	public void setStkindid(int stkindid) {
		this.stkindid = stkindid;
	}
	public int getStsal() {
		return stsal;
	}
	public void setStsal(int stsal) {
		this.stsal = stsal;
	}
	public String getStsalmoddate() {
		return stsalmoddate;
	}
	public void setStsalmoddate(String stsalmoddate) {
		this.stsalmoddate = stsalmoddate;
	}

}
