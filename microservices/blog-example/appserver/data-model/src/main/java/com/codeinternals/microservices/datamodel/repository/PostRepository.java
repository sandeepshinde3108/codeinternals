package com.codeinternals.microservices.datamodel.repository;

import com.codeinternals.microservices.datamodel.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
