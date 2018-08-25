package com.bootdo.cust.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-08-26 01:52:48
 */
public class FFaceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String userId;
	//
	private String logId;
	//
	private String faceToken;

	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
	/**
	 * 获取：
	 */
	public String getLogId() {
		return logId;
	}
	/**
	 * 设置：
	 */
	public void setFaceToken(String faceToken) {
		this.faceToken = faceToken;
	}
	/**
	 * 获取：
	 */
	public String getFaceToken() {
		return faceToken;
	}
}
