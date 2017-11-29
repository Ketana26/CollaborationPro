package com.chatapp.dao;



import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.chatapp.model.Blog;

@Repository
@ComponentScan("com.nik")
public interface BlogDao {
void addBlog(Blog blog);

List<Blog> viewBlogs();
List<Blog> viewAllBlogs();
void deleteBlog(Blog blog);
void updateBlog(Blog blog);
/*void updateBlogs(Blog blog);*/
List<Blog> viewMyBlogs(String postedby);
}
