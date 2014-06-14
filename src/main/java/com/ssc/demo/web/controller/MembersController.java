package com.ssc.demo.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
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

import com.ssc.demo.model.City;
import com.ssc.demo.model.Members;
import com.ssc.demo.service.BankService;
import com.ssc.demo.service.MemberBankService;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

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

	private BankService bankListService;

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
	public void setBankListService(BankService bankListService) {
		this.bankListService = bankListService;
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
		if (!StringUtil.isNullOrEmpty(members)) {
			members.setMsafepwd(secpass);
			membersService.modify(members);
			memCache.getMc().set(members.getUid() + "_object", members);
			model.addAttribute("bankList", bankListService.findByIsMember());
			model.addAttribute("provinceList", membersService.getProvince());
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
		secpass = MD5.getPasswordMD5(secpass);
		if (!StringUtil.isNullOrEmpty(secpass)) {
			Members members = (Members) memCache.getMc().get(session.getAttribute("uid").toString() + "_object");
			if (secpass.toUpperCase().equals(members.getMsafepwd().toUpperCase())) {
				model.addAttribute("bankList", bankListService.findByIsMember());
				model.addAttribute("provinceList", membersService.getProvince());
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
}
