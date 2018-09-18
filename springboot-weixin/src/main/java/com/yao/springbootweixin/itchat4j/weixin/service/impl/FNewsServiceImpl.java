package com.yao.springbootweixin.itchat4j.weixin.service.impl;

import com.yao.springbootweixin.itchat4j.weixin.dao.FNewsDao;
import com.yao.springbootweixin.itchat4j.weixin.domain.FNewsDO;
import com.yao.springbootweixin.itchat4j.weixin.service.FNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class FNewsServiceImpl implements FNewsService {
	@Autowired
	private FNewsDao fNewsDao;
	
	@Override
	public FNewsDO get(String id){
		return fNewsDao.get(id);
	}
	
	@Override
	public List<FNewsDO> list(Map<String, Object> map){
		return fNewsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fNewsDao.count(map);
	}
	
	@Override
	public int save(FNewsDO fNews){
		return fNewsDao.save(fNews);
	}
	
	@Override
	public int update(FNewsDO fNews){
		return fNewsDao.update(fNews);
	}
	
	@Override
	public int remove(String id){
		return fNewsDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return fNewsDao.batchRemove(ids);
	}

	@Override
	public FNewsDO getone() {
		return fNewsDao.getone();
	}

}
