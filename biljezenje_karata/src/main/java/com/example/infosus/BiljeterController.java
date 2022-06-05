package com.example.infosus;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;



@Controller
@RequestMapping()
public class BiljeterController {

    private String CurrentTaskID;
    private int currentTaskInternalValue;

    // GET ALL TASKS
    // COMPLETE SCAN TASK
    // COMPLETE INFORM TASK
    // COMPLETE VERIFY TASK
    // SEND MESSAGE

    /*
    POSALJI PORUKU
http://localhost:8080/engine-rest/message
{
  "messageName" : "DatabaseMessage",
  "businessKey" : "1",
  "processVariables" : {
    "isValid" : {"value" : true, "type": "Boolean"}
  }
}
DOHVATI SVE TASKOVe
http://localhost:8080/engine-rest/task/

POSALJI ODGOVOR NA SCAN
http://localhost:8080/engine-rest/task/id/complete
{"variables":
    {"QRCodeScanning": {"value": 100}}
}

POSALJI ODGOVOR NA INFORM
http://localhost:8080/engine-rest/task/id/complete


POSALJI ODGOVOR NA VERIFY
http://localhost:8080/engine-rest/task/id/complete
{"variables":
    {"isValid": {"value": true}}
}


     */

    @RequestMapping("/biljeter")
    public ModelAndView pocetna() {
        ModelAndView mav = new ModelAndView("biljeter");
        return mav;
    }



    @RequestMapping ("biljeter/poslovi")
    public ModelAndView getTask() {
        String getTaskUrl = "http://localhost:8080/engine-rest/task/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String>  response = restTemplate.getForEntity(getTaskUrl,String.class);
        System.out.println(response.getBody());
        String id = StringUtils.substringBetween(response.getBody(), "\"id\":\"", "\"");
        System.out.println(id);
        CurrentTaskID = id;

        String imePosla = StringUtils.substringBetween(response.getBody(), "\"taskDefinitionKey\":\"", "\"");
        System.out.println(imePosla);
        evaulatePosao(imePosla);



        ModelAndView mav = new ModelAndView("biljeterPoslovi");
        mav.addObject("posao",imePosla);
        return mav;

    }

    @RequestMapping(value="biljeter/obavi")
    public ModelAndView obaviTrenutniZadatak()
    {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("biljeterSkeniranje");
        switch (currentTaskInternalValue) {
            case 1:
                mav.setViewName("biljeterSkeniranje");
                break;
            case 2:
                mav.setViewName("biljeterInformiranje");
                break;
            case 3:
                mav.setViewName("biljeterVerificiranje");
                break;
            default:
                mav.setViewName("biljeter");
                break;
        }
        return mav;
    }



    @RequestMapping(value="biljeter/skeniranje", method=RequestMethod.POST)
    public String postSkeniranje(@ModelAttribute long QRkod)
    {
        System.out.println("QRKOD: "+QRkod);
        RestTemplate restTemplate = new RestTemplate();
        String url = constructURL();
        //SEND SCAN POST
        ResponseEntity<String> result = restTemplate.postForEntity(url, QRkod, String.class);
        return "redirect:biljeter";

    }

    @RequestMapping(value="biljeter/informiranje", method=RequestMethod.POST)
    public String postInformiranje()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = constructURL();
        //SEND SCAN POST
        ResponseEntity<String> result = restTemplate.postForEntity(url, "", String.class);
        return "redirect:biljeter";

    }
    @RequestMapping(value="biljeter/verificiranje", method=RequestMethod.POST)
    public String postVerificiranje(@ModelAttribute boolean valid)
    {
        System.out.println("valid: "+valid);
        RestTemplate restTemplate = new RestTemplate();
        String url = constructURL();
        //SEND SCAN POST
        ResponseEntity<String> result = restTemplate.postForEntity(url, valid, String.class);
        return "redirect:biljeter";
    }



    private void evaulatePosao(String ime)
    {
        switch (ime) {
            case "TaskScanQRCode":
                currentTaskInternalValue = 1;
                break;
            case "TaskInform":
                currentTaskInternalValue = 2;
                break;
            case "VerifyDatabase":
                currentTaskInternalValue = 3;
                break;
            default:
                currentTaskInternalValue = 0;
                break;
        }
    }

    private String constructURL()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("http://localhost:8080/engine-rest/task/");
        sb.append(CurrentTaskID);
        sb.append("/complete");
        return sb.toString();
    }


}
