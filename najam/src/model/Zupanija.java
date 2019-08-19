package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Zupanija {
    private int id;
    private String naziv;

    public Zupanija() {
    }

    public Zupanija(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
/*
    public static Zupanija add (Zupanija z){
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("INSERT INTO zupanija VALUES (null, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmnt.setString(1, z.getNaziv());
            stmnt.executeUpdate();
            ResultSet rs = stmnt.getGeneratedKeys();
            if (rs.next()){
                z.setId(rs.getInt(1));
            }
            return z;
        } catch (SQLException e) {
            System.out.println("Zupanija nije dodana: "+ e.getMessage());
            return null;
        }
    }

    public static boolean remove(Zupanija z) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("DELETE FROM zupanija WHERE id_zupanija=?");
            stmnt.setInt(1, z.getId());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Zupanija nije obrisana: " + e.getMessage());
            return false;
        }
    }

    public static boolean update(Zupanija z) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("UPDATE zupanija SET vrstaStana=? WHERE id_zupanija=?");
            stmnt.setString(1, z.getNaziv());
            stmnt.setInt(2, z.getId());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Županija nije uređena: " + e.getMessage());
            return false;
        }
    }

    public static List<Zupanija> select() {
        ObservableList<Zupanija> zupanija = FXCollections.observableArrayList();
        try {
            Statement stmnt = Database.CONNECTION.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM zupanija");


            while(rs.next()){
                zupanija.add(new Zupanija(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
            return zupanija;
        } catch (SQLException e) {
            System.out.println("Zupanija se ne moze izvuci iz baze: " + e.getMessage());
            return zupanija;
        }
    }
*/
}
