package pl.michaldurlak.URLReputationChecker.model;

public class URLModel {

    private String urlLink;
    private int urlGeneralScore;
    private int ipqualityscoreScore;


    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public int getUrlGeneralScore() {
        return urlGeneralScore;
    }

    public void setUrlGeneralScore(int urlGeneralScore) {
        this.urlGeneralScore = urlGeneralScore;
    }

    public int getIpqualityscoreScore() {
        return ipqualityscoreScore;
    }

    public void setIpqualityscoreScore(int ipqualityscoreScore) {
        this.ipqualityscoreScore = ipqualityscoreScore;
    }


    @Override
    public String toString() {
        return "URLModel{" +
                "urlLink='" + urlLink + '\'' +
                ", urlGeneralScore=" + urlGeneralScore +
                ", ipqualityscoreScore=" + ipqualityscoreScore +
                '}';
    }
}
