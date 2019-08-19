package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Klijent {
    private int id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String uloga;
    private String brojTelefona;

    public Klijent() {
    }

    public Klijent(int id, String ime, String prezime, String korisnickoIme, String lozinka, String uloga, String brojTelefona) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
        this.brojTelefona = brojTelefona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) throws Exception {
        if(uloga.toLowerCase().equals("klijent"))
            this.uloga=uloga.toUpperCase();
        else {
            throw new Exception("Odabrana kriva uloga korisnika! Pokušajte ponovo s ispravnom ulogom.");
        }
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public static Klijent add (Klijent k){
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("INSERT INTO klijent VALUES (null, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmnt.setString(1, k.getIme());
            stmnt.setString(2, k.getPrezime());
            stmnt.setString(3, k.getKorisnickoIme());
            stmnt.setString(4, k.getLozinka());
            stmnt.setString(5, k.getUloga());
            stmnt.setString(6, k.getBrojTelefona());
            stmnt.executeUpdate();
            ResultSet rs = stmnt.getGeneratedKeys();
            if (rs.next()){
                k.setId(rs.getInt(1));
            }
            return k;
        } catch (SQLException e) {
            System.out.println("Korisnik nije dodan: "+ e.getMessage());
            return null;
        }
    }

    public static boolean remove(Klijent k) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("DELETE FROM klijent WHERE id_klijent=?");
            stmnt.setInt(1, k.getId());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Korisnik nije obrisan: " + e.getMessage());
            return false;
        }
    }

    public static boolean update(Klijent k) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("UPDATE vlasnik SET ime=?, prezime=?, korisnickoIme=?, lozinka=?, uloga=?, brojTelefona=?  WHERE id_vlasnik=?");
            stmnt.setString(1, k.getIme());
            stmnt.setString(2, k.getPrezime());
            stmnt.setString(3, k.getKorisnickoIme());
            stmnt.setString(4, k.getLozinka());
            stmnt.setString(5, k.getUloga());
            stmnt.setString(6, k.getBrojTelefona());
            stmnt.setInt(7, k.getId());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Korisnik nije uređen: " + e.getMessage());
            return false;
        }
    }

    public static List<Klijent> select() {
        ObservableList<Klijent> klijent = FXCollections.observableArrayList();
        try {
            Statement stmnt = Database.CONNECTION.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM klijent");


            while(rs.next()){
                klijent.add(new Klijent(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
            return klijent;
        } catch (SQLException e) {
            System.out.println("Korisnici se ne mogu izvuci iz baze: " + e.getMessage());
            return klijent;
        }
    }
    public static Klijent get(int id) {
        try {
            PreparedStatement stmnt = Database.CONNECTION.prepareStatement("SELECT * FROM klijent WHERE id_klijent=?");
            stmnt.setInt(1, id);
            ResultSet rs = stmnt.executeQuery();


            if (rs.next()){
                return new Klijent(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
            }
            return null;
        } catch (SQLException e) {
            System.out.println("Korisnik se ne moze izvuci iz baze " + e.getMessage());
            return null;
        }
    }

}
