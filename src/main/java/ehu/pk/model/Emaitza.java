package ehu.pk.model;

import javafx.scene.image.Image;

import java.text.SimpleDateFormat;

public class Emaitza {

    private int posizioa;
    private Image posizioaImage;
    private String jokalaria;
    private long denbora;
    private String denboraString;
    private String data;

    public Emaitza(int posizioa, String jokalaria, long denbora, String data) {
        this.posizioa = posizioa;
        this.posizioaImage = new Image("pictures/" + posizioa + "posizioa.jpg");
        this.jokalaria = jokalaria;
        this.denbora = denbora;
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
        this.denboraString = dateFormat.format(denbora);
        this.data = data;
    }

    public String getJokalaria() {
        return jokalaria;
    }

    public void setJokalaria(String jokalaria) {
        this.jokalaria = jokalaria;
    }

    public double getDenbora() {
        return denbora;
    }

    public void setDenbora(long denbora) {
        this.denbora = denbora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPosizioa() {
        return posizioa;
    }

    public void setPosizioa(int posizioa) {
        this.posizioa = posizioa;
        this.posizioaImage = new Image("pictures/" + posizioa + "posizioa.jpg");
    }

    public String getDenboraString() {
        return denboraString;
    }

    public void setDenboraString(String denboraString) {
        this.denboraString = denboraString;
    }

    public Image getPosizioaImage() {
        return posizioaImage;
    }

    public void setPosizioaImage(Image posizioaImage) {
        this.posizioaImage = posizioaImage;
    }
}
