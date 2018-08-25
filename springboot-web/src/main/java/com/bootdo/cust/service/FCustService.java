package com.bootdo.cust.service;

import com.bootdo.cust.domain.FCustDO;

import java.util.List;
import java.util.Map;

/**
 * 客户信息表
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-08-25 16:45:31
 */
public interface FCustService {
	
	FCustDO get(String userId);
	
	List<FCustDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FCustDO fCust);
	
	int update(FCustDO fCust);
	
	int remove(String userId);
	
	int batchRemove(String[] userIds);
}
