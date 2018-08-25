package com.bootdo.cust.service;

import com.bootdo.cust.domain.FFaceDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-08-26 01:52:48
 */
public interface FFaceService {
	
	FFaceDO get(String userId);
	
	List<FFaceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FFaceDO fFace);
	
	int update(FFaceDO fFace);
	
	int remove(String userId);
	
	int batchRemove(String[] userIds);
}
