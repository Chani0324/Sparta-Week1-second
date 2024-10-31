package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount = 0;

    //static 패키지
    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    }

    //static 패키지
    @GetMapping("/html/redirect")
    public String htmlStatic() {
        return "redirect:/hello.html";
    }

    // templates 패키지
    @GetMapping("html/templates")
    public String htmlTemplates() {
        return "hello";
    }

    @GetMapping("html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }
}
