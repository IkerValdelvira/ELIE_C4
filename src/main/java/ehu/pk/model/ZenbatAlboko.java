package ehu.pk.model;

public class ZenbatAlboko {
    private String posizioa;
    private int zenbat;

    public ZenbatAlboko(String posizioa, int zenbat) {
        this.posizioa = posizioa;
        this.zenbat = zenbat;
    }

    public String getPosizioa() {
        return posizioa;
    }

    public void setPosizioa(String posizioa) {
        this.posizioa = posizioa;
    }

    public int getZenbat() {
        return zenbat;
    }

    public void setZenbat(int zenbat) {
        this.zenbat = zenbat;
    }
}
