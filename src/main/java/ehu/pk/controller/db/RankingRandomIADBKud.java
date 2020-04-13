package ehu.pk.controller.db;


import ehu.pk.model.Emaitza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RankingRandomIADBKud {

    //singleton patroia

    private static RankingRandomIADBKud instantzia = new RankingRandomIADBKud();

    public static RankingRandomIADBKud getInstantzia(){
        return instantzia;
    }

    private RankingRandomIADBKud() {}

    public void emaitzaSartu(Emaitza pEmaitza) {
        //Declare a INSERT statement
        String insertStmt = "INSERT INTO RankingRandomIA VALUES('" + pEmaitza.getPosizioa() + "','" + pEmaitza.getJokalaria() + "','" + pEmaitza.getDenbora() + "','" + pEmaitza.getData() + "');";
        DBKudeatzaile.getInstantzia().execSQL(insertStmt);
    }

    public void emaitzakSartu(ObservableList<Emaitza> pEmaitzak) {
        for(Emaitza unekoa : pEmaitzak){
            //Declare a INSERT statement
            String insertStmt = "INSERT INTO RankingRandomIA VALUES('" + unekoa.getPosizioa() + "','" + unekoa.getJokalaria() + "','" + unekoa.getDenbora() + "','" + unekoa.getData() + "');";
            DBKudeatzaile.getInstantzia().execSQL(insertStmt);
        }
    }

    public ObservableList<Emaitza> rankingLortu() {
        ObservableList<Emaitza> ranking = FXCollections.observableArrayList();;
        try {

            //Declare a SELECT statement
            String selectStmt = "SELECT * FROM RankingRandomIA";

            ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(selectStmt);

            while (rs.next()) {

                int posizioa = rs.getInt("Posizioa");
                String jokalaria = rs.getString("Jokalaria");
                long denbora = rs.getInt("Denbora");
                String data = rs.getString("Data");

                ranking.add(new Emaitza(posizioa,jokalaria,denbora,data));
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ranking;
    }

    public void emaitzaEzabatu(Emaitza pEmaitza) {
        //Declare a DELETE statement
        String statement = "DELETE FROM RankingRandomIA WHERE Jokalaria = '" + pEmaitza.getJokalaria() + "' AND Denbora = '" + pEmaitza.getDenbora() + "' AND Data = '" + "';";
        DBKudeatzaile.getInstantzia().execSQL(statement);
    }

    public void emaitzakEzabatu() {
        //Declare a DELETE statement
        String statement = "DELETE FROM RankingRandomIA;";
        DBKudeatzaile.getInstantzia().execSQL(statement);
    }

}
