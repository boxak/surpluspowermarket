package com.project.surpluspowermarket.service;

import com.project.surpluspowermarket.entity.UserVO;
import com.project.surpluspowermarket.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    public boolean insert(UserVO userVO, MultipartFile multiPartPhoto, HttpServletRequest requestFromController) {
        boolean result = false;
        try {
            userRepository.insert(userVO);
            uploadPhotoIntoResources(userVO.getId(),multiPartPhoto,requestFromController);
            result = true;
        } catch(Exception e) {
            log.info("몽고 DB에 유저 정보를 저장하는 데 실패!");
        }
        return result;
    }

    public boolean update(UserVO userVO, MultipartFile multiPartPhoto, HttpServletRequest requestFromController) {
        boolean result = false;
        try {
            userRepository.save(userVO);
            uploadPhotoIntoResources(userVO.getId(),multiPartPhoto,requestFromController);
            result = true;
        } catch (Exception e) {
            log.info("몽고 DB에 유저 정보 업데이트에 실패!");
        }
        return result;
    }

    public boolean delete(String userid) {
        boolean result = false;
        try {
            userRepository.deleteById(userid);
            result = true;
        } catch (Exception e) {
            log.info("해당 유저 정보 삭제에 실패!");
        }
        return result;
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
