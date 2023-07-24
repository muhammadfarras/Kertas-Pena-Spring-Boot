package com.farras.lsb.ch2;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService{
    private List<Video> videos = List.of(
            new Video("Film 1"),
            new Video("Film 2"),
            new Video("Film 3")
    );

    public List<Video> getVideos(){
        return this.videos;
    }
};
