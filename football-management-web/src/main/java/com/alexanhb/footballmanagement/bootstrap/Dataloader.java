package com.alexanhb.footballmanagement.bootstrap;


import com.alexanhb.footballmanagement.model.*;
import com.alexanhb.footballmanagement.services.*;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Dataloader implements CommandLineRunner {

    private final ClubService clubService;
    private final LeagueService leagueService;
    private final ManagerService managerService;
    private final PlayerService playerService;
    private final StadiumService stadiumService;

    public Dataloader(ClubService clubService, LeagueService leagueService, ManagerService managerService, PlayerService playerService, StadiumService stadiumService) {
        this.clubService = clubService;
        this.leagueService = leagueService;
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
        Manager ogs = new Manager("Ole", "Gunnar Solskjær", LocalDate.of(1973, 02,26));
        Manager savedOgs = managerService.save(ogs);

        System.out.println("Managers loading...");

        //Players
        Player marcusRashford = new Player("Marcus", "Rashford", LocalDate.of(1997, 10, 31), "Forward", 10);
        Player savedMarcusRashFord = playerService.save(marcusRashford);
        Player brunoFernandes = new Player("Bruno", "Fernandes", LocalDate.of(1994, 9, 8), "Midfield", 18);
        Player savedBrunoFernandes = playerService.save(brunoFernandes);

        System.out.println("Players loading...");

        //Stadiums
        Stadium oldTrafford = new Stadium("Old Trafford", 75000, "England", "105 by 68 metres");
        Stadium savedOldTrafford = stadiumService.save(oldTrafford);

        System.out.println("Stadiums loading...");

        //Creating and adding players to their own respective squads
        //Manchester United
        Set<Player> manUtdSquad = new HashSet<>();
        manUtdSquad.add(marcusRashford);
        manUtdSquad.add(brunoFernandes);

        //Creating and adding clubs to their league
        //Premier League
        Set<Club> premierLeagueClubs = new HashSet<>();
        Club manchesterUnited = new Club("Manchester United", oldTrafford, ogs, manUtdSquad);
        Club savedManchesterUnited = clubService.save(manchesterUnited);

        System.out.println("Clubs loading...");

        premierLeagueClubs.add(manchesterUnited);

        //Leagues
        League premierLeague = new League("Premier League", "England", premierLeagueClubs, 20, "https://www.premierleague.com/");
        League savedPremierLeague = leagueService.save(premierLeague);

        System.out.println("Leagues loading...");





    }
}
