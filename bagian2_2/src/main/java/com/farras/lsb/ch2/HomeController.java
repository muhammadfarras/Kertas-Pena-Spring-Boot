package com.farras.lsb.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private VideoService videoService;

    public HomeController(VideoService videoService){
        this.videoService = videoService;
    };
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("videos", videoService.getVideos());
        return "index";
    }
}
