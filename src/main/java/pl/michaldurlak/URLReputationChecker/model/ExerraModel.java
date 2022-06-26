package pl.michaldurlak.URLReputationChecker.model;

public class ExerraModel {

    private int statusCode;
    private String isScam;

    private String resultsJSON;

    private int exerraScore;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getIsScam() {
        return isScam;
    }

    public void setIsScam(String isScam) {
        if (isScam.equals("true")){
            this.isScam = "WYKRYTO ZAGROŻENIE";
        } else {
            this.isScam = "NIE WYKRYTO ZAGROŻENIA";
        }

    }

    public String getResultsJSON() {
        return resultsJSON;
    }

    public void setResultsJSON(String resultsJSON) {
        this.resultsJSON = resultsJSON;
    }

    public int getExerraScore() {
        return exerraScore;
    }

    public void setExerraScore(String isTrueOrFalse) {

        if (isTrueOrFalse.equals("true")){
            this.exerraScore = 0;
        } else {
            this.exerraScore = 100;
        }
    }

    @Override
    public String toString() {
        return "ExerraModel{" +
                "statusCode=" + statusCode +
                ", isScam='" + isScam + '\'' +
                ", resultsJSON='" + resultsJSON + '\'' +
                '}';
    }
}
