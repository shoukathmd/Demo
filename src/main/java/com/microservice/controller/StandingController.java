package com.microservice.controller;


import com.microservice.dto.Response;
import com.microservice.dto.TeamStanding;
import com.microservice.service.TeamStandingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.microservice.controller.BaseController.TEAM_STANDING;

@RestController
@RequestMapping(TEAM_STANDING)
public class StandingController {
    final protected Logger logger = LoggerFactory.getLogger(getClass());

    private TeamStandingService teamStandingService;

    @Autowired
    public StandingController(TeamStandingService teamStandingService){
        this.teamStandingService = teamStandingService;
    }

    @RequestMapping(value = "/{countryName}/{teamName}/{leagueName}", method = RequestMethod.GET)
    public Response<TeamStanding> findById(@PathVariable("countryName") String countryName,
                                           @PathVariable("leagueName") String leagueName,
                                           @PathVariable("teamName") String teamName) {
        logger.info("Country Name :" + countryName);

        return teamStandingService.getTeamStanding(countryName, teamName, leagueName);
    }
}
