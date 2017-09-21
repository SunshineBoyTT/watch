/**
 * 
 */
package com.spring.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.base.dao.impl.BaseDaoMysqlImpl;
import com.spring.common.dao.TbMonitorDao;
import com.spring.common.entity.TbMonitor;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月18日
 * @Version:1.1.0
 */
@Repository
public class TbMonitorDaoImpl extends BaseDaoMysqlImpl<TbMonitor, Integer> implements TbMonitorDao {
	
	public TbMonitorDaoImpl(){
		super(TbMonitor.class);
	}
}
