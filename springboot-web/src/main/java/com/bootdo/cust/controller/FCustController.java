package com.bootdo.cust.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.cust.domain.FCustDO;
import com.bootdo.cust.service.FCustService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 客户信息表
 * 
 * @author yaoyao
 * @email 15656009880@163.com
 * @date 2018-08-25 16:45:31
 */
 
@Controller
@RequestMapping("/cust/fCust")
@Slf4j
public class FCustController {
	@Autowired
	private FCustService fCustService;
	
	@GetMapping()
	@RequiresPermissions("cust:fCust:fCust")
	String FCust(){
	    return "cust/fCust/fCust";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("cust:fCust:fCust")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FCustDO> fCustList = fCustService.list(query);
		int total = fCustService.count(query);
		PageUtils pageUtils = new PageUtils(fCustList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("cust:fCust:add")
	String add(){
	    return "cust/fCust/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("cust:fCust:edit")
	String edit(@PathVariable("userId") String userId,Model model){
		FCustDO fCust = fCustService.get(userId);
		model.addAttribute("fCust", fCust);
		JSON.toJSONString(fCust);
	    return "cust/fCust/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("cust:fCust:add")
	public R save( FCustDO fCust){
		if(fCustService.save(fCust)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("cust:fCust:edit")
	public R update( FCustDO fCust){
		fCustService.update(fCust);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("cust:fCust:remove")
	public R remove( String userId){
		if(fCustService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("cust:fCust:batchRemove")
	public R remove(@RequestParam("ids[]") String[] userIds){
		fCustService.batchRemove(userIds);
		return R.ok();
	}
	@GetMapping("/get/{userId}")
	@Log("大屏查询客户")
	@ResponseBody
	String custInfo(@PathVariable("userId") String userId,Model model){
		FCustDO fCust = fCustService.get(userId);
		log.debug("获取大屏请求消息！");
		return JSON.toJSONString(fCust);
	}
}
