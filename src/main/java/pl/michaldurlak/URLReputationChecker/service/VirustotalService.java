package pl.michaldurlak.URLReputationChecker.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.URLReputationChecker.ReadSecrets;
import pl.michaldurlak.URLReputationChecker.model.IpqualityscoreModel;
import pl.michaldurlak.URLReputationChecker.model.VirustotalModel;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class VirustotalService {

    // API KEY
    private static final String API_virustotal = ReadSecrets.getProperty("API_VIRUSTOTAL");
    // STATIC URL
    private static final String URL_virustotal = "https://www.virustotal.com/vtapi/v2/url/report";

    private RestTemplate restTemplate = new RestTemplate();

    // GET RESULT AND SAVE AS A STRING
    public String getFullResultOfProvidedSite(String urlProvided) throws IOException {
        return restTemplate.getForObject(URL_virustotal+"?apikey={API_virustotal}&resource={urlProvided}&allinfo=false&scan=0",
                String.class , API_virustotal, urlProvided);
    }


    public void setModelForVirustotalModel(VirustotalModel virustotalModel) {
        JSONObject jsonObject = new JSONObject(virustotalModel.getResultsJSON());
        virustotalModel.setLinkToResultsSite(jsonObject.getString("permalink"));
        virustotalModel.setTotalResults(jsonObject.getInt("total"));
        virustotalModel.setPositives(jsonObject.getInt("positives"));

//        virustotalModel.setScanResults(jsonObject.getJSONObject("scans").);


        ArrayList<String> scanResults = new ArrayList();

    }

}
