package com.example.botanicki_vrt.vrsta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VrstaRepository extends CrudRepository<Vrsta,Integer> {
    public Vrsta findAllByVrstaID(Integer vrstaID);
}
