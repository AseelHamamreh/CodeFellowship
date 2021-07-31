package com.CodeFellowshipDemo.CodeFellowship.repositories;

import com.CodeFellowshipDemo.CodeFellowship.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
