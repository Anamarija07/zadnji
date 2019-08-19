package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VrstaStana {
    private int id;
    private String vrsta;

    public VrstaStana() {
    }

    public VrstaStana(int id, String vrsta) {
        this.id = id;
        this.vrsta = vrsta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }
/*
    public static VrstaStana add (VrstaStana vs){
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("INSERT INTO vrstaStana VALUES (null, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmnt.setString(1, vs.getVrsta());
            stmnt.executeUpdate();
            ResultSet rs = stmnt.getGeneratedKeys();
            if (rs.next()){
                vs.setId(rs.getInt(1));
            }
            return vs;
        } catch (SQLException e) {
            System.out.println("Vrsta stana nije dodana: "+ e.getMessage());
            return null;
        }
    }

    public static boolean remove(VrstaStana vs) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("DELETE FROM vrstaStana WHERE id_vrstaStana=?");
            stmnt.setInt(1, vs.getId());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Vrsta stana nije obrisana: " + e.getMessage());
            return false;
        }
    }

    public static boolean update(VrstaStana vs) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("UPDATE vrstaStana SET vrstaStana=? WHERE id_vrstaStana=?");
            stmnt.setString(1, vs.getVrsta());
            stmnt.setInt(2, vs.getId());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Vrsta stana nije uređena: " + e.getMessage());
            return false;
        }
    }

    public static List<VrstaStana> select() {
        ObservableList<VrstaStana> vrstaStana = FXCollections.observableArrayList();
        try {
            Statement stmnt = Database.CONNECTION.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM vrstaStana");


            while(rs.next()){
                vrstaStana.add(new VrstaStana(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
            return vrstaStana;
        } catch (SQLException e) {
            System.out.println("Vrsta stana se ne moze izvuci iz baze: " + e.getMessage());
            return vrstaStana;
        }
    }*/
}
