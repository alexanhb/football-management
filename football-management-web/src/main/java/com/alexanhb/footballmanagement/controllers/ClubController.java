package com.alexanhb.footballmanagement.controllers;

import com.alexanhb.footballmanagement.model.Club;
import com.alexanhb.footballmanagement.services.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/clubs")
@Controller
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findClubs(Model model){
        model.addAttribute("club", Club.builder().build());
        return "clubs/findClubs";
    }

    @GetMapping
    public String processFindForm(Club club, BindingResult result, Model model){
        //Allow parameterless GET requests for /clubs to return all records
        if(club.getClubName() == null){
            club.setClubName(""); //Empty String signifies broadest possible search
        }

        List<Club> searchResult = clubService.findAllByClubNameLike("%" + club.getClubName() + "%");

        if(searchResult.isEmpty()){
            //No clubs found
            result.rejectValue("clubName", "notFound", "not found");
            return "clubs/findClubs";
        }
        else if(searchResult.size() == 1){
            //1 club found
            club = searchResult.get(0);
            return "redirect:/clubs/" + club.getClubName();
        }
        else{
            //Multiple clubs found
            model.addAttribute("selections", searchResult);
            return "clubs/clubsList";
        }
    }

    @GetMapping("/{clubName}")
    public ModelAndView showClub(@PathVariable String clubName) {
        ModelAndView mav = new ModelAndView("clubs/clubDetails");
        mav.addObject(clubService.findByClubName(clubName));
        return mav;
    }


}
