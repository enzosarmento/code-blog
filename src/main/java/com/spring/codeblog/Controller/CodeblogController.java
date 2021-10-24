package com.spring.codeblog.Controller;


import com.spring.codeblog.Model.Post;
import com.spring.codeblog.Service.serviceImpl.CodeblogService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView(  "posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView post(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("post");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable Long id) {
        codeblogService.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/newpost")
    public String newPost() {
        return "postForm";
    }

    @PostMapping("/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Verifique se os campos foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setDate(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }

}
