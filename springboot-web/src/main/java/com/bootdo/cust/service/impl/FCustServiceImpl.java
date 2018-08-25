package com.bootdo.cust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.cust.dao.FCustDao;
import com.bootdo.cust.domain.FCustDO;
import com.bootdo.cust.service.FCustService;



@Service
public class FCustServiceImpl implements FCustService {
	@Autowired
	private FCustDao fCustDao;
	
	@Override
	public FCustDO get(String userId){
		return fCustDao.get(userId);
	}
	
	@Override
	public List<FCustDO> list(Map<String, Object> map){
		return fCustDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fCustDao.count(map);
	}
	
	@Override
	public int save(FCustDO fCust){
		return fCustDao.save(fCust);
	}
	
	@Override
	public int update(FCustDO fCust){
		return fCustDao.update(fCust);
	}
	
	@Override
	public int remove(String userId){
		return fCustDao.remove(userId);
	}
	
	@Override
	public int batchRemove(String[] userIds){
		return fCustDao.batchRemove(userIds);
	}
	
}
