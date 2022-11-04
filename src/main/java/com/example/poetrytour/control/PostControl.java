package com.example.poetrytour.control;

import com.example.poetrytour.dao.PostDAO;
import com.example.poetrytour.model.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostControl {

    @Autowired
    private PostDAO postDAO;

    @ResponseBody
    @RequestMapping("post/getPostById")
    public Post getPostById(@Param("id") long id){
        return postDAO.getPostById(id);
    }

    @ResponseBody
    @RequestMapping("post/deletePost")
    public Post deletePost(@Param("id") long id){
        Post post=postDAO.getPostById(id);
        postDAO.deletePost(id);
        return post;
    }
}
