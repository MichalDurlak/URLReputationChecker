package pl.michaldurlak.URLReputationChecker.service;


import kong.unirest.Unirest;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.URLReputationChecker.ReadSecrets;
import pl.michaldurlak.URLReputationChecker.model.ExerraModel;


public class ExerraService {

    // API KEY
//    private static final String API_exxeraservice = ReadSecrets.getProperty("API_EXERRA");
    private static final String API_exxeraservice = System.getenv("API_EXERRA");
    // STATIC URL
    private static final String URL_exxeraservice = "https://exerra-phishing-check.p.rapidapi.com/?url=";


    public void getResultExerra(String urlProvided, ExerraModel exerraModel) {
//        System.out.println(urlProvided);
        String response = Unirest.get(URL_exxeraservice+urlProvided)
                .header("X-RapidAPI-Key", API_exxeraservice)
                .header("X-RapidAPI-Host", "exerra-phishing-check.p.rapidapi.com")
                .asString()
                .getBody();

//        System.out.println(response);

        exerraModel.setResultsJSON(response);

        JSONObject jsonObject = new JSONObject(exerraModel.getResultsJSON());
        exerraModel.setStatusCode(jsonObject.getInt("status"));
        exerraModel.setIsScam(String.valueOf(jsonObject.getBoolean("isScam")));
        exerraModel.setExerraScore(String.valueOf(jsonObject.getBoolean("isScam")));

    }
}
