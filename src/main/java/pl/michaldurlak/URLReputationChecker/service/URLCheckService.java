package pl.michaldurlak.URLReputationChecker.service;

import org.springframework.stereotype.Service;
import pl.michaldurlak.URLReputationChecker.model.*;

import java.io.IOException;

@Service
public class URLCheckService {

public static void getAllReputation(URLModel providedURL, IpqualityscoreModel ipqualityscoreModel, VirustotalModel virustotalModel, ExerraModel exerraModel, PhishermanModel phishermanModel) throws IOException {


//// {"success":false,"message":"You have insufficient credits to make this query. Please contact IPQualityScore support if this error persists."
////    IPQUALITYSCORE.COM
//    IpqualityscoreService ipqualityscoreService = new IpqualityscoreService();
//
//    // download once results for site
//    providedURL.setLinkToResultFromIpqualityscoreScore(ipqualityscoreService.getFullResultOfProvidedSite(providedURL.getUrlLink()));
//    // set score for site
//    providedURL.setIpqualityscoreScore(ipqualityscoreService.getRiskScoreAndConvertToGeneralScore(providedURL.getLinkToResultFromIpqualityscoreScore()));
//    // set everything model ipqualityscore
//    ipqualityscoreService.setModelForIpqualityscoreModel(providedURL.getLinkToResultFromIpqualityscoreScore(),ipqualityscoreModel);
//    // set value is safe or not
//    providedURL.setIsSecureByIpqualityscoreScore(ipqualityscoreService.isSafeOrNot(ipqualityscoreModel.getRiskScore()));
//


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


// EXERRA
    ExerraService exerraService = new ExerraService();
    // is provided url scam or not
    exerraService.getResultExerra(providedURL.getUrlLink(),exerraModel);


// PHISHERMAN
    PhishermanService phishermanService = new PhishermanService();
    phishermanService.setCheckAndInfoResultJSON(providedURL.getOnlyUrlLink(), phishermanModel);
    phishermanService.setPhishermanCheckModel(providedURL.getOnlyUrlLink(), phishermanModel);






// SUM UP
    //    GET AVERAGE OF ALL SCORES
//    int sumAllScores = providedURL.getIpqualityscoreScore()+ virustotalModel.getVirustotalScore()+ exerraModel.getExerraScore();
    int sumAllScores = virustotalModel.getVirustotalScore()+ exerraModel.getExerraScore();
    int numerOfSorcesToDivide = 3;

    if (phishermanModel.getPhishermanScore() != -1){
        numerOfSorcesToDivide++;
        sumAllScores += phishermanModel.getPhishermanScore();
    }

    // SET GENERAL SCORE
    providedURL.setUrlGeneralScore(sumAllScores/numerOfSorcesToDivide);
}
}
