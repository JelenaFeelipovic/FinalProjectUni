/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jela
 */
public class Termin extends AbstractDomainObject {

    private Long terminID;
    private Date datumVreme;
    private double cenaTermina;
    private Klijent klijent;
    private Konsultant konsultant;
    private ArrayList<StavkaTermina> stavkeTermina;

    public Termin(Long terminID, Date datumVreme, double cenaTermina, Klijent klijent, Konsultant konsultant, ArrayList<StavkaTermina> stavkeTermina) {
        this.terminID = terminID;
        this.datumVreme = datumVreme;
        this.cenaTermina = cenaTermina;
        this.klijent = klijent;
        this.konsultant = konsultant;
        this.stavkeTermina = stavkeTermina;
    }
    @Override
    public String toString()
    {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	return sdf.format(datumVreme);
	//return cenaTermina + "e";
    }
    public Termin()
    {
    }

    @Override
    public String nazivTabele() {
        return " Termin ";
    }


    @Override
    public String alijas()
    {
        return " t ";
    }

    @Override
    public String join() {
	return " JOIN Klijent kl ON (kl.KlijentID = t.KlijentID) "
		+ "JOIN Konsultant k ON (k.KonsultantID = t.KonsultantID) "
		+ "JOIN MarketinskaAgencija ma ON (ma.AgencijaID = k.AgencijaID) ";
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

	    Termin termin = new Termin(rs.getLong("TerminID"),
		    rs.getTimestamp("DatumVreme"), rs.getDouble("CenaTermina"),
		    kl, k, null);

            lista.add(termin);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
	return " (DatumVreme, CenaTermina, KlijentID, KonsultantID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
	return " TerminID = " + terminID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', "
                + " " + cenaTermina + ", "
                + " " + klijent.getKlijentID() + ", "
                + " " + konsultant.getKonsultantID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
	return " DatumVreme = '" + new Timestamp(datumVreme.getTime()) + "', "
		+ "CenaTermina = " + cenaTermina + " ";
    }

    @Override
    public String uslov()
    {
	if (klijent == null)
	{
	    return "";
	}
	return " WHERE kl.KlijentID=" + klijent.getKlijentID();
    }

    public Long getTerminID() {
        return terminID;
    }

    public void setTerminID(Long terminID) {
        this.terminID = terminID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getCenaTermina() {
        return cenaTermina;
    }

    public void setCenaTermina(double cenaTermina) {
        this.cenaTermina = cenaTermina;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Konsultant getKonsultant() {
        return konsultant;
    }

    public void setKonsultant(Konsultant konsultant) {
        this.konsultant = konsultant;
    }

    public ArrayList<StavkaTermina> getStavkeTermina() {
        return stavkeTermina;
    }

    public void setStavkeTermina(ArrayList<StavkaTermina> stavkeTermina) {
        this.stavkeTermina = stavkeTermina;
    }

}
