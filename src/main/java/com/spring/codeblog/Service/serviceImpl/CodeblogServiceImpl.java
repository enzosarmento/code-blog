package com.spring.codeblog.Service.serviceImpl;

import com.spring.codeblog.Model.Post;
import com.spring.codeblog.Repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceImpl implements CodeblogService {

    @Autowired
    CodeblogRepository codeblogRepository;

    @Override
    public List<Post> findAll() {
        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeblogRepository.save(post);
    }

    @Override
    public Post deleteById(Long id) {
        codeblogRepository.deleteById(id);
        return null;
    }
}
