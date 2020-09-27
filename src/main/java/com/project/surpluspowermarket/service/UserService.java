package com.project.surpluspowermarket.service;

import com.project.surpluspowermarket.entity.UserEntity;
import com.project.surpluspowermarket.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    public boolean insert(UserEntity userEntity, MultipartFile multiPartPhoto, HttpServletRequest requestFromController) {
        boolean result = false;
        try {
            userRepository.insert(userEntity);
            uploadPhotoIntoResources(userEntity.getId(),multiPartPhoto,requestFromController);
            result = true;
        } catch(Exception e) {
            log.info("몽고 DB에 유저 정보를 저장하는 데 실패!");
        }
        return result;
    }

    public boolean update(UserEntity userEntity, MultipartFile multiPartPhoto, HttpServletRequest requestFromController) {
        boolean result = false;
        try {
            userRepository.save(userEntity);
            uploadPhotoIntoResources(userEntity.getId(),multiPartPhoto,requestFromController);
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
