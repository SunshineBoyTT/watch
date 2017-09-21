package com.spring.common.service.impl;

import com.spring.base.BaseCpu;
import com.spring.base.BaseDisk;
import com.spring.base.utils.SmsSend;
import com.spring.base.utils.StringUtil;
import com.spring.base.websocket.common.Global;
import com.spring.common.service.DataOperateService;
import org.hyperic.sigar.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("dataOperateService")
public class DataOperateServiceImpl implements DataOperateService {

	//签名
	@Value("#{config['vcode_tag']}")
	public String vcodeTag="";
	//手机号码
	@Value("#{config['vcode_phone']}")
	public String vcodePhone="";

	private static final Logger logger = LoggerFactory.getLogger(DataOperateServiceImpl.class);
	Sigar sigar = new Sigar();
	ArrayList memory_list = new ArrayList();

	@Override
	public boolean refreshData() {
		// TODO Auto-generated method stub
		Global.g_Cpu_list = this.getCPUInfo();
//		Global.g_memory_list = addMemoryList(this.getMEMORYInfo());
		Global.g_disk_list = this.getDiskInfo();
		Global.g_memory_map = this.getMEMORYInfo();
		return true;
	}

    @Override
    public ArrayList addMemoryList(Map<String, Object> memoryInfo) {
        int lenSize = 100;
        if (memory_list.size() == lenSize){
            memory_list.remove(0);
        }
        memory_list.add(memoryInfo);
        System.out.println("memory_list->"+memory_list.toString());
        return memory_list;
    }

	@Override
	public ArrayList getCPUInfo() {
		ArrayList<BaseCpu> alCpu = new ArrayList<BaseCpu>();
		try {
			CpuInfo infos[] = sigar.getCpuInfoList();
			CpuPerc cpuList[] = null;
			cpuList = sigar.getCpuPercList();
			Double sumUseRate = 0.0;
			for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
				CpuInfo info = infos[i];
				BaseCpu data = new BaseCpu();
				data.setCpuName("CPU-" + i);
				data.setCpuIdleRate(format(cpuList[i].getIdle()));//获取当前cpu的空闲率
				data.setCpuUseRate(format(cpuList[i].getCombined()));//获取当前cpu的占用率
				data.setAddTime(StringUtil.formatDate9(new Date()));
				data.setSize(infos.length);
				sumUseRate += cpuList[i].getCombined();
				alCpu.add(data);
			}
			System.out.println("cpu:"+sumUseRate/infos.length);
			if (sumUseRate/infos.length>0.9)
				Global.cpu_count++;
			else
				Global.cpu_count = 0;//归0
			System.out.println("cpu_count:"+Global.cpu_count);
			BaseCpu data = new BaseCpu();
			data.setCpuUseRate(format(sumUseRate/infos.length));//获取当前cpu的占用率
			data.setSize(infos.length);
			if (Global.cpu_count == 4){
				String content = "您的服务器CPU已达到"+data.getCpuUseRate()+"%";
				SmsSend sms = new SmsSend();
				sms.HttpSmsSend(vcodePhone, content, vcodeTag);
			}
			alCpu.add(data);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return alCpu;
	}


	/**
	 * 内存信息
	 *
	 * @return
	 */
	@Override
	public Map<String, Object> getMEMORYInfo() {
		Map<String, Object> momory_map = new HashMap();
		try {
			Mem mem = sigar.getMem();
			momory_map.put("Total_Memory", mem.getTotal() / 1024L / 1024L);
			momory_map.put("Userd_Memory", mem.getUsed() / 1024L / 1024L);
			momory_map.put("Free_Memory", mem.getActualFree() / 1024L / 1024L);
			momory_map.put("Using_Rate", mem.getUsedPercent());
			momory_map.put("add_time", StringUtil.formatDate9(new Date()));

		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return momory_map;
	}

	/**
	 * 硬盘信息
	 *
	 * @return
	 */
	@Override
	public ArrayList getDiskInfo() {
		ArrayList alResult = new ArrayList<BaseDisk>();
		try {
			FileSystem alFileSystem[] = sigar.getFileSystemList();

			for (int i = 0; i < alFileSystem.length; i++) {

				FileSystem fileSystem = alFileSystem[i];
				FileSystemUsage usage = null;
				logger.info("fileSystem.getSysTypeName():"+fileSystem.getSysTypeName());
				if (fileSystem.getSysTypeName().equals("NTFS")||fileSystem.getSysTypeName().equals("FAT32")){
					usage = sigar.getFileSystemUsage(fileSystem.getDirName());

					if (fileSystem.getType() == 2) {

						BaseDisk baseDisk = new BaseDisk();

						baseDisk.setDiskName(fileSystem.getDevName());
						baseDisk.setDbDiskTotal(usage.getTotal());
						baseDisk.setDbDiskTotalG(usage.getTotal() / 1024L / 1024L);
						baseDisk.setDbDiskUsed(usage.getUsed());
						baseDisk.setDbDiskAvail(usage.getAvail());
						baseDisk.setDbDiskFree(usage.getFree());
						baseDisk.setUsingRate(usage.getUsePercent() * 100D);
						alResult.add(baseDisk);
					}
				}

			}

		} catch (SigarException e) {
			e.printStackTrace();
		}

		return alResult;
	}
	public static String format(double val) {
		String p = String.valueOf(val * 100.0D);
		int ix = p.indexOf(".") + 1;
		String percent = p.substring(0, ix) + p.substring(ix, ix + 1);
//		return percent + "%";
		return percent + "";
	}
}
