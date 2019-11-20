package ehu.isad.model;

import javafx.scene.image.Image;

public class Ordezkaritza {

    private String banderaPath;
    private Image bandera;
    private String herrialdea;
    private String artista;
    private String abestia;
    private Integer puntuak;


    public Ordezkaritza(String banderaPath, String herrialdea, String artista, String abestia, Integer puntuak) {
        this.banderaPath = banderaPath;
        this.bandera = new Image(banderaPath);
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.puntuak = puntuak;
    }

    public Ordezkaritza(String banderaPath, String herrialdea, String artista, String abestia) {
        this.banderaPath = banderaPath;
        this.bandera = new Image(banderaPath);
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.puntuak = 0;
    }

    public Ordezkaritza(String banderaPath, String herrialdea, Integer puntuak) {
        this.banderaPath = banderaPath;
        this.bandera = new Image(banderaPath);
        this.herrialdea = herrialdea;
        this.puntuak = puntuak;
    }

    public String getBanderaPath() {
        return banderaPath;
    }

    public void setBanderaPath(String banderaPath) {
        this.banderaPath = banderaPath;
    }

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public Integer getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(Integer puntuak) {
        this.puntuak = puntuak;
    }
}
