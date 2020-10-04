package com.project.surpluspowermarket.service;

import com.project.surpluspowermarket.VO.UserVO;
import com.project.surpluspowermarket.repository.FindRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindService {

    @Autowired
    FindRepository findRepository;

    Logger log = LoggerFactory.getLogger(FindService.class);

    public String findIdCheck(String name, String phone) {
        int cnt1 = 0;
        int cnt2 = 0;
        String msgFromServer = "";
        try {
            cnt1 = (int)findRepository.countByName(name);
            cnt2 = (int)findRepository.countByPhone(phone);
            if(cnt1 == 0 || cnt2 == 0) {
                if(cnt1 == 0) msgFromServer = "일치하는 이름이 없습니다!";
                if(cnt2 == 0) msgFromServer = "일치하는 휴대폰 번호가 없습니다!";
            } else{
                msgFromServer = findRepository.findDistinctByNameAndPhone(name,phone).getId();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return msgFromServer;
    }

    public String findPwCheck(String userid,String name,String email) {
        String result = "";
        try {
            UserVO userVO = findRepository.findDistinctByIdAndNameAndEmail(userid,name,email);
            if(userVO == null) result = "해당 정보를 찾을 수 없습니다!";
            else result = "입력하신 정보가 확인되었습니다. 비밀번호를 재설정해주세요.";
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return result;
    }
}
