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
public class MarketinskaAgencija extends AbstractDomainObject {
    
    private Long agencijaID;
    private String nazivAgencije;
    private String gradAgencije;

    public MarketinskaAgencija(Long agencijaID, String nazivAgencije, String gradAgencije) {
        this.agencijaID = agencijaID;
        this.nazivAgencije = nazivAgencije;
        this.gradAgencije = gradAgencije;
    }

    public MarketinskaAgencija() {
    }
    
    @Override
    public String nazivTabele() {
        return " MarketinskaAgencija ";
    }

    @Override
    public String alijas() {
        return " ma ";
    }

    @Override
    public String join() {
        return " ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            MarketinskaAgencija ma = new MarketinskaAgencija(rs.getLong("AgencijaID"),
                    rs.getString("NazivAgencije"), rs.getString("GradAgencije"));

            lista.add(ma);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " AgencijaID = " + agencijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getAgencijaID() {
        return agencijaID;
    }

    public void setAgencijaID(Long agencijaID) {
        this.agencijaID = agencijaID;
    }

    public String getNazivAgencije() {
        return nazivAgencije;
    }

    public void setNazivAgencije(String nazivAgencije) {
        this.nazivAgencije = nazivAgencije;
    }

    public String getGradAgencije() {
        return gradAgencije;
    }

    public void setGradAgencije(String gradAgencije) {
        this.gradAgencije = gradAgencije;
    }
    
}
