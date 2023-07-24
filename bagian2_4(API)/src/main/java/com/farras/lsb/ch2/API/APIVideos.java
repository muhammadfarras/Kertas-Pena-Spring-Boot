package com.farras.lsb.ch2.API;

import com.farras.lsb.ch2.Video;
import com.farras.lsb.ch2.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIVideos {
    private VideoService videosService;

    public APIVideos(VideoService videos){
        this.videosService = videos;
    }

    @GetMapping("/API/videos")
    public List<Video> getAll(){
        return this.videosService.getVideos();
    }

    @PostMapping(value = "/API/videos", consumes = {"*/*"})
    public Video addVideo (@RequestBody Video addVideo){
        return this.videosService.create(addVideo);
    }
}
