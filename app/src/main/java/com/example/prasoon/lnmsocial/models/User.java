package com.example.prasoon.lnmsocial.models;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName,lastname,rollNumber,email,imageUrl, username,hometown,
            state,phoneNumber,password,aboutMe,sports,interests,clubs, department, year;
    private Boolean CCE,CSE,ECE,MME,ME;                                                                            //Department
    private Boolean cybros,CSI,insignia,ecell,ccell,arts,rendition,quizzinga,literary,chess,fashion,innovation;    //Clubs
    private Boolean badminton,tableTennis,cricket,football,volleyball,basketball,lawnTennis,kabaddi,squash;        //Sports
    private Boolean CP,AI,DS,ML,webDev,mobileWebDev,android,ios,blockChain,robotics,contentWriting,uiux,literature,webDesign;//Interests

    private String facebookProfileLink, githubProfileLink, linkedInProfileLink, twitterProfileLink;

    public User(){}

    public User(String firstName, String lastname, String rollNumber, String email, String imageUrl, String username, String hometown, String state, String phoneNumber, String password, String aboutMe, String sports, String interests, String clubs, String department, String year, Boolean CCE, Boolean CSE, Boolean ECE, Boolean MME, Boolean ME, Boolean cybros, Boolean CSI, Boolean insignia, Boolean ecell, Boolean ccell, Boolean arts, Boolean rendition, Boolean quizzinga, Boolean literary, Boolean chess, Boolean fashion, Boolean innovation, Boolean badminton, Boolean tableTennis, Boolean cricket, Boolean football, Boolean volleyball, Boolean basketball, Boolean lawnTennis, Boolean kabaddi, Boolean squash, Boolean CP, Boolean AI, Boolean DS, Boolean ML, Boolean webDev, Boolean mobileWebDev, Boolean android, Boolean ios, Boolean blockChain, Boolean robotics, Boolean contentWriting, Boolean uiux, Boolean literature, Boolean webDesign, String facebookProfileLink, String githubProfileLink, String linkedInProfileLink, String twitterProfileLink) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.rollNumber = rollNumber;
        this.email = email;
        this.imageUrl = imageUrl;
        this.username = username;
        this.hometown = hometown;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.aboutMe = aboutMe;
        this.sports = sports;
        this.interests = interests;
        this.clubs = clubs;
        this.department = department;
        this.year = year;
        this.CCE = CCE;
        this.CSE = CSE;
        this.ECE = ECE;
        this.MME = MME;
        this.ME = ME;
        this.cybros = cybros;
        this.CSI = CSI;
        this.insignia = insignia;
        this.ecell = ecell;
        this.ccell = ccell;
        this.arts = arts;
        this.rendition = rendition;
        this.quizzinga = quizzinga;
        this.literary = literary;
        this.chess = chess;
        this.fashion = fashion;
        this.innovation = innovation;
        this.badminton = badminton;
        this.tableTennis = tableTennis;
        this.cricket = cricket;
        this.football = football;
        this.volleyball = volleyball;
        this.basketball = basketball;
        this.lawnTennis = lawnTennis;
        this.kabaddi = kabaddi;
        this.squash = squash;
        this.CP = CP;
        this.AI = AI;
        this.DS = DS;
        this.ML = ML;
        this.webDev = webDev;
        this.mobileWebDev = mobileWebDev;
        this.android = android;
        this.ios = ios;
        this.blockChain = blockChain;
        this.robotics = robotics;
        this.contentWriting = contentWriting;
        this.uiux = uiux;
        this.literature = literature;
        this.webDesign = webDesign;
        this.facebookProfileLink = facebookProfileLink;
        this.githubProfileLink = githubProfileLink;
        this.linkedInProfileLink = linkedInProfileLink;
        this.twitterProfileLink = twitterProfileLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getClubs() {
        return clubs;
    }

    public void setClubs(String clubs) {
        this.clubs = clubs;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getCCE() {
        return CCE;
    }

    public void setCCE(Boolean CCE) {
        this.CCE = CCE;
    }

    public Boolean getCSE() {
        return CSE;
    }

    public void setCSE(Boolean CSE) {
        this.CSE = CSE;
    }

    public Boolean getECE() {
        return ECE;
    }

    public void setECE(Boolean ECE) {
        this.ECE = ECE;
    }

    public Boolean getMME() {
        return MME;
    }

    public void setMME(Boolean MME) {
        this.MME = MME;
    }

    public Boolean getME() {
        return ME;
    }

    public void setME(Boolean ME) {
        this.ME = ME;
    }

    public Boolean getCybros() {
        return cybros;
    }

    public void setCybros(Boolean cybros) {
        this.cybros = cybros;
    }

    public Boolean getCSI() {
        return CSI;
    }

    public void setCSI(Boolean CSI) {
        this.CSI = CSI;
    }

    public Boolean getInsignia() {
        return insignia;
    }

    public void setInsignia(Boolean insignia) {
        this.insignia = insignia;
    }

    public Boolean getEcell() {
        return ecell;
    }

    public void setEcell(Boolean ecell) {
        this.ecell = ecell;
    }

    public Boolean getCcell() {
        return ccell;
    }

    public void setCcell(Boolean ccell) {
        this.ccell = ccell;
    }

    public Boolean getArts() {
        return arts;
    }

    public void setArts(Boolean arts) {
        this.arts = arts;
    }

    public Boolean getRendition() {
        return rendition;
    }

    public void setRendition(Boolean rendition) {
        this.rendition = rendition;
    }

    public Boolean getQuizzinga() {
        return quizzinga;
    }

    public void setQuizzinga(Boolean quizzinga) {
        this.quizzinga = quizzinga;
    }

    public Boolean getLiterary() {
        return literary;
    }

    public void setLiterary(Boolean literary) {
        this.literary = literary;
    }

    public Boolean getChess() {
        return chess;
    }

    public void setChess(Boolean chess) {
        this.chess = chess;
    }

    public Boolean getFashion() {
        return fashion;
    }

    public void setFashion(Boolean fashion) {
        this.fashion = fashion;
    }

    public Boolean getInnovation() {
        return innovation;
    }

    public void setInnovation(Boolean innovation) {
        this.innovation = innovation;
    }

    public Boolean getBadminton() {
        return badminton;
    }

    public void setBadminton(Boolean badminton) {
        this.badminton = badminton;
    }

    public Boolean getTableTennis() {
        return tableTennis;
    }

    public void setTableTennis(Boolean tableTennis) {
        this.tableTennis = tableTennis;
    }

    public Boolean getCricket() {
        return cricket;
    }

    public void setCricket(Boolean cricket) {
        this.cricket = cricket;
    }

    public Boolean getFootball() {
        return football;
    }

    public void setFootball(Boolean football) {
        this.football = football;
    }

    public Boolean getVolleyball() {
        return volleyball;
    }

    public void setVolleyball(Boolean volleyball) {
        this.volleyball = volleyball;
    }

    public Boolean getBasketball() {
        return basketball;
    }

    public void setBasketball(Boolean basketball) {
        this.basketball = basketball;
    }

    public Boolean getLawnTennis() {
        return lawnTennis;
    }

    public void setLawnTennis(Boolean lawnTennis) {
        this.lawnTennis = lawnTennis;
    }

    public Boolean getKabaddi() {
        return kabaddi;
    }

    public void setKabaddi(Boolean kabaddi) {
        this.kabaddi = kabaddi;
    }

    public Boolean getSquash() {
        return squash;
    }

    public void setSquash(Boolean squash) {
        this.squash = squash;
    }

    public Boolean getCP() {
        return CP;
    }

    public void setCP(Boolean CP) {
        this.CP = CP;
    }

    public Boolean getAI() {
        return AI;
    }

    public void setAI(Boolean AI) {
        this.AI = AI;
    }

    public Boolean getDS() {
        return DS;
    }

    public void setDS(Boolean DS) {
        this.DS = DS;
    }

    public Boolean getML() {
        return ML;
    }

    public void setML(Boolean ML) {
        this.ML = ML;
    }

    public Boolean getWebDev() {
        return webDev;
    }

    public void setWebDev(Boolean webDev) {
        this.webDev = webDev;
    }

    public Boolean getMobileWebDev() {
        return mobileWebDev;
    }

    public void setMobileWebDev(Boolean mobileWebDev) {
        this.mobileWebDev = mobileWebDev;
    }

    public Boolean getAndroid() {
        return android;
    }

    public void setAndroid(Boolean android) {
        this.android = android;
    }

    public Boolean getIos() {
        return ios;
    }

    public void setIos(Boolean ios) {
        this.ios = ios;
    }

    public Boolean getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(Boolean blockChain) {
        this.blockChain = blockChain;
    }

    public Boolean getRobotics() {
        return robotics;
    }

    public void setRobotics(Boolean robotics) {
        this.robotics = robotics;
    }

    public Boolean getContentWriting() {
        return contentWriting;
    }

    public void setContentWriting(Boolean contentWriting) {
        this.contentWriting = contentWriting;
    }

    public Boolean getUiux() {
        return uiux;
    }

    public void setUiux(Boolean uiux) {
        this.uiux = uiux;
    }

    public Boolean getLiterature() {
        return literature;
    }

    public void setLiterature(Boolean literature) {
        this.literature = literature;
    }

    public Boolean getWebDesign() {
        return webDesign;
    }

    public void setWebDesign(Boolean webDesign) {
        this.webDesign = webDesign;
    }

    public String getFacebookProfileLink() {
        return facebookProfileLink;
    }

    public void setFacebookProfileLink(String facebookProfileLink) {
        this.facebookProfileLink = facebookProfileLink;
    }

    public String getGithubProfileLink() {
        return githubProfileLink;
    }

    public void setGithubProfileLink(String githubProfileLink) {
        this.githubProfileLink = githubProfileLink;
    }

    public String getLinkedInProfileLink() {
        return linkedInProfileLink;
    }

    public void setLinkedInProfileLink(String linkedInProfileLink) {
        this.linkedInProfileLink = linkedInProfileLink;
    }

    public String getTwitterProfileLink() {
        return twitterProfileLink;
    }

    public void setTwitterProfileLink(String twitterProfileLink) {
        this.twitterProfileLink = twitterProfileLink;
    }
}
