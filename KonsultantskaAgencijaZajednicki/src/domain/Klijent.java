package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jela
 */
public class Klijent extends AbstractDomainObject {

    private Long klijentID;
    private String nazivFirme;
    private String gradFirme;
    private String industrija;
    private String imeVlasnika;
    private String kontakt;

    @Override
    public String toString() {
        return nazivFirme;
    }

    public Klijent(Long klijentID, String nazivFirme, String gradFirme, String industrija, String imeVlasnika, String kontakt) {
        this.klijentID = klijentID;
        this.nazivFirme = nazivFirme;
        this.gradFirme = gradFirme;
        this.industrija = industrija;
        this.imeVlasnika = imeVlasnika;
        this.kontakt = kontakt;
    }

    public Klijent() {
    }

    @Override
    public String nazivTabele() {
        return " Klijent ";
    }

    @Override
    public String alijas() {
        return " kl ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            Klijent kl = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("NazivFirme"), rs.getString("GradFirme"),
                    rs.getString("Industrija"), rs.getString("ImeVlasnika"),
                    rs.getString("Kontakt"));

            lista.add(kl);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivFirme, GradFirme, Industrija, ImeVlasnika, Kontakt) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KlijentID = " + klijentID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivFirme + "', '" + gradFirme + "', "
                + "'" + industrija + "', '" + imeVlasnika + "', '" + kontakt + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " imeVlasnika = '" + imeVlasnika + "', kontakt = '" + kontakt + "', "
                + "gradFirme = '" + gradFirme + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }

    public String getGradFirme() {
        return gradFirme;
    }

    public void setGradFirme(String gradFirme) {
        this.gradFirme = gradFirme;
    }

    public String getIndustrija() {
        return industrija;
    }

    public void setIndustrija(String industrija) {
        this.industrija = industrija;
    }

    public String getImeVlasnika() {
        return imeVlasnika;
    }

    public void setImeVlasnika(String imeVlasnika) {
        this.imeVlasnika = imeVlasnika;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

}
