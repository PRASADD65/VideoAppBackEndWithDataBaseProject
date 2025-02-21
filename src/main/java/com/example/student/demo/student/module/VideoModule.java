package com.example.student.demo.student.module;

import jakarta.persistence.*;

@Entity
@Table(name = "videomodule")
public class VideoModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String videoName;
    private String videoDescription;
    private String videoSourceUrl;

    public  VideoModule()
    {

    }

    public VideoModule(Long id, String videoName, String videoDescription, String videoSourceUrl) {
        this.id = id;
        this.videoName = videoName;
        this.videoDescription = videoDescription;
        this.videoSourceUrl = videoSourceUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getVideoSourceUrl() {
        return videoSourceUrl;
    }

    public void setVideoSourceUrl(String videoSourceUrl) {
        this.videoSourceUrl = videoSourceUrl;
    }
}
