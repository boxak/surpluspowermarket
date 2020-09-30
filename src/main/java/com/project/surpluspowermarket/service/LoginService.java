package com.project.surpluspowermarket.service;

import com.project.surpluspowermarket.entity.UserVO;
import com.project.surpluspowermarket.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    Logger log = LoggerFactory.getLogger(LoginService.class);
    private String exceptionMsg = "";

    public UserVO loginCheck(String userid, String password) {
        UserVO userVO = null;
        try {
            userVO = loginRepository.findById(userid).get();
            if(!userVO.getPassword().equals(password)) {
                userVO = null;
            }
        } catch (NullPointerException npe) {
            exceptionMsg = "NullPointerException";
            log.info("해당 아이디를 찾을 수 없음!");
        }
        return userVO;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }
}
