package com.yao.springbootweixin.itchat4j.weixin.dao;

import java.util.List;
import java.util.Map;

import com.yao.springbootweixin.itchat4j.weixin.domain.FNewsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-09-18 22:55:58
 */
@Mapper
public interface FNewsDao {

	FNewsDO get(String id);
	
	List<FNewsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FNewsDO fNews);
	
	int update(FNewsDO fNews);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	@Select("select * from tf_f_news where flag = '0' limit 0,1 ")
	FNewsDO getone();
}
