package com.alexanhb.footballmanagement.bootstrap;


import com.alexanhb.footballmanagement.model.*;
import com.alexanhb.footballmanagement.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        ogs.setBirthDate(LocalDate.of(1973, 2,26));
        managerService.save(ogs);

        Manager klopp = new Manager();
        klopp.setFirstName("Jurgen");
        klopp.setLastName("Klopp");
        klopp.setBirthDate(LocalDate.of(1967, 6,16));
        managerService.save(klopp);

        Manager tuchel = new Manager();
        tuchel.setFirstName("Thomas");
        tuchel.setLastName("Tuchel");
        tuchel.setBirthDate(LocalDate.of(1973, 8,29));
        managerService.save(tuchel);

        Manager guardiola = new Manager();
        guardiola.setFirstName("Pep");
        guardiola.setLastName("Guardiola");
        guardiola.setBirthDate(LocalDate.of(1971, 1,18));
        managerService.save(guardiola);

        Manager bruce = new Manager();
        bruce.setFirstName("Steve");
        bruce.setLastName("Bruce");
        bruce.setBirthDate(LocalDate.of(1960, 12,31));
        managerService.save(bruce);

        Manager farke = new Manager();
        farke.setFirstName("Daniel");
        farke.setLastName("Farke");
        farke.setBirthDate(LocalDate.of(1976, 10,30));
        managerService.save(farke);

        Manager arteta = new Manager();
        arteta.setFirstName("Mikel");
        arteta.setLastName("Arteta");
        arteta.setBirthDate(LocalDate.of(1982, 3,26));
        managerService.save(arteta);

        System.out.println("Managers loading...");

        //Stadiums
        //Old Trafford
        Stadium oldTrafford = new Stadium();
        oldTrafford.setStadiumName("Old Trafford");
        oldTrafford.setCapacity(75000);
        oldTrafford.setLocation("England");
        oldTrafford.setFieldSize("105 by 68 metres");
        oldTrafford.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t1.jpg");
        stadiumService.save(oldTrafford);

        //Anfield
        Stadium anfield = new Stadium();
        anfield.setStadiumName("Anfield");
        anfield.setCapacity(53394);
        anfield.setLocation("England");
        anfield.setFieldSize("101 by 68 metres");
        anfield.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t14.jpg");
        stadiumService.save(anfield);

        //Stamford Bridge
        Stadium stamfordBridge = new Stadium();
        stamfordBridge.setStadiumName("Stamford Bridge");
        stamfordBridge.setCapacity(41798);
        stamfordBridge.setLocation("England");
        stamfordBridge.setFieldSize("103 × 67 meter");
        stamfordBridge.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t8.jpg");
        stadiumService.save(stamfordBridge);

        //Etihad Stadium
        Stadium etihad = new Stadium();
        etihad.setStadiumName("Etihad Stadium");
        etihad.setCapacity(55017);
        etihad.setLocation("England");
        etihad.setFieldSize("105 by 68 metres");
        etihad.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t43.jpg");
        stadiumService.save(etihad);

        //St James' Park
        Stadium stJamesPark = new Stadium();
        stJamesPark.setStadiumName("St James' Park");
        stJamesPark.setCapacity(52305);
        stJamesPark.setLocation("England");
        stJamesPark.setFieldSize("105 by 68 metres");
        stJamesPark.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t4.jpg");
        stadiumService.save(stJamesPark);

        //Carrow Road
        Stadium carrowRoad = new Stadium();
        carrowRoad.setStadiumName("Carrow Road");
        carrowRoad.setCapacity(43984);
        carrowRoad.setLocation("England");
        carrowRoad.setFieldSize("105.2 by 68 metres");
        carrowRoad.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t45.jpg");
        stadiumService.save(carrowRoad);

        //Emirates Stadium
        Stadium emirates = new Stadium();
        emirates.setStadiumName("Carrow Road");
        emirates.setCapacity(60260);
        emirates.setLocation("England");
        emirates.setFieldSize("105 by 68 metres");
        emirates.setStadiumImage("https://www.premierleague.com/resources/prod/3e365c2-3613/i/stadiums/club-index/t3.jpg");
        stadiumService.save(emirates);

        System.out.println("Stadiums loading...");

        //Creating and adding clubs to their league
        //Premier League
        //Manchester United
        Club manchesterUnited = new Club();
        manchesterUnited.setClubName("Manchester United");
        manchesterUnited.setClubColor("#d81920");
        manchesterUnited.setStadium(oldTrafford);
        manchesterUnited.setManager(ogs);
        manchesterUnited.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t1.png");
        clubService.save(manchesterUnited);

        //Liverpool
        Club liverpool = new Club();
        liverpool.setClubName("Liverpool");
        liverpool.setClubColor("#e31b23");
        liverpool.setStadium(anfield);
        liverpool.setManager(klopp);
        liverpool.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t14.png");
        clubService.save(liverpool);

        //Chelsea
        Club chelsea = new Club();
        chelsea.setClubName("Chelsea");
        chelsea.setClubColor("#0a4595");
        chelsea.setStadium(stamfordBridge);
        chelsea.setManager(tuchel);
        chelsea.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t8.png");
        clubService.save(chelsea);

        //Manchester City
        Club manchesterCity = new Club();
        manchesterCity.setClubName("Manchester City");
        manchesterCity.setClubColor("#6caee0");
        manchesterCity.setStadium(etihad);
        manchesterCity.setManager(guardiola);
        manchesterCity.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t43.png");
        clubService.save(manchesterCity);

        //Newcastle United
        Club newcastleUnited = new Club();
        newcastleUnited.setClubName("Newcastle United");
        newcastleUnited.setClubColor("#383838");
        newcastleUnited.setStadium(stJamesPark);
        newcastleUnited.setManager(bruce);
        newcastleUnited.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t4.png");
        clubService.save(newcastleUnited);

        //Norwich
        Club norwichCity = new Club();
        norwichCity.setClubName("Norwich City FC");
        norwichCity.setClubColor("#00a94f");
        norwichCity.setStadium(carrowRoad);
        norwichCity.setManager(farke);
        norwichCity.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t45.png");
        clubService.save(norwichCity);

        //Arsenal
        Club arsenal = new Club();
        arsenal.setClubName("Arsenal");
        arsenal.setClubColor("#fe0002");
        arsenal.setStadium(emirates);
        arsenal.setManager(arteta);
        arsenal.setClubLogo("https://resources.premierleague.com/premierleague/badges/70/t3.png");
        clubService.save(arsenal);

        System.out.println("Clubs loading...");

        //Creating a Set of teams to put into premier league
        Set<Club> premierLeagueClubs = new HashSet<>();
        premierLeagueClubs.add(manchesterUnited);
        premierLeagueClubs.add(liverpool);
        premierLeagueClubs.add(chelsea);
        premierLeagueClubs.add(manchesterCity);
        premierLeagueClubs.add(newcastleUnited);
        premierLeagueClubs.add(norwichCity);

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
