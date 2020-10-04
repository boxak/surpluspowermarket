package com.project.surpluspowermarket.controller;

import com.project.surpluspowermarket.VO.UserVO;
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
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    //true, false를 여기서 처리하는게 아니라,
    //service에서 아예 msg도 처리해서 전달.
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
        mav.addObject("msg",userService.insert(userVO,multipartPhoto,request));
        return mav;
    }

    @PostMapping("/updateUser")
    public ModelAndView update(UserVO userVO, MultipartFile multipartPhoto
                        , HttpSession session
                        ,HttpServletRequest request) {
        Map<String,Object> map = userService.update(userVO,multipartPhoto,session,request);
        ModelAndView mav = new ModelAndView((String)map.get("viewName"));
        mav.addObject("msg",map.get("msg"));
        return mav;
    }
    //이거 하면서 느낀 것. 기능을 다 구현해놨다고 해도,
    //계속해서 유지보수, 혹은 리뉴얼 하면서 끊임없이 고쳐나가야 하는 것임을
    //깨달을 수 있었음.
    @GetMapping("/deleteUser")
    public ModelAndView deleteUser(String userid) {
        ModelAndView mav = new ModelAndView("userResult");
        mav.addObject("msg",userService.delete(userid));
        return mav;
    }

    @GetMapping("/readUser")
    public ModelAndView readUser(HttpSession session) {

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
