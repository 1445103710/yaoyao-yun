package com.yao.springbootweixin.itchat4j.weixin.service;

import com.yao.springbootweixin.itchat4j.weixin.domain.FNewsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-09-18 22:55:58
 */
public interface FNewsService {
	
	FNewsDO get(String id);
	
	List<FNewsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FNewsDO fNews);
	
	int update(FNewsDO fNews);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	FNewsDO getone();
}
