package pl.michaldurlak.URLReputationChecker.model;

import java.util.ArrayList;

public class VirustotalModel {

    private String url;
    ArrayList<String> scanResults = new ArrayList();
    private int positives;
    private int totalResults;
    private String linkToResultsSite;

    private String resultsJSON;

    private int virustotalScore;
    private String isSecureByVirustotal;




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getScanResults() {
        return scanResults;
    }

    public void setScanResults(ArrayList<String> scanResults) {
        this.scanResults = scanResults;
    }

    public int getPositives() {
        return positives;
    }

    public void setPositives(int positives) {
        this.positives = positives;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getLinkToResultsSite() {
        return linkToResultsSite;
    }

    public void setLinkToResultsSite(String linkToResultsSite) {
        this.linkToResultsSite = linkToResultsSite;
    }

    public String getResultsJSON() {
        return resultsJSON;
    }

    public void setResultsJSON(String resultsJSON) {
        this.resultsJSON = resultsJSON;
    }

    public int getVirustotalScore() {
        return virustotalScore;
    }

    public void setVirustotalScore(int virustotalScore) {
        this.virustotalScore = virustotalScore;
    }

    public String getIsSecureByVirustotal() {
        return isSecureByVirustotal;
    }

    public void setIsSecureByVirustotal(String isSecureByVirustotal) {
        this.isSecureByVirustotal = isSecureByVirustotal;
    }

    @Override
    public String toString() {
        return "VirustotalModel{" +
                "url='" + url + '\'' +
                ", scanResults=" + scanResults +
                ", positives=" + positives +
                ", totalResults=" + totalResults +
                ", linkToResultsSite='" + linkToResultsSite + '\'' +
                ", resultsJSON='" + resultsJSON + '\'' +
                ", virustotalScore=" + virustotalScore +
                ", isSecureByVirustotal='" + isSecureByVirustotal + '\'' +
                '}';
    }
}
