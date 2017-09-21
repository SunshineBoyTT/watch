package com.spring.common.service;


import com.spring.base.BaseCpu;
import com.spring.base.BaseDisk;
import com.spring.common.service.core.Logic;
import org.hyperic.sigar.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 所有的数据交互均在此类中完成 此类由服务端单独分发线程完成 ProcessData 函数不支持异步操作数据流
 *
 * @author leehom
 */
public class LogicPro implements Logic {
 
    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	Sigar sigar = new Sigar();
 
    @Override
    public void processClientData(DataInputStream dis, DataOutputStream dos,
            InetAddress add) throws IOException {
        // TODO Auto-generated method stub
    //    int size = dis.available();
      //  byte[] data = new byte[size];
    //    dis.read(data);
    
    	
    	//开始生成服务器相关信息
    	
    	StringBuffer sbInfo = new StringBuffer();
    	sbInfo.append("**********************CPU INFO*****************************"+"\r\n");
    	
    	ArrayList<BaseCpu> alCpu = new ArrayList<BaseCpu>();
		try {
			alCpu = this.getCpuInfo();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for(int i= 0;i <alCpu.size();i++){
    		BaseCpu data = alCpu.get(i);
    		
    		sbInfo.append("Name:\t" + data.getCpuName()+"\r\n");
    		sbInfo.append("使用率:\t" + data.getCpuUseRate()+"\r\n");
    		sbInfo.append("--------------------------------"+"\r\n");
    	}
    	
    	
    	sbInfo.append("**********************MEMORY INFO*****************************"+"\r\n");
    	
    
        try {
			Mem mem = sigar.getMem();
			sbInfo.append("Total Memory:\t" +mem.getTotal()/ 1024L/ 1024L+"M \r\n");
			sbInfo.append("Userd Memory:\t" +mem.getUsed()/ 1024L/ 1024L+"M \r\n");
			sbInfo.append("Using Rate:\t" +mem.getUsedPercent()+"M \r\n");
			
			
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        sbInfo.append("**********************Disk INFO*****************************"+"\r\n");
        
        ArrayList<BaseDisk> alDisk = this.getSystemDiskInfo();
        
        for(int j =0;j<alDisk.size();j++){
        	
        	BaseDisk data = alDisk.get(j);
        	sbInfo.append("Disk Name:\t" +data.getDiskName()+" \r\n");
			sbInfo.append("Total :\t" +  data.getDbDiskTotal()/1024L/ 1024L  +"G \r\n");
			sbInfo.append("Free:\t" + data.getDbDiskFree()/1024L/ 1024L  +"G \r\n");
			sbInfo.append("Avail:\t" + data.getDbDiskAvail()/1024L/ 1024L  +"G \r\n");
			sbInfo.append("Using rate:\t" + data.getUsingRate() +" \r\n");
			sbInfo.append("--------------------------------" +" \r\n");
        	
        	
        }
        
     //   System.out.println(new String(data));
        String sendStr = sbInfo.toString();
        byte[] tmp = sendStr.getBytes();
        byte[] sendData = new byte[ tmp.length];
        System.arraycopy(tmp, 0, sendData, 0, tmp.length);
    //    System.arraycopy(data, 0, sendData, tmp.length, data.length);
        dos.write(sendData);
    }
    
    
    public ArrayList getCpuInfo() throws SigarException{
    	
    	ArrayList alCpu = new  ArrayList<BaseCpu>();
    	
  //  	 Sigar sigar = new Sigar();
         CpuInfo infos[] = sigar.getCpuInfoList();
         CpuPerc cpuList[] = null;
         cpuList = sigar.getCpuPercList();
         for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
        	 
        	 BaseCpu data = new BaseCpu();
        //     CpuInfo info = infos[i];
             System.out.println("第" + (i + 1) + "块CPU");
             data.setCpuName("CPU-" + i );
             data.setCpuIdleRate(CpuPerc.format(cpuList[i].getIdle()));
             data.setCpuUseRate(CpuPerc.format(cpuList[i].getCombined()));
             alCpu.add(data);
         }
    	return alCpu;
    }
    
    public  ArrayList<BaseDisk>  getSystemDiskInfo(){
    	
    	ArrayList  alResult = new ArrayList<BaseDisk>();
    	
    	 try {
 			FileSystem alFileSystem[] = sigar.getFileSystemList();
 			
 			for (int i = 0; i < alFileSystem.length; i++) {
 				
 				FileSystem fileSystem = alFileSystem[i];
 				FileSystemUsage usage = null;
                usage = sigar.getFileSystemUsage(fileSystem.getDirName());
 				
 				if( fileSystem.getType() == 2 ){
 				
 					BaseDisk baseDisk = new BaseDisk();
 				
 					baseDisk.setDiskName(fileSystem.getDevName());
 					baseDisk.setDbDiskTotal(usage.getTotal());
 					baseDisk.setDbDiskUsed(usage.getUsed());
 					baseDisk.setDbDiskAvail(usage.getAvail());
 					baseDisk.setDbDiskFree(usage.getFree());
 					baseDisk.setUsingRate(usage.getUsePercent() * 100D);
 					alResult.add(baseDisk);
 				}
 				
 			}
 			
 		} catch (SigarException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	
    	return alResult;
    }
    
    

 
}
