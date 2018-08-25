package com.bootdo.cust.controller;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.cust.domain.FCustDO;
import com.bootdo.cust.domain.FFaceDO;
import com.bootdo.cust.service.FCustService;
import com.bootdo.cust.service.FFaceService;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.RoleService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.UserVO;
import com.bootdo.utils.baidu.face.FaceControl;
import com.bootdo.utils.sequnce.impl.DefaultIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/cust/user")
@Controller
@Slf4j
public class CustController extends BaseController {
	private String prefix="custom/user"  ;
	@Autowired
	UserService userService;
	@Autowired
	FCustService fCustService;
	@Autowired
	RoleService roleService;
	@Autowired
	DictService dictService;
	@Autowired
	FFaceService faceService;
	@RequiresPermissions("cust:user:user")
	@GetMapping("")
	String user(Model model) {
		return prefix + "/user";
	}

	@GetMapping("/list")
	@ResponseBody
	PageUtils list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		List<FCustDO> fCustList = fCustService.list(query);
		int total = fCustService.count(query);
		PageUtils pageUtils = new PageUtils(fCustList, total);
		return pageUtils;
	}

	@RequiresPermissions("cust:user:add")
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		model.addAttribute("sexList",dictService.getSexList());
		log.debug(JSON.toJSONString(dictService.getSexList()));
		return prefix + "/add";
	}

	@RequiresPermissions("cust:user:edit")
	@Log("编辑客户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") String id) {
		FCustDO fCustDO = fCustService.get(id);
		model.addAttribute("user", fCustDO);
		return prefix+"/edit";
	}

	@RequiresPermissions("cust:user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
	public R save(FCustDO fCust){
		fCust.setStatus("1");
		fCust.setCreateTime(new Date());
		fCust.setUpdateBy(getUsername());
		log.debug("新增用户:"+JSON.toJSONString(fCust));
		if(fCustService.save(fCust)>0){
			return R.ok("新增用户成功");
		}
		return R.error();
	}

	@RequiresPermissions("cust:user:edit")
	@Log("更新客户")
	@PostMapping("/update")
	@ResponseBody
	R update(FCustDO fCustDO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (fCustService.update(fCustDO) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("cust:user:edit")
	@Log("更新用户")
	@PostMapping("/updatePeronal")
	@ResponseBody
	R updatePeronal(UserDO user) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (userService.updatePersonal(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("cust:user:remove")
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	R remove(String id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (fCustService.remove(id) > 0) {
			new Thread("线程删除"){
				@Override
				public void run(){
					FFaceDO fFaceDO = faceService.get(id);
					if (fFaceDO!=null){

						FaceControl.remove(id,fFaceDO.getFaceToken());
						faceService.remove(id);
					}
				}
			}.start();
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("cust:user:batchRemove")
	@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") String[] userIds) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		int r = fCustService.batchRemove(userIds);
		if (r > 0) {
			new Thread("线程批量删除"){
				@Override
				public void run(){
					for (String userId:userIds){
						FFaceDO fFaceDO = faceService.get(userId);
						if (fFaceDO!=null){
							FaceControl.remove(userId,fFaceDO.getFaceToken());
							faceService.remove(userId);
						}
					}
				}
			}.start();

			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !userService.exit(params);
	}

	@RequiresPermissions("cust:user:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {

		UserDO userDO = new UserDO();
		userDO.setUserId(userId);
		model.addAttribute("user", userDO);
		return prefix + "/reset_pwd";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(UserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		try{
			userService.resetPwd(userVO,getUser());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@RequiresPermissions("cust:user:resetPwd")
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(UserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		try{
			userService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = userService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	@GetMapping("/personal")
	String personal(Model model) {
		UserDO userDO  = userService.get(getUserId());
		model.addAttribute("user",userDO);
		model.addAttribute("hobbyList",dictService.getHobbyList(userDO));
		model.addAttribute("sexList",dictService.getSexList());
		return prefix + "/personal";
	}

	@ResponseBody
	@PostMapping("/uploadCustImg")
	R uploadCustImg(@RequestParam("avatar_file") MultipartFile file, String avatar_data, HttpServletRequest request) {
		DefaultIdGenerator defaultIdGenerator = new DefaultIdGenerator();
		String userId = defaultIdGenerator.next();

		Map<String, Object> result = new HashMap<>();
		try {
			result = userService.updatecustImg(file, avatar_data,userId);

		} catch (Exception e) {
			e.printStackTrace();
			return R.error("新增照片失败！");
		}
		if(result!=null && result.size()>0){
			Map<String, String> resultMap = FaceControl.addCustFace(file, userId);
			if (!"0".equals(resultMap.get("code"))){
				return R.error(resultMap.get("code"),"百度人脸识别错误-->错误码:"+resultMap.get("code")+",错误信息:"+resultMap.get("msg"));
			}else {
				String face_token = resultMap.get("face_token");
				String log_id = resultMap.get("log_id");
				FFaceDO fFaceDO = new FFaceDO();
				fFaceDO.setUserId(userId);
				fFaceDO.setLogId(log_id);
				fFaceDO.setFaceToken(face_token);
				faceService.save(fFaceDO);
			}
			log.debug("新增百度人脸识别成功");
			return R.ok(result);
		}else {
			return R.error("新增照片失败！");
		}
	}
}
