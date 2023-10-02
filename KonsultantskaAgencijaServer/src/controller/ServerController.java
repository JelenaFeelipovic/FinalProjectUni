/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Klijent;
import domain.Konsultant;
import domain.MarketinskaAgencija;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import java.util.ArrayList;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOGetAllKlijent;
import so.klijent.SOUpdateKlijent;
import so.konsultant.SOGetAllKonsultant;
import so.login.SOLogin;
import so.marketinskaAgencija.SOGetAllMarketinskaAgencija;
import so.stavkaTermina.SOGetAllStavkaTermina;
import so.termin.SOAddTermin;
import so.termin.SODeleteTermin;
import so.termin.SOGetAllTermin;
import so.termin.SOUpdateTermin;
import so.usluga.SOGetAllUsluga;

/**
 *
 * @author Jela
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Konsultant login(Konsultant konsultant) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(konsultant);
        return so.getUlogovani();
    }

    public void addKlijent(Klijent klijent) throws Exception
    {
	SOAddKlijent so = new SOAddKlijent();
	so.templateExecute(klijent);
    }

    public void addTermin(Termin termin) throws Exception
    {
	SOAddTermin so = new SOAddTermin();
	so.templateExecute(termin);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
	SODeleteKlijent so = new SODeleteKlijent();
	so.templateExecute(klijent);
    }

    public void deleteTermin(Termin termin) throws Exception
    {
	SODeleteTermin so = new SODeleteTermin();
	so.templateExecute(termin);
    }

    public void updateKlijent(Klijent klijent) throws Exception
    {
	SOUpdateKlijent so = new SOUpdateKlijent();
	so.templateExecute(klijent);
    }

    public void updateTermin(Termin termin) throws Exception
    {
	SOUpdateTermin so = new SOUpdateTermin();
	so.templateExecute(termin);
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Termin> getAllTermin() throws Exception {
        SOGetAllTermin so = new SOGetAllTermin();
        so.templateExecute(new Termin());
        return so.getLista();
    }

    public ArrayList<Konsultant> getAllKonsultant() throws Exception {
        SOGetAllKonsultant so = new SOGetAllKonsultant();
        so.templateExecute(new Konsultant());
        return so.getLista();
    }

    public ArrayList<StavkaTermina> getAllStavkaTermina(Termin t) throws Exception {
        SOGetAllStavkaTermina so = new SOGetAllStavkaTermina();
        
        StavkaTermina st = new StavkaTermina();
        st.setTermin(t);
        
        so.templateExecute(st);
        return so.getLista();
    }

    public ArrayList<MarketinskaAgencija> getAllMarketinskaAgencija() throws Exception {
        SOGetAllMarketinskaAgencija so = new SOGetAllMarketinskaAgencija();
        so.templateExecute(new MarketinskaAgencija());
        return so.getLista();
    }

    public ArrayList<Usluga> getAllUsluga() throws Exception {
        SOGetAllUsluga so = new SOGetAllUsluga();
        so.templateExecute(new Usluga());
        return so.getLista();
    }

    public Object getAllTermin(Klijent klijent) throws Exception
    {
	/*SOGetAllTermin so = new SOGetAllTermin();
	so.templateExecute(new Termin());
	//Klijent k = (Klijent) data;
	ArrayList<Termin> terminiKlijenta = new ArrayList<>();
	for (Termin t : so.getLista())
	{
	    if (t.getKlijent().getKlijentID().equals(klijent.getKlijentID()))
	    {
		terminiKlijenta.add(t);
	    }
	}
	return terminiKlijenta;*/

	SOGetAllTermin so = new SOGetAllTermin();

	Termin t = new Termin();
	t.setKlijent(klijent);

	so.templateExecute(t);
	return so.getLista();
    }

}
