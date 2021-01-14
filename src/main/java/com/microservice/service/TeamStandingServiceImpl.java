package com.microservice.service;

import com.microservice.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStandingServiceImpl implements TeamStandingService {

    private RestClientService restClientService;

    @Autowired
    public TeamStandingServiceImpl(RestClientService restClientService) {
        this.restClientService = restClientService;
    }


    @Override
    public Response<TeamStanding> getTeamStanding(String countryName, String teamName, String leagueName) {
        try {
            TeamStanding teamStanding = new TeamStanding();

            Response<List<Country>> countriesResponse = restClientService.getCountries();
            List<Country> countries = countriesResponse.getData();
            Country country = countries.stream()
                    .filter(c -> countryName.equalsIgnoreCase(c.getCountryName())).findFirst()
                    .orElse(null);

            teamStanding.setCountryId(country.getCountryId());

            Response<List<Leagues>> leaguesListResponse = restClientService.getLeagues(country.getCountryId());
            List<Leagues> leaguesList = leaguesListResponse.getData();
            Leagues leagues = leaguesList.stream()
                    .filter(l -> leagueName.equalsIgnoreCase(l.getLeagueName()))
                    .findFirst().orElse(null);

            teamStanding.setLeagueId(leagues.getLeagueId());
            Response<List<TeamStanding>> teamStandingsResponse = restClientService.getTeamStanding(leagues.getLeagueId());
            List<TeamStanding> teamStandings = teamStandingsResponse.getData();

            TeamStanding teamStandingResponse = teamStandings.stream()
                    .filter(t -> teamName.equalsIgnoreCase(t.getTeamName()))
                    .findFirst().orElse(null);
            if (teamStandingResponse == null) {
                String responseMessage = "No match found for Country Name : " + countryName + ", Team Name : " + teamName + " and League Name : " + leagueName;
                return new Response<>().withMessage(new Message(MessageType.INFO, "", responseMessage));
            }


            return new Response<TeamStanding>(teamStandingResponse);
        } catch (Exception ex) {
            String responseMessage = "No match found for Country Name : " + countryName + ", Team Name : " + teamName + " and League Name : " + leagueName;
            return new Response<>().withMessage(new Message(MessageType.INFO, "", responseMessage));
        }
    }

}
