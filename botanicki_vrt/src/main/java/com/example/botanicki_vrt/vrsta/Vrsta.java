package com.example.botanicki_vrt.vrsta;

import com.example.botanicki_vrt.jedinka.Jedinka;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Vrsta")
public class Vrsta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vrstaID;
    private String imevrste;
    private int maksimalnazrelavisina;
    private int maksimalnazrelatezina;
    private int dobsazrijevanja;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mindatumusjeva;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxdatumusjeva;


    @JsonIgnore
    @OneToMany (mappedBy = "vrsta")
    private List<Jedinka> jedinkeVrste = new ArrayList<>();


    public List<Jedinka> getJedinkeVrste()
    {
        return jedinkeVrste;
    }


    public Integer getVrstaID() {
        return vrstaID;
    }

    public void setVrstaID(Integer vrstaID) {
        this.vrstaID = vrstaID;
    }

    public String getImevrste() {
        return imevrste;
    }

    public void setImevrste(String imevrste) {
        this.imevrste = imevrste;
    }

    public int getMaksimalnazrelavisina() {
        return maksimalnazrelavisina;
    }

    public void setMaksimalnazrelavisina(int maksimalnazrelavisina) {
        this.maksimalnazrelavisina = maksimalnazrelavisina;
    }
    /*
    public List<Jedinka> getJedinkeVrste() {
        return jedinkeVrste;
    }

    public void setJedinkeVrste(List<Jedinka> jedinkeVrste) {
        this.jedinkeVrste = jedinkeVrste;
    }
    */


    public int getMaksimalnazrelatezina() {
        return maksimalnazrelatezina;
    }

    @Override
    public String toString() {
        return "Vrsta{" +
                "VrstaID=" + vrstaID +
                ", imevrste='" + imevrste + '\'' +
                ", maksimalnazrelavisina=" + maksimalnazrelavisina +
                ", maksimalnazrelatezina=" + maksimalnazrelatezina +
                ", dobsazrijevanja=" + dobsazrijevanja +
                ", mindatumusjeva=" + mindatumusjeva +
                ", maxdatumusjeva=" + maxdatumusjeva +
                ", jedinkeVrste=" + jedinkeVrste +
                '}';
    }

    public void setMaksimalnazrelatezina(int maksimalnazrelatezina) {
        this.maksimalnazrelatezina = maksimalnazrelatezina;
    }

    public int getDobsazrijevanja() {
        return dobsazrijevanja;
    }

    public void setDobsazrijevanja(int dobsazrijevanja) {
        this.dobsazrijevanja = dobsazrijevanja;
    }

    public Date getMindatumusjeva() {
        return mindatumusjeva;
    }

    public void setMindatumusjeva(Date mindatumusjeva) {
        this.mindatumusjeva = mindatumusjeva;
    }

    public Date getMaxdatumusjeva() {
        return maxdatumusjeva;
    }

    public void setMaxdatumusjeva(Date maxdatumusjeva) {
        this.maxdatumusjeva = maxdatumusjeva;
    }

}
