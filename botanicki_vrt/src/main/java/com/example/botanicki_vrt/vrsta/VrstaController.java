package com.example.botanicki_vrt.vrsta;


import com.example.botanicki_vrt.jedinka.Jedinka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping()
public class VrstaController {

    private final VrstaService vrstaService;
    @Autowired
    public VrstaController(VrstaService vrstaService)
    {
        this.vrstaService = vrstaService;
    }



    @RequestMapping("/vrsta")
    public ModelAndView getVrstas() {
        ModelAndView mav = new ModelAndView("vrsta");
        return mav;
    }


    @RequestMapping("vrsta/vrstaTable")
    public ModelAndView vrstaTable()
    {
        ModelAndView mav = new ModelAndView("vrstaTable");
        mav.addObject("vrstaTable",vrstaService.getVrstas());
        return mav;
    }


    @RequestMapping("vrsta/dodajVrstu")
    public String dodajJedinku(Model model)
    {
        Vrsta vrsta = new Vrsta();
        model.addAttribute("vrsta",vrsta);
        return "dodajVrstu";
    }

    @RequestMapping(value="vrsta/spremiVrstu", method=RequestMethod.POST)
    public String spremiVrstu(@ModelAttribute Vrsta vrsta)
    {
        System.out.println(vrsta);
        vrstaService.spremiVrstu(vrsta);
        return "redirect:vrstaTable";
    }



    @RequestMapping(value="vrsta/obrisiVrstu/{id}")
    public String obrisiVrstu(@PathVariable (value = "id") Integer id)
    {
        Vrsta vrsta = vrstaService.getByID(id);
        System.out.println("BRISANJE");
        System.out.println(vrsta);
        vrstaService.obrisiVrstu(vrsta);
        return "redirect:/vrsta/vrstaTable";
    }
    @RequestMapping(value = "vrsta/detail/{id}")
    public ModelAndView detail(@PathVariable (value = "id") Integer id)
    {
        Vrsta vrsta = vrstaService.getByID(id);
        ModelAndView mav = new ModelAndView("detail");
        List<Jedinka> jedinkaList = vrsta.getJedinkeVrste();
        mav.addObject("detail",jedinkaList);
        return mav;

    }


}
