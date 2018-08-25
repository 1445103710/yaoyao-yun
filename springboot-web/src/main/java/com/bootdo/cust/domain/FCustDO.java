package com.bootdo.cust.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户信息表
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-08-25 16:45:31
 */
public class FCustDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private String userId;
	//客户昵称
	private String userName;
	//用户邮箱
	private String email;
	//手机号码
	private String phonenumber;
	//用户性别（0男 1女 2未知）
	private String sex;
	//照片名称
	private String picture;
	//帐号状态（0正常 1停用）
	private String status;
	//删除标志（0代表存在 2代表删除）
	private String delFlag;
	//最后登陆时间
	private Date loginDate;
	//创建者
	private String createBy;
	//创建时间
	private Date createTime;
	//更新者
	private String updateBy;
	//更新时间
	private Date updateTime;
	//备注
	private String remark;

	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：客户昵称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：客户昵称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：用户邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号码
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * 设置：用户性别（0男 1女 2未知）
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：用户性别（0男 1女 2未知）
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：照片名称
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：照片名称
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * 设置：帐号状态（0正常 1停用）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：帐号状态（0正常 1停用）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：删除标志（0代表存在 2代表删除）
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标志（0代表存在 2代表删除）
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：最后登陆时间
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	/**
	 * 获取：最后登陆时间
	 */
	public Date getLoginDate() {
		return loginDate;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
