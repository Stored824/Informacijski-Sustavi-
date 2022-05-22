package com.example.botanicki_vrt.jedinka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping()
public class JedinkaController {
    private final JedinkaService jedinkaService;

    @Autowired
    public JedinkaController(JedinkaService jedinkaService) {
        this.jedinkaService = jedinkaService;
    }


    @RequestMapping("/jedinka")
    public ModelAndView getJedinkas() {
        ModelAndView mav = new ModelAndView("jedinka");
        return mav;
    }


    @RequestMapping("jedinka/jedinkaTable")
    public ModelAndView jedinkaTable()
    {
        ModelAndView mav = new ModelAndView("jedinkaTable");
        mav.addObject("jedinkaTable",jedinkaService.getJedinkas());
        return mav;
    }


    @RequestMapping("jedinka/poDobi/{dob}")
    public ModelAndView poDobi(@PathVariable(value = "dob") int dob)
    {
        ModelAndView mav = new ModelAndView("jedinkaTable");
        mav.addObject("jedinkaTable",jedinkaService.poDobi(dob));
        return mav;
    }



    @RequestMapping("jedinka/dodajJedinku")
    public String dodajJedinku(Model model)
    {
        Jedinka jedinka = new Jedinka();
        model.addAttribute("jedinka",jedinka);
        return "dodajJedinku";
    }


    @PostMapping("jedinka/spremiJedinku")
    public String spremiJedinku(@ModelAttribute Jedinka jedinka)
    {
        jedinkaService.spremiJedinku(jedinka);
        return "redirect:jedinka/jednikaTable";
    }


}
