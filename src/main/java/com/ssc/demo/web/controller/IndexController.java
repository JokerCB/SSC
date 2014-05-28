package com.ssc.demo.web.controller;



import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssc.demo.model.Members;
import com.ssc.demo.model.Menu;
import com.ssc.demo.model.Played;
import com.ssc.demo.service.MenuService;
import com.ssc.demo.service.PlayedService;
import com.ssc.demo.util.IssTime;
import com.ssc.demo.web.controller.base.MessageController;

import framework.generic.memcached.MemCache;
import framework.generic.utils.date.DateUtil;
import framework.generic.utils.json.JsonUtil;

@Controller
@RequestMapping("index/*")
public class IndexController extends MessageController{
	
	@Resource
	PlayedService playedService;
	
	@Resource 
	MemCache memCache;
	
	@Resource
	MenuService menuService;
	
	@RequestMapping(value = "userMain", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(Model model,HttpServletRequest request) throws Exception {
		int type = Integer.parseInt(request.getParameter("type"));
		List<Menu> menus = menuService.findByType(type);
		model.addAttribute("menus",menus);
		return new ModelAndView("../index_files/accManager/userMain");
	}

	@RequestMapping(value = "getSscData", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getSscData(HttpSession session,HttpServletRequest request) {
		return "{issue:'"+IssTime.getIss()+"',nowtime:'"+IssTime.getServetTime()+"',saleend:'"+IssTime.getEndTime()+"'}";
	}
	
	@RequestMapping(value = "getCqsscPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView getCqsscPage(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		String mname = session.getAttribute("mname")!=null?session.getAttribute("mname").toString():null;
			Date nowDate = new Date();
			Date tomorrow = DateUtil.parse(DateUtil.format((new Date(nowDate.getTime()+24*60*60*1000))).subSequence(0, 11)+"00:00:00");
			model.addAttribute("cur_issue","{issue:'"+IssTime.getIss()+"',endtime:'"+IssTime.getEndTime()+"'}");
			model.addAttribute("servertime",IssTime.getServetTime());
			model.addAttribute("Iss_today",IssTime.getAllIss(nowDate));
			model.addAttribute("Iss_tomorrow",IssTime.getAllIss(tomorrow));
			
			//获取奖金
			Members members = (Members) memCache.getMc().get(session.getAttribute("uid")+"_object");
			BigDecimal fandian = members.getMfandian();
			BigDecimal andianbdw = members.getMfandianbdw();
			
			model.addAttribute("fandian",fandian);
			model.addAttribute("fandianbdw",andianbdw);
			
			Map moneyMap = new HashMap();
			
			List<Played> playeds = playedService.findAll();
			for(int i=0; i<playeds.size();i++){
				Played played = playeds.get(i);
				if(played.getKey() != null){
					if(played.getBonusPropMax().compareTo(played.getBonusPropMin()) == 0){
						moneyMap.put(played.getId(), played.getBonusPropMax()+","+played.getBonusPropMin());
					}
					else{
						BigDecimal max = played.getBonusBase().multiply(fandian).add(played.getBonusPropMin());
						moneyMap.put(played.getId(), max.setScale(2, BigDecimal.ROUND_HALF_UP)+","+played.getBonusPropMin());
					}
				}
			}
			String as = JsonUtil.objectToJson(moneyMap);
			model.addAttribute("moneyMap",as);
			return new ModelAndView("/index_files/a");
	}
	
	@RequestMapping(value = "getInitData", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String , Object> getInitData(HttpSession session,HttpServletRequest request)throws Exception {
		Map map = new HashMap();
		Date nowDate = new Date();
		Date tomorrow = DateUtil.parse(DateUtil.format((new Date(nowDate.getTime()+24*60*60*1000))).subSequence(0, 11)+"00:00:00");
		map.put("cur_issue","{issue:'"+IssTime.getIss()+"',endtime:'"+IssTime.getEndTime()+"'}");
		map.put("servertime",IssTime.getServetTime());
		map.put("Iss_today",IssTime.getAllIss(nowDate));
		map.put("Iss_tomorrow",IssTime.getAllIss(tomorrow));
		
		
		
		//获取奖金
		Members members = (Members) memCache.getMc().get(session.getAttribute("uid")+"_object");
		BigDecimal fandian = members.getMfandian();
		BigDecimal andianbdw = members.getMfandianbdw();
		
		map.put("fandian",fandian);
		map.put("fandianbdw",andianbdw);
		
		Map moneyMap = new HashMap();
		
		List<Played> playeds = playedService.findAll();
		for(int i=0; i<playeds.size();i++){
			Played played = playeds.get(i);
			if(played.getKey() != null){
				if(played.getBonusPropMax().compareTo(played.getBonusPropMin()) == 0){
					moneyMap.put(played.getId(), played.getBonusPropMax()+","+played.getBonusPropMin());
				}
				else{
					BigDecimal max = played.getBonusBase().multiply(fandian).add(played.getBonusPropMin());
					moneyMap.put(played.getId(), max.setScale(2, BigDecimal.ROUND_HALF_UP)+","+played.getBonusPropMin());
				}
			}
		}
		
		String as = JsonUtil.objectToJson(moneyMap);
		
		map.put("moneyMap",as);
		
		return map;
	}
}
