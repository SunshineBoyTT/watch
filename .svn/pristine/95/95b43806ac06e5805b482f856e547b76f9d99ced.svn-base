/**
 * 
 */
package com.spring.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.TbMonitorDao;
import com.spring.common.entity.PageBean;
import com.spring.common.entity.TbMonitor;
import com.spring.common.service.TbMonitorService;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月18日
 * @Version:1.1.0
 */
@Service
public class TbMonitorServiceImpl extends BaseServiceImpl<TbMonitor, Integer> implements TbMonitorService {
	
	@Autowired
	private TbMonitorDao tbMonitorDao;

	/* (non-Javadoc)
	 * @see com.spring.base.service.impl.BaseServiceImpl#getGenericDao()
	 */
	@Override
	public BaseDao<TbMonitor, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return tbMonitorDao;
	}



}
