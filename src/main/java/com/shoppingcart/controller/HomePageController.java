package com.shoppingcart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.entities.Queries;
import com.shoppingcart.service.QueriesService;

/**
 * Controller for home page/index page display
 * 
 * @author kenarayan
 *
 */
@Controller
public class HomePageController {
	
	@Autowired
	private QueriesService queryService;
	
	public QueriesService getQueryService() {
		return queryService;
	}

	public void setQueryService(QueriesService queryService) {
		this.queryService = queryService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String displayHomepage(Model model) {
		model.addAttribute("hello", "hello");
		return "index";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and Password");
		if (logout != null)
			model.addAttribute("logout", "You have logged out successfully");
		return "login";
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) throws IOException {
		ModelAndView view = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(StringUtils.equals(username, "test@amadeus.com") && StringUtils.equals(password, "amadeus") && StringUtils.isNotBlank(password)){
			view.setViewName("aboutUs");
		}else{
			view.setViewName("login");
		}
		
		return view;
	}

	@RequestMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}

	@RequestMapping(value = "/contactus")
	public ModelAndView getQuery() {
		Queries query = new Queries();
		return new ModelAndView("contactUs", "contact", query);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute(value = "contact") Queries query, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "contactUs";
		}

		queryService.addQuery(query);
		model.addAttribute("querySuccess",
				"Thank you. We have received your query and we will contact through corresponding Mail");
		return "login";

	}
}
