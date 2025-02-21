package com.example.student.demo.student.repository;

import com.example.student.demo.student.module.VideoModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoModule,Long> {

    List<VideoModule> findByVideoNameContaining(String name);
}
