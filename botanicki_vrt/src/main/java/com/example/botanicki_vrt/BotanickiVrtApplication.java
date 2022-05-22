package com.example.botanicki_vrt;

import com.example.botanicki_vrt.jedinka.Jedinka;
import com.example.botanicki_vrt.jedinka.JedinkaController;
import com.example.botanicki_vrt.jedinka.JedinkaRepository;
import com.example.botanicki_vrt.vrsta.Vrsta;
import com.example.botanicki_vrt.vrsta.VrstaController;
import com.example.botanicki_vrt.vrsta.VrstaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class BotanickiVrtApplication  {

	@Autowired
	private JedinkaController jedinkaController;
	@Autowired
	private VrstaController vrstaController;

	@Autowired
	private VrstaRepository vrstaRepository;
	public static void main(String[] args) {
		SpringApplication.run(BotanickiVrtApplication.class, args);

	}

}
