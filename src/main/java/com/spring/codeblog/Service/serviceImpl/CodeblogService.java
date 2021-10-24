package com.spring.codeblog.Service.serviceImpl;

import com.spring.codeblog.Model.Post;

import java.util.List;

public interface CodeblogService {

    List<Post> findAll();

    Post findById(Long id);

    Post save(Post post);

    Post deleteById(Long id);
}
