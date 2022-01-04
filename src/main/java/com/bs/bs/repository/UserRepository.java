package com.bs.bs.repository;


import com.bs.bs.entity.UserEntity;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}