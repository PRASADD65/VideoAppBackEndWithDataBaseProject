package com.example.student.demo.student.controller;

import com.example.student.demo.student.module.VideoModule;
import com.example.student.demo.student.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/video")
public class VideoController {

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    public VideoController(VideoServiceImpl videoServiceImp)
    {
        this.videoServiceImpl=videoServiceImpl;
    }
    @PostMapping
    public VideoModule saveUser(@RequestBody VideoModule videoModule)
    {
        return videoServiceImpl.addVideo(videoModule);
    }
    @DeleteMapping
    public String deleteAllVideos()
    {
        return videoServiceImpl.deleteAllVideo();
    }

    @GetMapping("/videoByid/{id}")
    public VideoModule getVideoDetailsById(@PathVariable Long id)
    {
        return videoServiceImpl.getVideoById(id);
    }

    @GetMapping
    public List<VideoModule> getAllRecords(@RequestParam(required = false) String videoName) {
        if (videoName != null) {
            return videoServiceImpl.getVideoName(videoName);
        } else {
           return videoServiceImpl.getAllVideos();
        }
    }
}
