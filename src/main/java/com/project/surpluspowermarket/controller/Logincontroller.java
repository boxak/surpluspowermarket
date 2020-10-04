package com.project.surpluspowermarket.controller;

import com.project.surpluspowermarket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class Logincontroller {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/")
    public ModelAndView doLogin(String id, String password
                                , String saveId, HttpSession session
                                , HttpServletResponse response) {
        Map<String,String> map = loginService.loginCheck(id,password,saveId
                                                        ,saveId,session
                                                        ,response);
        ModelAndView mav = new ModelAndView(map.get("viewName"));
        mav.addObject("msg",map.get("msg"));
        return mav;
    }

}
