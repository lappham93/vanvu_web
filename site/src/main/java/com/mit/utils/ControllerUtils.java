package com.mit.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;

public class ControllerUtils {
	
	public static ModelAndView initPage(String template, List<String> breadCrumbs, String... tabs) {
		ModelAndView mav = new ModelAndView(template);
		mav.addObject("breadcrumbs", breadCrumbs);
		if (tabs != null) {
			for (String tab : tabs) {
				mav.addObject(tab, true);
			}
		}
		return mav;
	}
	
	public static String buildParam(HttpServletRequest request, List<String> ignoreParam) {
		if (request == null) {
			return "";
		}
		String uri = request.getServletPath();
		Map<String, String[]> paramMap = new HashMap<String, String[]>();
		for (String param : request.getParameterMap().keySet()) {
			if (ignoreParam == null || !ignoreParam.contains(param))
			paramMap.put(param, request.getParameterMap().get(param));
		}
		if (CollectionUtils.isEmpty(paramMap)) {
			return uri;
		}
		String query = "?";
		for (String key : paramMap.keySet()) {
			for (String value : paramMap.get(key)) {
				query += key + "=" + value + "&";
			}
		}
		query = query.substring(0, query.length() - 1); 
		return uri + query;
	}
}
