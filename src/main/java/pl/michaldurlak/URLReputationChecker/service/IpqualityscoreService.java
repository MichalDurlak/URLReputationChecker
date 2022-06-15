package pl.michaldurlak.URLReputationChecker.service;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.URLReputationChecker.ReadSecrets;
import pl.michaldurlak.URLReputationChecker.model.IpqualityscoreModel;
import pl.michaldurlak.URLReputationChecker.model.URLModel;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class IpqualityscoreService {

    // API KEY
    private static final String API_ipqualityscoreservice = ReadSecrets.getProperty("API_IPQUALITYSCORE");
    // STATIC URL
    private static final String URL_ipqualityscoreservice = "https://ipqualityscore.com/api/json/url";

    private RestTemplate restTemplate = new RestTemplate();

    // GET RESULT AND SAVE AS A STRING
    public String getFullResultOfProvidedSite(String urlProvided){
        return restTemplate.getForObject(URL_ipqualityscoreservice+"/{API_ipqualityscoreservice}/{urlProvided}",
                String.class, API_ipqualityscoreservice,urlProvided);
    }

    // GET RISK SCORE AND MINUS 100 TO GET GENERAL SCORE
    public int getRiskScoreAndConvertToGeneralScore(String jsonResultFromSite){
        JSONObject jsonObject = new JSONObject(jsonResultFromSite);
        int riskScore = 100-jsonObject.getInt("risk_score");
        return riskScore;
    }

    // SET IS THE SITE SAFE OR NOT
    public String isSafeOrNot(int ipqualityscoreScore){
//        System.out.println(ipqualityscoreScore);
        if(ipqualityscoreScore >= 75 && ipqualityscoreScore < 85){
            return "PODEJRZANA";
        } else if(ipqualityscoreScore >= 85 && ipqualityscoreScore < 100){
            return "WYSOKIE ZAGROŻENIE";
        } else if(ipqualityscoreScore == 100){
            return "NIEBEZPIECZNA!!";
        }else {
            return "BEZPIECZNA";
        }

    }


    //SET ALL VALUES FOR IPQUALITYSCORE-MODEL
    public void setModelForIpqualityscoreModel(String jsonResultFromSite, IpqualityscoreModel ipqualityscoreModel){
        JSONObject jsonObject = new JSONObject(jsonResultFromSite);
        ipqualityscoreModel.setMessage(jsonObject.getString("message"));
        ipqualityscoreModel.setDomain(jsonObject.getString("domain"));
        ipqualityscoreModel.setIpAddress(jsonObject.getString("ip_address"));
        ipqualityscoreModel.setCategory(jsonObject.getString("category"));
        ipqualityscoreModel.setStatusCode(jsonObject.getInt("status_code"));
        ipqualityscoreModel.setRiskScore(jsonObject.getInt("risk_score"));
        ipqualityscoreModel.setIsDnsValid(String.valueOf(jsonObject.getBoolean("dns_valid")));
        ipqualityscoreModel.setIsAdult(String.valueOf(jsonObject.getBoolean("adult")));
        ipqualityscoreModel.setIsParking(String.valueOf(jsonObject.getBoolean("parking")));
        ipqualityscoreModel.setIsSpamming(String.valueOf(jsonObject.getBoolean("spamming")));
        ipqualityscoreModel.setIsMalware(String.valueOf(jsonObject.getBoolean("malware")));
        ipqualityscoreModel.setIsPhishing(String.valueOf(jsonObject.getBoolean("phishing")));
        ipqualityscoreModel.setIsSuspicious(String.valueOf(jsonObject.getBoolean("suspicious")));
        ipqualityscoreModel.setIsAdult(String.valueOf(jsonObject.getBoolean("adult")));
        ipqualityscoreModel.setIsSuccess(String.valueOf(jsonObject.getBoolean("success")));
        ipqualityscoreModel.setIsUnsafe(String.valueOf(jsonObject.getBoolean("unsafe")));

    }

}
