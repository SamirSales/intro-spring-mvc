package io.github.samirsales.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.samirsales.curso.dao.UserDao;
import io.github.samirsales.curso.domain.User;

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
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user, ModelMap model) {
		return "/user/add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") User user, RedirectAttributes attr) {
		userDao.save(user);
		attr.addFlashAttribute("message", "User has been saved successfully!");
		return "redirect:/user/all";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		User user = userDao.getUser(id);
		model.addAttribute("user", user);
		return new ModelAndView("/user/add", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute("user") User user, RedirectAttributes attr) {
		userDao.update(user);
		attr.addFlashAttribute("message", "User has been updated successfully!");
		return new ModelAndView("redirect:/user/all");
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		userDao.remove(id);
		attr.addFlashAttribute("message", "User has been removed successfully!");
		return "redirect:/user/all";
	}
	
}
