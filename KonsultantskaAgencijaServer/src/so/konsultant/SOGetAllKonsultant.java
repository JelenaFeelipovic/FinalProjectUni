/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.konsultant;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Konsultant;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Jela
 *
 */
public class SOGetAllKonsultant extends AbstractSO {

    private ArrayList<Konsultant> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Konsultant)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Konsultant!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> konsultanti = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Konsultant>) (ArrayList<?>) konsultanti;
    }

    public ArrayList<Konsultant> getLista() {
        return lista;
    }

}
