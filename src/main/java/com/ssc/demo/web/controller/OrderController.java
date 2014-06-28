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
import org.springframework.ui.Model;
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
import framework.generic.utils.security.MD5;


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
		
		boolean zhuiHao = "yes".equals(request.getParameter("lt_trace_if"));//是否追号
		if(zhuiHao){
			List<Order> list = new ArrayList();
			boolean isStop = "yes".equals(request.getParameter("lt_trace_stop"));//中奖是否停止
			String[] issues = request.getParameterValues("lt_trace_issues[]");
			for(int m=0; m<issues.length; m++){
				String issue = issues[m];//期号
				int beiShu = Integer.parseInt(request.getParameter("lt_trace_times_"+issue));//倍数(整个订单)
				
				Order order = new Order();
				order.setZhuiHaoId(orderService.buildOrderId("zhuiHao"));
				order.setZhuiHao(true);
				order.setIsStop(isStop);
				order.setUid(Integer.parseInt(session.getAttribute("uid").toString()));
				int type = Integer.parseInt(request.getParameter("lotteryid"));

			
				int lt_total_nums = Integer.parseInt(request.getParameter("lt_total_nums"));
				BigDecimal lt_total_money = new BigDecimal(request.getParameter("lt_total_money"));
				String[] details = request.getParameterValues("lt_project[]");
				
				order.setType(type);
				order.setLtIssueStart(issue);
				order.setTotalActionNum(lt_total_nums);
				order.setLtTotalMoney(lt_total_money);
				
				order.setCreateDate(new Date());
				List<OrderDetail> detailList = new ArrayList<OrderDetail>();
				
				BigDecimal money = new BigDecimal("0.00");
				
				for(int i=0; i<details.length; i++){
					JSONObject map = new JSONObject(details[i]);
					OrderDetail detail = new OrderDetail();
					String  playType = map.get("type").toString();
					int playedId = Integer.parseInt(map.get("methodid").toString());
					String actionData = map.get("codes").toString();
					detail.setType(playType);//投注方式  复式 单式
					detail.setPlayId(playedId);//玩法
					detail.setActionData(actionData);//号码
					int actionNum = playedService.getActionNum(playedId, actionData, playType);
					
					detail.setActionNum(actionNum);
					detail.setOmodel(Integer.parseInt(map.get("omodel").toString()));//返奖模式 (1-1850 2-1962)
					detail.setBeiShu(Integer.parseInt(map.get("times").toString()) * beiShu);//倍数
					
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
				list.add(order);				
			}
			orderService.addOrders(list);
		}
		else{
			
			
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
				
//				detail.setActionNum(Integer.parseInt(map.get("nums").toString()));//注数
				detail.setActionNum(actionNum);
				detail.setOmodel(Integer.parseInt(map.get("omodel").toString()));//返奖模式 (1-1850 2-1962)
				detail.setBeiShu(Integer.parseInt(map.get("times").toString()));//倍数
				
//				detail.setActionMoney(new BigDecimal(map.get("money").toString()));//金额
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
		}
		
		
		
		return "success";

	}
	
	@RequestMapping(value = "findDetailsByPage", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
//	public Map<String, Object> listData(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage, @RequestParam(value = "perNum", defaultValue = "10") Integer perNum, HttpServletRequest request) {
	public  Map<String, Object> findDetailsByPage(HttpSession session,PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
//		Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request, "sch_");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int type = Integer.parseInt(request.getParameter("lotteryid"));
		if(type != 0)
			paramMap.put("type", type);
		if(request.getParameter("methodid") != null){
			int playedId = Integer.parseInt(request.getParameter("methodid"));
			if(playedId != 0)
				paramMap.put("playedId", playedId);
		}
		paramMap.put("orderId", request.getParameter("orderId"));
		paramMap.put("mname", request.getParameter("mname"));
		paramMap.put("issue", request.getParameter("issue"));
		paramMap.put("starttime", request.getParameter("starttime"));
		paramMap.put("endtime", request.getParameter("endtime"));
		pageRequest.setPageNo(Integer.parseInt(request.getParameter("pageIndex")));
		pageRequest.addDefaultOrder("orderId.desc");
		if((paramMap.get("mname") == null || "".equals(paramMap.get("mname"))) && request.getParameter("all") == null)
			paramMap.put("uid", session.getAttribute("uid"));
		
		pageRequest.setParameter(paramMap);
		
		PageInfo pageInfo = new PageInfo();
//		pageInfo.setPageSize(perNum);
//		pageInfo.setPageIndex(currentPage);
//		paramMap.put("pageInfo", pageInfo);
		PageList<OrderDetail> list = orderService.findDetailsByPage(pageRequest);
		String now_issue = IssTime.getIss();
		for(int i=0; i<list.size(); i++){
			OrderDetail detail = list.get(i);
			Map map = new HashMap();
			Order order = orderService.load(detail.getOrderId());
//			detail.setIssue(order.getLtIssueStart());
			map.put("issue", order.getLtIssueStart());
			
			Played played = playedService.load(detail.getPlayId());
//			detail.setPlayedName(played.getName());
			map.put("playedName", played.getName());
			
			if("all".equals(request.getParameter("all"))){
				Members m = membersService.load(order.getUid());
//				detail.setmName(m.getMname());
				map.put("mname", m.getMname());
			}
			if(order.getStatus() ==0){
				map.put("state", "未开奖");
				
				if(order.getLtIssueStart().compareTo(now_issue) >= 0)
					map.put("cancel", 1);
			}
			else if(order.getStatus() ==2)
				map.put("state", "已撤单");
			else{
				if(detail.getBonus() != null && detail.getBonus().compareTo(new BigDecimal("0")) == 1)
					map.put("state", "已中奖");
				else
					map.put("state", "未中奖");
			}
			
//			detail.setZhuiHaoId(order.getZhuiHaoId());
//			detail.setZhuiHao(order.getZhuiHao());
//			detail.setIsStop(order.getIsStop());
			map.put("zhuiHaoId", order.getZhuiHaoId());
			map.put("zhuiHao", order.getZhuiHao());
			map.put("isStop", order.getIsStop());
			
			detail.setMap(map);
			
		}
		pageInfo.setDataList(list);
		pageInfo.setPageSize(list.getPaginator().getLimit());
		pageInfo.setPageIndex(list.getPaginator().getPage());
		pageInfo.setPageCount(list.getPaginator().getTotalPages());
		return ajaxDone(pageInfo);
	}
	
	/**
	 *撤单操作
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "cancel", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String cancel(Model model, HttpSession session, HttpServletRequest request) {

		Members members = new Members();
		String orderId = request.getParameter("orderId");
		Order order = orderService.load(orderId);
		String now_issue = IssTime.getIss();
		if(order.getLtIssueStart().compareTo(now_issue) == -1){
			return "此订单不允许撤单，请确认";
		}
		try{
			if(order.getZhuiHao()){
				List<Order> l = orderService.findOrderByZhuiHaoId(order.getZhuiHaoId(), order.getStatus());
				List<Order> list = new ArrayList();
				for(int i=0; i<l.size(); i++){
					Order o = l.get(i);
					if(o.getLtIssueStart().compareTo(now_issue) >=0 ){
						list.add(o);
					}
				}
				
				orderService.cancel(list);
			}
			else{
				orderService.cancel(order);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return "撤单失败";
		}
		return "撤单成功";
	}
}
