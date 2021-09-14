package com.spring.codeblog.Repository;

import com.spring.codeblog.Model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeblogRepository extends JpaRepository<Post, Long> {

}
