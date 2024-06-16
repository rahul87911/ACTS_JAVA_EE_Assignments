package com.app.dao;

import com.app.entities.BlogPost;

public interface BlogPostDao {

	String addNewBlog(Long categoryId, Long bloggerId,BlogPost post);

	String removeBlog(Long catId, Long blogId);

}
