package com.project.surpluspowermarket.repository;

import com.project.surpluspowermarket.VO.UserVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindRepository extends MongoRepository<UserVO,String> {
    public UserVO findDistinctByNameAndPhone(String name, String phone);
    public UserVO findDistinctByIdAndNameAndEmail(String userid,String name,String email);
    public long countByName(String name);
    public long countByPhone(String phone);
}
