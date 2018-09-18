package com.yao.springbootweixin.itchat4j.weixin.dao;

import java.util.List;
import java.util.Map;

import com.yao.springbootweixin.itchat4j.weixin.domain.FJokeDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-09-18 22:49:36
 */
@Mapper
public interface FJokeDao {

	FJokeDO get(String id);
	
	List<FJokeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FJokeDO fJoke);
	
	int update(FJokeDO fJoke);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	@Select("select * from tf_f_joke where flag = '0' limit 0,1 ")
	FJokeDO getone();
}
