package com.yao.springbootweixin.itchat4j.weixin.service;

import com.yao.springbootweixin.itchat4j.weixin.domain.FJokeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-09-18 22:49:36
 */
public interface FJokeService {
	
	FJokeDO get(String id);
	
	List<FJokeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FJokeDO fJoke);
	
	int update(FJokeDO fJoke);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	public FJokeDO getone();
}
