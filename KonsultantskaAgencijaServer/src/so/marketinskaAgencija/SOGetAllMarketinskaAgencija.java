/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.marketinskaAgencija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MarketinskaAgencija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Jela
 *
 */
public class SOGetAllMarketinskaAgencija extends AbstractSO {

    private ArrayList<MarketinskaAgencija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MarketinskaAgencija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MarketinskaAgencija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> marketinskeAgencije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<MarketinskaAgencija>) (ArrayList<?>) marketinskeAgencije;
    }

    public ArrayList<MarketinskaAgencija> getLista() {
        return lista;
    }

}
