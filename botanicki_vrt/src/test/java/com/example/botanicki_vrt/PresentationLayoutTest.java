package com.example.botanicki_vrt;

import com.example.botanicki_vrt.jedinka.Jedinka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@SpringBootApplication
public class PresentationLayoutTest {
    public static void main (String [] args)
    {
        SpringApplication.run(PresentationLayoutTest.class, args);

        System.out.println("TESTING PRESENTATION");
        System.out.println("Jedinka test 1: empty array");
        ArrayList<Jedinka> jedinkaArrayList= new ArrayList<>();

    }


    @RequestMapping("/jedinkaTable")
    public ModelAndView jedinkaTable(ArrayList<Jedinka> jedinkaArrayList)
    {
        ModelAndView mav = new ModelAndView("jedinkaTable");
        mav.addObject("jedinkaTable",jedinkaArrayList);
        return mav;
    }

}
