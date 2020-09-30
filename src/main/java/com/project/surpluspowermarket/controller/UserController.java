package com.project.surpluspowermarket.controller;

import com.project.surpluspowermarket.entity.UserVO;
import com.project.surpluspowermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String goToSignupPage() {
        return "signupForm";
    }

    //sign.result.jsp -> userResult.jsp로 변경.
    @PostMapping("/insertUser")
    public ModelAndView insert(UserVO userVO
                              , MultipartFile multipartPhoto
                              , HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("userResult");
        boolean result = userService.insert(userVO, multipartPhoto, request);
        if(result) {
            mav.addObject("msg","회원가입 되었습니다!");
        } else {
            mav.addObject("msg","Error : 회원가입에 실패하였습니다!");
        }
        return mav;
    }

    @GetMapping("/deleteUser")
    public ModelAndView deleteUser(String userid) {
        ModelAndView mav = new ModelAndView("userResult");
        boolean result = userService.delete(userid);
        if(result) {
            mav.addObject("msg","탈퇴되었습니다.");
        } else {
            mav.addObject("msg","Error : 탈퇴실패!");
        }
        return mav;
    }

    @ResponseBody
    @PostMapping(value = "/idCheck", produces = "application/json; charset=UTF-8")
    public HashMap<String, String> idCheck(String userid) {
        HashMap<String, String> map = new HashMap<>();
        Boolean result = Boolean.valueOf(userService.hasId(userid));
        map.put("result",result.toString());
        return map;
    }
}
