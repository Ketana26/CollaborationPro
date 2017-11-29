package com.chatapp.dao;



import java.util.List;

import com.chatapp.model.Blog;
import com.chatapp.model.Jobs;

public interface JobsDao {
void addJobs(Jobs jobs);
List<Jobs> viewJobs();

void deleteJob(Jobs jobs);
void updateJob(Jobs jobs);

}

