package pl.michaldurlak.URLReputationChecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.michaldurlak.URLReputationChecker.model.URLModel;
import pl.michaldurlak.URLReputationChecker.service.URLCheckService;

import javax.print.DocFlavor;

@Controller
public class IndexController {

        @RequestMapping("/")
        public String showIndex() {
            return "index";
        }

        @PostMapping("/")
        public String getResultPage(@ModelAttribute("URLRequest") URLModel urlModel, Model model){
            model.addAttribute("urlModel",urlModel);

            // METHOD TO SET ALL VALUES FROM MODEL
            URLCheckService.getAllReputation(urlModel);

            // PRINT RESULT FROM IPQUALITYSCORE SITE
            System.out.println(urlModel.getLinkToResultFromIpqualityscoreScore());
            return "result";
        }


}
