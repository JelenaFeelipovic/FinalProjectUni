/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klijent;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Jela
 */
public class SOAddKlijent extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klijent)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klijent!");
        }

	Klijent k = (Klijent) ado;

        ArrayList<Klijent> klijenti = (ArrayList<Klijent>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Klijent klijent : klijenti) {
            if (klijent.getNazivFirme().equals(k.getNazivFirme())) {
                throw new Exception("Vec postoji klijent sa tim nazivom firme!");
            }
            if (klijent.getKontakt().equals(k.getKontakt())) {
                throw new Exception("Vec postoji klijent sa tim kontakt telefonom!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
