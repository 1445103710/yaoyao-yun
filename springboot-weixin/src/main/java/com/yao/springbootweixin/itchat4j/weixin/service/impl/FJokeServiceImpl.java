package com.yao.springbootweixin.itchat4j.weixin.service.impl;

import com.yao.springbootweixin.itchat4j.weixin.dao.FJokeDao;
import com.yao.springbootweixin.itchat4j.weixin.domain.FJokeDO;
import com.yao.springbootweixin.itchat4j.weixin.service.FJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class FJokeServiceImpl implements FJokeService {
	@Autowired
	private FJokeDao fJokeDao;
	
	@Override
	public FJokeDO get(String id){
		return fJokeDao.get(id);
	}
	
	@Override
	public List<FJokeDO> list(Map<String, Object> map){
		return fJokeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fJokeDao.count(map);
	}
	
	@Override
	public int save(FJokeDO fJoke){
		return fJokeDao.save(fJoke);
	}
	
	@Override
	public int update(FJokeDO fJoke){
		return fJokeDao.update(fJoke);
	}
	
	@Override
	public int remove(String id){
		return fJokeDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return fJokeDao.batchRemove(ids);
	}

	@Override
	public FJokeDO getone() {
		return fJokeDao.getone();
	}
	
}
