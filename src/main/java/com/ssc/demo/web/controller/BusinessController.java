package com.ssc.demo.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ssc.demo.service.CoinLogService;
import com.ssc.demo.web.controller.base.BaseController;


/**
 * 后台菜单管理
 * @author
 *
 */
@Controller
@RequestMapping("business/*")
public class BusinessController extends BaseController{

	/**********************业务流水****************************/
	
	@RequestMapping(value = "cash", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cash(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/cash");

	}
	@RequestMapping(value = "cashLog", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cashLog(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/cash-log");

	}
	//投注记录
	@RequestMapping(value = "betLog", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView betLog(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/bet-log");

	}
	//帐变明细
	@RequestMapping(value = "coinLog", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView coinLog(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/business/coin-log");

	}
	
	//充值记录
	@RequestMapping(value = "rechargeLog", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView rechargeLog(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/business/recharge-log");

		}
	
	//新增充值记录
	@RequestMapping(value = "rechargeModal", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView rechargeModal(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/business/recharge-modal");

		}
		
	
	/***************开奖数据**********************/
	

	@RequestMapping(value = "index", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/data/index");

	}
	
	/****************数据统计********************/
	//综合统计
	@RequestMapping(value = "betDate", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView betDate(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/business/bet-date");

		}
	
	
	
	/***********用户管理**************/
	
	//增加会员
	@RequestMapping(value = "add_member", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView add_member(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/members/add");

	}
	
	//用户列表
	@RequestMapping(value = "index_member", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index_member(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/members/list-user");

		}
	
	//银行信息
	@RequestMapping(value = "bank_member", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView bank_member(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/members/bank");

		}
		
	//登录日志
	@RequestMapping(value = "loginLog_member", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginLog_member(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/members/login-log");

		}

	/*******************管理人员*********************/
		
	//管理员列表
	@RequestMapping(value = "index_manage", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index_manage(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/manage/list");

		}
		
	//登录日志
	@RequestMapping(value = "login-list", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginLog_manage(Model model,HttpSession session,HttpServletRequest request) throws Exception {
			return new ModelAndView("../admin/manage/login-list");

		}
	
	/*************************系统设置***************************/
	//系统设置
	@RequestMapping(value = "settings_sys", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView settings_sys(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/system/settings");

	}
	//系统公告
	@RequestMapping(value = "notice_sys", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView notice_sys(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/system/notice");

	}
	//银行设置
	@RequestMapping(value = "bank_sys", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView bankIndex(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/system/bank");

	}
	//玩法设置
	@RequestMapping(value = "played_sys", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView played_sys(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		return new ModelAndView("../admin/system/played-list");

	}
}
