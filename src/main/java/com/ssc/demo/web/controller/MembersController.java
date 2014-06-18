package com.ssc.demo.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.Bank;
import com.ssc.demo.model.City;
import com.ssc.demo.model.MemberBank;
import com.ssc.demo.model.MemberCash;
import com.ssc.demo.model.Members;
import com.ssc.demo.service.BankService;
import com.ssc.demo.service.MemberBankService;
import com.ssc.demo.service.MemberCashService;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;
import com.ssc.demo.web.util.PropertiesUtil;

import framework.generic.memcached.MemCache;
import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.security.MD5;
import framework.generic.utils.string.StringUtil;

/**
 * @author Joker
 *
 */
@Controller
@RequestMapping("members/*")
public class MembersController extends BaseController {

	private MembersService membersService;

	private MemberBankService memberBankService;

	private BankService bankService;
	
	private MemberCashService memberCashService;

	@Resource
	MemCache memCache;

	@Resource
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}

	@Resource
	public void setMemberBankService(MemberBankService memberBankService) {
		this.memberBankService = memberBankService;
	}
	
	@Resource
	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}
	@Resource
	public void setMemberCashService(MemberCashService memberCashService) {
		this.memberCashService = memberCashService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> findByPage(HttpSession session, PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		if (request.getParameter("mname") != null && request.getParameter("mname") != "")
			paramMap.put("mname", request.getParameter("mname"));
		else
			paramMap.put("mparentid", session.getAttribute("uid"));
		
		if (request.getParameter("uid") != null)
			paramMap.put("mparentid", request.getParameter("uid"));
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Members> list = membersService.findByPage(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);

	}

	@RequestMapping(value = "addUser", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String addUser(HttpSession session, HttpServletRequest request) {

		Members members = new Members();
		String mname = request.getParameter("mname");
		Members existMembers = membersService.load(mname);
		String msg = "注册成功!";
		if (existMembers != null) {
			msg = "此用户名已存在!";
			return "{'sMsg':'" + msg + "'}";
		}
		BigDecimal mfandian = new BigDecimal(request.getParameter("mfandian"));
		BigDecimal mfandianbdw = new BigDecimal(request.getParameter("mfandianbdw"));
		int mparentid = Integer.parseInt(session.getAttribute("uid").toString());
		boolean mtype = "1".equals(request.getParameter("mtype")) ? true : false;

		Members pM = (Members) memCache.getMc().get(mparentid + "_object");
		members.setMgrade(pM.getMgrade() + 1);
		members.setMname(mname);
		members.setMfandian(mfandian);
		members.setMfandianbdw(mfandianbdw);
		members.setMparentid(mparentid);
		members.setMtype(mtype);
		members.setMpassword(MD5.getPasswordMD5("123456"));
		members.setMcoin(new BigDecimal("0"));
		members.setMfcoin(new BigDecimal("0"));
		
		members.setIsAdmin(false);
		members.setCreateName(session.getAttribute("mname").toString());
		members.setCreateDate(new Date());
		members.setModifyDate(new Date());
		membersService.addMembers(members);

		return "{'sMsg':'" + msg + "'}";
	}

	/**
	 * 绑定卡号 
	 * 提款密码不存在则提醒设定
	 * 存在的话进入输入提醒密码页面
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "bindCard", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView bindCard(Model model, HttpServletRequest request, HttpSession session) throws Exception {

		Members pM = (Members) memCache.getMc().get(session.getAttribute("uid") + "_object");
		String safepwd = pM.getMsafepwd();
		if (StringUtil.isNullOrEmpty(safepwd)) {
			model.addAttribute("noticeWord", "您还未设定提款密码，为了您的账户安全，请先设定好您的提款密码");
			model.addAttribute("noticeHref", "../members/addsafepwd");
			model.addAttribute("noticeButton", "设定提款密码");
			return new ModelAndView("../index_files/accManager/error");
		}
		return new ModelAndView("../index_files/accManager/safepwd");
	}

	/**
	 * 进入设定提款密码页面
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addsafepwd", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView addsafepwd(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		String topage = request.getParameter("topage");
		if (!StringUtil.isNullOrEmpty(topage)) {
			model.addAttribute("topage", "platwithdraw");
		}
		return new ModelAndView("../index_files/accManager/setsafepwd");
	}

	/**
	 * 设定提款密码
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "safepwd", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView safepwd(Model model, HttpServletRequest request, HttpSession session) throws Exception {

		String secpass = request.getParameter("secpass");
		String mname = (String) session.getAttribute("mname");
		Members members = membersService.load(mname);
		String topage = request.getParameter("topage");
		if (!StringUtil.isNullOrEmpty(members)) {
			members.setMsafepwd(secpass);
			membersService.modify(members);
			memCache.getMc().set(members.getUid() + "_object", members);
			model.addAttribute("bankList", bankService.findByIsMember());
			model.addAttribute("provinceList", membersService.getProvince());
			// 存在跳转参数且绑定了卡号才能进入提款页面
			if (!StringUtil.isNullOrEmpty(topage)) {
				if (memberBankService.findByUid(members.getUid()).size() > 0) {
					return new ModelAndView("../index_files/accManager/platwithdraw");
				} else {
					model.addAttribute("noticeWord", "您还未绑定银行卡号，请先绑定您的银行卡号");
					model.addAttribute("noticeHref", "../members/bindCard");
					model.addAttribute("noticeButton", "绑定银行卡号");
					return new ModelAndView("../index_files/accManager/error");
				}
			}
			return new ModelAndView("../index_files/accManager/bindCard");
		}
		return new ModelAndView("../index_files/accManager/error");
	}

	/**
	 * 验证提款密码是否正确.
	 * 正确则进入绑定银行卡页面
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "validsafepwd", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView validsafepwd(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		String secpass = request.getParameter("secpass");
		String topage = request.getParameter("topage");
		secpass = MD5.getPasswordMD5(secpass);
		if (!StringUtil.isNullOrEmpty(secpass)) {
			Members members = (Members) memCache.getMc().get(session.getAttribute("uid").toString() + "_object");
			if (secpass.toUpperCase().equals(members.getMsafepwd().toUpperCase())) {
				model.addAttribute("bankList", bankService.findByIsMember());
				model.addAttribute("provinceList", membersService.getProvince());
				if (!StringUtil.isNullOrEmpty(topage)) {
					if (memberBankService.findByUid(members.getUid()).size() > 0) {
						return new ModelAndView("../index_files/accManager/platwithdraw");
					} else {
						model.addAttribute("noticeWord", "您还未绑定银行卡号，请先绑定您的银行卡号");
						model.addAttribute("noticeHref", "../members/bindCard");
						model.addAttribute("noticeButton", "绑定银行卡号");
						return new ModelAndView("../index_files/accManager/error");
					}
				}
				return new ModelAndView("../index_files/accManager/bindCard");
			}
		}
		return new ModelAndView("../index_files/accManager/error");
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@RequestMapping(value = "getCity", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getCity(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		String provinceId = request.getParameter("provinceId");
		PageInfo pageInfo = new PageInfo();
		pageInfo.setDataList(membersService.getCity(provinceId));
		return ajaxDone(pageInfo);

	}

	/**
	 * 绑定银行卡
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveCard", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView blindCard(MemberBank memberBank, HttpServletRequest request, HttpSession session) throws Exception {
		if (StringUtil.isNullOrEmpty(memberBank)) {
			return new ModelAndView("../index_files/accManager/error");
		}
		memberBank.setUid(Integer.parseInt(session.getAttribute("uid").toString()));
		memberBank.setEnable(true);
		memberBankService.create(memberBank);
		return new ModelAndView("../index_files/accManager/success");
	}

	/**
	 * 绑定卡号 
	 * 提款密码不存在则提醒设定
	 * 存在的话进入输入提醒密码页面
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "platwithdraw", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView platwithdraw(Model model, HttpServletRequest request, HttpSession session) throws Exception {

		Members pM = (Members) memCache.getMc().get(session.getAttribute("uid") + "_object");
		String safepwd = pM.getMsafepwd();
		model.addAttribute("topage", "platwithdraw");
		if (StringUtil.isNullOrEmpty(safepwd)) {
			model.addAttribute("noticeWord", "您还未设定提款密码，为了您的账户安全，请先设定好您的提款密码");
			model.addAttribute("noticeHref", "../members/addsafepwd?topage=platwithdraw");
			model.addAttribute("noticeButton", "设定提款密码");
			return new ModelAndView("../index_files/accManager/error");
		}
		return new ModelAndView("../index_files/accManager/safepwd");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "getBanks", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map getBanks(HttpSession session) {
		int uid = Integer.parseInt(session.getAttribute("uid").toString());
		Members member = membersService.load(uid);
		List<MemberBank> list = memberBankService.findByUid(uid);
		List l = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map m = new HashMap();
			MemberBank mb = list.get(i);
			Bank bank = bankService.findByPk(mb.getBankid());
			m.put("id", mb.getId());
			m.put("bankName", bank.getName());
			m.put("account", mb.getAccount());

			l.add(m);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", l);
		map.put("memberName", member.getMname());
		map.put("coin", member.getMcoin());
		map.put("cashNo", memberCashService.getCountToday(uid + ""));
		return map;
	}

	@RequestMapping(value = "saveplatwithdraw", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView saveplatwithdraw(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		int uid = Integer.parseInt(session.getAttribute("uid").toString());
		Members member = membersService.load(uid);
		int cashNo = memberCashService.getCountToday(uid+"");
		int bankinfo = Integer.parseInt(request.getParameter("bankinfo"));
		BigDecimal money = new BigDecimal(request.getParameter("money"));
		int appCashNo = Integer.parseInt(PropertiesUtil.readString("ssc.cashNo"));
		BigDecimal appMoney = new BigDecimal(PropertiesUtil.readString("ssc.money"));
		
		if (cashNo > appCashNo) {
			model.addAttribute("noticeWord", "提款次数超过"+appCashNo+"次限制");
			return new ModelAndView("../index_files/accManager/error");
		}
		if (money.compareTo(appMoney) == 1) {
			model.addAttribute("noticeWord", "提款金额超过"+appMoney+"限制");
			return new ModelAndView("../index_files/accManager/error");
		}
		if (money.compareTo(member.getMcoin()) == 1) {
			model.addAttribute("noticeWord", "提款金额超过可提款金额");
			return new ModelAndView("../index_files/accManager/error");
		}
		MemberCash memberCash = new MemberCash();
		memberCash.setAmount(money);
		memberCash.setUid(uid);
		memberCash.setMembersBankId(bankinfo);
		memberCash.setCreateDate(new Date());
		memberCash.setState(1); // 1=用户申请
		memberCashService.saveCash(member, memberCash);
		
		return new ModelAndView("../index_files/accManager/safepwd");
	}
	
	
	@RequestMapping(value = "getTotalMoney", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getTotalMoney(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		String mname = (String) session.getAttribute("mname");
		Members members = membersService.load(mname);
		BigDecimal toatlM = membersService.getTotalMoney(members.getUid()+"", members.getMcoin());
		
		Map map = new HashMap();
		map.put("totalMoney", toatlM);
		map.put("mname", mname);
		
		return map;
	}
}
