package ehu.isad.controller.db;


import ehu.isad.model.Bozkaketa;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BozkaketaDBKud {

    //singleton patroia

    private static BozkaketaDBKud instantzia = new BozkaketaDBKud();

    public static BozkaketaDBKud getInstantzia(){
        return instantzia;
    }

    private BozkaketaDBKud(){}

    public ArrayList<Bozkaketa> bozkatuDu(String pHerrialdea){
        ArrayList<Bozkaketa> emaitza = new ArrayList<>();
        try {
            //Declare a SELECT statement
            String selectStmt = "SELECT * FROM Bozkaketa WHERE bozkatuDu = '"+ pHerrialdea + "' AND urtea = strftime('%Y','now')";

            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(selectStmt);

            while (rs.next()) {

                String bozkatuaIzanDa = rs.getString("bozkatuaIzanDa");
                String bozkatuDu = rs.getString("bozkatuDu");
                Integer urtea = rs.getInt("urtea");
                Integer puntuak = rs.getInt("puntuak");

                emaitza.add(new Bozkaketa(bozkatuaIzanDa,bozkatuDu,urtea,puntuak));
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return emaitza;
    }

    public void puntuakGorde(ArrayList<Bozkaketa> bozkatuak) {
        for(Bozkaketa unekoa : bozkatuak){
            //Declare a INSERT statement
            //String insertStmt = "INSERT INTO Bozkaketa SET bozkatuaIzanDa = '" + unekoa.getBozkatuaIzanDa() + "', bozkatuDu = '" + unekoa.getBozkatuDu() + "', urtea = " + unekoa.getUrtea() + ", puntuak = " + unekoa.getPuntuak();
            String insertStmt = "INSERT INTO Bozkaketa VALUES('" + unekoa.getBozkatuaIzanDa() + "','" + unekoa.getBozkatuDu() + "', strftime('%Y','now')," + unekoa.getPuntuak() + ");";
            DBKudeatzaile.getInstantzia().execSQL(insertStmt);
        }
    }
}
