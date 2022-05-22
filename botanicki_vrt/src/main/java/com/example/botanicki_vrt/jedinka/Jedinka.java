package com.example.botanicki_vrt.jedinka;

import com.example.botanicki_vrt.vrsta.Vrsta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "jedinka")
public class Jedinka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer JedinkaID;

    private Integer dob;
    private String ime;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="vrstajedinke",referencedColumnName = "VrstaID")
    private Vrsta vrsta;



    @Override
    public String toString() {
        return "Jedinka{" +
                "JedinkaID=" + JedinkaID +
                ", dob=" + dob +
                ", ime='" + ime + '\'' +
                ", vrsta=" + vrsta.getVrstaID() +
                '}';
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) { this.ime = ime; }

    public Integer getJedinkaID() {
        return JedinkaID;
    }

    public void setJedinkaID(Integer jedinkaID) {
        JedinkaID = jedinkaID;
    }


    public Integer getDob() { return dob; }
    public void setDob(Integer dob) {
        this.dob = dob;
    }
}
