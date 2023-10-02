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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author Jela
 */
public class SOAddTermin extends AbstractSO {

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

	PreparedStatement ps = DBBroker.getInstance().insert(ado);

	ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long terminID = tableKeys.getLong(1);

	Termin termin = (Termin) ado;
        termin.setTerminID(terminID);

        for (StavkaTermina stavkaTermina : termin.getStavkeTermina()) {
            stavkaTermina.setTermin(termin);
            DBBroker.getInstance().insert(stavkaTermina);
        }

    }

}
