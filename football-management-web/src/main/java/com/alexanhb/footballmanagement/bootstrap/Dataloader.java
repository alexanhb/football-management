package com.alexanhb.footballmanagement.bootstrap;


import com.alexanhb.footballmanagement.model.*;
import com.alexanhb.footballmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class Dataloader implements CommandLineRunner {

    private final ClubService clubService;
    private final ManagerService managerService;
    private final PlayerService playerService;
    private final StadiumService stadiumService;

    public Dataloader(ClubService clubService, ManagerService managerService, PlayerService playerService, StadiumService stadiumService) {
        this.clubService = clubService;
        this.managerService = managerService;
        this.playerService = playerService;
        this.stadiumService = stadiumService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){

        //Creating and saving object to their own respective services
        //Managers
        Manager ogs = new Manager();
        ogs.setFirstName("Ole");
        ogs.setLastName("Gunnar Solskjær");
        ogs.setBirthDate(LocalDate.of(1973, 02,26));
        managerService.save(ogs);

        Manager klopp = new Manager();
        klopp.setFirstName("Jurgen");
        klopp.setLastName("Klopp");
        klopp.setBirthDate(LocalDate.of(1967, 06,16));
        managerService.save(klopp);

        System.out.println("Managers loading...");

        //Stadiums
        Stadium oldTrafford = new Stadium();
        oldTrafford.setStadiumName("Old Trafford");
        oldTrafford.setCapacity(75000);
        oldTrafford.setLocation("England");
        oldTrafford.setFieldSize("105 by 68 metres");

        stadiumService.save(oldTrafford);

        Stadium anfield = new Stadium();
        anfield.setStadiumName("Anfield");
        anfield.setCapacity(53394);
        anfield.setLocation("England");
        anfield.setFieldSize("101 by 68 metres");

        stadiumService.save(anfield);

        System.out.println("Stadiums loading...");

        //Creating and adding clubs to their league
        //Premier League
        //Manchester United
        Club manchesterUnited = new Club();
        manchesterUnited.setClubName("Manchester United");
        manchesterUnited.setStadium(oldTrafford);
        manchesterUnited.setManager(ogs);
        manchesterUnited.setClubLogo("https://assets.manutd.com/AssetPicker/images/0/0/3/2/197240/Header-Logo1500994616801.png");
        clubService.save(manchesterUnited);


        //Liverpool
        Club liverpool = new Club();
        liverpool.setClubName("Liverpool");
        liverpool.setStadium(anfield);
        liverpool.setManager(klopp);
        liverpool.setClubLogo("https://d3j2s6hdd6a7rg.cloudfront.net/v2/JE-657/lfc/images/logo.png");
        clubService.save(liverpool);


        System.out.println("Clubs loading...");

        //Creating a Set of teams to put into premier league
        Set<Club> premierLeagueClubs = new HashSet<>();
        premierLeagueClubs.add(manchesterUnited);
        premierLeagueClubs.add(liverpool);

        //|----------------------------------------------------------------------|

        //Players
        //ManUtd
        Player marcusRashford = new Player();
        marcusRashford.setFirstName("Marcus");
        marcusRashford.setLastName("Rashford");
        marcusRashford.setBirthDate(LocalDate.of(1997, 10, 31));
        marcusRashford.setPosition("Forward");
        marcusRashford.setShirtNumber(10);
        marcusRashford.setClub(manchesterUnited);

        playerService.save(marcusRashford);

        Player brunoFernandes = new Player();
        brunoFernandes.setFirstName("Bruno");
        brunoFernandes.setLastName("Fernandes");
        brunoFernandes.setBirthDate(LocalDate.of(1994, 9, 8));
        brunoFernandes.setPosition("Midfield");
        brunoFernandes.setShirtNumber(18);
        brunoFernandes.setClub(manchesterUnited);

        playerService.save(brunoFernandes);

        //Liverpool
        Player salah = new Player();
        salah.setFirstName("Mohammed");
        salah.setLastName("Salah");
        salah.setBirthDate(LocalDate.of(1992, 6, 15));
        salah.setPosition("Forward");
        salah.setShirtNumber(11);
        salah.setClub(liverpool);

        playerService.save(salah);

        Player vanDijk = new Player();
        vanDijk.setFirstName("Virgil");
        vanDijk.setLastName("Van Dijk");
        vanDijk.setBirthDate(LocalDate.of(1991, 7, 8));
        vanDijk.setPosition("Defender");
        vanDijk.setShirtNumber(4);
        vanDijk.setClub(liverpool);

        playerService.save(vanDijk);

        System.out.println("Players loading...");
    }
}
