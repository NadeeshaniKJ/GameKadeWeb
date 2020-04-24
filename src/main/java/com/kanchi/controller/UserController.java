package com.kanchi.controller;

import com.kanchi.dto.User;
import com.kanchi.service.UserService;
import com.kanchi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
//@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired(required = true)
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", this.userService.getAllUsers());
        model.addAttribute("count",userService.getUserCount());
        return new ModelAndView("users");
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        return new ModelAndView("users");
    }


    /*@RequestMapping(value = "/users/newUser", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        model.addObject("user",new User());
        model.setViewName("userForm");
        return model;
    }*/

    /*@RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user) {
        this.userService.addUser(user);
        return new ModelAndView("redirect:/users");
    }*/

    @RequestMapping(value = "/users/newUser", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("command",new User());
        return "userForm";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        this.userService.addUser(user);
        return "redirect:/users";
    }






   /* @RequestMapping(value = "/user/edit", method = RequestMethod.PUT)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        this.userService.updateUser(user);
        return new ModelAndView("users");
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ModelAndView removeUser(@PathVariable("id") int id) {
        this.userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }


    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model) {
        model.addAttribute("count",userService.getUserCount());
        return new ModelAndView("users");
    }*/
}
