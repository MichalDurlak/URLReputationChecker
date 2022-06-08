package pl.michaldurlak.URLReputationChecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.michaldurlak.URLReputationChecker.service.IpqualityscoreService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class URLCheckController {

    @GetMapping("/check")
    @ResponseBody
    public String CheckURL(@RequestParam(required = true) String url, HttpServletRequest request){
        IpqualityscoreService ipqualityscoreService = new IpqualityscoreService();
        String result = ipqualityscoreService.getURLScore(url) + " \n" + request.getRemoteAddr();
        return result;
    }

    @GetMapping("/")
    public String mainSite(){
        return "index";
    }

}
