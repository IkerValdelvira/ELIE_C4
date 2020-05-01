package ehu.pk.model;

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

    private Boolean irabaziDuBertikal(int pErrenkada, int pZutabea, String pTxanda){
        Boolean irabazi=false;
        int kont=1;
        if (pErrenkada<tableroa.length-3){
            int i=1;
            while (pErrenkada+i<tableroa.length && pTxanda.equals(tableroa[pErrenkada+i][pZutabea])){
                kont++;
                i++;
            }
            if (kont>=4){
                irabazi=true;
            }
        }
        return irabazi;
    }


    private Boolean irabaziDuHorizontal(int pErrenkada, int pZutabea, String pTxanda){
        Boolean irabazi=false;
        int kont=1;
        int j=1;
        while (pZutabea+j<tableroa[0].length && pTxanda.equals(tableroa[pErrenkada][pZutabea+j])){
            kont++;
            j++;
        }
        if (kont>=4){
            irabazi=true;
        }
        else{
            j=1;
            while ( pZutabea-j>=0 && pTxanda.equals(tableroa[pErrenkada][pZutabea-j])){
                kont++;
                j++;
            }
            if (kont>=4){
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
        if (kont>=4){
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
            if (kont>=4){
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
                if (kont>=4){
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
                    if (kont>=4){
                        irabazi=true;
                    }
                }
            }
        }
        return irabazi;
    }

    public Boolean irabaziDuJokalariak(String jokalaria) {
        Boolean irabaziDu = false;
        for (int erren = 1; erren < tableroa.length + 1; erren++) {  // Errenkada
            for (int zut = 0; zut < tableroa[0].length; zut++) {     // Zutabe
                if (irabaziDu(erren,zut,jokalaria)) {
                    irabaziDu = true;
                    break;
                }
            }
        }

        return irabaziDu;
    }

    /*
    public boolean albokorenBatDauka(int errenkada, int zutabe, String jokalari) {

        if (errenkada < 5) {
            if (jokalari.equals(tableroa[errenkada+1][zutabe])) // Behean
                return true;
        }
        else if (errenkada > 1) {
            if (jokalari.equals(tableroa[errenkada-1][zutabe])) // Goian
                return true;
        }
        else if (zutabe < 0) {
            if (jokalari.equals(tableroa[errenkada][zutabe+1])) // Ezkerrean
                return true;
        }
        else if (zutabe < 8) {
            if (jokalari.equals(tableroa[errenkada][zutabe+1])) // Eskuinean
                return true;
        }

        else if ((0 < zutabe) && ( zutabe < 8) && (1 < errenkada) && (errenkada < 5)) {
            if (jokalari.equals(tableroa[errenkada+1][zutabe-1])) // Behean ezkerrean
                return true;
            else if (jokalari.equals(tableroa[errenkada+1][zutabe+1])) // Behean eskuinean
                return true;
            else if (jokalari.equals(tableroa[errenkada-1][zutabe-1])) // Goian ezkerrean
                return true;
            else if (jokalari.equals(tableroa[errenkada-1][zutabe+1])) // Goian eskuinean
                return true;
        }

        return false;

    }
    */

    public ZenbatAlboko albokorenBatDauka(int pErrenkada, int pZutabea, String pJokalari) {
        int[] zenbatAlboan = new int[4];
        zenbatAlboan[0] = zenbatBehean(pErrenkada,pZutabea,pJokalari);
        zenbatAlboan[1] = zenbatHorizontalean(pErrenkada,pZutabea,pJokalari);
        zenbatAlboan[2] = zenbatDiagonalEzkerra(pErrenkada,pZutabea,pJokalari);
        zenbatAlboan[3] = zenbatDiagonalEskuina(pErrenkada,pZutabea,pJokalari);
        int max = 0;
        int maxPos = -1;
        for(int i=0; i< zenbatAlboan.length; i++){
            if(zenbatAlboan[i] > max && lauKokatzekoPosible(pErrenkada,pZutabea,pJokalari,zenbatAlboan[i],i)){
                max = zenbatAlboan[i];
                maxPos = i;
            }
        }
        if(maxPos == 0){
            return new ZenbatAlboko("Behean",max);
        }
        else if(maxPos == 1){
            return new ZenbatAlboko("Horizontalean",max);
        }
        else if(maxPos == 2){
            return new ZenbatAlboko("DiagonaleanEzkerra",max);
        }
        else if(maxPos == 3){
            return new ZenbatAlboko("DiagonaleanEskuina",max);
        }
        else{
            return null;
        }
    }

    private int zenbatBehean(int pErrenkada, int pZutabea, String pJokalari){
        int kont = 0;
        if(pErrenkada < tableroa.length-1){
            int i = 1;
            while(pErrenkada+i < tableroa.length && pJokalari.equals(tableroa[pErrenkada+i][pZutabea])){
                i ++;
                kont ++;
            }
        }
        return kont;
    }

    private int zenbatHorizontalean(int pErrenkada, int pZutabea, String pJokalaria){
        int kont = 0;
        int j = 1;
        while (pZutabea+j < tableroa[0].length && pJokalaria.equals(tableroa[pErrenkada][pZutabea+j])){
            kont ++;
            j ++;
        }
        j = 1;
        while ( pZutabea-j >= 0 && pJokalaria.equals(tableroa[pErrenkada][pZutabea-j])){
            kont ++;
            j ++;
        }
        return kont;
    }

    private int zenbatDiagonalEzkerra(int pErrenkada, int pZutabea, String pJokalari){
        int kont=0;
        int i=1;
        int j=1;
        //ezkerra gora
        while (pErrenkada-i>=1 && pZutabea-j>=0 && pJokalari.equals(tableroa[pErrenkada-i][pZutabea-j])){
            kont++;
            j++;
            i++;
        }
        //eskuina behera
        j=1;
        i=1;
        while (pErrenkada+i<tableroa.length && pZutabea+j<tableroa[0].length && pJokalari.equals(tableroa[pErrenkada+i][pZutabea+j])){
            kont++;
            i++;
            j++;
        }
        return kont;
    }

    private int zenbatDiagonalEskuina(int pErrenkada, int pZutabea, String pJokalari) {
        int kont = 0;
        int j = 1;
        int i = 1;
        //eskuina gora
        while (pErrenkada - i >= 1 && pZutabea + j < tableroa[0].length && pJokalari.equals(tableroa[pErrenkada - i][pZutabea + j])) {
            kont++;
            i++;
            j++;
        }
        //ezkerra behera
        j = 1;
        i = 1;
        while (pErrenkada + i < tableroa.length && pZutabea - j >= 0 && pJokalari.equals(tableroa[pErrenkada + i][pZutabea - j])) {
            kont++;
            i++;
            j++;
        }
        return kont;
    }

    private boolean lauKokatzekoPosible(int pErrenkada, int pZutabea, String pJokalaria, int pZenbatAlboan, int noranzkoa) {
        if(noranzkoa == 0){
            if(pZenbatAlboan == 1 && pErrenkada >=2){
                return true;
            }
            else if(pZenbatAlboan == 2 && pErrenkada >=1){
                return true;
            }
        }
        else if(noranzkoa == 1){
            // ... [UNEKOA] [JOK] [LIBRE] [LIBRE] ...
            if(pZenbatAlboan == 1
                    && pZutabea+3 < tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+3])){
                return true;
            }
            // ... [LIBRE] [UNEKOA] [JOK] [LIBRE] ...
            else if(pZenbatAlboan == 1
                    && pZutabea >= 1 && pZutabea+2 < tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-1])){
                return true;
            }
            // ... [LIBRE] [LIBRE] [UNEKOA] [JOK] ...
            else if(pZenbatAlboan == 1
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-2])){
                return true;
            }
            // ... [JOK] [UNEKOA] [LIBRE] [LIBRE] ...
            else if(pZenbatAlboan == 1
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+2])){
                return true;
            }
            // ... [LIBRE] [JOK] [UNEKOA] [LIBRE] ...
            else if(pZenbatAlboan == 1
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-2])){
                return true;
            }
            // ... [LIBRE] [LIBRE] [JOK] [UNEKOA] ...
            else if(pZenbatAlboan == 1
                    && pZutabea-3 >= 0
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-3])){
                return true;
            }
            // ... [UNEKOA] [JOK] [JOK] [LIBRE] ...
            else if(pZenbatAlboan == 2
                    && pZutabea+3 < tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+3])){
                return true;
            }
            // ... [LIBRE] [UNEKOA] [JOK] [JOK] ...
            else if(pZenbatAlboan == 2
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-1])){
                return true;
            }
            // ... [JOK] [JOK] [UNEKOA] [LIBRE] ...
            else if(pZenbatAlboan == 2
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+1])){
                return true;
            }
            // ... [LIBRE] [JOK] [JOK] [UNEKOA] ...
            else if(pZenbatAlboan == 2
                    && pZutabea-3 >= 0
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-3])){
                return true;
            }
            // ... [JOK] [UNEKOA] [JOK] [LIBRE] ...
            else if(pZenbatAlboan == 2
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea+2])){
                return true;
            }
            // ... [LIBRE] [JOK] [UNEKOA] [JOK] ...
            else if(pZenbatAlboan == 2
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada][pZutabea-2])){
                return true;
            }
        }
        else if(noranzkoa == 2) {
            // ... [UNEKOA] [...]   [...]    [...]   ...
            // ... [...]    [JOK]   [...]    [...]   ...
            // ... [...]    [...]   [LIBRE]  [...]   ...
            // ... [...]    [...]   [...]    [LIBRE] ...
            if (pZenbatAlboan == 1
                    && pErrenkada+3 < tableroa.length && pZutabea+3 < tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea + 2])
                    && "Z".equals(tableroa[pErrenkada+3][pZutabea + 3])) {
                return true;
            }
            // ... [LIBRE]  [...]    [...]    [...]   ...
            // ... [...]    [UNEKOA] [...]    [...]   ...
            // ... [...]    [...]    [JOK]    [...]   ...
            // ... [...]    [...]    [...]    [LIBRE] ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >=1 && pZutabea<= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada-1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea+2])) {
                return true;
            }
            // ... [LIBRE]  [...]    [...]    [...]   ...
            // ... [...]    [LIBRE]  [...]    [...]   ...
            // ... [...]    [...]    [UNEKOA] [...]   ...
            // ... [...]    [...]    [...]    [JOK]   ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >=2 && pZutabea<= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada-1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea-2])) {
                return true;
            }
            // ... [JOK]  [...]     [...]    [...]   ...
            // ... [...]  [UNEKOA]  [...]    [...]   ...
            // ... [...]  [...]     [LIBRE]  [...]   ...
            // ... [...]  [...]     [...]    [LIBRE] ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >=1 && pZutabea<= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea+2])) {
                return true;
            }
            // ... [LIBRE] [...]  [...]    [...]   ...
            // ... [...]   [JOK]  [...]    [...]   ...
            // ... [...]   [...]  [UNEKOA] [...]   ...
            // ... [...]   [...]  [...]    [LIBRE] ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >=2 && pZutabea<= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea-2])) {
                return true;
            }
            // ... [LIBRE] [...]    [...]  [...]    ...
            // ... [...]   [LIBRE]  [...]  [...]    ...
            // ... [...]   [...]    [JOK]  [...]    ...
            // ... [...]   [...]    [...]  [UNEKOA] ...
            else if (pZenbatAlboan == 1
                    && pErrenkada-3 >= 0 && pZutabea-3 >=0
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada-3][pZutabea-3])) {
                return true;
            }
            // ... [UNEKOA] [...]   [...]  [...]    ...
            // ... [...]    [JOK]   [...]  [...]    ...
            // ... [...]    [...]   [JOK]  [...]    ...
            // ... [...]    [...]   [...]  [LIBRE]  ...
            else if (pZenbatAlboan == 1
                    && pErrenkada+3 < tableroa.length && pZutabea+3 >= tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada+2][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada+3][pZutabea+3])) {
                return true;
            }
            // ... [LIBRE] [...]    [...]  [...]  ...
            // ... [...]   [UNEKOA] [...]  [...]  ...
            // ... [...]   [...]    [JOK]  [...]  ...
            // ... [...]   [...]    [...]  [JOK]  ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada+2][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada-1][pZutabea-1])) {
                return true;
            }
            // ... [JOK]  [...]  [...]    [...]  ...
            // ... [...]  [JOK]  [...]    [...]  ...
            // ... [...]  [...]  [UNEKOA] [...]  ...
            // ... [...]  [...]  [...]    [LIBRE]  ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada-2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada+1][pZutabea+1])) {
                return true;
            }
            // ... [LIBRE] [...]  [...]  [...]    ...
            // ... [...]   [JOK]  [...]  [...]    ...
            // ... [...]   [...]  [JOK]  [...]    ...
            // ... [...]   [...]  [...]  [UNEKOA] ...
            else if (pZenbatAlboan == 1
                    && pErrenkada-3 >= 0 && pZutabea-3 >= 0
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada-2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada-3][pZutabea-3])) {
                return true;
            }
            // ... [LIBRE] [...]  [...]    [...]  ...
            // ... [...]   [JOK]  [...]    [...]  ...
            // ... [...]   [...]  [UNEKOA] [...]  ...
            // ... [...]   [...]  [...]    [JOK]  ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >=2 && pErrenkada <= tableroa.length-2
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea-2])) {
                return true;
            }
            // ... [JOK]  [...]    [...]  [...]    ...
            // ... [...]  [UNEKOA] [...]  [...]    ...
            // ... [...]  [...]    [JOK]  [...]    ...
            // ... [...]  [...]    [...]  [LIBRE]  ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >=1 && pErrenkada <= tableroa.length-3
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea+2])) {
                return true;
            }
        }
        else if(noranzkoa == 3){
            // ... [...]   [...]   [...]  [UNEKOA] ...
            // ... [...]   [...]   [JOK]  [...]   ...
            // ... [...]   [LIBRE] [...]  [...]   ...
            // ... [LIBRE] [...]   [...]  [...]   ...
            if (pZenbatAlboan == 1
                    && pErrenkada+3 < tableroa.length && pZutabea-3 >= 0
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada+3][pZutabea-3])) {
                return true;
            }
            // ... [...]   [...]  [...]    [LIBRE] ...
            // ... [...]   [...]  [UNEKOA] [...]   ...
            // ... [...]   [JOK]  [...]    [...]   ...
            // ... [LIBRE] [...]  [...]    [...]   ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada-1][pZutabea+1])) {
                return true;
            }
            // ... [...]  [...]    [...]   [LIBRE] ...
            // ... [...]  [...]    [LIBRE] [...]   ...
            // ... [...]  [UNEKOA] [...]   [...]   ...
            // ... [JOK]  [...]    [...]   [...]   ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada-1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea+2])) {
                return true;
            }
            // ... [...]   [...]   [...]    [JOK] ...
            // ... [...]   [...]   [UNEKOA] [...]   ...
            // ... [...]   [LIBRE] [...]    [...]   ...
            // ... [LIBRE] [...]   [...]    [...]   ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea-2])) {
                return true;
            }
            // ... [...]   [...]    [...]  [LIBRE] ...
            // ... [...]   [...]    [JOK]  [...]   ...
            // ... [...]   [UNEKOA] [...]  [...]   ...
            // ... [LIBRE] [...]    [...]  [...]   ...
            else if (pZenbatAlboan == 1
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea+2])) {
                return true;
            }
            // ... [...]    [...]  [...]   [LIBRE] ...
            // ... [...]    [...]  [LIBRE] [...]   ...
            // ... [...]    [JOK]  [...]   [...]   ...
            // ... [UNEKOA] [...]  [...]   [...]   ...
            else if (pZenbatAlboan == 1
                    && pErrenkada-3 >= 0 && pZutabea+3 < tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && "Z".equals(tableroa[pErrenkada-2][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada-3][pZutabea+3])) {
                return true;
            }
            // ... [...]    [...]    [...]  [JOK]  ...
            // ... [...]    [...]    [JOK]  [...]  ...
            // ... [...]    [UNEKOA] [...]  [...]  ...
            // ... [LIBRE]  [...]    [...]  [...]  ...
            else if (pZenbatAlboan == 2
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada-2][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada+1][pZutabea-1])) {
                return true;
            }
            // ... [...]    [...]  [...]  [LIBRE]  ...
            // ... [...]    [...]  [JOK]  [...]   ...
            // ... [...]    [JOK]  [...]  [...]   ...
            // ... [UNEKOA] [...]  [...]  [...]   ...
            else if (pZenbatAlboan == 2
                    && pErrenkada-3 >= 0 && pZutabea+3 < tableroa[0].length
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada-2][pZutabea+2])
                    && "Z".equals(tableroa[pErrenkada-3][pZutabea+3])) {
                return true;
            }
            // ... [...]   [...]  [...]  [UNEKOA] ...
            // ... [...]   [...]  [JOK]  [...]   ...
            // ... [...]   [JOK]  [...]  [...]   ...
            // ... [LIBRE] [...]  [...]  [...]   ...
            else if (pZenbatAlboan == 2
                    && pErrenkada+3 < tableroa.length && pZutabea-3 >= 0
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada+2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada+3][pZutabea-3])) {
                return true;
            }
            // ... [...]  [...]  [...]    [LIBRE] ...
            // ... [...]  [...]  [UNEKOA] [...]   ...
            // ... [...]  [JOK]  [...]    [...]   ...
            // ... [JOK]  [...]  [...]    [...]   ...
            else if (pZenbatAlboan == 2
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && pJokalaria.equals(tableroa[pErrenkada+2][pZutabea-2])
                    && "Z".equals(tableroa[pErrenkada-1][pZutabea+1])) {
                return true;
            }
            // ... [...]   [...]  [...]    [JOK]  ...
            // ... [...]   [...]  [UNEKOA] [...]  ...
            // ... [...]   [JOK]  [...]    [...]  ...
            // ... [LIBRE] [...]  [...]    [...]  ...
            else if (pZenbatAlboan == 2
                    && pErrenkada >= 1 && pErrenkada <= tableroa.length-3
                    && pZutabea >= 2 && pZutabea <= tableroa[0].length-2
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea-2])) {
                return true;
            }
            // ... [...] [...]    [...] [LIBRE] ...
            // ... [...] [...]    [JOK] [...]  ...
            // ... [...] [UNEKOA] [...] [...]  ...
            // ... [JOK] [...]    [...] [...]  ...
            else if (pZenbatAlboan == 2
                    && pErrenkada >= 2 && pErrenkada <= tableroa.length-2
                    && pZutabea >= 1 && pZutabea <= tableroa[0].length-3
                    && pJokalaria.equals(tableroa[pErrenkada-1][pZutabea+1])
                    && pJokalaria.equals(tableroa[pErrenkada+1][pZutabea-1])
                    && "Z".equals(tableroa[pErrenkada+2][pZutabea-2])) {
                return true;
            }
        }
        return false;
    }

    public boolean egoeraBereziaDago(int erren, int zut, String pJokalaria) {
        if(zut > 0 && zut < tableroa[0].length-1){
            // ... [LIBRE] [UNEKOA] [JOK] [JOK] [LIBRE] ...
            if("Z".equals(tableroa[erren][zut-1]) && (erren == tableroa.length-1 || !"Z".equals(tableroa[erren+1][zut-1]))){
                if(zut <= 5
                        && pJokalaria.equals(tableroa[erren][zut+1])
                        && pJokalaria.equals(tableroa[erren][zut+2])
                        && "Z".equals(tableroa[erren][zut+3])
                        && (erren == tableroa.length-1 || !"Z".equals(tableroa[erren+1][zut+3]))){
                    return true;
                }
            }
            // ... [LIBRE] [JOK] [JOK] [UNEKOA] [LIBRE] ...
            else if("Z".equals(tableroa[erren][zut+1]) && (erren == tableroa.length-1 || !"Z".equals(tableroa[erren+1][zut+1]))){
                if(zut >= 3
                        && pJokalaria.equals(tableroa[erren][zut-1])
                        && pJokalaria.equals(tableroa[erren][zut-2])
                        && "Z".equals(tableroa[erren][zut-3])
                        && (erren == tableroa.length-1 || !"Z".equals(tableroa[erren+1][zut-3]))){
                    return true;
                }
            }
            // ... [LIBRE] [JOK] [UNEKOA] [JOK] [LIBRE] ...
            else if(pJokalaria.equals(tableroa[erren][zut-1]) && pJokalaria.equals(tableroa[erren][zut+1]) && (erren == tableroa.length-1 || (!"Z".equals(tableroa[erren+1][zut-1]) && !"Z".equals(tableroa[erren+1][zut+1])))){
                if(zut >= 2 && zut <= tableroa[0].length-3
                        && "Z".equals(tableroa[erren][zut+2])
                        && "Z".equals(tableroa[erren][zut-2])
                        && (erren == tableroa.length-1 || (!"Z".equals(tableroa[erren+1][zut-2]) && !"Z".equals(tableroa[erren+1][zut+2])))){
                    return true;
                }
            }
        }
        return false;
    }

    public Tableroa tableroaKopiatu() {
        Tableroa kopia = new Tableroa();
        for(int i=0; i<tableroa.length; i++){
            for(int j=0; j<tableroa[0].length; j++){
                kopia.setFitxa(i,j,tableroa[i][j]);
            }
        }
        return  kopia;
    }
}
