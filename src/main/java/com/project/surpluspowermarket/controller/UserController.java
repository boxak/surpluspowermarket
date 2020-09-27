package com.project.surpluspowermarket.controller;

import com.project.surpluspowermarket.entity.UserEntity;
import com.project.surpluspowermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/signup")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String goToSignupPage() {
        return "signupForm";
    }

    @PostMapping("/done")
    public ModelAndView insert(UserEntity userEntity
                              ,MultipartFile multipartPhoto
                              ,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        boolean result = userService.insert(userEntity, multipartPhoto, request);
        if(result) {
            mav.addObject("msg","회원가입 되었습니다!");
        } else {
            mav.addObject("msg","Error : 회원가입에 실패하였습니다!");
        }
        mav.setViewName("signupResult");
        return mav;
    }
}
