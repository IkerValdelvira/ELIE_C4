package ehu.isad.controller.db;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HerrialdeaDBKud {

    //singleton patroia

    private static HerrialdeaDBKud instantzia = new HerrialdeaDBKud();

    public static HerrialdeaDBKud getInstantzia(){
        return instantzia;
    }

    private HerrialdeaDBKud(){}

    public ArrayList<String> lortuPartaideak(){
        ArrayList<String> emaitza = new ArrayList<>();
        try {
            //Declare a SELECT statement
            String selectStmt = "SELECT izena FROM ParteHartzea WHERE etorrikoDa = 'BAI' AND urtea = strftime('%Y','now')";

            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(selectStmt);

            while (rs.next()) {

                String herrialdeIzena = rs.getString("izena");

                emaitza.add(herrialdeIzena);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return emaitza;
    }

    public String banderaLortu(String pHerrialdea) {
        String emaitza = null;
        try {
            //Declare a SELECT statement
            String selectStmt = "SELECT bandera FROM Herrialde WHERE izena = '" + pHerrialdea + "'";

            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(selectStmt);

            while (rs.next()) {

                emaitza = rs.getString("bandera");

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
