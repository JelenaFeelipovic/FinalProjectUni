/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.termin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaTermina;
import domain.Termin;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author Jela
 */
public class SOUpdateTermin extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Termin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Termin!");
        }

        Termin termin = (Termin) ado;

        if (!termin.getDatumVreme().after(new Date())) {
            throw new Exception("Datum i vreme termina mora biti u buducnosti!");
        }

        if (termin.getStavkeTermina().isEmpty()) {
            throw new Exception("Termin mora imati barem jednu stavku!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
	DBBroker.getInstance().update(ado);

        Termin termin = (Termin) ado;

        DBBroker.getInstance().delete(termin.getStavkeTermina().get(0));

	for (StavkaTermina stavkaTermina : termin.getStavkeTermina())
	{
            DBBroker.getInstance().insert(stavkaTermina);
        }
    }

}
