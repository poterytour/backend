package com.example.poetrytour.dao;

import com.example.poetrytour.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {

    /**
     * 查询一篇帖子的评论
     * @param postId
     * @return
     */
    List<Comment> getComments(long postId);

    /**
     * 根据评论id查找评论
     * @param id
     * @return
     */
    Comment getCommentById(long id);

    /**
     * 增加评论
     * @param id
     * @param context
     * @param parentId
     * @param userId
     * @param postId
     * @return
     */
    int addComment(long id,String context,long parentId,long userId,long postId);

    /**
     * 删除评论
     * @param id
     * @return
     */
    int deleteComment(long id);
}
