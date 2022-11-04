package com.example.poetrytour.dao;

import com.example.poetrytour.model.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostDAO {

    /**
     * 根据帖子id查找帖子
     * @param id
     * @return
     */
    Post getPostById(long id);

    /**
     * 删除帖子
     * @param id
     * @return
     */
    int deletePost(long id);

}
