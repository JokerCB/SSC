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
import com.ssc.demo.model.MemberBank;
import com.ssc.demo.model.MemberCash;
import com.ssc.demo.model.Members;
import com.ssc.demo.model.Notice;
import com.ssc.demo.model.Played;
import com.ssc.demo.service.BankService;
import com.ssc.demo.service.MemberBankService;
import com.ssc.demo.service.MemberCashService;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.service.PlayedService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;
import com.ssc.demo.web.util.PropertiesUtil;

import framework.generic.memcached.MemCache;
import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;
import framework.generic.utils.json.JsonUtil;
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
	
	private PlayedService playedService;

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
	
	@Resource
	public void setPlayedService(PlayedService playedService) {
		this.playedService = playedService;
	}

	/*-------------------------------列表显示页面---------------------------------*/
	@RequestMapping(value = "findByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> findByPage(HttpSession session, PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		//前端查询
		if(request.getParameter("ALL") == null)
		{
			if (request.getParameter("mname") != null && request.getParameter("mname") != "")
				paramMap.put("mname", request.getParameter("mname"));
			else
				paramMap.put("mparentid", session.getAttribute("uid"));			
			
		}
		//后台查询
		else{
			if (request.getParameter("mname") != null && request.getParameter("mname") != "")
				paramMap.put("mname", request.getParameter("mname"));
		}
		
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

	@RequestMapping(value = "userList", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView userList(Model model, HttpServletRequest request) {
		return new ModelAndView("../index_files/accManager/userList");
	}
	
	/**
	 *前端添加会员
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addUser", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView addUser(Model model, HttpSession session, HttpServletRequest request) {

		Members members = new Members();
		String mname = request.getParameter("mname");
		Members existMembers = membersService.load(mname);
		if (existMembers != null) {
			model.addAttribute("noticeWord", "此用户名已存在!");
			return new ModelAndView("../index_files/accManager/error");
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
		members.setMfullparentid(pM.getMfullparentid()+"," +mparentid);
		members.setMtype(mtype);
		members.setMpassword(MD5.getPasswordMD5("123456"));
		members.setMcoin(new BigDecimal("0"));
		members.setMfcoin(new BigDecimal("0"));
		
		members.setIsAdmin(false);
		members.setCreateName(session.getAttribute("mname").toString());
		members.setCreateDate(new Date());
		members.setModifyDate(new Date());
		membersService.addMembers(members);

		model.addAttribute("noticeHref", "../members/userList");
		model.addAttribute("noticeButton", "返回");
		return new ModelAndView("../index_files/accManager/success");
	}
	
	@RequestMapping(value = "updateUser", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updateUser(Model model, HttpSession session, HttpServletRequest request) {
		
		Members members = new Members();
		String mname = request.getParameter("mname");
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
		members.setMfullparentid(pM.getMfullparentid()+"," +mparentid);
		members.setMtype(mtype);
		members.setMpassword(MD5.getPasswordMD5("123456"));
		members.setMcoin(new BigDecimal("0"));
		members.setMfcoin(new BigDecimal("0"));
		
		members.setIsAdmin(false);
		members.setCreateName(session.getAttribute("mname").toString());
		members.setCreateDate(new Date());
		members.setModifyDate(new Date());
		membersService.modify(members);
		
		model.addAttribute("noticeHref", "../members/userList");
		model.addAttribute("noticeButton", "用户列表");
		return new ModelAndView("../index_files/accManager/success");
	}
	
	/**
	 *后台添加会员
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addMembers", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String addMembers(Model model, HttpSession session, HttpServletRequest request) {

		Members members = new Members();
		String mname = request.getParameter("username");
		Members existMembers = membersService.load(mname);
		if (existMembers != null) {
			return "{'err':'此用户名已存在!'}";
		}
		BigDecimal mfandian = new BigDecimal(request.getParameter("fanDian"));
		BigDecimal mfandianbdw = new BigDecimal(request.getParameter("fanDianBdw"));
		int mparentid = Integer.parseInt(session.getAttribute("uid").toString());
		boolean mtype = "1".equals(request.getParameter("type")) ? true : false;
		Members pM = (Members) memCache.getMc().get(mparentid + "_object");
		members.setMgrade(pM.getMgrade() + 1);
		members.setMname(mname);
		members.setMfandian(mfandian);
		members.setMfandianbdw(mfandianbdw);
		members.setMtype(mtype);
		members.setMparentid(mparentid);
		members.setMfullparentid(pM.getMfullparentid()+"," +mparentid);
		members.setMpassword(MD5.getPasswordMD5(request.getParameter("password")));
		members.setMcoin(new BigDecimal("0"));
		members.setMfcoin(new BigDecimal("0"));		
		members.setIsAdmin(false);
		members.setCreateName(session.getAttribute("mname").toString());
		members.setCreateDate(new Date());
		members.setModifyDate(new Date());
		membersService.addMembers(members);

		return "{'success':'添加用户成功!'}";
	}
	
	/**
	 *后台修改会员
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "memberUpdate", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String memberUpdate(Model model, HttpSession session, HttpServletRequest request) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		Members members = membersService.load(uid);
		BigDecimal mfandian = new BigDecimal(request.getParameter("fanDian"));
		BigDecimal mfandianbdw = new BigDecimal(request.getParameter("fanDianBdw"));
		members.setMfandian(mfandian);
		members.setMfandianbdw(mfandianbdw);
		members.setMpassword(MD5.getPasswordMD5(request.getParameter("password")));
		members.setMsafepwd(MD5.getPasswordMD5(request.getParameter("coinPassword")));
		members.setCreateName(session.getAttribute("mname").toString());
		members.setModifyDate(new Date());
		membersService.modify(members);
		return null;
	}
	
	/**
	 *后台删除会员
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delMember", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String delMember(Model model, HttpSession session, HttpServletRequest request) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		membersService.remove(uid);
		return null;
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
		
		Members members = null;
		String mname = (String) session.getAttribute("mname");
		String uid = request.getParameter("uid");
		if (!StringUtil.isNullOrEmpty(uid)) {
			members = membersService.load(Integer.parseInt(uid));
		} else{
			members = membersService.load(mname);
		}
		BigDecimal toatlM = membersService.getTotalMoney(members.getUid()+"", members.getMcoin());
		
		Map map = new HashMap();
		map.put("totalMoney", toatlM);
		map.put("mname", members.getMname());
		
		return map;
	}
	
	/*-------------------------------会员银行信息列表显示页面---------------------------------*/
	@RequestMapping(value = "findMembersBankInfo", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> findMembersBankInfo(HttpSession session, PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		
		if (!StringUtil.isNullOrEmpty(request.getParameter("mname"))) {
			paramMap.put("mname", request.getParameter("mname"));
		}
		
		PageInfo pageInfo = new PageInfo();
		pageRequest.setParameter(paramMap);
		PageList<Map> list = membersService.findMembersBankInfo(pageRequest);
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);

	}
	
	/**
	 * 进入帐变记录页面
	 * @param model
	 */
	@RequestMapping(value = "coinLog", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView coinLog(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/coinLog");
	}
	
	/**
	 * 进入查询余额页面
	 * @param model
	 */
	@RequestMapping(value = "coinSum", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView coinSum(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/coinSum");
	}
	
	/**
	 * 进入返点总额页面
	 * @param model
	 */
	@RequestMapping(value = "fandianSum", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView fandianSum(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/fandianSum");
	}

	/**
	 * 进入消息管理页面
	 * @param model
	 */
	@RequestMapping(value = "messageList", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageList(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/messageList");
	}

	/**
	 * 进入修改密码页面
	 * @param model
	 */
	@RequestMapping(value = "modifyPassword", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView modifyPassword(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/modifyPassword");
	}

	/**
	 * 进入购彩查询 页面
	 * @param model
	 */
	@RequestMapping(value = "orderList", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView orderList(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		List<Played> list = playedService.findByType(1);
		List l = new ArrayList();
		for(int i=0; i<list.size(); i++){
			Map pm = new HashMap();
			pm.put("methodid", list.get(i).getId());
			pm.put("methodname", list.get(i).getName());
			l.add(pm);
		}
		Map map = new HashMap();
		map.put("1", l);
		String json = JsonUtil.toJson(map);
		model.addAttribute("data_method", json);
		return new ModelAndView("../index_files/accManager/orderList");
	}

	/**
	 * 进入完善资料 页面
	 * @param model
	 */
	@RequestMapping(value = "prefectData", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView prefectData(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/prefectData");
	}

	/**
	 * 进入易宝支付充值 页面
	 * @param model
	 */
	@RequestMapping(value = "recharge", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView recharge(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/recharge");
	}

	/**
	 * 进入报表查询 页面
	 * @param model
	 */
	@RequestMapping(value = "reportList", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView reportList(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/reportList");
	}

	/**
	 * 进入我的团队 页面
	 * @param model
	 */
	@RequestMapping(value = "teamSum", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView teamSum(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		String uid = request.getParameter("uid");
		model.addAttribute("uid", uid);
		return new ModelAndView("../index_files/accManager/teamSum");
	}

	/**
	 * 进入彩种信息 页面
	 * @param model
	 */
	@RequestMapping(value = "typeList", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView typeList(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/typeList");
	}

	/**
	 * 进入充提记录页面
	 * @param model
	 */
	@RequestMapping(value = "updownList", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updownList(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		return new ModelAndView("../index_files/accManager/updownList");
	}

	/**
	 * 进入增加用户页面/返点设定
	 * @param model
	 */
	@RequestMapping(value = "userAdd", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView userAdd(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		String flag = request.getParameter("flag");
		String uid = request.getParameter("uid");
		String mname = request.getParameter("mname");
		String action = "../members/addUser";
		if ("modify".equals(flag)) {
			Members members = membersService.load(Integer.parseInt(uid), mname);
			model.addAttribute("members", members);
			action = "../members/updateUser";
		}
		model.addAttribute("action", action);
		return new ModelAndView("../index_files/accManager/userAdd");
	}
	
	/**
	 * 进入网站公告页面
	 * @param model
	 */
	@RequestMapping(value = "notice", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView notice(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		List<Notice> list = membersService.getNotice();
		model.addAttribute("list", list);
		return new ModelAndView("../index_files/accManager/notice");
	}
}
