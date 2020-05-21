package ehu.pk.model;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class IntelligentIA {

    private static ArrayList<Point> emanAukeraGuztiak(Tableroa tableroa) {
        ArrayList<Point> emaitza = new ArrayList<>();
        // Sartu ahal diren kasilla guztiak lortu
        for (int zut = 0; zut < tableroa.getZutabeKop(); zut++) {
            int erren = tableroa.kokapenErrenkadaBilatu(zut);
            emaitza.add(new Point(erren,zut));
        }
        return emaitza;
    }

    public static Point emanAukeraHoberena(Tableroa tableroa) {

        ArrayList<Point> aukeraGuztiak = emanAukeraGuztiak(tableroa);
        Point galdu = null;
        Point irabazi = null;
        Point egoeraBerezia = null;

        HashMap<Point,ZenbatAlboko> albokoKop = new HashMap<>();

        // Fitxa batekin irabazten duen konprobatu
        for (Point aukera: aukeraGuztiak) {
            int erren = (int) aukera.getX();
            int zut = (int) aukera.getY();

            if (tableroa.irabaziDu(erren,zut, "IA")) {
                irabazi = new Point(erren, zut);
                return irabazi;
            }
        }

        // Fitxa batekin gal dezakeen konprobatu
        for (Point aukera: aukeraGuztiak) {
            int erren = (int) aukera.getX();
            int zut = (int) aukera.getY();

            if (tableroa.irabaziDu(erren,zut, "G")) {
                galdu = new Point(erren, zut);
                return galdu;
            }
        }

        // Fitxa batekin egoera berezia gertatzen den konprobatu
        for (Point aukera: aukeraGuztiak) {
            int erren = (int) aukera.getX();
            int zut = (int) aukera.getY();

            if(tableroa.egoeraBereziaDago(erren,zut,"G") && !irabaztekoAukeraEman(erren,zut,tableroa)){
                egoeraBerezia = new Point(erren, zut);
                return egoeraBerezia;
            }
        }

        // Albokoak bilatu
        for (Point aukera: aukeraGuztiak) {
            int erren = (int) aukera.getX();
            int zut = (int) aukera.getY();

            ZenbatAlboko albokoKopUnekoa = tableroa.albokorenBatDauka(erren,zut,"IA");
            if(albokoKopUnekoa != null && !irabaztekoAukeraEman(erren,zut,tableroa)){
                albokoKop.put(aukera,albokoKopUnekoa);
            }
        }

        // Kasilla irabazle ez badago edo galtzea saihesten duena ez badago
        // jokalariaren alboko fitxa gehien dituen aukera itzuli
        Iterator<Point> itr = albokoKop.keySet().iterator();
        int maxAlboko = 0;
        Point maxAlbokoPoint = null;
        while(itr.hasNext()){
            Point unekoa = itr.next();
            if(albokoKop.get(unekoa).getZenbat() == 2){
                return unekoa;
            }
            else if(albokoKop.get(unekoa).getZenbat() > maxAlboko){
                maxAlboko = albokoKop.get(unekoa).getZenbat();
                maxAlbokoPoint = unekoa;
            }
        }
        if(maxAlbokoPoint != null){
            return  maxAlbokoPoint;
        }
        else{
            return null;
        }
    }

    public static boolean irabaztekoAukeraEman(int pErrenkada, int pZutabea, Tableroa pTableroa){
        Tableroa tableroaKopia = pTableroa.tableroaKopiatu();
        tableroaKopia.setFitxa(pErrenkada,pZutabea,"IA");
        ArrayList<Point> aukeraPosibleak = emanAukeraGuztiak(tableroaKopia);
        for(int i=0; i<aukeraPosibleak.size(); i++){
            if(tableroaKopia.irabaziDu((int)aukeraPosibleak.get(i).getX(),(int)aukeraPosibleak.get(i).getY(),"G")){
                return  true;
            }
        }
        return false;
    }
}
