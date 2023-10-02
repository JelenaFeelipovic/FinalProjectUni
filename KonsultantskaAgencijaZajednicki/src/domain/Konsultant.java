/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jela
 */
public class Konsultant extends AbstractDomainObject {

    private Long konsultantID;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private MarketinskaAgencija agencija;

    public Konsultant() {
    }

    public Konsultant(Long konsultantID, String ime, String prezime, String username, String password, MarketinskaAgencija agencija) {
        this.konsultantID = konsultantID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.agencija = agencija;
    }

    public Long getKonsultantID() {
        return konsultantID;
    }

    public void setKonsultantID(Long konsultantID) {
        this.konsultantID = konsultantID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
	return " Konsultant ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
	return " JOIN MarketinskaAgencija ma ON (ma.AgencijaID = k.AgencijaID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            MarketinskaAgencija ma = new MarketinskaAgencija(rs.getLong("AgencijaID"),
                    rs.getString("NazivAgencije"), rs.getString("GradAgencije"));

            Konsultant k = new Konsultant(rs.getLong("KonsultantID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"), ma);

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Username, Password, AgencijaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
	return " KonsultantID = " + konsultantID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + username + "', '" + password + "', " + agencija.getAgencijaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "Username = '" + username + "', Password = '" + password + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

}
