package com.example.botanicki_vrt.vrsta;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VrstaService {

    @Autowired
    private VrstaRepository vrstaRepository;

    public  List<Vrsta> getVrstas()
    {
        List<Vrsta> vrstaList = new ArrayList<>();
        vrstaRepository.findAll().forEach(vrstaList::add);
        return vrstaList;
    }

    public Vrsta getByID(Integer id)
    {
        return vrstaRepository.findAllByVrstaID(id);
    }


    public void spremiVrstu(Vrsta vrsta)
    {
        vrstaRepository.save(vrsta);
    }
    public void obrisiVrstu(Vrsta vrsta)
    {
        vrstaRepository.delete(vrsta);
    }
    public void izmjeniVrstu(Vrsta oldVrsta, Vrsta newVrsta)
    {
        vrstaRepository.delete(oldVrsta);
        vrstaRepository.save(newVrsta);
    }
}
