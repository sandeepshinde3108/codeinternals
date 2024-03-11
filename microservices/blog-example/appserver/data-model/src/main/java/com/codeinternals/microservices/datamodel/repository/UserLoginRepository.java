package com.codeinternals.microservices.datamodel.repository;

import com.codeinternals.microservices.datamodel.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
}
