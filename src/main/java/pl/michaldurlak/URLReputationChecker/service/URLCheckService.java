package pl.michaldurlak.URLReputationChecker.service;

import org.springframework.stereotype.Service;
import pl.michaldurlak.URLReputationChecker.model.IpqualityscoreModel;
import pl.michaldurlak.URLReputationChecker.model.URLModel;
import pl.michaldurlak.URLReputationChecker.model.VirustotalModel;

import java.io.IOException;

@Service
public class URLCheckService {

public static void getAllReputation(URLModel providedURL, IpqualityscoreModel ipqualityscoreModel, VirustotalModel virustotalModel) throws IOException {

//    IPQUALITYSCORE.COM
    IpqualityscoreService ipqualityscoreService = new IpqualityscoreService();

    // download once results for site
    providedURL.setLinkToResultFromIpqualityscoreScore(ipqualityscoreService.getFullResultOfProvidedSite(providedURL.getUrlLink()));
    // set score for site
    providedURL.setIpqualityscoreScore(ipqualityscoreService.getRiskScoreAndConvertToGeneralScore(providedURL.getLinkToResultFromIpqualityscoreScore()));
    // set everything model ipqualityscore
    ipqualityscoreService.setModelForIpqualityscoreModel(providedURL.getLinkToResultFromIpqualityscoreScore(),ipqualityscoreModel);
    // set value is safe or not
    providedURL.setIsSecureByIpqualityscoreScore(ipqualityscoreService.isSafeOrNot(ipqualityscoreModel.getRiskScore()));

// VIRSUTOTAL.COM
    VirustotalService virustotalService = new VirustotalService();

    // download once results for site
    virustotalModel.setResultsJSON(virustotalService.getFullResultOfProvidedSite(providedURL.getUrlLink()));
    // set everything model ipqualityscore
    virustotalService.setModelForVirustotalModel(virustotalModel);
    // set score for site
    virustotalService.setVirustotalScore(virustotalModel);
    //     private int virustotalScore;
    // set value is safe or not
    virustotalService.setIsSecureByVirustotalScore(virustotalModel);
    //    private String isSecureByVirustotal;

// SUM UP
    //    GET AVERAGE OF ALL SCORES
    int sumAllScores = providedURL.getIpqualityscoreScore()+ virustotalModel.getVirustotalScore();
    // SET GENERAL SCORE
    providedURL.setUrlGeneralScore(sumAllScores/2);
}
}
