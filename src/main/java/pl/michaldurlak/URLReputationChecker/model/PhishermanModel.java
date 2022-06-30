package pl.michaldurlak.URLReputationChecker.model;

import java.util.Locale;

public class PhishermanModel {


    // check site
    private String classificationScan;
    private String verifiedPhishScan;
    private String checkResultJSON;

    // info site
    private String infoResultJSON;
    private String statusInfo;
    private String verifiedPhishInfo;
    private String classificationInfo;
    private String firstSeenInfo;
    private String lastCheckInfo;
    private String lastSeenInfo;
    private String phishCaughtInfo;
    private String websiteScreenshotInfo;
    private String ip_addressInfo;
    private String country_nameInfo;




    // global
    private int phishermanScore;
    private String phishermanIsSecure;



    public String getClassificationScan() {
        return classificationScan;
    }

    public void setClassificationScan(String classificationScan) {
        this.classificationScan = classificationScan;
    }

    public String getVerifiedPhishScan() {
        return verifiedPhishScan;
    }

    public void setVerifiedPhishScan(String verifiedPhishScan) {
        this.verifiedPhishScan = verifiedPhishScan;
    }

    public String getCheckResultJSON() {
        return checkResultJSON;
    }

    public void setCheckResultJSON(String checkResultJSON) {
        this.checkResultJSON = checkResultJSON;
    }

    public String getInfoResultJSON() {
        return infoResultJSON;
    }

    public void setInfoResultJSON(String infoResultJSON) {
        this.infoResultJSON = infoResultJSON;
    }

    public int getPhishermanScore() {
        return phishermanScore;
    }

    public String getLastCheckInfo() {
        return lastCheckInfo;
    }

    public void setLastCheckInfo(String lastCheckInfo) {
        this.lastCheckInfo = lastCheckInfo;
    }

    public void setPhishermanScore(String classification) {
        if (classification.toLowerCase(Locale.ROOT).equals("suspicious")){
            this.phishermanScore = 80;
        } else if (classification.toLowerCase(Locale.ROOT).equals("malicious")){
            this.phishermanScore = 0;
        }else if (classification.toLowerCase(Locale.ROOT).equals("safe")){
            this.phishermanScore = 100;
        } else {
            this.phishermanScore = -1;
        }

    }


    public String getPhishermanIsSecure() {
        return phishermanIsSecure;
    }

    public void setPhishermanIsSecure(String classification) {

        if (classification.toLowerCase(Locale.ROOT).equals("suspicious")){
            this.phishermanIsSecure = "PODEJRZANA STRONA";
        } else if (classification.toLowerCase(Locale.ROOT).equals("malicious")){
            this.phishermanIsSecure = "ZŁOŚLIWA STRONA";
        } else if (classification.toLowerCase(Locale.ROOT).equals("unknown")){
            this.phishermanIsSecure = "BRAK INFORMACJI";
        } else {
            this.phishermanIsSecure = "STRONA W ZAUFANEJ BAZIE";
        }


    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getVerifiedPhishInfo() {
        return verifiedPhishInfo;
    }

    public void setVerifiedPhishInfo(String verifiedPhishInfo) {
        this.verifiedPhishInfo = verifiedPhishInfo;
    }

    public String getClassificationInfo() {
        return classificationInfo;
    }

    public void setClassificationInfo(String classificationInfo) {
        this.classificationInfo = classificationInfo;
    }

    public String getFirstSeenInfo() {
        return firstSeenInfo;
    }

    public void setFirstSeenInfo(String firstSeenInfo) {
        this.firstSeenInfo = firstSeenInfo;
    }

    public String getLastSeenInfo() {
        return lastSeenInfo;
    }

    public void setLastSeenInfo(String lastSeenInfo) {
        this.lastSeenInfo = lastSeenInfo;
    }

    public String getPhishCaughtInfo() {
        return phishCaughtInfo;
    }

    public void setPhishCaughtInfo(String phishCaughtInfo) {
        this.phishCaughtInfo = phishCaughtInfo;
    }

    public String getWebsiteScreenshotInfo() {
        return websiteScreenshotInfo;
    }

    public void setWebsiteScreenshotInfo(String websiteScreenshotInfo) {
        this.websiteScreenshotInfo = websiteScreenshotInfo;
    }

    public String getIp_addressInfo() {
        return ip_addressInfo;
    }

    public void setIp_addressInfo(String ip_addressInfo) {
        this.ip_addressInfo = ip_addressInfo;
    }

    public String getCountry_nameInfo() {
        return country_nameInfo;
    }

    public void setCountry_nameInfo(String country_nameInfo) {
        this.country_nameInfo = country_nameInfo;
    }

    @Override
    public String toString() {
        return "PhishermanModel{" +
                "classification='" + classificationScan + '\'' +
                ", verifiedPhish='" + verifiedPhishScan + '\'' +
                ", checkResultJSON='" + checkResultJSON + '\'' +
                ", infoResultJSON='" + infoResultJSON + '\'' +
                '}';
    }
}
