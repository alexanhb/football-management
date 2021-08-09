package com.alexanhb.footballmanagement.controllers;

import com.alexanhb.footballmanagement.model.Manager;
import com.alexanhb.footballmanagement.services.ClubService;
import com.alexanhb.footballmanagement.services.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RequestMapping("/managers")
@Controller
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/")
    public String findAllManagers(Model model){
        Set<Manager> setAllManagers = managerService.findAll();
        List<Manager> allManagers = new ArrayList<>(setAllManagers);
        model.addAttribute("managers", allManagers);

        allManagers.sort(((o1, o2) -> o1.getLastName().compareTo(o2.getLastName())));
        return "/managers/managersList";
    }

    @GetMapping("/{managerId}")
    public ModelAndView showManager(@PathVariable Long managerId) {
        ModelAndView mav = new ModelAndView("managers/managerDetails");
        mav.addObject(managerService.findById(managerId));
        return mav;
    }
}
