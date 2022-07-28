package pl.michaldurlak.URLReputationChecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michaldurlak.URLReputationChecker.model.*;
import pl.michaldurlak.URLReputationChecker.service.ExerraService;
import pl.michaldurlak.URLReputationChecker.service.IpqualityscoreService;
import pl.michaldurlak.URLReputationChecker.service.URLCheckService;
import pl.michaldurlak.URLReputationChecker.service.VirustotalService;

import javax.print.DocFlavor;
import java.io.IOException;

@Controller
public class IndexController {

        @RequestMapping("/")
        public String showIndex() {
            return "index";
        }

        @PostMapping("/")
        public String getResultPage(@ModelAttribute("URLRequest") URLModel urlModel,
                                    IpqualityscoreModel ipqualityscoreModel,
                                    VirustotalModel virustotalModel,
                                    ExerraModel exerraModel,
                                    PhishermanModel phishermanModel,
                                    Model model) throws IOException {
            model.addAttribute("urlModel",urlModel);
//            model.addAttribute("ipqualityscoreModel",ipqualityscoreModel);
            model.addAttribute("virustotalModel",virustotalModel);
            model.addAttribute("exerraModel",exerraModel);
            model.addAttribute("phishermanModel",phishermanModel);

            // METHOD TO SET ALL VALUES FROM MODEL
            URLCheckService.getAllReputation(urlModel, ipqualityscoreModel, virustotalModel, exerraModel, phishermanModel);


            // PRINT RESULT FROM IPQUALITYSCORE SITE + PRINT RESULT OF IPQUALITYSCOREMODEL
//            System.out.println(urlModel.getLinkToResultFromIpqualityscoreScore());
//            System.out.println(ipqualityscoreModel);

            return "result";
        }



}
