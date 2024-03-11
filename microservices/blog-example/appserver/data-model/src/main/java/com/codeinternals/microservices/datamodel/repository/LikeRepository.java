package com.codeinternals.microservices.datamodel.repository;

import com.codeinternals.microservices.datamodel.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
