package com.alexanhb.footballmanagement.controllers;

import com.alexanhb.footballmanagement.model.Club;
import com.alexanhb.footballmanagement.services.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequestMapping("/clubs")
@Controller
public class ClubController {

    private static final String VIEWS_CLUB_CREATE_OR_UPDATE_FORM = "clubs/createOrUpdateClubForm";

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/")
    public String findAllClubs(Model model){
        Set<Club> setAllClubs = clubService.findAll();
        List<Club> allClubs = new ArrayList<>(setAllClubs);
        model.addAttribute("clubs", allClubs);

        allClubs.sort(((o1, o2) -> o1.getClubName().compareTo(o2.getClubName())));
        return "clubs/clubsList";
    }

    @GetMapping("/{clubName}")
    public ModelAndView showClub(@PathVariable String clubName) {
        ModelAndView mav = new ModelAndView("clubs/clubDetails");
        mav.addObject(clubService.findByClubName(clubName));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("club", Club.builder().build());
        return VIEWS_CLUB_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Club club, BindingResult result){
            Club savedClub = clubService.save(club);
            return "redirect:/clubs/" + savedClub.getClubName();
    }


}
