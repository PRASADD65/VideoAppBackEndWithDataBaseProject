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
        String videoRole=videoModule.getVideoDescription();
        if(videoRole.equals("abhiupload")) {
            return videoServiceImpl.addVideo(videoModule);
        }
        else {
            return null;
        }
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
    public List<VideoModule> getVideoByName(@RequestParam(required = false) String videoName) {
        if (videoName != null) {
            return videoServiceImpl.getVideoName(videoName);
        } else {
           return null;
        }
    }

    @GetMapping("getAllVideos")
    public List<VideoModule> getAllVideosRecords()
    {
        return videoServiceImpl.getAllVideos();
    }
}
