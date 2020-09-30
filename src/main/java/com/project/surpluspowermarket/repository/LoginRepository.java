package com.project.surpluspowermarket.repository;

import com.project.surpluspowermarket.entity.UserVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends MongoRepository<UserVO,String> {
}
