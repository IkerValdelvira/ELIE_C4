package ehu.isad.model;

import javafx.scene.image.Image;

import java.sql.Date;

public class Bozkaketa {

    private String bozkatuaIzanDa;
    private String bozkatuDu;
    private Integer urtea;
    private Integer puntuak;

    public Bozkaketa(String bozkatuaIzanDa, String bozkatuDu, Integer urtea, Integer puntuak) {
        this.bozkatuaIzanDa = bozkatuaIzanDa;
        this.bozkatuDu = bozkatuDu;
        this.urtea = urtea;
        this.puntuak = puntuak;
    }

    public String getBozkatuaIzanDa() {
        return bozkatuaIzanDa;
    }

    public void setBozkatuaIzanDa(String bozkatuaIzanDa) {
        this.bozkatuaIzanDa = bozkatuaIzanDa;
    }

    public String getBozkatuDu() {
        return bozkatuDu;
    }

    public void setBozkatuDu(String bozkatuDu) {
        this.bozkatuDu = bozkatuDu;
    }

    public Integer getUrtea() {
        return urtea;
    }

    public void setUrtea(Integer urtea) {
        this.urtea = urtea;
    }

    public Integer getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(Integer puntuak) {
        this.puntuak = puntuak;
    }
}