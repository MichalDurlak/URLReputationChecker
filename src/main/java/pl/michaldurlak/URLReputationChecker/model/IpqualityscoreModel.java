package pl.michaldurlak.URLReputationChecker.model;

public class IpqualityscoreModel {

    private String message;

    private String domain;
    private String ipAddress;
    private String category;
    private int statusCode;
    private int riskScore;
    // CAN CHANGE FROM STRING TO BOOLEAN
    private String isDnsValid;
    private String isParking;
    private String isSpamming;
    private String isMalware;
    private String isPhishing;
    private String isSuspicious;
    private String isAdult;
    private String isSuccess;
    private String isUnsafe;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getIsDnsValid() {
        return isDnsValid;
    }

    public void setIsDnsValid(String isDnsValid) {
        this.isDnsValid = isDnsValid;
    }

    public String getIsParking() {
        return isParking;
    }

    public void setIsParking(String isParking) {
        this.isParking = isParking;
    }

    public String getIsSpamming() {
        return isSpamming;
    }

    public void setIsSpamming(String isSpamming) {
        this.isSpamming = isSpamming;
    }

    public String getIsMalware() {
        return isMalware;
    }

    public void setIsMalware(String isMalware) {
        this.isMalware = isMalware;
    }

    public String getIsPhishing() {
        return isPhishing;
    }

    public void setIsPhishing(String isPhishing) {
        this.isPhishing = isPhishing;
    }

    public String getIsSuspicious() {
        return isSuspicious;
    }

    public void setIsSuspicious(String isSuspicious) {
        this.isSuspicious = isSuspicious;
    }

    public String getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(String isAdult) {
        this.isAdult = isAdult;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getIsUnsafe() {
        return isUnsafe;
    }

    public void setIsUnsafe(String isUnsafe) {
        this.isUnsafe = isUnsafe;
    }

    @Override
    public String toString() {
        return "IpqualityscoreModel{" +
                "message='" + message + '\'' +
                ", domain='" + domain + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", category='" + category + '\'' +
                ", statusCode=" + statusCode +
                ", riskScore=" + riskScore +
                ", isDnsValid='" + isDnsValid + '\'' +
                ", isParking='" + isParking + '\'' +
                ", isSpamming='" + isSpamming + '\'' +
                ", isMalware='" + isMalware + '\'' +
                ", isPhishing='" + isPhishing + '\'' +
                ", isSuspicious='" + isSuspicious + '\'' +
                ", isAdult='" + isAdult + '\'' +
                ", isSuccess='" + isSuccess + '\'' +
                ", isUnsafe='" + isUnsafe + '\'' +
                '}';
    }
}
