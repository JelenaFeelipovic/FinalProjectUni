/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Konsultant;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Jela
 */
public class SOLogin extends AbstractSO {
    
    Konsultant ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Konsultant)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Konsultant!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Konsultant k = (Konsultant) ado;

        ArrayList<Konsultant> konsultanti
                = (ArrayList<Konsultant>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Konsultant konsultant : konsultanti) {
            if (konsultant.getUsername().equals(k.getUsername())
                    && konsultant.getPassword().equals(k.getPassword())) {
                ulogovani = konsultant;
                return;
            }
        }

        throw new Exception("Ne postoji konsultant sa tim kredencijalima.");
        
    }

    public Konsultant getUlogovani() {
        return ulogovani;
    }
    
    

}
