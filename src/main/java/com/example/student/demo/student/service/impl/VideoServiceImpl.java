package com.example.student.demo.student.service.impl;

import com.example.student.demo.student.module.VideoModule;
import com.example.student.demo.student.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl {
@Autowired
private VideoRepository videoRepository;

public VideoServiceImpl(VideoRepository videoRepository)
{
    this.videoRepository=videoRepository;
}
public VideoModule addVideo (VideoModule videoModule)
{
    return videoRepository.save(videoModule);
}

public String deleteAllVideo()
{
    videoRepository.deleteAll();
    return "All Records have been Deleted Successfully";
}

public VideoModule getVideoById(Long id)
{
    return videoRepository.findById(id).orElseThrow(()->new RuntimeException("recod not found"));
}

public List<VideoModule> getAllVideos()
{
        return videoRepository.findAll();
}

public List<VideoModule> getVideoName(String videoName)
{
        return videoRepository.findByVideoNameContaining(videoName);
}

}
