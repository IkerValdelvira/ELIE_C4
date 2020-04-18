package ehu.pk.controller;

import ehu.pk.controller.ui.MainKud;
import ehu.pk.model.Tableroa;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class IntelligentIA {

    private static int globalDepth = 2;

    public static Point emanZutabeHoberena (Tableroa tableroa) {
        Point aukeraHoberena = null;
        Double max = Double.NEGATIVE_INFINITY;
        Double v = Double.NEGATIVE_INFINITY;
        ArrayList<Point> aukeraPosibleGuztiak = emanAukeraGuztiak(tableroa);
        for (Point aukera: aukeraPosibleGuztiak) {
            v = minValue(generateSuccessor(aukera, tableroa), 0);
            if (max < v) {
                max = v;
                aukeraHoberena = aukera;
            }
        }

        return aukeraHoberena;
    }

    private static Double minValue(Tableroa tableroa, int depth) {
        Double v = Double.POSITIVE_INFINITY;
        Boolean isLose = null;  // Tableroa egoera honetan ea norbaitek galdu duen
        Boolean isWin = null;  // Tableroa egoera honetan ea norbaitek irabazi duen
        if (globalDepth == depth || isLose == true || isWin == true)
            return evaluationFunction(tableroa);
        else {
            depth ++;
            ArrayList<Point> aukeraPosibleGuztiak = emanAukeraGuztiak(tableroa);
            for (Point aukera: aukeraPosibleGuztiak)
                v = Double.min(v, maxValue(generateSuccessor(aukera, tableroa), depth));
        }
        return v;
    }

    private static Double maxValue(Tableroa tableroa, int depth) {
        Double v = Double.NEGATIVE_INFINITY;
        Boolean isLose = tableroa.irabaziDuJokalariak("G");  // Tableroa egoera honetan ea norbaitek galdu duen
        Boolean isWin = tableroa.irabaziDuJokalariak("IA");;  // Tableroa egoera honetan ea norbaitek irabazi duen
        if (globalDepth == depth || isLose == true || isWin == true)
            return evaluationFunction(tableroa);
        else {
            ArrayList<Point> aukeraPosibleGuztiak = emanAukeraGuztiak(tableroa);
            for (Point aukera: aukeraPosibleGuztiak)
                v = Double.max(v, minValue(generateSuccessor(aukera, tableroa), depth));
        }
        return v;
    }

    private static Double evaluationFunction(Tableroa tableroa) {

        if(tableroa.irabaziDuJokalariak("IA"))
            return Double.MAX_VALUE;
        else if (tableroa.irabaziDuJokalariak("G"))
            return Double.MIN_VALUE;
        else {
            Double emaitza = null;


            return emaitza;
        }
    }

    private static Tableroa generateSuccessor(Point aukera, Tableroa tableroa) {
        Tableroa tableroAux = tableroa;
        tableroa.setFitxa((int) aukera.getX(),(int) aukera.getY(),"IA");
        return tableroAux;
    }

    private static ArrayList<Point> emanAukeraGuztiak(Tableroa tableroa) {
        ArrayList<Point> emaitza = new ArrayList<>();
        // Sartu ahal diren kasilla guztiak lortu
        for (int zut = 0; zut < tableroa.getZutabeKop(); zut++) {
            int erren = tableroa.kokapenErrenkadaBilatu(zut);
            if (erren != 0)
                emaitza.add(new Point(erren,zut));
        }
        return emaitza;
    }

    public static Point emanAukeraHoberena(Tableroa tableroa) {

        ArrayList<Point> aukeraGuztiak = emanAukeraGuztiak(tableroa);
        System.out.println(aukeraGuztiak);
        Point galdu = null;
        Point irabazi = null;
        Point alboko = null;

        for (Point aukera: aukeraGuztiak) {
            int erren = (int) aukera.getX();
            int zut = (int) aukera.getY();
            tableroa.setFitxa(erren,zut,"G");
            if (tableroa.irabaziDu(erren,zut, "G"))
                galdu = new Point(erren,zut);

            tableroa.setFitxa(erren, zut, "IA");
            if (tableroa.irabaziDu(erren,zut, "IA"))
                irabazi = new Point(erren,zut);

            if (tableroa.albokorenBatDauka(erren,zut,"IA"))
                alboko = new Point(erren,zut);
            tableroa.setFitxa(erren,zut,"Z");
        }

        if(galdu != null)
            return galdu;
        else if(irabazi !=null)
            return irabazi;
        else if(alboko != null)
            return alboko;
        else
            return null;
    }

    public static void main(String[] args) {
        //emanZutabeHoberena(null);
        Tableroa t = new Tableroa();
//        for (int i = 1; i < t.getErrenkadaKop() + 1; i++) {
//            int j = t.kokapenErrenkadaBilatu(0);
//            t.setFitxa(j, 0, "G");
//        }
        t.setFitxa(5,0,"G");
        t.setFitxa(4,0,"G");
        t.setFitxa(3,0,"G");
        t.setFitxa(2,0,"G");
//        t.setFitxa(1,0, "G");

        System.out.println(emanAukeraGuztiak(t));


    }

}
