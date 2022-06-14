package pl.michaldurlak.URLReputationChecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.michaldurlak.URLReputationChecker.model.URLModel;
import pl.michaldurlak.URLReputationChecker.service.IpqualityscoreService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class URLCheckController {

    // need to check if its used
//    @GetMapping("/check")
//    @ResponseBody
//    public String CheckURL(@RequestParam(required = true) String url, HttpServletRequest request){
//        IpqualityscoreService ipqualityscoreService = new IpqualityscoreService();
//        String result = ipqualityscoreService.getURLScore(url) + " \n" + request.getRemoteAddr();
//        return result;
//    }


}
