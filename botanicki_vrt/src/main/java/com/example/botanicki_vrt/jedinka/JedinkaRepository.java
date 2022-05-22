package com.example.botanicki_vrt.jedinka;

import com.example.botanicki_vrt.vrsta.Vrsta;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface JedinkaRepository extends CrudRepository<Jedinka,Integer> {

    List<Jedinka> findAllByDob(int dob);
}
