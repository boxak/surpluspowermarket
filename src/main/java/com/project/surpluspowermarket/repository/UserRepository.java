package com.project.surpluspowermarket.repository;

import com.project.surpluspowermarket.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {
    public long countAllById(String userid);
}
