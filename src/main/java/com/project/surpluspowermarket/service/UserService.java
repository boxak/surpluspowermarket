package com.project.surpluspowermarket.service;

import com.project.surpluspowermarket.VO.UserVO;
import com.project.surpluspowermarket.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    public String insert(UserVO userVO, MultipartFile multiPartPhoto, HttpServletRequest requestFromController) {
        String msg = "";
        try {
            //순서 중요함. 왜냐하면 유저 정보를 넣지 않았는데 사진이
            //업로드 되면 안되기 때문임.
            userRepository.insert(userVO);
            uploadPhotoIntoResources(userVO.getId(),multiPartPhoto,requestFromController);
            msg = "회원가입 되었습니다!";
        } catch(Exception e) {
            msg = "Error : 회원가입에 실패하였습니다!";
            log.info("몽고 DB에 유저 정보를 저장하는 데 실패!");
        }
        return msg;
    }

    public Map<String,Object> update(UserVO userVO, MultipartFile multiPartPhoto, HttpSession session, HttpServletRequest requestFromController) {
        Map<String,Object> map = new HashMap<>();
        try {
            userRepository.save(userVO);
            uploadPhotoIntoResources(userVO.getId(),multiPartPhoto,requestFromController);
            map.put("msg","회원 정보 업데이트에 성공하였습니다!");
            map.put("viewName","mypage");
            session.setAttribute("loginVO",userVO);
        } catch (Exception e) {
            map.put("msg","회원 정보 업데이트에 실패하였습니다!");
            map.put("viewName","modifyError");
            log.info("몽고 DB에 유저 정보 업데이트에 실패!");
        }
        return map;
    }

    public String delete(String userid) {
        String msg = "";
        try {
            userRepository.deleteById(userid);
            msg = "회원 정보 삭제 성공!";
        } catch (Exception e) {
            msg = "회원 정보 삭제 실패!";
            log.info("해당 유저 정보 삭제에 실패!");
        }
        return msg;
    }

    public boolean hasId(String userid) {
        int cnt = 0;
        try {
            cnt = (int)userRepository.countAllById(userid);
        } catch (Exception e) {
            log.info("유저 정보에 접속하는 데 실패!");
        }
        return !(cnt==0);
    }

    private static void uploadPhotoIntoResources(String userid, MultipartFile multipartPhoto, HttpServletRequest request) {
        byte[] photoTransmisionArray = null;
        try {
            if(!multipartPhoto.isEmpty()) {
                photoTransmisionArray = multipartPhoto.getBytes();
                String photoSavePath = request.getSession().getServletContext()
                                       .getRealPath("/")+"resources/user_profile_photo/"+userid+".png";
                log.info(photoSavePath);
                File photoFile = new File(photoSavePath);
                FileOutputStream photoOutputStream = new FileOutputStream(photoFile);
                photoOutputStream.write(photoTransmisionArray);
                photoOutputStream.close();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
