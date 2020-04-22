package com.kanchi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/login")
public class NextController {

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        return "nextPage";
    }

}
