package kok.spring21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;




@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping()
    public String index(Model model){
        return "admin";
    }
    @GetMapping("/1")
    public String index1(Model model){
        return "admin";
    }
    @GetMapping("/2")
    public String index2(Model model){
        return "admin";
    }
}
