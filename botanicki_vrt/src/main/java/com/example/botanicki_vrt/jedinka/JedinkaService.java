package com.example.botanicki_vrt.jedinka;



import com.example.botanicki_vrt.vrsta.Vrsta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JedinkaService {

    @Autowired
    private JedinkaRepository jedinkaRepository;

    public  List<Jedinka> getJedinkas()
    {
        List<Jedinka> jedinkaList = new ArrayList<>();
        jedinkaRepository.findAll().forEach(jedinkaList::add);
        return jedinkaList;
    }

    /*
    public List<Jedinka> poVrsti(int vrstaID)
    {
        return jedinkaRepository.findAllByVrstajedinke(vrstaID);
    }*/

    public List<Jedinka> poDobi(int dob)
    {
        return jedinkaRepository.findAllByDob(dob);
    }


    public void spremiJedinku(Jedinka jedinka)
    {
        jedinkaRepository.save(jedinka);
    }
}
