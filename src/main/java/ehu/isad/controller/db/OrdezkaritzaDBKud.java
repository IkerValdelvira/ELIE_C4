package ehu.isad.controller.db;


import ehu.isad.model.Bozkaketa;
import ehu.isad.model.Ordezkaritza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdezkaritzaDBKud {

    //singleton patroia

    private static OrdezkaritzaDBKud instantzia = new OrdezkaritzaDBKud();

    public static OrdezkaritzaDBKud getInstantzia(){
        return instantzia;
    }

    private OrdezkaritzaDBKud(){}

    public ArrayList<Ordezkaritza> lortuOrdezkaritzak(){
        ArrayList<Ordezkaritza> emaitza = new ArrayList<>();
        try {
            //Declare a SELECT statement
            String selectStmt = "SELECT H.bandera, O.herrialdea, O.artista, O.abestia FROM Herrialde H INNER JOIN Ordezkaritza O ON H.izena = O.herrialdea WHERE O.urtea = strftime('%Y','now')";

            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(selectStmt);

            while (rs.next()) {

                String bandera = rs.getString("bandera") + ".png";
                String herrialdea = rs.getString("herrialdea");
                String artista = rs.getString("artista");
                String abestia = rs.getString("abestia");

                emaitza.add(new Ordezkaritza(bandera,herrialdea,artista,abestia));
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return emaitza;
    }

    public void puntuakEguneratu(ArrayList<Ordezkaritza> ordezkaritzaEguneratuak) {
        for(Ordezkaritza unekoa : ordezkaritzaEguneratuak){
            //Declare a UPDATE statement
            String updateStmt = "UPDATE Ordezkaritza SET puntuak = (puntuak + " + unekoa.getPuntuak() + ") WHERE herrialdea = '" + unekoa.getHerrialdea() + "' AND urtea = strftime('%Y','now')";
            DBKudeatzaile.getInstantzia().execSQL(updateStmt);
        }
    }

    public ArrayList<Ordezkaritza> lortuTop3Ordezkariak() {
        ArrayList<Ordezkaritza> emaitza = new ArrayList<>();
        try {
            //Declare a SELECT statement
            String selectStmt = "SELECT H.bandera, O.herrialdea, O.puntuak FROM Herrialde H INNER JOIN Ordezkaritza O ON H.izena = O.herrialdea WHERE O.urtea = strftime('%Y','now') ORDER BY O.puntuak DESC LIMIT 3";

            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(selectStmt);

            while (rs.next()) {

                String bandera = rs.getString("bandera") + ".png";
                String herrialdea = rs.getString("herrialdea");
                Integer puntuak = rs.getInt("puntuak");

                emaitza.add(new Ordezkaritza(bandera,herrialdea,puntuak));
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return emaitza;
    }
}
