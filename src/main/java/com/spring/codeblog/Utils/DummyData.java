package com.spring.codeblog.Utils;

import com.spring.codeblog.Model.Post;
import com.spring.codeblog.Repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository codeblogRepository;

    //@PostConstruct
    public void savePosts() {

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Enzo Fernandes");
        post1.setDate(LocalDate.now());
        post1.setTitle("É o nome");
        post1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        Post post2 = new Post();
        post2.setAutor("Enzo Fernandes Sarmento");
        post2.setDate(LocalDate.now());
        post2.setTitle("É o nome do seu vídeo");
        post2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");


        postList.add(post1);
        postList.add(post2);

        for (Post post: postList) {
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }



}
