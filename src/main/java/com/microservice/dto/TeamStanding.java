package com.microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TeamStanding implements Serializable {
    @JsonProperty("country_id")
    private int countryId;

    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("league_id")
    private int leagueId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("team_id")
    private String teamId;

    @JsonProperty("team_name")
    private String teamName;
    @JsonProperty("overall_league_position")
    private int overallLeaguePosition;

    public TeamStanding() {
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public int getLeagueId() {
        return this.leagueId;
    }

    public String getLeagueName() {
        return this.leagueName;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getOverallLeaguePosition() {
        return this.overallLeaguePosition;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setOverallLeaguePosition(int overallLeaguePosition) {
        this.overallLeaguePosition = overallLeaguePosition;
    }


    public String toString() {
        return "TeamStanding(countryId=" + this.getCountryId() + ", countryName=" + this.getCountryName() + ", leagueId=" + this.getLeagueId() + ", leagueName=" + this.getLeagueName() + ", teamId=" + this.getTeamId() + ", teamName=" + this.getTeamName() + ", overallLeaguePosition=" + this.getOverallLeaguePosition() + ")";
    }
}
