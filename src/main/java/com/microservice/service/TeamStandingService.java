package com.microservice.service;

import com.microservice.dto.Response;
import com.microservice.dto.TeamStanding;

public interface TeamStandingService {

    public Response<TeamStanding> getTeamStanding(String countryName, String teamName, String leagueName);

}
