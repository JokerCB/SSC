package com.ssc.demo.web.controller;

import java.io.UnsupportedEncodingException;
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

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.ssc.demo.model.Members;
import com.ssc.demo.model.Order;
import com.ssc.demo.model.OrderDetail;
import com.ssc.demo.model.Played;
import com.ssc.demo.service.MembersService;
import com.ssc.demo.service.OrderService;
import com.ssc.demo.service.PlayedService;
import com.ssc.demo.util.IssTime;
import com.ssc.demo.web.controller.base.BaseController;
import com.ssc.demo.web.ui.PageRequest;

import framework.generic.page.PageInfo;
import framework.generic.paginator.domain.PageList;


@Controller
@RequestMapping("order/*")
public class OrderController extends BaseController{

	@Resource
	private OrderService orderService;
	@Resource
	private PlayedService playedService;
	
	@Resource
	private MembersService membersService;
	
	/**
	 * 保存订单 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/saveOrder", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String saveOrder(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(session.getAttribute("uid") == null)
			return "";
		Members members = membersService.load(Integer.parseInt(session.getAttribute("uid").toString()));
		
		Order order = new Order();
		order.setUid(Integer.parseInt(session.getAttribute("uid").toString()));
		int type = Integer.parseInt(request.getParameter("lotteryid"));
		String lt_issue_start = request.getParameter("lt_issue_start");
		String now_issue = IssTime.getIss();
		if(!now_issue.equals(lt_issue_start)){
			return "期号不对,请确认！";
		}
		int lt_total_nums = Integer.parseInt(request.getParameter("lt_total_nums"));
		BigDecimal lt_total_money = new BigDecimal(request.getParameter("lt_total_money"));
		String[] details = request.getParameterValues("lt_project[]");
		
		order.setType(type);
		order.setLtIssueStart(lt_issue_start);
		order.setTotalActionNum(lt_total_nums);
		order.setLtTotalMoney(lt_total_money);
		
		order.setCreateDate(new Date());
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		
		BigDecimal money = new BigDecimal("0.00");
		
		for(int i=0; i<details.length; i++){
			JSONObject map = new JSONObject(details[i]);
		//	Map map = JsonUtil.jsonToMap(JsonUtil.toJson(details[i]));
			OrderDetail detail = new OrderDetail();
			String  playType = map.get("type").toString();
			int playedId = Integer.parseInt(map.get("methodid").toString());
			String actionData = map.get("codes").toString();
			detail.setType(playType);//投注方式  复式 单式
			detail.setPlayId(playedId);//玩法
			detail.setActionData(actionData);//号码
			int actionNum = playedService.getActionNum(playedId, actionData, playType);
			
//			detail.setActionNum(Integer.parseInt(map.get("nums").toString()));//注数
			detail.setActionNum(actionNum);
			detail.setOmodel(Integer.parseInt(map.get("omodel").toString()));//返奖模式 (1-1850 2-1962)
			detail.setBeiShu(Integer.parseInt(map.get("times").toString()));//倍数
			
//			detail.setActionMoney(new BigDecimal(map.get("money").toString()));//金额
			detail.setMode(Integer.parseInt(map.get("mode").toString()));//圆角分模式
			BigDecimal model = new BigDecimal("2");//模式(1:元,2:角,3:分)
			if(detail.getMode() == 2)
				model = new BigDecimal("0.2");
			else if(detail.getMode() == 3)
				model = new BigDecimal("0.02");
			detail.setActionMoney(new BigDecimal(actionNum).multiply(new BigDecimal(detail.getBeiShu())).multiply(model));
			detail.setSeq(i+1);
			detail.setCreateDate(new Date());
			detailList.add(detail);
			
			money = money.add(detail.getActionMoney());
		}
		if(money.compareTo(members.getMcoin()) == 1)
		{
			return "";
		}
		order.setLtTotalMoney(money);
		order.setOrderDetails(detailList);
		
		orderService.addOrder(order);
		
		return "success";

	}
	
	@RequestMapping(value = "findDetailsByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
//	public Map<String, Object> listData(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage, @RequestParam(value = "perNum", defaultValue = "10") Integer perNum, HttpServletRequest request) {
	public  Map<String, Object> findDetailsByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
//		Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request, "sch_");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mname", request.getParameter("mname"));
		paramMap.put("issue", request.getParameter("issue"));
		paramMap.put("starttime", request.getParameter("starttime"));
		paramMap.put("endtime", request.getParameter("endtime"));
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		pageRequest.addDefaultOrder("orderId.desc");
		if(paramMap.get("mname") == null || "".equals(paramMap.get("mname")))
			paramMap.put("uid", session.getAttribute("uid"));
		
		pageRequest.setParameter(paramMap);
		
		PageInfo pageInfo = new PageInfo();
//		pageInfo.setPageSize(perNum);
//		pageInfo.setPageIndex(currentPage);
//		paramMap.put("pageInfo", pageInfo);
		PageList<OrderDetail> list = orderService.findDetailsByPage(pageRequest);
		for(int i=0; i<list.size(); i++){
			OrderDetail detail = list.get(i);
			Order order = orderService.load(detail.getOrderId());
			detail.setIssue(order.getLtIssueStart());
			Played played = playedService.load(detail.getPlayId());
			detail.setPlayedName(played.getName());
			
		}
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
	}
}
