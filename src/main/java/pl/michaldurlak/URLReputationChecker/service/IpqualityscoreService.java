package pl.michaldurlak.URLReputationChecker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.URLReputationChecker.ReadSecrets;

@Service
public class IpqualityscoreService {

    private static final String API_ipqualityscoreservice = ReadSecrets.getProperty("API_IPQUALITYSCORE");
    private static final String URL_ipqualityscoreservice = "https://ipqualityscore.com/api/json/url";

    private RestTemplate restTemplate = new RestTemplate();
    public String getURLScore(String urlProvided){
        return restTemplate.getForObject(URL_ipqualityscoreservice+"/{API_ipqualityscoreservice}/{urlProvided}",
                String.class, API_ipqualityscoreservice,urlProvided);
    }




}
