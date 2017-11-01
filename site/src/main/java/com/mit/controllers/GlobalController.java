package com.mit.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public final class GlobalController {
	@Value("${site.prefix}")
	private String sitePrefix;
	@Value("${site.title}")
	private String siteTitle;
	@Value("${site.resources.path}")
	private String resourcesPath;
	
	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest req) {
		model.addAttribute("site_prefix", sitePrefix);
		model.addAttribute("site_title", siteTitle);
		model.addAttribute("resources_path", resourcesPath);
	}
}
