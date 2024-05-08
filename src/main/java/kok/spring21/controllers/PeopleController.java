package kok.spring21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import kok.spring21.dao.PersonDAO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import kok.spring21.models.Person;



import org.hibernate.*; //для сессий

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PersonDAO dao;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people",dao.index());
        model.addAttribute("kok","pip");
	model.addAttribute("kok1",dao.getN()); //N
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("person",dao.show(id).getFio());
        return "people/show";
    }

    @GetMapping("/new")
    public String new1(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }

    @PostMapping("/new")
    public String new2(@ModelAttribute("person")Person person){
        dao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/update/{id}")
    public String new1(@PathVariable("id")int id, Model model){
        Person person=dao.get(id);
        model.addAttribute("person",person);
        return "people/update";
    }

    @PostMapping("/update")
    public String update2(@ModelAttribute("person")Person person){
        dao.update(person);
        return "redirect:/people";
    }

    @GetMapping("/delete/{id}")
    public String del(@PathVariable("id")int id, Model model){
        Person person=dao.get(id);
        model.addAttribute("person",person);
        return "people/delete";
    }

    @PostMapping("/delete")
    public String del(@ModelAttribute("person")Person person){
        dao.delete(person);
        return "redirect:/people";
    }
}
