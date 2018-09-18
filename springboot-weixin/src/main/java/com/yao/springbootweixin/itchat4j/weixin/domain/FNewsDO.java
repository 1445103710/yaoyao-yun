package com.yao.springbootweixin.itchat4j.weixin.domain;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-09-18 22:55:58
 */
@ToString
public class FNewsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String news;
	//
	private Date date;
	//
	private String flag;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setNews(String news) {
		this.news = news;
	}
	/**
	 * 获取：
	 */
	public String getNews() {
		return news;
	}
	/**
	 * 设置：
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 设置：
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 获取：
	 */
	public String getFlag() {
		return flag;
	}
}
