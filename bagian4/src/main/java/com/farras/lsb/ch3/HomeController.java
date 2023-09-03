package com.farras.lsb.ch3;

import com.farras.lsb.ch3.DTO.UniversalSearch;
import com.farras.lsb.ch3.DTO.VideoSearch;
import com.farras.lsb.ch3.entitiy.VideoEntity;
import com.farras.lsb.ch3.services.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class HomeController {
    private VideoService videoService;

    // Depedency Injection
    public HomeController  (VideoService videoService){
        this.videoService = videoService;
    }
    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/paging")
    public String indexPage(Model model){
        return "index-page";
    }

    @GetMapping("/universal")
    public String indexUniversal(Model model){
        return "index-universal";
    }

    @PostMapping("/multi-field-search")
    public String search(@ModelAttribute VideoSearch search, Model model){
        List<VideoEntity> searchResult = videoService.search(search);
        model.addAttribute("videos", searchResult);
        return "index";
    }

    @PostMapping("/search-paging")
    public String searchAndPaging(@ModelAttribute VideoSearch search, Model model){
        Page<VideoEntity> searchResult = videoService.searchUsePage(search);

        // Display maximum page can enter by user
        model.addAttribute("maxPage", searchResult.getTotalPages()-1);

        // Display current page of user
        model.addAttribute("currentPage", search.page());

        // Display result
        model.addAttribute("videos", searchResult);
        return "index-page";
    }

    @PostMapping("/universal-search")
    public String searchUniversal(@ModelAttribute UniversalSearch search, Model model){
        List<VideoEntity> searchResult = videoService.unversalSearch(search);

        // Display result
        model.addAttribute("videos", searchResult);
        return "index-universal";
    }

    @GetMapping("/add")
    public String add(){
        return "add";
    }
    @PostMapping("/add-video")
    public String add(@ModelAttribute VideoSearch search, Model model){
        List<VideoEntity> update = videoService.addVideo(search);
        model.addAttribute("videos", update);
        return "index";
    }
}
