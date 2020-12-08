package com.example.project;

import com.example.project.domain.Computers;
import com.example.project.repos.ComputersRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private ComputersRepos computeresRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Computers> computers = computeresRepos.findAll();

        model.put("computers", computers);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam Integer year, Map<String, Object> model){
      Computers computer =  new Computers(name, year);

      computeresRepos.save(computer);
        Iterable<Computers> computers = computeresRepos.findAll();

        model.put("computers", computers);
        return "main";

    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Computers> computers;
        if(filter != null && !filter.isEmpty()){
            computers = computeresRepos.findByName(filter);

        }else{
            computers = computeresRepos.findAll();
        }
        model.put("computers", computers);
         return "main";
    }
}