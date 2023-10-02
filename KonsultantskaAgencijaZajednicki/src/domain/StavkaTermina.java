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
public class StavkaTermina extends AbstractDomainObject {

    private Termin termin;
    private int rbStavke;
    private double cenaStavke;
    private Usluga usluga;

    public StavkaTermina(Termin termin, int rbStavke, double cenaStavke, Usluga usluga) {
        this.termin = termin;
        this.rbStavke = rbStavke;
        this.cenaStavke = cenaStavke;
        this.usluga = usluga;
    }

    public StavkaTermina() {
    }

    @Override
    public String nazivTabele() {
        return " StavkaTermina ";
    }

    @Override
    public String alijas() {
        return " st ";
    }

    @Override
    public String join() {
	return " JOIN Termin t ON (t.TerminID = st.TerminID) "
		+ "JOIN Klijent kl ON (kl.KlijentID = t.KlijentID) "
		+ "JOIN Konsultant k ON (k.KonsultantID = t.KonsultantID) "
		+ "JOIN MarketinskaAgencija ma ON (ma.AgencijaID = k.AgencijaID) "
		+ "JOIN Usluga u ON (u.UslugaID = st.UslugaID) ";
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

            Klijent kl = new Klijent(rs.getLong("KlijentID"),
                    rs.getString("NazivFirme"), rs.getString("GradFirme"),
                    rs.getString("Industrija"), rs.getString("ImeVlasnika"),
                    rs.getString("Kontakt"));

            Usluga u = new Usluga(rs.getLong("UslugaID"),
                    rs.getString("NazivUsluge"), rs.getString("Opis"),
                    rs.getDouble("Cena"));

	    Termin t = new Termin(rs.getLong("TerminID"),
		    rs.getTimestamp("DatumVreme"), rs.getDouble("CenaTermina"),
		    kl, k, null);

	    StavkaTermina st = new StavkaTermina(t, rs.getInt("RbStavke"),
		    rs.getDouble("CenaStavke"), u);

            lista.add(st);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
	return " (TerminID, RbStavke, CenaStavke, UslugaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
	return " TerminID = " + termin.getTerminID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + termin.getTerminID() + ", " + rbStavke + ", "
                + " " + cenaStavke + ", " + usluga.getUslugaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
	return " WHERE t.TerminID = " + termin.getTerminID() + " ORDER BY st.RbStavke";
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

}
