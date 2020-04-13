package ehu.pk.model;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tableroa {

    private String[][] tableroa;

    public Tableroa(){
        tableroa = new String[6][9];
        for(int i=0; i<tableroa.length; i++){
            for(int j=0; j<tableroa[0].length; j++){
                tableroa[i][j] = "Z";   //  Fitxa zuria
            }
        }
    }

    public int kokapenErrenkadaBilatu(int pZut){
        int i = tableroa.length-1;
        while(i>0 && !tableroa[i][pZut].equals("Z")){
            i--;
        }
        return i;
    }

    public String getFitxa(int pErrenkada, int pZutabea){
        return tableroa[pErrenkada][pZutabea];
    }

    public void setFitxa(int pErrenkada, int pZutabea, String pFitxa) {
        tableroa[pErrenkada][pZutabea] = pFitxa;
    }

    public int getErrenkadaKop(){
        return tableroa.length;
    }

    public int getZutabeKop(){
        return tableroa[0].length;
    }

    public boolean irabaziDu(int pErrenkada, int pZutabea, String pTxanda){
        if(irabaziDuBertikal(pErrenkada,pZutabea,pTxanda) || irabaziDuHorizontal(pErrenkada,pZutabea,pTxanda) || irabaziDuDiagonal(pErrenkada,pZutabea,pTxanda)){
            return true;
        }
        return false;
    }

    public Boolean irabaziDuBertikal(int pErrenkada, int pZutabea, String pTxanda){
        Boolean irabazi=false;
        int kont=1;
        if (pErrenkada<tableroa.length-3){
            int i=1;
            while (pErrenkada+i<tableroa.length && pTxanda.equals(tableroa[pErrenkada+i][pZutabea])){
                kont++;
                i++;
            }
            if (kont==4){
                irabazi=true;
            }
        }
        return irabazi;
    }


    public Boolean irabaziDuHorizontal(int pErrenkada, int pZutabea, String pTxanda){
        Boolean irabazi=false;
        int kont=1;
        int j=1;
        while (pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada][pZutabea+j])){
            kont++;
            j++;
        }
        if (kont==4){
            irabazi=true;
        }
        else{
            j=1;
            while ( pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada][pZutabea-j])){
                kont++;
                j++;
            }
            if (kont==4){
                irabazi=true;
            }
        }
        return irabazi;
    }


    private Boolean irabaziDuDiagonal(int pErrenkada, int pZutabea, String pTxanda) {
        Boolean irabazi=false;
        int kont=1;
        int i=1;
        int j=1;
        //ezkerra gora
        while (pErrenkada-i>=1 && pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada-i][pZutabea-j])){
            kont++;
            j++;
            i++;
        }
        if (kont==4){
            irabazi=true;
        }
        else{
            //eskuina behera
            j=1;
            i=1;
            while (pErrenkada+i<tableroa.length && pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada+i][pZutabea+j])){
                kont++;
                i++;
                j++;
            }
            if (kont==4){
                irabazi=true;
            }
            else{
                //eskuina gora
                kont=1;
                j=1;
                i=1;
                while (pErrenkada-i>=1 && pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada-i][pZutabea+j])){
                    kont++;
                    i++;
                    j++;
                }
                if (kont==4){
                    irabazi=true;
                }
                else{
                    //ezkerra behera
                    j=1;
                    i=1;
                    while (pErrenkada+i<tableroa.length && pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada+i][pZutabea-j])){
                        kont++;
                        i++;
                        j++;
                    }
                    if (kont==4){
                        irabazi=true;
                    }
                }
            }
        }
        return irabazi;
    }
}
