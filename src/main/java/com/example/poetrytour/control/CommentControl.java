package com.example.poetrytour.control;

import com.example.poetrytour.dao.CommentDAO;
import com.example.poetrytour.dao.PostDAO;
import com.example.poetrytour.model.Comment;
import com.example.poetrytour.model.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentControl {

    @Autowired
    private CommentDAO commentDAO;

    @ResponseBody
    @RequestMapping("post/comment/getAllComments")
    public List<Comment> getAllComment(@Param("postId") long postId){
        return commentDAO.getComments(postId);
    }

    @ResponseBody
    @RequestMapping("post/comment/getCommentById")
    public Comment getCommentById(@Param("id") long id){
        return commentDAO.getCommentById(id);
    }

    @ResponseBody
    @RequestMapping("post/comment/addComment")
    public Comment addComment(@Param("id") long id,@Param("context") String context,@Param("parentId") long parentId,
                              @Param("userId") long userId,@Param("postId") long postId){
        commentDAO.addComment(id, context, parentId, userId, postId);
        return commentDAO.getCommentById(id);
    }

    @ResponseBody
    @RequestMapping("post/comment/deleteComment")
    public int deleteComment(@Param("id") long id){
        return commentDAO.deleteComment(id);
    }
}
