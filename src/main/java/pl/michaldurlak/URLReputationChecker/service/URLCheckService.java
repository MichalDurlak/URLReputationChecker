package pl.michaldurlak.URLReputationChecker.service;

import org.springframework.stereotype.Service;
import pl.michaldurlak.URLReputationChecker.model.URLModel;

@Service
public class URLCheckService {

public static void getAllReputation(URLModel providedURL){

//    IPQUALITYSCORE.COM
    IpqualityscoreService ipqualityscoreService = new IpqualityscoreService();
    // download once results for site
    providedURL.setLinkToResultFromIpqualityscoreScore(ipqualityscoreService.getFullResultOfProvidedSite(providedURL.getUrlLink()));
    // set score for site
    providedURL.setIpqualityscoreScore(ipqualityscoreService.getRiskScoreAndConvertToGeneralScore(providedURL.getLinkToResultFromIpqualityscoreScore()));
    // set value is safe or not
    providedURL.setIsSecureByIpqualityscoreScore(ipqualityscoreService.isSafeOrNot(providedURL.getIpqualityscoreScore()));






// SUM UP
    //    GET AVERAGE OF ALL SCORES
    int sumAllScores = providedURL.getIpqualityscoreScore();
    // SET GENERAL SCORE
    providedURL.setUrlGeneralScore(sumAllScores/1);
}
}
