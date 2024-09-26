package com.example.goalalerts;

import java.util.List;

public class LiveMatchesResponse {

    private List<Match> matches;  // Lista de partidos en vivo

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public static class Match {
        private Fixture fixture;

        public Fixture getFixture() {
            return fixture;
        }

        public void setFixture(Fixture fixture) {
            this.fixture = fixture;
        }
    }

    public static class Fixture {
        private Teams teams;
        private String date;
        private Status status;

        public Teams getTeams() {
            return teams;
        }

        public void setTeams(Teams teams) {
            this.teams = teams;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }

    public static class Teams {
        private Team home;
        private Team away;

        public Team getHome() {
            return home;
        }

        public void setHome(Team home) {
            this.home = home;
        }

        public Team getAway() {
            return away;
        }

        public void setAway(Team away) {
            this.away = away;
        }
    }

    public static class Team {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Status {
        private String longStatus;

        public String getLongStatus() {
            return longStatus;
        }

        public void setLongStatus(String longStatus) {
            this.longStatus = longStatus;
        }
    }
}
