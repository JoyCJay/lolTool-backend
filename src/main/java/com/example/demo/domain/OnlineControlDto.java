package com.example.demo.domain;

public class OnlineControlDto {
    private String email;
    private String summonerName;
    private String timeInterval;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getEmail() {
        return email;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public OnlineControlDto() {
//        this.email = email;
//        this.summonerName = summonerName;
//        this.timeInterval = timeInterval;
    }

    public String toString() {
        return "demoId=" + email + "," + "name=" + summonerName;
    }
}
