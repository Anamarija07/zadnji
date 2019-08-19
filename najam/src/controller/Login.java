package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Database;
import model.Vlasnik;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    TextField korisnikTxt;

    @FXML
    TextField lozinkaTxt;

    @FXML
    Button prijavaBtn;

    @FXML
    ImageView slikaImg;

    public static Vlasnik logiraniKorisnik;

    @FXML
    public void login (ActionEvent a){
        String korisnickoIme = korisnikTxt.getText();
        String lozinka = lozinkaTxt.getText();
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("SELECT * FROM vlasnik WHERE korisnickoIme=? AND lozinka=?");
            //PreparedStatement stmnt1 = Database.CONNECTION.prepareStatement("SELECT * FROM klijent WHERE korisnickoIme=? AND lozinka=?");
            stmnt.setString(1, korisnickoIme);
            stmnt.setString(2, lozinka);
            /*stmnt1.setString(1, korisnickoIme);
            stmnt1.setString(2, lozinka);*/
            ResultSet rs = stmnt.executeQuery();

            if (rs.next()) {
                Login.logiraniKorisnik = Vlasnik.get(rs.getInt(1));
                Utils u = new Utils();
                if (logiraniKorisnik.getUloga().equals("VLASNIK")) {
                    u.showNewWindow("strVlasnik", a);
                }
                else if (logiraniKorisnik.getUloga().equals("KLIJENT")){
                    u.showNewWindow("strKlijent", a);
                }
                else {
                    u.showNewWindow("strAdmin", a);
                }
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
