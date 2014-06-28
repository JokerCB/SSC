package com.ssc.demo.web.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssc.demo.model.Played;
import com.ssc.demo.service.PlayedService;
import com.ssc.demo.web.controller.base.BaseController;

@Controller
@RequestMapping("played/*")
public class PlayedController extends BaseController {
	@Resource
	private PlayedService playedService;

	@RequestMapping(value = "getPlayedList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<Played> getPlayedList()
	{
		List<Played> list = playedService.findByType(1);
		return list;
		
	}
}
