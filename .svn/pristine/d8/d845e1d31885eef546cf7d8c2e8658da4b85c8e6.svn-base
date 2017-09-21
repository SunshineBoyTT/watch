package com.spring.common.service;


import org.hyperic.sigar.SigarException;

import java.util.ArrayList;
import java.util.Map;

public interface DataOperateService {
	public boolean refreshData();

	public ArrayList addMemoryList(Map<String, Object> memoryInfo);

	/**
	 * 获取CPU使用率
	 * @return
	 */
	public ArrayList getCPUInfo();

	/**
	 * 获取内存使用情况
	 * @return
	 */
	public Map<String,Object> getMEMORYInfo();

	/**
	 * 硬盘使用情况
	 * @return
	 */
	public ArrayList getDiskInfo();
}
