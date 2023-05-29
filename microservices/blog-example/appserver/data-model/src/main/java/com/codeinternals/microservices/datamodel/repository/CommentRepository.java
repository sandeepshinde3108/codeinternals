package com.codeinternals.microservices.datamodel.repository;

import com.codeinternals.microservices.datamodel.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
