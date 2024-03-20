package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class MyController {
    private UserService service;

    @Autowired
    public MyController(UserService service) {
        this.service = service;
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping ("/saveNewUser")
    public String saveNewUser(@ModelAttribute ("user") User user){
        service.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUserBy(@RequestParam ("id") Long id, Model model){
        model.addAttribute("user", service.getUser(id));
    return "update";
    }
    @PostMapping("/saveUser")
    public String updateUser(@ModelAttribute ("user") User user){
        service.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllUsers(Model model){
        model.addAttribute("users", service.getAllUsers());
        return "allUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam ("id") Long id){
        service.deleteUser(id);
        return "redirect:/";
    }



}
