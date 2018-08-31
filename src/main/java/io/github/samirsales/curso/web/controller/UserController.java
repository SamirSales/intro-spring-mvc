package io.github.samirsales.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.samirsales.curso.dao.UserDao;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allUsers(ModelMap model) {
		model.addAttribute("users", userDao.getAll());
		return new ModelAndView("/user/list");
	}
}
