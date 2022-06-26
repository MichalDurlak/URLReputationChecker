package pl.michaldurlak.URLReputationChecker.model;

public class URLModel {

    // GENERAL VALUES
    private String urlLink;
    private String prefixUrlLink;
    private int urlGeneralScore;

    // GENERAL VALUES FOR ipqualityscore
    private int ipqualityscoreScore;
    private String isSecureByIpqualityscoreScore;
    private String linkToResultFromIpqualityscoreScore;

    // VALUES FOR NEXT SITE






    public String getUrlLink() {
        return prefixUrlLink+urlLink;
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

    public String getIsSecureByIpqualityscoreScore() {
        return isSecureByIpqualityscoreScore;
    }

    public void setIsSecureByIpqualityscoreScore(String isSecureByIpqualityscoreScore) {
        this.isSecureByIpqualityscoreScore = isSecureByIpqualityscoreScore;
    }

    public String getLinkToResultFromIpqualityscoreScore() {
        return linkToResultFromIpqualityscoreScore;
    }

    public void setLinkToResultFromIpqualityscoreScore(String linkToResultFromIpqualityscoreScore) {
        this.linkToResultFromIpqualityscoreScore = linkToResultFromIpqualityscoreScore;
    }

    public String getPrefixUrlLink() {
        return prefixUrlLink;
    }

    public void setPrefixUrlLink(String prefixUrlLink) {
        this.prefixUrlLink = prefixUrlLink;
    }

    @Override
    public String toString() {
        return "URLModel{" +
                "urlLink='" + urlLink + '\'' +
                ", urlGeneralScore=" + urlGeneralScore +
                ", ipqualityscoreScore=" + ipqualityscoreScore +
                ", isSecureByIpqualityscoreScore='" + isSecureByIpqualityscoreScore + '\'' +
                ", linkToResultFromIpqualityscoreScore='" + linkToResultFromIpqualityscoreScore + '\'' +
                '}';
    }
}
