package com.mit.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mit.utils.ControllerUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Home Api")
@RestController
@RequestMapping(value = "/")
public class HomeController {
	@ApiOperation(value = "get list")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView renderHome(HttpServletRequest req) {
		ModelAndView mav = ControllerUtils.initPage("home", null, "isHome");
        return mav;
	}
}
