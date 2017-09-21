package com.spring.base;

public class BaseDisk {
	
	String  diskName;
	long  dbDiskTotal;
	long  dbDiskFree;
	long  dbDiskAvail;
	long  dbDiskUsed;
	double usingRate;
	double dbDiskTotalG;

	
	
	public double getUsingRate() {
		return usingRate;
	}
	public void setUsingRate(double usingRate) {
		this.usingRate = usingRate;
	}
	public String getDiskName() {
		return diskName;
	}
	public long getDbDiskTotal() {
		return dbDiskTotal;
	}
	public long getDbDiskFree() {
		return dbDiskFree;
	}
	public long getDbDiskAvail() {
		return dbDiskAvail;
	}
	public long getDbDiskUsed() {
		return dbDiskUsed;
	}
	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}
	public void setDbDiskTotal(long dbDiskTotal) {
		this.dbDiskTotal = dbDiskTotal;
	}
	public void setDbDiskFree(long dbDiskFree) {
		this.dbDiskFree = dbDiskFree;
	}
	public void setDbDiskAvail(long dbDiskAvail) {
		this.dbDiskAvail = dbDiskAvail;
	}
	public void setDbDiskUsed(long dbDiskUsed) {
		this.dbDiskUsed = dbDiskUsed;
	}

	public double getDbDiskTotalG() {
		return dbDiskTotalG;
	}

	public void setDbDiskTotalG(double dbDiskTotalG) {
		this.dbDiskTotalG = dbDiskTotalG;
	}
}
