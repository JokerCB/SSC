package com.ssc.demo.web.controller.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ssc.demo.web.ui.DataGrid;
import com.ssc.demo.web.ui.Json;
import com.ssc.demo.web.ui.PageRequest;
import com.ssc.demo.web.util.ConvertRegisterHelper;

import framework.generic.utils.string.StringUtil;

@Controller
@RequestMapping(value = "abstract/*")
public class AbstractController<T, PK> extends MessageController {
	static {
		// 注册converters
		ConvertRegisterHelper.registerConverters();
	}

	/**
	 * 初始化binder的回调函数.
	 * 
	 * @see MultiActionController#createBinder(HttpServletRequest,Object)
	 */
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Short.class, new CustomNumberEditor(Short.class, true));
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
		binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
		binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, true));
		binder.registerCustomEditor(BigInteger.class, new CustomNumberEditor(BigInteger.class, true));
	}

	// 特别说明: 由于spring的方法参数映射太过于灵活,如果以下参数不适应你,请自己修改参数并修改代码生成器模板
	// 如果你不喜欢 HttpServletRequest request,HttpServletResponse response作为方法参数，也请删除

	/** 进入dataGrid页面 */
	@RequestMapping(value = "index", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** dataGrid数据请求 */
	@RequestMapping(value = "dataGrid", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public DataGrid dataGrid(PageRequest pageRequest, HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/**数据请求 */
	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<T> list(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 进入新增页面 */
	@RequestMapping(value = "addForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView addFrom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 保存新增 */
	@RequestMapping(value = "insert", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Json insert(@ModelAttribute("entity")
	T entity, HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 进入编辑 页面 */
	@RequestMapping(value = "editForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView editForm(@RequestParam
	PK key, HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 进入编辑 页面 */
	@RequestMapping(value = "updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 保存更新 */
	@RequestMapping(value = "update", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Json update(T entity, HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 删除 */
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Json delete(@RequestParam
	PK primaryKey, HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 批量删除 */
	@RequestMapping(value = "deleteAll", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Json deleteAll(PK[] ids, HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 删除 */
	@RequestMapping(value = "remove", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Json remove(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 删除 */
	@RequestMapping(value = "removeAll", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Json removeAll(@RequestBody
	List<T> lst, HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 查看 */
	@RequestMapping(value = "view", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView view(@RequestParam
	PK primaryKey, HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 查看 */
	@RequestMapping(value = "viewForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		throw new UnsupportedOperationException("not yet implement");
	}

	/** 验证主键是否已经存在 */
	@RequestMapping(value = "validatePk", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public boolean validatePk(@RequestParam
	PK primaryKey, HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("not yet implement");
	}

	// ---------------------关于SSO有关的设置 end--------------------//

	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

}
