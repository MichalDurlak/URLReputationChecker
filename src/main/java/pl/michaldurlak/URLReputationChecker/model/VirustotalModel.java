package pl.michaldurlak.URLReputationChecker.model;

import java.util.ArrayList;

public class VirustotalModel {

    private String url;
    ArrayList<String> scanResults = new ArrayList();
    private int positives;
    private int totalResults;
    private String linkToResultsSite;

    private String resultsJSON;


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

    @Override
    public String toString() {
        return "VirustotalModel{" +
                "url='" + url + '\'' +
                ", scanResults=" + scanResults +
                ", positives=" + positives +
                ", totalResults=" + totalResults +
                ", linkToResultsSite='" + linkToResultsSite + '\'' +
                '}';
    }
}
