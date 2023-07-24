package com.farras.lsb.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/new-video")
    public String addVideo(@ModelAttribute Video newVideo){
        this.videoService.create(newVideo);
        return "redirect:/";
    }
}
