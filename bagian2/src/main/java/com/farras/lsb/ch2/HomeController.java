package com.farras.lsb.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *  Anotasi ini diguakan untuk berkomunikasi dan mengatakn bahwa class ini adalah web controller
 */
@Controller
public class HomeController {
    record Video(String name){};
    List<Video> videos = List.of(
      new Video("Film 1"),
      new Video("Film 2"),
      new Video("Film 3")
    );

    /**
     * Anotasi untuk pemetaan HTTP GET alamat / untuk memanggil method ini
     * @return
     */
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("videos",this.videos);
        return "index";
    }
}
