package com.spring.base.websocket.output;


/* 以小时为单位，显示每小时的分网店、区域的报修数量*/
public class EntityDayReport {
	
	String hour;  //小时 
	String subumitNumber;//保修数量
	String pointId;// 网点id
	String orderStatus; //工单状态
	
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getSubumitNumber() {
		return subumitNumber;
	}
	public void setSubumitNumber(String subumitNumber) {
		this.subumitNumber = subumitNumber;
	}
	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	String pointName;//网点名称

}
