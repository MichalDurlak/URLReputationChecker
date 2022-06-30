package pl.michaldurlak.URLReputationChecker.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pl.michaldurlak.URLReputationChecker.ReadSecrets;
import pl.michaldurlak.URLReputationChecker.model.PhishermanModel;

@Service
public class PhishermanService {

    // API KEY
    private static final String API_phisherman = ReadSecrets.getProperty("API_PHISHERMAN");
    // STATIC URL
    private static final String URL_phishermanCheck = "https://api.phisherman.gg/v2/domains/check/";
    private static final String URL_phishermanInfo = "https://api.phisherman.gg/v2/domains/info/";



    public void setCheckAndInfoResultJSON (String providedURL,PhishermanModel phishermanModel){

        // Check
        String responseForCheck = Unirest.get(URL_phishermanCheck+providedURL)
                .header("Authorization", "Bearer "+API_phisherman)
                .asString()
                .getBody();

//        System.out.println(responseForCheck);

        // Info
        String responseForInfo = Unirest.get(URL_phishermanInfo+providedURL)
                .header("Authorization", "Bearer "+API_phisherman)
                .asString()
                .getBody();

        System.out.println("Tuuuuutaj" + responseForInfo);

        phishermanModel.setCheckResultJSON(responseForCheck);
        phishermanModel.setInfoResultJSON(responseForInfo);


//        System.out.println(phishermanModel.getCheckResultJSON());
//        System.out.println(phishermanModel.getInfoResultJSON());
//
//        System.out.println(responseForCheck);
//        System.out.println(responseForInfo);

    }

    public void setPhishermanCheckModel(String providedSite, PhishermanModel phishermanModel){
        // check
        JSONObject tempJSONCheck = new JSONObject(phishermanModel.getCheckResultJSON());
        phishermanModel.setClassificationScan(tempJSONCheck.getString("classification"));
        phishermanModel.setVerifiedPhishScan(String.valueOf(tempJSONCheck.getBoolean("verifiedPhish")));
        phishermanModel.setPhishermanScore(phishermanModel.getClassificationScan());
        phishermanModel.setPhishermanIsSecure(phishermanModel.getClassificationScan());

        // info

        JSONObject tempJSONInfo = new JSONObject(phishermanModel.getInfoResultJSON());
        JSONObject tempJSONInfoProvidedSite = tempJSONInfo.getJSONObject(providedSite);
        JSONObject tempJSONInfoDetails = tempJSONInfoProvidedSite.getJSONObject("details");
        JSONObject tempJSONInfoCountry = tempJSONInfoDetails.getJSONObject("country");

            // json -> providedSite
        phishermanModel.setStatusInfo(tempJSONInfoProvidedSite.getString("status"));
        phishermanModel.setVerifiedPhishInfo(String.valueOf(tempJSONInfoProvidedSite.getBoolean("verifiedPhish")));
        phishermanModel.setClassificationInfo(tempJSONInfoProvidedSite.getString("classification"));
        phishermanModel.setFirstSeenInfo(tempJSONInfoProvidedSite.getString("firstSeen"));
        phishermanModel.setLastCheckInfo(tempJSONInfoProvidedSite.getString("lastChecked"));
        phishermanModel.setLastSeenInfo(tempJSONInfoProvidedSite.getString("lastSeen"));
        phishermanModel.setPhishCaughtInfo(String.valueOf(tempJSONInfoProvidedSite.getInt("phishCaught")));

            // json -> details
        phishermanModel.setWebsiteScreenshotInfo(tempJSONInfoDetails.getString("websiteScreenshot"));
        phishermanModel.setIp_addressInfo(tempJSONInfoDetails.getString("ip_address"));

            // json -> country
        phishermanModel.setCountry_nameInfo(tempJSONInfoCountry.getString("name"));

    }


}
