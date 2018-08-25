package com.bootdo.cust.dao;

import com.bootdo.cust.domain.FFaceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-08-26 01:52:48
 */
@Mapper
public interface FFaceDao {

	FFaceDO get(String userId);
	
	List<FFaceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FFaceDO fFace);
	
	int update(FFaceDO fFace);
	
	int remove(String user_id);
	
	int batchRemove(String[] userIds);
}
