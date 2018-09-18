package com.yao.springbootweixin.itchat4j.controller;

import com.yao.springbootweixin.itchat4j.thread.CheckLoginStatusThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yao.springbootweixin.itchat4j.service.ILoginService;
import com.yao.springbootweixin.itchat4j.service.impl.LoginServiceImpl;
import com.yao.springbootweixin.itchat4j.utils.SleepUtils;
import com.yao.springbootweixin.itchat4j.utils.tools.CommonTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆控制器
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月13日 下午12:56:07
 * @version 1.0
 *
 */
public class LoginController {
	private static Logger LOG = LoggerFactory.getLogger(LoginController.class);
	private ILoginService loginService = new LoginServiceImpl();
	private static com.yao.springbootweixin.itchat4j.core.Core core = com.yao.springbootweixin.itchat4j.core.Core.getInstance();
	public void login(String qrPath) {
		if (core.isAlive()) { // 已登陆
			LOG.warn("姚尧已登陆");
			return;
		}
		while (true) {
			for (int count = 0; count < 10; count++) {
				LOG.warn("获取UUID");
				while (loginService.getUuid() == null) {
					LOG.warn("1. 获取微信UUID");
					while (loginService.getUuid() == null) {
						LOG.warn("1.1. 获取微信UUID失败，两秒后重新获取");
						SleepUtils.sleep(2000);
					}
				}
				LOG.warn("2. 获取登陆二维码图片");
				if (loginService.getQR(qrPath)) {
					break;
				} else if (count == 10) {
					LOG.error("2.2. 获取登陆二维码图片失败，系统退出");
					System.exit(0);
				}
			}
			LOG.info("3. 请扫描二维码图片，并在手机上确认");
			if (!core.isAlive()) {
				loginService.login();
				core.setAlive(true);
				LOG.warn(("登陆成功"));
				break;
			}
			LOG.warn("4. 登陆超时，请重新扫描二维码图片");
		}

		LOG.warn("5. 登陆成功，微信初始化");
		if (!loginService.webWxInit()) {
			LOG.warn("6. 微信初始化异常");
			System.exit(0);
		}

		LOG.warn("6. 开启微信状态通知");
		loginService.wxStatusNotify();

		LOG.warn("7. 清除。。。。");
		CommonTools.clearScreen();
		LOG.warn(String.format("欢迎回来， %s", core.getNickName()));

		LOG.warn("8. 开始接收消息");
		loginService.startReceiving();

		LOG.warn("9. 获取联系人信息");
		loginService.webWxGetContact();

		LOG.warn("10. 获取群好友及群好友列表");
		loginService.WebWxBatchGetContact();

		LOG.warn("11. 缓存本次登陆好友相关消息");
		com.yao.springbootweixin.itchat4j.api.WechatTools.setUserInfo(); // 登陆成功后缓存本次登陆好友相关消息（NickName, UserName）

		LOG.warn("12.开启微信状态检测线程");
		new Thread(new CheckLoginStatusThread()).start();
	}
}