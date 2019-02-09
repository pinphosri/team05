package com.sut.se.g05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class CommentController {

    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private CommentRepository commentRepository;
    /*@Autowired
    private DriverRepository driverRepository ;*/

    @GetMapping("/Comment")
    public Collection <Comment> Commment() {

        return commentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Level")
    public Collection<Level> Level(){
        return levelRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Comment/{level1}/{level2}/{level3}/{name}/{phone}/{post}")
    public Comment newComment(Comment newComment,@PathVariable Long level1,@PathVariable Long level2,
                              @PathVariable Long level3,@PathVariable String name,@PathVariable String phone,
                              @PathVariable String post) {

        Level levels1 = levelRepository.findByLevelId(level1);
        Level levels2 = levelRepository.findByLevelId(level2);
        Level levels3 = levelRepository.findByLevelId(level3);

        newComment.setPhone(phone);
        newComment.setName(name);
        newComment.setPost(post);

        return  commentRepository.save(newComment);
    }
}
