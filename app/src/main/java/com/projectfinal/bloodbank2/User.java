package com.projectfinal.bloodbank2;

public class User {

    String username, unitType2, unitNeeded2, date;

    public User(){}

    public String getUsername() {
        return username;
    }

    public String getUnitType2() {
        return unitType2;
    }

    public String getUnitNeeded2() {
        return unitNeeded2;
    }

    public String getDate() {
        return date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUnitType2(String unitType2) {
        this.unitType2 = unitType2;
    }

    public void setUnitNeeded2(String unitNeeded2) {
        this.unitNeeded2 = unitNeeded2;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
