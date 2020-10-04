package com.project.surpluspowermarket.repository;

import com.project.surpluspowermarket.VO.UserVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<UserVO,String> {
}
