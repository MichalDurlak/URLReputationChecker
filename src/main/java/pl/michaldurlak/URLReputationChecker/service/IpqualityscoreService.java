package pl.michaldurlak.URLReputationChecker.service;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.URLReputationChecker.ReadSecrets;
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

    // SET IS THE SITE SEFE OR NOT
    public String isSafeOrNot(int ipqualityscoreScore){
        if(ipqualityscoreScore >= 45){
            return "BEZPIECZNA";
        } else {
            return "NIEBEZPIECZNA!!";
        }
    }






}
