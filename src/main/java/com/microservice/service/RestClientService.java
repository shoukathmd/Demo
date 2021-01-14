package com.microservice.service;

import com.microservice.dto.Country;
import com.microservice.dto.Leagues;
import com.microservice.dto.Response;
import com.microservice.dto.TeamStanding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;


@Service
public class RestClientService {

    private static final String APIKEY = "APIkey";
    private RestTemplate restTemplate;

    @Value("${football.league.base.url}")
    private String baseUrl;

    @Value("${football.league.action.standings}")
    private String standingsAction;

    @Value("${football.league.action.countries}")
    private String countriesAction;

    @Value("${football.league.action.leagues}")
    private String leaguesAction;

    @Value("${football.league.api}")
    private String api;




    @Autowired
    public RestClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Response<List<Country>> getCountries() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", countriesAction);
        UriComponentsBuilder builder = getUriComponentsBuilder(baseUrl, queryParams);


        Country[] countries = this.restTemplate
                .exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(getHeaders()),
                        Country[].class).getBody();
        List<Country> countryList = new ArrayList<>(Arrays.asList(countries));
        return new Response<>(countryList);


    }

    public Response<List<Leagues>> getLeagues(int countryId) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", leaguesAction);
        queryParams.put("country_id", String.valueOf(countryId));
        UriComponentsBuilder builder = getUriComponentsBuilder(baseUrl, queryParams);

        Leagues[] leagues = this.restTemplate
                .exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(getHeaders()),
                        Leagues[].class).getBody();

        List<Leagues> leaguesList = new ArrayList<>(Arrays.asList(leagues));

        return new Response<>(leaguesList);
    }




    public Response<List<TeamStanding>> getTeamStanding(int leagueId) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("action", standingsAction);
        queryParams.put("league_id", String.valueOf(leagueId));
        UriComponentsBuilder builder = getUriComponentsBuilder(baseUrl, queryParams);
        TeamStanding[] teamStandings = this.restTemplate
                .exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(getHeaders()),
                        TeamStanding[].class).getBody();

        List<TeamStanding> teamStandingList = new ArrayList<>(Arrays.asList(teamStandings));

        return new Response<>(teamStandingList);
    }






    private UriComponentsBuilder getUriComponentsBuilder(String url,
                                                         Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(APIKEY, api);
        queryParams.forEach(builder::queryParam);
        return builder;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }


}
