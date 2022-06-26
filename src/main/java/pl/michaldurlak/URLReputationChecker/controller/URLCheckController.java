package pl.michaldurlak.URLReputationChecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.michaldurlak.URLReputationChecker.model.ExerraModel;
import pl.michaldurlak.URLReputationChecker.model.URLModel;
import pl.michaldurlak.URLReputationChecker.service.ExerraService;
import pl.michaldurlak.URLReputationChecker.service.IpqualityscoreService;
import pl.michaldurlak.URLReputationChecker.service.VirustotalService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class URLCheckController {

    // virustotal test page

//    @RequestMapping("/test")
//    public String test() throws IOException {
//        VirustotalService virustotalService = new VirustotalService();
//        String valueTest = virustotalService.getFullResultOfProvidedSite().toString();
//        return valueTest;
//    }
// scam -> buxquick.com



}
