package com.bootdo.cust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.cust.dao.FFaceDao;
import com.bootdo.cust.domain.FFaceDO;
import com.bootdo.cust.service.FFaceService;



@Service
public class FFaceServiceImpl implements FFaceService {
	@Autowired
	private FFaceDao fFaceDao;
	
	@Override
	public FFaceDO get(String userId){
		return fFaceDao.get(userId);
	}
	
	@Override
	public List<FFaceDO> list(Map<String, Object> map){
		return fFaceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fFaceDao.count(map);
	}
	
	@Override
	public int save(FFaceDO fFace){
		return fFaceDao.save(fFace);
	}
	
	@Override
	public int update(FFaceDO fFace){
		return fFaceDao.update(fFace);
	}
	
	@Override
	public int remove(String userId){
		return fFaceDao.remove(userId);
	}
	
	@Override
	public int batchRemove(String[] userIds){
		return fFaceDao.batchRemove(userIds);
	}
	
}
