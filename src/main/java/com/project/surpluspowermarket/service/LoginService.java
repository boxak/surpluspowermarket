package com.project.surpluspowermarket.service;

import com.project.surpluspowermarket.VO.UserVO;
import com.project.surpluspowermarket.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    Logger log = LoggerFactory.getLogger(LoginService.class);

    public Map<String,String> loginCheck(String id, String password
                                        , String saveId, HttpSession session
                                        , HttpServletResponse response) {
        Map<String,String> map = new HashMap<>();
        String msg = "";
        String viewName = "";

        UserVO
    }

}
